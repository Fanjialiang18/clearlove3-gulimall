package com.clearlove3.gulimall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.clearlove3.common.utils.PageUtils;
import com.clearlove3.gulimall.ware.entity.WareInfoEntity;

import java.util.Map;

/**
 * 仓库信息
 *
 * @author clearlove3
 * @email clearlovefan@gmail.com
 * @date 2021-11-02 17:13:13
 */
public interface WareInfoService extends IService<WareInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

