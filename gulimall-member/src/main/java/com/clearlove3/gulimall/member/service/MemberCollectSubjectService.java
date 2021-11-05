package com.clearlove3.gulimall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.clearlove3.common.utils.PageUtils;
import com.clearlove3.gulimall.member.entity.MemberCollectSubjectEntity;

import java.util.Map;

/**
 * 会员收藏的专题活动
 *
 * @author clearlove3
 * @email clearlovefan@gmail.com
 * @date 2021-11-02 17:04:59
 */
public interface MemberCollectSubjectService extends IService<MemberCollectSubjectEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

