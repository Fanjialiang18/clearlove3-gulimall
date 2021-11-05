package com.clearlove3.gulimall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.clearlove3.common.utils.PageUtils;
import com.clearlove3.gulimall.coupon.entity.SeckillSessionEntity;

import java.util.Map;

/**
 * 秒杀活动场次
 *
 * @author clearlove3
 * @email clearlovefan@gmail.com
 * @date 2021-11-02 16:59:35
 */
public interface SeckillSessionService extends IService<SeckillSessionEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

