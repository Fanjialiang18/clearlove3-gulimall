package com.clearlove3.gulimall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.clearlove3.common.constant.ProductConstant;
import com.clearlove3.gulimall.product.dao.AttrAttrgroupRelationDao;
import com.clearlove3.gulimall.product.dao.AttrGroupDao;
import com.clearlove3.gulimall.product.dao.CategoryDao;
import com.clearlove3.gulimall.product.entity.AttrAttrgroupRelationEntity;
import com.clearlove3.gulimall.product.entity.AttrGroupEntity;
import com.clearlove3.gulimall.product.entity.CategoryEntity;
import com.clearlove3.gulimall.product.service.CategoryService;
import com.clearlove3.gulimall.product.vo.AttrResponseVo;
import com.clearlove3.gulimall.product.vo.AttrVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.clearlove3.common.utils.PageUtils;
import com.clearlove3.common.utils.Query;

import com.clearlove3.gulimall.product.dao.AttrDao;
import com.clearlove3.gulimall.product.entity.AttrEntity;
import com.clearlove3.gulimall.product.service.AttrService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;


@Service("attrService")
public class AttrServiceImpl extends ServiceImpl<AttrDao, AttrEntity> implements AttrService {

    @Autowired
    AttrAttrgroupRelationDao relationDao;

    @Autowired
    AttrGroupDao attrGroupDao;

    @Autowired
    CategoryDao categoryDao;

    @Autowired
    CategoryService categoryService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AttrEntity> page = this.page(
                new Query<AttrEntity>().getPage(params),
                new QueryWrapper<AttrEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    @Transactional
    public void saveAttr(AttrVo attr) {
        AttrEntity attrEntity = new AttrEntity();
        //调用Spring中的工具来复制
        BeanUtils.copyProperties(attr, attrEntity);
        //保存基本数据
        this.save(attrEntity);
        //保存关联关系
        if(attr.getAttrType()== ProductConstant.
                AttrEnum.ATTR_TYPE_BASE.getCode()){
            AttrAttrgroupRelationEntity relationEntity = new AttrAttrgroupRelationEntity();
            relationEntity.setAttrId(attrEntity.getAttrId());
            relationEntity.setAttrGroupId(attr.getAttrGroupId());
            relationDao.insert(relationEntity);
        }
    }

    @Override
    public PageUtils queryBaseAttrPage(Map<String, Object> params, Long catelogId, String type) {
        QueryWrapper<AttrEntity> queryWrapper = new QueryWrapper<AttrEntity>().eq("attr_type",
                "base".equalsIgnoreCase(type)?ProductConstant.
                        AttrEnum.ATTR_TYPE_BASE.getCode():
                        ProductConstant.AttrEnum.ATTR_TYPE_SALE);
        if (catelogId != 0) {
            queryWrapper.eq("catelog_id",catelogId);
        }
        String key = (String) params.get("key");
        if(StringUtils.hasLength(key)){
            queryWrapper.and((wrapper)->{
                wrapper.eq("attr_id",key).
                        or().like("attr_name",key);
            });
        }
        IPage<AttrEntity> page = this.page(
                new Query<AttrEntity>().getPage(params),
                queryWrapper
        );
        PageUtils pageUtils = new PageUtils(page);
        List<AttrEntity> records = page.getRecords();
        List<AttrResponseVo> responseVos = records.stream().map((attrEntity) -> {
            AttrResponseVo attrResponseVo = new AttrResponseVo();
            BeanUtils.copyProperties(attrEntity, attrResponseVo);
            //设置分类和分组的名字
            if("base".equalsIgnoreCase(type)){
                AttrAttrgroupRelationEntity attrId = relationDao.selectOne(new QueryWrapper<AttrAttrgroupRelationEntity>().
                        eq("attr_id", attrEntity.getAttrId()));
                if (attrId != null) {
                    AttrGroupEntity attrGroupEntity = attrGroupDao.selectById(attrId.getAttrGroupId());
                    attrResponseVo.setGroupName(attrGroupEntity.getAttrGroupName());
                }
            }

            CategoryEntity categoryEntity = categoryDao.selectById(attrEntity.getCatelogId());
            if (categoryEntity != null) {
                attrResponseVo.setCatelogName(categoryEntity.getName());
            }
            return attrResponseVo;
        }).collect(Collectors.toList());
        pageUtils.setList(responseVos);
        return pageUtils;
    }

    @Override
    public AttrResponseVo getAttrInfo(Long attrId) {
        AttrResponseVo responseVo=new AttrResponseVo();
        AttrEntity attrEntity = this.getById(attrId);
        BeanUtils.copyProperties(attrEntity,responseVo);

        if(attrEntity.getAttrType()==ProductConstant.AttrEnum.ATTR_TYPE_BASE.getCode()){
            //设置分组信息
            AttrAttrgroupRelationEntity attrgroupRelation = relationDao.selectOne(new QueryWrapper<AttrAttrgroupRelationEntity>().
                    eq("attr_id", attrId));
            if(attrgroupRelation!=null){
                responseVo.setAttrGroupId(attrgroupRelation.getAttrGroupId());
                AttrGroupEntity attrGroupEntity = attrGroupDao.selectById(attrgroupRelation.getAttrGroupId());
                if(attrGroupEntity!=null){
                    responseVo.setGroupName(attrGroupEntity.getAttrGroupName());
                }
            }
        }
        //设置分类信息
        Long catelogId = attrEntity.getCatelogId();
        Long[] catelogPath = categoryService.findCatelogPath(catelogId);
        responseVo.setCatelogPath(catelogPath);
        CategoryEntity categoryEntity = categoryDao.selectById(catelogId);
        if(categoryEntity!=null){
            responseVo.setCatelogName(categoryEntity.getName());
        }
        return responseVo;
    }

    @Transactional
    @Override
    public void updateAttr(AttrVo attr) {
        AttrEntity attrEntity=new AttrEntity();
        BeanUtils.copyProperties(attr,attrEntity);
        this.updateById(attrEntity);

        if(attrEntity.getAttrType()==ProductConstant.AttrEnum.ATTR_TYPE_BASE.getCode()){
            //1.修改分组关联
            AttrAttrgroupRelationEntity relationEntity = new AttrAttrgroupRelationEntity();
            relationEntity.setAttrGroupId(attr.getAttrGroupId());
            relationEntity.setAttrId(attr.getAttrId());

            Integer count = relationDao.selectCount(new QueryWrapper<AttrAttrgroupRelationEntity>().
                    eq("attr_id", attr.getAttrId()));
            //判断是该修改还是该新增
            if(count>0){
                relationDao.update(relationEntity,new UpdateWrapper<AttrAttrgroupRelationEntity>().
                        eq("attr_id",attr.getAttrId()));
            }else {
                relationDao.insert(relationEntity);
            }
        }
    }

    /**
     * 根据分组id查找关联的基本属性
     * @param attrgroupId
     * @return
     */
    @Override
    public List<AttrEntity> getRelationAttr(Long attrgroupId) {
        List<AttrAttrgroupRelationEntity> entities = relationDao.selectList(new QueryWrapper<AttrAttrgroupRelationEntity>().
                eq("attr_group_id", attrgroupId));
        List<Long> attrIds = entities.stream().map((attr) -> {
            return attr.getAttrId();
        }).collect(Collectors.toList());
        List<AttrEntity> attrEntities = this.listByIds(attrIds);
        return attrEntities;
    }

}