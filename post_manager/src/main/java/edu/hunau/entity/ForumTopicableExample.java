package edu.hunau.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ForumTopicableExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ForumTopicableExample() {
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

        public Criteria andTopicIdIsNull() {
            addCriterion("topic_id is null");
            return (Criteria) this;
        }

        public Criteria andTopicIdIsNotNull() {
            addCriterion("topic_id is not null");
            return (Criteria) this;
        }

        public Criteria andTopicIdEqualTo(Long value) {
            addCriterion("topic_id =", value, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdNotEqualTo(Long value) {
            addCriterion("topic_id <>", value, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdGreaterThan(Long value) {
            addCriterion("topic_id >", value, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdGreaterThanOrEqualTo(Long value) {
            addCriterion("topic_id >=", value, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdLessThan(Long value) {
            addCriterion("topic_id <", value, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdLessThanOrEqualTo(Long value) {
            addCriterion("topic_id <=", value, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdIn(List<Long> values) {
            addCriterion("topic_id in", values, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdNotIn(List<Long> values) {
            addCriterion("topic_id not in", values, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdBetween(Long value1, Long value2) {
            addCriterion("topic_id between", value1, value2, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdNotBetween(Long value1, Long value2) {
            addCriterion("topic_id not between", value1, value2, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicableIdIsNull() {
            addCriterion("topicable_id is null");
            return (Criteria) this;
        }

        public Criteria andTopicableIdIsNotNull() {
            addCriterion("topicable_id is not null");
            return (Criteria) this;
        }

        public Criteria andTopicableIdEqualTo(Long value) {
            addCriterion("topicable_id =", value, "topicableId");
            return (Criteria) this;
        }

        public Criteria andTopicableIdNotEqualTo(Long value) {
            addCriterion("topicable_id <>", value, "topicableId");
            return (Criteria) this;
        }

        public Criteria andTopicableIdGreaterThan(Long value) {
            addCriterion("topicable_id >", value, "topicableId");
            return (Criteria) this;
        }

        public Criteria andTopicableIdGreaterThanOrEqualTo(Long value) {
            addCriterion("topicable_id >=", value, "topicableId");
            return (Criteria) this;
        }

        public Criteria andTopicableIdLessThan(Long value) {
            addCriterion("topicable_id <", value, "topicableId");
            return (Criteria) this;
        }

        public Criteria andTopicableIdLessThanOrEqualTo(Long value) {
            addCriterion("topicable_id <=", value, "topicableId");
            return (Criteria) this;
        }

        public Criteria andTopicableIdIn(List<Long> values) {
            addCriterion("topicable_id in", values, "topicableId");
            return (Criteria) this;
        }

        public Criteria andTopicableIdNotIn(List<Long> values) {
            addCriterion("topicable_id not in", values, "topicableId");
            return (Criteria) this;
        }

        public Criteria andTopicableIdBetween(Long value1, Long value2) {
            addCriterion("topicable_id between", value1, value2, "topicableId");
            return (Criteria) this;
        }

        public Criteria andTopicableIdNotBetween(Long value1, Long value2) {
            addCriterion("topicable_id not between", value1, value2, "topicableId");
            return (Criteria) this;
        }

        public Criteria andTopicableTypeIsNull() {
            addCriterion("topicable_type is null");
            return (Criteria) this;
        }

        public Criteria andTopicableTypeIsNotNull() {
            addCriterion("topicable_type is not null");
            return (Criteria) this;
        }

        public Criteria andTopicableTypeEqualTo(Integer value) {
            addCriterion("topicable_type =", value, "topicableType");
            return (Criteria) this;
        }

        public Criteria andTopicableTypeNotEqualTo(Integer value) {
            addCriterion("topicable_type <>", value, "topicableType");
            return (Criteria) this;
        }

        public Criteria andTopicableTypeGreaterThan(Integer value) {
            addCriterion("topicable_type >", value, "topicableType");
            return (Criteria) this;
        }

        public Criteria andTopicableTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("topicable_type >=", value, "topicableType");
            return (Criteria) this;
        }

        public Criteria andTopicableTypeLessThan(Integer value) {
            addCriterion("topicable_type <", value, "topicableType");
            return (Criteria) this;
        }

        public Criteria andTopicableTypeLessThanOrEqualTo(Integer value) {
            addCriterion("topicable_type <=", value, "topicableType");
            return (Criteria) this;
        }

        public Criteria andTopicableTypeIn(List<Integer> values) {
            addCriterion("topicable_type in", values, "topicableType");
            return (Criteria) this;
        }

        public Criteria andTopicableTypeNotIn(List<Integer> values) {
            addCriterion("topicable_type not in", values, "topicableType");
            return (Criteria) this;
        }

        public Criteria andTopicableTypeBetween(Integer value1, Integer value2) {
            addCriterion("topicable_type between", value1, value2, "topicableType");
            return (Criteria) this;
        }

        public Criteria andTopicableTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("topicable_type not between", value1, value2, "topicableType");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterionForJDBCDate("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterionForJDBCDate("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterionForJDBCDate("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("create_time not between", value1, value2, "createTime");
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