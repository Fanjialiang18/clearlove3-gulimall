package com.clearlove3.gulimall.member.dao;

import com.clearlove3.gulimall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author clearlove3
 * @email clearlovefan@gmail.com
 * @date 2021-11-02 17:04:59
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
