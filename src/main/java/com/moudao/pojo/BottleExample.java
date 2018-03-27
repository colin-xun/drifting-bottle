package com.moudao.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BottleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BottleExample() {
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

        public Criteria andBottleIdIsNull() {
            addCriterion("bottle_id is null");
            return (Criteria) this;
        }

        public Criteria andBottleIdIsNotNull() {
            addCriterion("bottle_id is not null");
            return (Criteria) this;
        }

        public Criteria andBottleIdEqualTo(Integer value) {
            addCriterion("bottle_id =", value, "bottleId");
            return (Criteria) this;
        }

        public Criteria andBottleIdNotEqualTo(Integer value) {
            addCriterion("bottle_id <>", value, "bottleId");
            return (Criteria) this;
        }

        public Criteria andBottleIdGreaterThan(Integer value) {
            addCriterion("bottle_id >", value, "bottleId");
            return (Criteria) this;
        }

        public Criteria andBottleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("bottle_id >=", value, "bottleId");
            return (Criteria) this;
        }

        public Criteria andBottleIdLessThan(Integer value) {
            addCriterion("bottle_id <", value, "bottleId");
            return (Criteria) this;
        }

        public Criteria andBottleIdLessThanOrEqualTo(Integer value) {
            addCriterion("bottle_id <=", value, "bottleId");
            return (Criteria) this;
        }

        public Criteria andBottleIdIn(List<Integer> values) {
            addCriterion("bottle_id in", values, "bottleId");
            return (Criteria) this;
        }

        public Criteria andBottleIdNotIn(List<Integer> values) {
            addCriterion("bottle_id not in", values, "bottleId");
            return (Criteria) this;
        }

        public Criteria andBottleIdBetween(Integer value1, Integer value2) {
            addCriterion("bottle_id between", value1, value2, "bottleId");
            return (Criteria) this;
        }

        public Criteria andBottleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("bottle_id not between", value1, value2, "bottleId");
            return (Criteria) this;
        }

        public Criteria andBottleTitleIsNull() {
            addCriterion("bottle_title is null");
            return (Criteria) this;
        }

        public Criteria andBottleTitleIsNotNull() {
            addCriterion("bottle_title is not null");
            return (Criteria) this;
        }

        public Criteria andBottleTitleEqualTo(String value) {
            addCriterion("bottle_title =", value, "bottleTitle");
            return (Criteria) this;
        }

        public Criteria andBottleTitleNotEqualTo(String value) {
            addCriterion("bottle_title <>", value, "bottleTitle");
            return (Criteria) this;
        }

        public Criteria andBottleTitleGreaterThan(String value) {
            addCriterion("bottle_title >", value, "bottleTitle");
            return (Criteria) this;
        }

        public Criteria andBottleTitleGreaterThanOrEqualTo(String value) {
            addCriterion("bottle_title >=", value, "bottleTitle");
            return (Criteria) this;
        }

        public Criteria andBottleTitleLessThan(String value) {
            addCriterion("bottle_title <", value, "bottleTitle");
            return (Criteria) this;
        }

        public Criteria andBottleTitleLessThanOrEqualTo(String value) {
            addCriterion("bottle_title <=", value, "bottleTitle");
            return (Criteria) this;
        }

        public Criteria andBottleTitleLike(String value) {
            addCriterion("bottle_title like", value, "bottleTitle");
            return (Criteria) this;
        }

        public Criteria andBottleTitleNotLike(String value) {
            addCriterion("bottle_title not like", value, "bottleTitle");
            return (Criteria) this;
        }

        public Criteria andBottleTitleIn(List<String> values) {
            addCriterion("bottle_title in", values, "bottleTitle");
            return (Criteria) this;
        }

        public Criteria andBottleTitleNotIn(List<String> values) {
            addCriterion("bottle_title not in", values, "bottleTitle");
            return (Criteria) this;
        }

        public Criteria andBottleTitleBetween(String value1, String value2) {
            addCriterion("bottle_title between", value1, value2, "bottleTitle");
            return (Criteria) this;
        }

        public Criteria andBottleTitleNotBetween(String value1, String value2) {
            addCriterion("bottle_title not between", value1, value2, "bottleTitle");
            return (Criteria) this;
        }

        public Criteria andBottleContentIsNull() {
            addCriterion("bottle_content is null");
            return (Criteria) this;
        }

        public Criteria andBottleContentIsNotNull() {
            addCriterion("bottle_content is not null");
            return (Criteria) this;
        }

        public Criteria andBottleContentEqualTo(String value) {
            addCriterion("bottle_content =", value, "bottleContent");
            return (Criteria) this;
        }

        public Criteria andBottleContentNotEqualTo(String value) {
            addCriterion("bottle_content <>", value, "bottleContent");
            return (Criteria) this;
        }

        public Criteria andBottleContentGreaterThan(String value) {
            addCriterion("bottle_content >", value, "bottleContent");
            return (Criteria) this;
        }

        public Criteria andBottleContentGreaterThanOrEqualTo(String value) {
            addCriterion("bottle_content >=", value, "bottleContent");
            return (Criteria) this;
        }

        public Criteria andBottleContentLessThan(String value) {
            addCriterion("bottle_content <", value, "bottleContent");
            return (Criteria) this;
        }

        public Criteria andBottleContentLessThanOrEqualTo(String value) {
            addCriterion("bottle_content <=", value, "bottleContent");
            return (Criteria) this;
        }

        public Criteria andBottleContentLike(String value) {
            addCriterion("bottle_content like", value, "bottleContent");
            return (Criteria) this;
        }

        public Criteria andBottleContentNotLike(String value) {
            addCriterion("bottle_content not like", value, "bottleContent");
            return (Criteria) this;
        }

        public Criteria andBottleContentIn(List<String> values) {
            addCriterion("bottle_content in", values, "bottleContent");
            return (Criteria) this;
        }

        public Criteria andBottleContentNotIn(List<String> values) {
            addCriterion("bottle_content not in", values, "bottleContent");
            return (Criteria) this;
        }

        public Criteria andBottleContentBetween(String value1, String value2) {
            addCriterion("bottle_content between", value1, value2, "bottleContent");
            return (Criteria) this;
        }

        public Criteria andBottleContentNotBetween(String value1, String value2) {
            addCriterion("bottle_content not between", value1, value2, "bottleContent");
            return (Criteria) this;
        }

        public Criteria andBottleCategoryIsNull() {
            addCriterion("bottle_category is null");
            return (Criteria) this;
        }

        public Criteria andBottleCategoryIsNotNull() {
            addCriterion("bottle_category is not null");
            return (Criteria) this;
        }

        public Criteria andBottleCategoryEqualTo(Byte value) {
            addCriterion("bottle_category =", value, "bottleCategory");
            return (Criteria) this;
        }

        public Criteria andBottleCategoryNotEqualTo(Byte value) {
            addCriterion("bottle_category <>", value, "bottleCategory");
            return (Criteria) this;
        }

        public Criteria andBottleCategoryGreaterThan(Byte value) {
            addCriterion("bottle_category >", value, "bottleCategory");
            return (Criteria) this;
        }

        public Criteria andBottleCategoryGreaterThanOrEqualTo(Byte value) {
            addCriterion("bottle_category >=", value, "bottleCategory");
            return (Criteria) this;
        }

        public Criteria andBottleCategoryLessThan(Byte value) {
            addCriterion("bottle_category <", value, "bottleCategory");
            return (Criteria) this;
        }

        public Criteria andBottleCategoryLessThanOrEqualTo(Byte value) {
            addCriterion("bottle_category <=", value, "bottleCategory");
            return (Criteria) this;
        }

        public Criteria andBottleCategoryIn(List<Byte> values) {
            addCriterion("bottle_category in", values, "bottleCategory");
            return (Criteria) this;
        }

        public Criteria andBottleCategoryNotIn(List<Byte> values) {
            addCriterion("bottle_category not in", values, "bottleCategory");
            return (Criteria) this;
        }

        public Criteria andBottleCategoryBetween(Byte value1, Byte value2) {
            addCriterion("bottle_category between", value1, value2, "bottleCategory");
            return (Criteria) this;
        }

        public Criteria andBottleCategoryNotBetween(Byte value1, Byte value2) {
            addCriterion("bottle_category not between", value1, value2, "bottleCategory");
            return (Criteria) this;
        }

        public Criteria andBottleStatusIsNull() {
            addCriterion("bottle_status is null");
            return (Criteria) this;
        }

        public Criteria andBottleStatusIsNotNull() {
            addCriterion("bottle_status is not null");
            return (Criteria) this;
        }

        public Criteria andBottleStatusEqualTo(Byte value) {
            addCriterion("bottle_status =", value, "bottleStatus");
            return (Criteria) this;
        }

        public Criteria andBottleStatusNotEqualTo(Byte value) {
            addCriterion("bottle_status <>", value, "bottleStatus");
            return (Criteria) this;
        }

        public Criteria andBottleStatusGreaterThan(Byte value) {
            addCriterion("bottle_status >", value, "bottleStatus");
            return (Criteria) this;
        }

        public Criteria andBottleStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("bottle_status >=", value, "bottleStatus");
            return (Criteria) this;
        }

        public Criteria andBottleStatusLessThan(Byte value) {
            addCriterion("bottle_status <", value, "bottleStatus");
            return (Criteria) this;
        }

        public Criteria andBottleStatusLessThanOrEqualTo(Byte value) {
            addCriterion("bottle_status <=", value, "bottleStatus");
            return (Criteria) this;
        }

        public Criteria andBottleStatusIn(List<Byte> values) {
            addCriterion("bottle_status in", values, "bottleStatus");
            return (Criteria) this;
        }

        public Criteria andBottleStatusNotIn(List<Byte> values) {
            addCriterion("bottle_status not in", values, "bottleStatus");
            return (Criteria) this;
        }

        public Criteria andBottleStatusBetween(Byte value1, Byte value2) {
            addCriterion("bottle_status between", value1, value2, "bottleStatus");
            return (Criteria) this;
        }

        public Criteria andBottleStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("bottle_status not between", value1, value2, "bottleStatus");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNull() {
            addCriterion("create_user_id is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNotNull() {
            addCriterion("create_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdEqualTo(Integer value) {
            addCriterion("create_user_id =", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotEqualTo(Integer value) {
            addCriterion("create_user_id <>", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThan(Integer value) {
            addCriterion("create_user_id >", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("create_user_id >=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThan(Integer value) {
            addCriterion("create_user_id <", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("create_user_id <=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIn(List<Integer> values) {
            addCriterion("create_user_id in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotIn(List<Integer> values) {
            addCriterion("create_user_id not in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdBetween(Integer value1, Integer value2) {
            addCriterion("create_user_id between", value1, value2, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("create_user_id not between", value1, value2, "createUserId");
            return (Criteria) this;
        }

        public Criteria andPraiseNumIsNull() {
            addCriterion("praise_num is null");
            return (Criteria) this;
        }

        public Criteria andPraiseNumIsNotNull() {
            addCriterion("praise_num is not null");
            return (Criteria) this;
        }

        public Criteria andPraiseNumEqualTo(Integer value) {
            addCriterion("praise_num =", value, "praiseNum");
            return (Criteria) this;
        }

        public Criteria andPraiseNumNotEqualTo(Integer value) {
            addCriterion("praise_num <>", value, "praiseNum");
            return (Criteria) this;
        }

        public Criteria andPraiseNumGreaterThan(Integer value) {
            addCriterion("praise_num >", value, "praiseNum");
            return (Criteria) this;
        }

        public Criteria andPraiseNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("praise_num >=", value, "praiseNum");
            return (Criteria) this;
        }

        public Criteria andPraiseNumLessThan(Integer value) {
            addCriterion("praise_num <", value, "praiseNum");
            return (Criteria) this;
        }

        public Criteria andPraiseNumLessThanOrEqualTo(Integer value) {
            addCriterion("praise_num <=", value, "praiseNum");
            return (Criteria) this;
        }

        public Criteria andPraiseNumIn(List<Integer> values) {
            addCriterion("praise_num in", values, "praiseNum");
            return (Criteria) this;
        }

        public Criteria andPraiseNumNotIn(List<Integer> values) {
            addCriterion("praise_num not in", values, "praiseNum");
            return (Criteria) this;
        }

        public Criteria andPraiseNumBetween(Integer value1, Integer value2) {
            addCriterion("praise_num between", value1, value2, "praiseNum");
            return (Criteria) this;
        }

        public Criteria andPraiseNumNotBetween(Integer value1, Integer value2) {
            addCriterion("praise_num not between", value1, value2, "praiseNum");
            return (Criteria) this;
        }

        public Criteria andActiveStatusIsNull() {
            addCriterion("active_status is null");
            return (Criteria) this;
        }

        public Criteria andActiveStatusIsNotNull() {
            addCriterion("active_status is not null");
            return (Criteria) this;
        }

        public Criteria andActiveStatusEqualTo(Byte value) {
            addCriterion("active_status =", value, "activeStatus");
            return (Criteria) this;
        }

        public Criteria andActiveStatusNotEqualTo(Byte value) {
            addCriterion("active_status <>", value, "activeStatus");
            return (Criteria) this;
        }

        public Criteria andActiveStatusGreaterThan(Byte value) {
            addCriterion("active_status >", value, "activeStatus");
            return (Criteria) this;
        }

        public Criteria andActiveStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("active_status >=", value, "activeStatus");
            return (Criteria) this;
        }

        public Criteria andActiveStatusLessThan(Byte value) {
            addCriterion("active_status <", value, "activeStatus");
            return (Criteria) this;
        }

        public Criteria andActiveStatusLessThanOrEqualTo(Byte value) {
            addCriterion("active_status <=", value, "activeStatus");
            return (Criteria) this;
        }

        public Criteria andActiveStatusIn(List<Byte> values) {
            addCriterion("active_status in", values, "activeStatus");
            return (Criteria) this;
        }

        public Criteria andActiveStatusNotIn(List<Byte> values) {
            addCriterion("active_status not in", values, "activeStatus");
            return (Criteria) this;
        }

        public Criteria andActiveStatusBetween(Byte value1, Byte value2) {
            addCriterion("active_status between", value1, value2, "activeStatus");
            return (Criteria) this;
        }

        public Criteria andActiveStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("active_status not between", value1, value2, "activeStatus");
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