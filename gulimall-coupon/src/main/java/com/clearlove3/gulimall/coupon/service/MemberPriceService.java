package com.clearlove3.gulimall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.clearlove3.common.utils.PageUtils;
import com.clearlove3.gulimall.coupon.entity.MemberPriceEntity;

import java.util.Map;

/**
 * 商品会员价格
 *
 * @author clearlove3
 * @email clearlovefan@gmail.com
 * @date 2021-11-02 16:59:34
 */
public interface MemberPriceService extends IService<MemberPriceEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

