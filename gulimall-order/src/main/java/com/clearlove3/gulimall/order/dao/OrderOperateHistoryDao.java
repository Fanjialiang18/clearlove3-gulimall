package com.clearlove3.gulimall.order.dao;

import com.clearlove3.gulimall.order.entity.OrderOperateHistoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单操作历史记录
 * 
 * @author clearlove3
 * @email clearlovefan@gmail.com
 * @date 2021-11-02 17:11:11
 */
@Mapper
public interface OrderOperateHistoryDao extends BaseMapper<OrderOperateHistoryEntity> {
	
}
