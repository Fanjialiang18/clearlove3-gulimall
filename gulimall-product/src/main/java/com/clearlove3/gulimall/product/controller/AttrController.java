package com.clearlove3.gulimall.product.controller;

import java.util.Arrays;
import java.util.Map;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.clearlove3.gulimall.product.vo.AttrResponseVo;
import com.clearlove3.gulimall.product.vo.AttrVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.clearlove3.gulimall.product.entity.AttrEntity;
import com.clearlove3.gulimall.product.service.AttrService;
import com.clearlove3.common.utils.PageUtils;
import com.clearlove3.common.utils.R;



/**
 * 商品属性
 *
 * @author clearlove3
 * @email clearlovefan@gmail.com
 * @date 2021-11-02 16:26:58
 */
@RestController
@RequestMapping("product/attr")
public class AttrController {
    @Autowired
    private AttrService attrService;

    /**
     * 查询参数规格方法
     * @param params
     * @param catelogId
     * @return
     */
    @GetMapping("/{attrType}/list/{catelogId}")
    public R baseAttrList(@RequestParam Map<String,Object> params,
                          @PathVariable("catelogId") Long catelogId,
                          @PathVariable("attrType")String type){
        PageUtils page=attrService.queryBaseAttrPage(params,catelogId,type);
        return R.ok().put("page",page);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:attr:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = attrService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{attrId}")
    //@RequiresPermissions("product:attr:info")
    public R info(@PathVariable("attrId") Long attrId){
//		AttrEntity attr = attrService.getById(attrId);
        AttrResponseVo responseVo=attrService.getAttrInfo(attrId);
        return R.ok().put("attr", responseVo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:attr:save")
    public R save(@RequestBody AttrVo attr){
		attrService.saveAttr(attr);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:attr:update")
    public R update(@RequestBody AttrVo attr){
		attrService.updateAttr(attr);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:attr:delete")
    public R delete(@RequestBody Long[] attrIds){
		attrService.removeByIds(Arrays.asList(attrIds));

        return R.ok();
    }

}
