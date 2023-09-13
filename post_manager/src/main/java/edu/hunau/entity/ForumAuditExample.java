package edu.hunau.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ForumAuditExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ForumAuditExample() {
        oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andAuditIdIsNull() {
            addCriterion("audit_id is null");
            return (Criteria) this;
        }

        public Criteria andAuditIdIsNotNull() {
            addCriterion("audit_id is not null");
            return (Criteria) this;
        }

        public Criteria andAuditIdEqualTo(Long value) {
            addCriterion("audit_id =", value, "auditId");
            return (Criteria) this;
        }

        public Criteria andAuditIdNotEqualTo(Long value) {
            addCriterion("audit_id <>", value, "auditId");
            return (Criteria) this;
        }

        public Criteria andAuditIdGreaterThan(Long value) {
            addCriterion("audit_id >", value, "auditId");
            return (Criteria) this;
        }

        public Criteria andAuditIdGreaterThanOrEqualTo(Long value) {
            addCriterion("audit_id >=", value, "auditId");
            return (Criteria) this;
        }

        public Criteria andAuditIdLessThan(Long value) {
            addCriterion("audit_id <", value, "auditId");
            return (Criteria) this;
        }

        public Criteria andAuditIdLessThanOrEqualTo(Long value) {
            addCriterion("audit_id <=", value, "auditId");
            return (Criteria) this;
        }

        public Criteria andAuditIdIn(List<Long> values) {
            addCriterion("audit_id in", values, "auditId");
            return (Criteria) this;
        }

        public Criteria andAuditIdNotIn(List<Long> values) {
            addCriterion("audit_id not in", values, "auditId");
            return (Criteria) this;
        }

        public Criteria andAuditIdBetween(Long value1, Long value2) {
            addCriterion("audit_id between", value1, value2, "auditId");
            return (Criteria) this;
        }

        public Criteria andAuditIdNotBetween(Long value1, Long value2) {
            addCriterion("audit_id not between", value1, value2, "auditId");
            return (Criteria) this;
        }

        public Criteria andAuditTypeIsNull() {
            addCriterion("audit_type is null");
            return (Criteria) this;
        }

        public Criteria andAuditTypeIsNotNull() {
            addCriterion("audit_type is not null");
            return (Criteria) this;
        }

        public Criteria andAuditTypeEqualTo(Integer value) {
            addCriterion("audit_type =", value, "auditType");
            return (Criteria) this;
        }

        public Criteria andAuditTypeNotEqualTo(Integer value) {
            addCriterion("audit_type <>", value, "auditType");
            return (Criteria) this;
        }

        public Criteria andAuditTypeGreaterThan(Integer value) {
            addCriterion("audit_type >", value, "auditType");
            return (Criteria) this;
        }

        public Criteria andAuditTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("audit_type >=", value, "auditType");
            return (Criteria) this;
        }

        public Criteria andAuditTypeLessThan(Integer value) {
            addCriterion("audit_type <", value, "auditType");
            return (Criteria) this;
        }

        public Criteria andAuditTypeLessThanOrEqualTo(Integer value) {
            addCriterion("audit_type <=", value, "auditType");
            return (Criteria) this;
        }

        public Criteria andAuditTypeIn(List<Integer> values) {
            addCriterion("audit_type in", values, "auditType");
            return (Criteria) this;
        }

        public Criteria andAuditTypeNotIn(List<Integer> values) {
            addCriterion("audit_type not in", values, "auditType");
            return (Criteria) this;
        }

        public Criteria andAuditTypeBetween(Integer value1, Integer value2) {
            addCriterion("audit_type between", value1, value2, "auditType");
            return (Criteria) this;
        }

        public Criteria andAuditTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("audit_type not between", value1, value2, "auditType");
            return (Criteria) this;
        }

        public Criteria andAuditedIdIsNull() {
            addCriterion("audited_id is null");
            return (Criteria) this;
        }

        public Criteria andAuditedIdIsNotNull() {
            addCriterion("audited_id is not null");
            return (Criteria) this;
        }

        public Criteria andAuditedIdEqualTo(Long value) {
            addCriterion("audited_id =", value, "auditedId");
            return (Criteria) this;
        }

        public Criteria andAuditedIdNotEqualTo(Long value) {
            addCriterion("audited_id <>", value, "auditedId");
            return (Criteria) this;
        }

        public Criteria andAuditedIdGreaterThan(Long value) {
            addCriterion("audited_id >", value, "auditedId");
            return (Criteria) this;
        }

        public Criteria andAuditedIdGreaterThanOrEqualTo(Long value) {
            addCriterion("audited_id >=", value, "auditedId");
            return (Criteria) this;
        }

        public Criteria andAuditedIdLessThan(Long value) {
            addCriterion("audited_id <", value, "auditedId");
            return (Criteria) this;
        }

        public Criteria andAuditedIdLessThanOrEqualTo(Long value) {
            addCriterion("audited_id <=", value, "auditedId");
            return (Criteria) this;
        }

        public Criteria andAuditedIdIn(List<Long> values) {
            addCriterion("audited_id in", values, "auditedId");
            return (Criteria) this;
        }

        public Criteria andAuditedIdNotIn(List<Long> values) {
            addCriterion("audited_id not in", values, "auditedId");
            return (Criteria) this;
        }

        public Criteria andAuditedIdBetween(Long value1, Long value2) {
            addCriterion("audited_id between", value1, value2, "auditedId");
            return (Criteria) this;
        }

        public Criteria andAuditedIdNotBetween(Long value1, Long value2) {
            addCriterion("audited_id not between", value1, value2, "auditedId");
            return (Criteria) this;
        }

        public Criteria andAuditManIdIsNull() {
            addCriterion("audit_man_id is null");
            return (Criteria) this;
        }

        public Criteria andAuditManIdIsNotNull() {
            addCriterion("audit_man_id is not null");
            return (Criteria) this;
        }

        public Criteria andAuditManIdEqualTo(String value) {
            addCriterion("audit_man_id =", value, "auditManId");
            return (Criteria) this;
        }

        public Criteria andAuditManIdNotEqualTo(String value) {
            addCriterion("audit_man_id <>", value, "auditManId");
            return (Criteria) this;
        }

        public Criteria andAuditManIdGreaterThan(String value) {
            addCriterion("audit_man_id >", value, "auditManId");
            return (Criteria) this;
        }

        public Criteria andAuditManIdGreaterThanOrEqualTo(String value) {
            addCriterion("audit_man_id >=", value, "auditManId");
            return (Criteria) this;
        }

        public Criteria andAuditManIdLessThan(String value) {
            addCriterion("audit_man_id <", value, "auditManId");
            return (Criteria) this;
        }

        public Criteria andAuditManIdLessThanOrEqualTo(String value) {
            addCriterion("audit_man_id <=", value, "auditManId");
            return (Criteria) this;
        }

        public Criteria andAuditManIdLike(String value) {
            addCriterion("audit_man_id like", value, "auditManId");
            return (Criteria) this;
        }

        public Criteria andAuditManIdNotLike(String value) {
            addCriterion("audit_man_id not like", value, "auditManId");
            return (Criteria) this;
        }

        public Criteria andAuditManIdIn(List<String> values) {
            addCriterion("audit_man_id in", values, "auditManId");
            return (Criteria) this;
        }

        public Criteria andAuditManIdNotIn(List<String> values) {
            addCriterion("audit_man_id not in", values, "auditManId");
            return (Criteria) this;
        }

        public Criteria andAuditManIdBetween(String value1, String value2) {
            addCriterion("audit_man_id between", value1, value2, "auditManId");
            return (Criteria) this;
        }

        public Criteria andAuditManIdNotBetween(String value1, String value2) {
            addCriterion("audit_man_id not between", value1, value2, "auditManId");
            return (Criteria) this;
        }

        public Criteria andAuditStarusIsNull() {
            addCriterion("audit_starus is null");
            return (Criteria) this;
        }

        public Criteria andAuditStarusIsNotNull() {
            addCriterion("audit_starus is not null");
            return (Criteria) this;
        }

        public Criteria andAuditStarusEqualTo(Integer value) {
            addCriterion("audit_starus =", value, "auditStarus");
            return (Criteria) this;
        }

        public Criteria andAuditStarusNotEqualTo(Integer value) {
            addCriterion("audit_starus <>", value, "auditStarus");
            return (Criteria) this;
        }

        public Criteria andAuditStarusGreaterThan(Integer value) {
            addCriterion("audit_starus >", value, "auditStarus");
            return (Criteria) this;
        }

        public Criteria andAuditStarusGreaterThanOrEqualTo(Integer value) {
            addCriterion("audit_starus >=", value, "auditStarus");
            return (Criteria) this;
        }

        public Criteria andAuditStarusLessThan(Integer value) {
            addCriterion("audit_starus <", value, "auditStarus");
            return (Criteria) this;
        }

        public Criteria andAuditStarusLessThanOrEqualTo(Integer value) {
            addCriterion("audit_starus <=", value, "auditStarus");
            return (Criteria) this;
        }

        public Criteria andAuditStarusIn(List<Integer> values) {
            addCriterion("audit_starus in", values, "auditStarus");
            return (Criteria) this;
        }

        public Criteria andAuditStarusNotIn(List<Integer> values) {
            addCriterion("audit_starus not in", values, "auditStarus");
            return (Criteria) this;
        }

        public Criteria andAuditStarusBetween(Integer value1, Integer value2) {
            addCriterion("audit_starus between", value1, value2, "auditStarus");
            return (Criteria) this;
        }

        public Criteria andAuditStarusNotBetween(Integer value1, Integer value2) {
            addCriterion("audit_starus not between", value1, value2, "auditStarus");
            return (Criteria) this;
        }

        public Criteria andAuditDateIsNull() {
            addCriterion("audit_date is null");
            return (Criteria) this;
        }

        public Criteria andAuditDateIsNotNull() {
            addCriterion("audit_date is not null");
            return (Criteria) this;
        }

        public Criteria andAuditDateEqualTo(Date value) {
            addCriterionForJDBCDate("audit_date =", value, "auditDate");
            return (Criteria) this;
        }

        public Criteria andAuditDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("audit_date <>", value, "auditDate");
            return (Criteria) this;
        }

        public Criteria andAuditDateGreaterThan(Date value) {
            addCriterionForJDBCDate("audit_date >", value, "auditDate");
            return (Criteria) this;
        }

        public Criteria andAuditDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("audit_date >=", value, "auditDate");
            return (Criteria) this;
        }

        public Criteria andAuditDateLessThan(Date value) {
            addCriterionForJDBCDate("audit_date <", value, "auditDate");
            return (Criteria) this;
        }

        public Criteria andAuditDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("audit_date <=", value, "auditDate");
            return (Criteria) this;
        }

        public Criteria andAuditDateIn(List<Date> values) {
            addCriterionForJDBCDate("audit_date in", values, "auditDate");
            return (Criteria) this;
        }

        public Criteria andAuditDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("audit_date not in", values, "auditDate");
            return (Criteria) this;
        }

        public Criteria andAuditDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("audit_date between", value1, value2, "auditDate");
            return (Criteria) this;
        }

        public Criteria andAuditDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("audit_date not between", value1, value2, "auditDate");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}