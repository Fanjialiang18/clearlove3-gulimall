package com.clearlove3.gulimall.member.feign;

import com.clearlove3.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author clearlove3
 * @date 2021/11/5 11:57
 */

@FeignClient("gulimall-coupon")
public interface CouponFeignService {
    @RequestMapping("/coupon/coupon/member/list")
    public R memberCoupons();

}
