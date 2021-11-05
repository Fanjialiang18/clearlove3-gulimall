package com.clearlove3.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.clearlove3.common.utils.PageUtils;
import com.clearlove3.gulimall.product.entity.CommentReplayEntity;

import java.util.Map;

/**
 * 商品评价回复关系
 *
 * @author clearlove3
 * @email clearlovefan@gmail.com
 * @date 2021-11-02 15:57:42
 */
public interface CommentReplayService extends IService<CommentReplayEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

