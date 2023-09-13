package edu.hunau.mapper;

import edu.hunau.entity.ForumPermissions;
import edu.hunau.entity.ForumPermissionsExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author ND_LJQ
 */
@Mapper
public interface ForumPermissionsMapper {
    long countByExample(ForumPermissionsExample example);

    int deleteByExample(ForumPermissionsExample example);

    int deleteByPrimaryKey(Long permissionsId);

    int insert(ForumPermissions row);

    int insertSelective(ForumPermissions row);

    List<ForumPermissions> selectByExample(ForumPermissionsExample example);

    ForumPermissions selectByPrimaryKey(Long permissionsId);

    int updateByExampleSelective(@Param("row") ForumPermissions row, @Param("example") ForumPermissionsExample example);

    int updateByExample(@Param("row") ForumPermissions row, @Param("example") ForumPermissionsExample example);

    int updateByPrimaryKeySelective(ForumPermissions row);

    int updateByPrimaryKey(ForumPermissions row);
}