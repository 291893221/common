package com.github.ums.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.github.ums.entity.MtmUserOrganization;

/**
 * Created by Mybatis Generator 2019/05/17
 */
@Mapper
public interface MtmUserOrganizationMapper {
	int deleteByPrimaryKey(@Param("userId") Long userId, @Param("organizationId") Long organizationId);

	int insert(MtmUserOrganization record);

	int insertSelective(MtmUserOrganization record);
}