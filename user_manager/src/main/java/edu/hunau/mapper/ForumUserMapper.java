package edu.hunau.mapper;

import edu.hunau.entity.ForumUser;
import edu.hunau.entity.ForumUserExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 论坛用户映射器
 *
 * @author ND_LJQ
 * @date 2022/12/17
 */
@Mapper
public interface ForumUserMapper {
    /**
     * 计算实例
     *
     * @param example 例子
     * @return long
     */
    long countByExample(ForumUserExample example);

    /**
     * 删除实例
     *
     * @param example 例子
     * @return int
     */
    int deleteByExample(ForumUserExample example);

    /**
     * 按主键删除
     *
     * @param userId 用户id
     * @return int
     */
    int deleteByPrimaryKey(Integer userId);

    /**
     * 插入
     *
     * @param row 行
     * @return int
     */
    int insert(ForumUser row);

    /**
     * 插入选择性
     *
     * @param row 行
     * @return int
     */
    int insertSelective(ForumUser row);

    /**
     * 选择例子
     *
     * @param example 例子
     * @return {@link List}<{@link ForumUser}>
     */
    List<ForumUser> selectByExample(ForumUserExample example);

    /**
     * 查询通过主键
     *
     * @param userId 用户id
     * @return {@link ForumUser}
     */
    ForumUser selectByPrimaryKey(Integer userId);

    /**
     * 查询用户通过电子邮件
     *
     * @param email 电子邮件
     * @return {@link ForumUser}
     */
    ForumUser selectByEmail(String email);


    /**
     * 查询用户通过电话
     *
     * @param Tel 电话
     * @return {@link ForumUser}
     */
    ForumUser selectByTel(String Tel);


    /**
     * 查询所有
     *
     * @return {@link List}<{@link ForumUser}>
     */
    List<ForumUser> selectAll();

    /**
     * 更新例子有选择性
     *
     * @param row     行
     * @param example 例子
     * @return int
     */
    int updateByExampleSelective(@Param("row") ForumUser row, @Param("example") ForumUserExample example);

    /**
     * 更新例子
     *
     * @param row     行
     * @param example 例子
     * @return int
     */
    int updateByExample(@Param("row") ForumUser row, @Param("example") ForumUserExample example);

    /**
     * 更新主键选择性
     *
     * @param row 行
     * @return int
     */
    int updateByPrimaryKeySelective(ForumUser row);

    /**
     * 更新主键
     *
     * @param row 行
     * @return int
     */
    int updateByPrimaryKey(ForumUser row);
}