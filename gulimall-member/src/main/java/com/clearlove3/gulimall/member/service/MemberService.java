package com.clearlove3.gulimall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.clearlove3.common.utils.PageUtils;
import com.clearlove3.gulimall.member.entity.MemberEntity;

import java.util.Map;

/**
 * 会员
 *
 * @author clearlove3
 * @email clearlovefan@gmail.com
 * @date 2021-11-02 17:04:59
 */
public interface MemberService extends IService<MemberEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

