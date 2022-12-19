package edu.hunau.mapper;

import edu.hunau.entity.ForumToken;
import edu.hunau.entity.ForumTokenExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 论坛标记映射器
 *
 * @author ND_LJQ
 * @date 2022/12/17
 */
@Mapper
public interface ForumTokenMapper {
    /**
     * 计算实例
     *
     * @param example 例子
     * @return long
     */
    long countByExample(ForumTokenExample example);

    /**
     * 删除实例
     *
     * @param example 例子
     * @return int
     */
    int deleteByExample(ForumTokenExample example);

    /**
     * 按主键删除
     *
     * @param token 令牌
     * @return int
     */
    int deleteByPrimaryKey(String token);

    /**
     * 插入
     *
     * @param row 行
     * @return int
     */
    int insert(ForumToken row);

    /**
     * 插入选择性
     *
     * @param row 行
     * @return int
     */
    int insertSelective(ForumToken row);

    /**
     * 选择例子
     *
     * @param example 例子
     * @return {@link List}<{@link ForumToken}>
     */
    List<ForumToken> selectByExample(ForumTokenExample example);

    /**
     * 选择通过主键
     *
     * @param token 令牌
     * @return {@link ForumToken}
     */
    ForumToken selectByPrimaryKey(String token);

    /**
     * 更新例子有选择性
     *
     * @param row     行
     * @param example 例子
     * @return int
     */
    int updateByExampleSelective(@Param("row") ForumToken row, @Param("example") ForumTokenExample example);

    /**
     * 更新例子
     *
     * @param row     行
     * @param example 例子
     * @return int
     */
    int updateByExample(@Param("row") ForumToken row, @Param("example") ForumTokenExample example);

    /**
     * 更新主键选择性
     *
     * @param row 行
     * @return int
     */
    int updateByPrimaryKeySelective(ForumToken row);

    /**
     * 更新主键
     *
     * @param row 行
     * @return int
     */
    int updateByPrimaryKey(ForumToken row);
}