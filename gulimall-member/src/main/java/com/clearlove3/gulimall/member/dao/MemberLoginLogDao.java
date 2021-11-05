package com.clearlove3.gulimall.member.dao;

import com.clearlove3.gulimall.member.entity.MemberLoginLogEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员登录记录
 * 
 * @author clearlove3
 * @email clearlovefan@gmail.com
 * @date 2021-11-02 17:04:59
 */
@Mapper
public interface MemberLoginLogDao extends BaseMapper<MemberLoginLogEntity> {
	
}
