package com.clearlove3.gulimall.order.dao;

import com.clearlove3.gulimall.order.entity.PaymentInfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 支付信息表
 * 
 * @author clearlove3
 * @email clearlovefan@gmail.com
 * @date 2021-11-02 17:11:11
 */
@Mapper
public interface PaymentInfoDao extends BaseMapper<PaymentInfoEntity> {
	
}
