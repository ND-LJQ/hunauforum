package edu.hunau.entity;

import java.io.Serializable;
import java.util.Date;

public class ForumAudit implements Serializable {
    private Long auditId;

    private Integer auditType;

    private Long auditedId;

    private String auditManId;

    private Integer auditStarus;

    private Date auditDate;

    private String auditReason;

    private static final long serialVersionUID = 1L;

    public Long getAuditId() {
        return auditId;
    }

    public void setAuditId(Long auditId) {
        this.auditId = auditId;
    }

    public Integer getAuditType() {
        return auditType;
    }

    public void setAuditType(Integer auditType) {
        this.auditType = auditType;
    }

    public Long getAuditedId() {
        return auditedId;
    }

    public void setAuditedId(Long auditedId) {
        this.auditedId = auditedId;
    }

    public String getAuditManId() {
        return auditManId;
    }

    public void setAuditManId(String auditManId) {
        this.auditManId = auditManId == null ? null : auditManId.trim();
    }

    public Integer getAuditStarus() {
        return auditStarus;
    }

    public void setAuditStarus(Integer auditStarus) {
        this.auditStarus = auditStarus;
    }

    public Date getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
    }

    public String getAuditReason() {
        return auditReason;
    }

    public void setAuditReason(String auditReason) {
        this.auditReason = auditReason == null ? null : auditReason.trim();
    }

    public ForumAudit(){}

    public ForumAudit(Long auditId, Integer auditType, Long auditedId, Integer auditStarus) {
        this.auditId = auditId;
        this.auditType = auditType;
        this.auditedId = auditedId;
        this.auditStarus = auditStarus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", auditId=").append(auditId);
        sb.append(", auditType=").append(auditType);
        sb.append(", auditedId=").append(auditedId);
        sb.append(", auditManId=").append(auditManId);
        sb.append(", auditStarus=").append(auditStarus);
        sb.append(", auditDate=").append(auditDate);
        sb.append(", auditReason=").append(auditReason);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}