package com.clearlove3.gulimall.product.dao;

import com.clearlove3.gulimall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author clearlove3
 * @email clearlovefan@gmail.com
 * @date 2021-11-02 15:57:42
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
