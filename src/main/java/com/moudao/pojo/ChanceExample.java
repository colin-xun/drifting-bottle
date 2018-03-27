package com.moudao.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChanceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ChanceExample() {
        oredCriteria = new ArrayList<Criteria>();
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
            criteria = new ArrayList<Criterion>();
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

        public Criteria andChanceIdIsNull() {
            addCriterion("chance_id is null");
            return (Criteria) this;
        }

        public Criteria andChanceIdIsNotNull() {
            addCriterion("chance_id is not null");
            return (Criteria) this;
        }

        public Criteria andChanceIdEqualTo(Integer value) {
            addCriterion("chance_id =", value, "chanceId");
            return (Criteria) this;
        }

        public Criteria andChanceIdNotEqualTo(Integer value) {
            addCriterion("chance_id <>", value, "chanceId");
            return (Criteria) this;
        }

        public Criteria andChanceIdGreaterThan(Integer value) {
            addCriterion("chance_id >", value, "chanceId");
            return (Criteria) this;
        }

        public Criteria andChanceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("chance_id >=", value, "chanceId");
            return (Criteria) this;
        }

        public Criteria andChanceIdLessThan(Integer value) {
            addCriterion("chance_id <", value, "chanceId");
            return (Criteria) this;
        }

        public Criteria andChanceIdLessThanOrEqualTo(Integer value) {
            addCriterion("chance_id <=", value, "chanceId");
            return (Criteria) this;
        }

        public Criteria andChanceIdIn(List<Integer> values) {
            addCriterion("chance_id in", values, "chanceId");
            return (Criteria) this;
        }

        public Criteria andChanceIdNotIn(List<Integer> values) {
            addCriterion("chance_id not in", values, "chanceId");
            return (Criteria) this;
        }

        public Criteria andChanceIdBetween(Integer value1, Integer value2) {
            addCriterion("chance_id between", value1, value2, "chanceId");
            return (Criteria) this;
        }

        public Criteria andChanceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("chance_id not between", value1, value2, "chanceId");
            return (Criteria) this;
        }

        public Criteria andChanceNumIsNull() {
            addCriterion("chance_num is null");
            return (Criteria) this;
        }

        public Criteria andChanceNumIsNotNull() {
            addCriterion("chance_num is not null");
            return (Criteria) this;
        }

        public Criteria andChanceNumEqualTo(Integer value) {
            addCriterion("chance_num =", value, "chanceNum");
            return (Criteria) this;
        }

        public Criteria andChanceNumNotEqualTo(Integer value) {
            addCriterion("chance_num <>", value, "chanceNum");
            return (Criteria) this;
        }

        public Criteria andChanceNumGreaterThan(Integer value) {
            addCriterion("chance_num >", value, "chanceNum");
            return (Criteria) this;
        }

        public Criteria andChanceNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("chance_num >=", value, "chanceNum");
            return (Criteria) this;
        }

        public Criteria andChanceNumLessThan(Integer value) {
            addCriterion("chance_num <", value, "chanceNum");
            return (Criteria) this;
        }

        public Criteria andChanceNumLessThanOrEqualTo(Integer value) {
            addCriterion("chance_num <=", value, "chanceNum");
            return (Criteria) this;
        }

        public Criteria andChanceNumIn(List<Integer> values) {
            addCriterion("chance_num in", values, "chanceNum");
            return (Criteria) this;
        }

        public Criteria andChanceNumNotIn(List<Integer> values) {
            addCriterion("chance_num not in", values, "chanceNum");
            return (Criteria) this;
        }

        public Criteria andChanceNumBetween(Integer value1, Integer value2) {
            addCriterion("chance_num between", value1, value2, "chanceNum");
            return (Criteria) this;
        }

        public Criteria andChanceNumNotBetween(Integer value1, Integer value2) {
            addCriterion("chance_num not between", value1, value2, "chanceNum");
            return (Criteria) this;
        }

        public Criteria andChanceCategoryIsNull() {
            addCriterion("chance_category is null");
            return (Criteria) this;
        }

        public Criteria andChanceCategoryIsNotNull() {
            addCriterion("chance_category is not null");
            return (Criteria) this;
        }

        public Criteria andChanceCategoryEqualTo(Byte value) {
            addCriterion("chance_category =", value, "chanceCategory");
            return (Criteria) this;
        }

        public Criteria andChanceCategoryNotEqualTo(Byte value) {
            addCriterion("chance_category <>", value, "chanceCategory");
            return (Criteria) this;
        }

        public Criteria andChanceCategoryGreaterThan(Byte value) {
            addCriterion("chance_category >", value, "chanceCategory");
            return (Criteria) this;
        }

        public Criteria andChanceCategoryGreaterThanOrEqualTo(Byte value) {
            addCriterion("chance_category >=", value, "chanceCategory");
            return (Criteria) this;
        }

        public Criteria andChanceCategoryLessThan(Byte value) {
            addCriterion("chance_category <", value, "chanceCategory");
            return (Criteria) this;
        }

        public Criteria andChanceCategoryLessThanOrEqualTo(Byte value) {
            addCriterion("chance_category <=", value, "chanceCategory");
            return (Criteria) this;
        }

        public Criteria andChanceCategoryIn(List<Byte> values) {
            addCriterion("chance_category in", values, "chanceCategory");
            return (Criteria) this;
        }

        public Criteria andChanceCategoryNotIn(List<Byte> values) {
            addCriterion("chance_category not in", values, "chanceCategory");
            return (Criteria) this;
        }

        public Criteria andChanceCategoryBetween(Byte value1, Byte value2) {
            addCriterion("chance_category between", value1, value2, "chanceCategory");
            return (Criteria) this;
        }

        public Criteria andChanceCategoryNotBetween(Byte value1, Byte value2) {
            addCriterion("chance_category not between", value1, value2, "chanceCategory");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andExt1IsNull() {
            addCriterion("ext1 is null");
            return (Criteria) this;
        }

        public Criteria andExt1IsNotNull() {
            addCriterion("ext1 is not null");
            return (Criteria) this;
        }

        public Criteria andExt1EqualTo(String value) {
            addCriterion("ext1 =", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1NotEqualTo(String value) {
            addCriterion("ext1 <>", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1GreaterThan(String value) {
            addCriterion("ext1 >", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1GreaterThanOrEqualTo(String value) {
            addCriterion("ext1 >=", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1LessThan(String value) {
            addCriterion("ext1 <", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1LessThanOrEqualTo(String value) {
            addCriterion("ext1 <=", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1Like(String value) {
            addCriterion("ext1 like", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1NotLike(String value) {
            addCriterion("ext1 not like", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1In(List<String> values) {
            addCriterion("ext1 in", values, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1NotIn(List<String> values) {
            addCriterion("ext1 not in", values, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1Between(String value1, String value2) {
            addCriterion("ext1 between", value1, value2, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1NotBetween(String value1, String value2) {
            addCriterion("ext1 not between", value1, value2, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt2IsNull() {
            addCriterion("ext2 is null");
            return (Criteria) this;
        }

        public Criteria andExt2IsNotNull() {
            addCriterion("ext2 is not null");
            return (Criteria) this;
        }

        public Criteria andExt2EqualTo(String value) {
            addCriterion("ext2 =", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2NotEqualTo(String value) {
            addCriterion("ext2 <>", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2GreaterThan(String value) {
            addCriterion("ext2 >", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2GreaterThanOrEqualTo(String value) {
            addCriterion("ext2 >=", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2LessThan(String value) {
            addCriterion("ext2 <", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2LessThanOrEqualTo(String value) {
            addCriterion("ext2 <=", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2Like(String value) {
            addCriterion("ext2 like", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2NotLike(String value) {
            addCriterion("ext2 not like", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2In(List<String> values) {
            addCriterion("ext2 in", values, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2NotIn(List<String> values) {
            addCriterion("ext2 not in", values, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2Between(String value1, String value2) {
            addCriterion("ext2 between", value1, value2, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2NotBetween(String value1, String value2) {
            addCriterion("ext2 not between", value1, value2, "ext2");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNull() {
            addCriterion("created_time is null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNotNull() {
            addCriterion("created_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeEqualTo(Date value) {
            addCriterion("created_time =", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotEqualTo(Date value) {
            addCriterion("created_time <>", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThan(Date value) {
            addCriterion("created_time >", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("created_time >=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThan(Date value) {
            addCriterion("created_time <", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("created_time <=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIn(List<Date> values) {
            addCriterion("created_time in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotIn(List<Date> values) {
            addCriterion("created_time not in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeBetween(Date value1, Date value2) {
            addCriterion("created_time between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("created_time not between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeIsNull() {
            addCriterion("updated_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeIsNotNull() {
            addCriterion("updated_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeEqualTo(Date value) {
            addCriterion("updated_time =", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotEqualTo(Date value) {
            addCriterion("updated_time <>", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeGreaterThan(Date value) {
            addCriterion("updated_time >", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updated_time >=", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeLessThan(Date value) {
            addCriterion("updated_time <", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("updated_time <=", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeIn(List<Date> values) {
            addCriterion("updated_time in", values, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotIn(List<Date> values) {
            addCriterion("updated_time not in", values, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeBetween(Date value1, Date value2) {
            addCriterion("updated_time between", value1, value2, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("updated_time not between", value1, value2, "updatedTime");
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