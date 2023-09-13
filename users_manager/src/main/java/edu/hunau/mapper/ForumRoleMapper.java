package edu.hunau.mapper;

import edu.hunau.entity.ForumRole;
import edu.hunau.entity.ForumRoleExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 论坛角色映射器
 *
 * @author ND_LJQ
 * @date 2023/09/13
 */
@Mapper
public interface ForumRoleMapper {
    long countByExample(ForumRoleExample example);

    int deleteByExample(ForumRoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ForumRole row);

    int insertSelective(ForumRole row);

    List<ForumRole> selectByExample(ForumRoleExample example);

    ForumRole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("row") ForumRole row, @Param("example") ForumRoleExample example);

    int updateByExample(@Param("row") ForumRole row, @Param("example") ForumRoleExample example);

    int updateByPrimaryKeySelective(ForumRole row);

    int updateByPrimaryKey(ForumRole row);
}