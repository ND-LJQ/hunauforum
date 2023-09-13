package edu.hunau.mapper;

import edu.hunau.entity.ForumAudit;
import edu.hunau.entity.ForumAuditExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ForumAuditMapper {
    long countByExample(ForumAuditExample example);

    int deleteByExample(ForumAuditExample example);

    int deleteByPrimaryKey(Long auditId);

    int insert(ForumAudit row);

    int insertSelective(ForumAudit row);

    List<ForumAudit> selectByExampleWithBLOBs(ForumAuditExample example);

    List<ForumAudit> selectByExample(ForumAuditExample example);

    ForumAudit selectByPrimaryKey(Long auditId);

    int updateByExampleSelective(@Param("row") ForumAudit row, @Param("example") ForumAuditExample example);

    int updateByExampleWithBLOBs(@Param("row") ForumAudit row, @Param("example") ForumAuditExample example);

    int updateByExample(@Param("row") ForumAudit row, @Param("example") ForumAuditExample example);

    int updateByPrimaryKeySelective(ForumAudit row);

    int updateByPrimaryKeyWithBLOBs(ForumAudit row);

    int updateByPrimaryKey(ForumAudit row);
}