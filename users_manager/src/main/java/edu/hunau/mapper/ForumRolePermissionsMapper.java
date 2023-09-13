package edu.hunau.mapper;

import edu.hunau.entity.ForumRolePermissions;
import edu.hunau.entity.ForumRolePermissionsExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ForumRolePermissionsMapper {
    long countByExample(ForumRolePermissionsExample example);

    int deleteByExample(ForumRolePermissionsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ForumRolePermissions row);

    int insertSelective(ForumRolePermissions row);

    List<ForumRolePermissions> selectByExample(ForumRolePermissionsExample example);

    ForumRolePermissions selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("row") ForumRolePermissions row, @Param("example") ForumRolePermissionsExample example);

    int updateByExample(@Param("row") ForumRolePermissions row, @Param("example") ForumRolePermissionsExample example);

    int updateByPrimaryKeySelective(ForumRolePermissions row);

    int updateByPrimaryKey(ForumRolePermissions row);
}