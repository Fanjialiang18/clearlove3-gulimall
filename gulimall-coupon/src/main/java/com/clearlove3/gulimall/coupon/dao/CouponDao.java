package com.clearlove3.gulimall.coupon.dao;

import com.clearlove3.gulimall.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author clearlove3
 * @email clearlovefan@gmail.com
 * @date 2021-11-02 16:59:35
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
