package edu.hunau.mapper;

import edu.hunau.entity.ForumUserRole;
import edu.hunau.entity.ForumUserRoleExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ForumUserRoleMapper {
    long countByExample(ForumUserRoleExample example);

    int deleteByExample(ForumUserRoleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ForumUserRole row);

    int insertSelective(ForumUserRole row);

    List<ForumUserRole> selectByExample(ForumUserRoleExample example);

    ForumUserRole selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") ForumUserRole row, @Param("example") ForumUserRoleExample example);

    int updateByExample(@Param("row") ForumUserRole row, @Param("example") ForumUserRoleExample example);

    int updateByPrimaryKeySelective(ForumUserRole row);

    int updateByPrimaryKey(ForumUserRole row);
}