package com.clearlove3.gulimall.coupon.dao;

import com.clearlove3.gulimall.coupon.entity.CouponSpuRelationEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券与产品关联
 * 
 * @author clearlove3
 * @email clearlovefan@gmail.com
 * @date 2021-11-02 16:59:34
 */
@Mapper
public interface CouponSpuRelationDao extends BaseMapper<CouponSpuRelationEntity> {
	
}
