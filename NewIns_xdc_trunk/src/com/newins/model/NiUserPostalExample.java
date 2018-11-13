package com.newins.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NiUserPostalExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NiUserPostalExample() {
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

        public Criteria andPostalidIsNull() {
            addCriterion("postalId is null");
            return (Criteria) this;
        }

        public Criteria andPostalidIsNotNull() {
            addCriterion("postalId is not null");
            return (Criteria) this;
        }

        public Criteria andPostalidEqualTo(Integer value) {
            addCriterion("postalId =", value, "postalid");
            return (Criteria) this;
        }

        public Criteria andPostalidNotEqualTo(Integer value) {
            addCriterion("postalId <>", value, "postalid");
            return (Criteria) this;
        }

        public Criteria andPostalidGreaterThan(Integer value) {
            addCriterion("postalId >", value, "postalid");
            return (Criteria) this;
        }

        public Criteria andPostalidGreaterThanOrEqualTo(Integer value) {
            addCriterion("postalId >=", value, "postalid");
            return (Criteria) this;
        }

        public Criteria andPostalidLessThan(Integer value) {
            addCriterion("postalId <", value, "postalid");
            return (Criteria) this;
        }

        public Criteria andPostalidLessThanOrEqualTo(Integer value) {
            addCriterion("postalId <=", value, "postalid");
            return (Criteria) this;
        }

        public Criteria andPostalidIn(List<Integer> values) {
            addCriterion("postalId in", values, "postalid");
            return (Criteria) this;
        }

        public Criteria andPostalidNotIn(List<Integer> values) {
            addCriterion("postalId not in", values, "postalid");
            return (Criteria) this;
        }

        public Criteria andPostalidBetween(Integer value1, Integer value2) {
            addCriterion("postalId between", value1, value2, "postalid");
            return (Criteria) this;
        }

        public Criteria andPostalidNotBetween(Integer value1, Integer value2) {
            addCriterion("postalId not between", value1, value2, "postalid");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userId is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userId is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("userId =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("userId <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("userId >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("userId >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("userId <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("userId <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("userId in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("userId not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("userId between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("userId not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andRecipientnameIsNull() {
            addCriterion("recipientName is null");
            return (Criteria) this;
        }

        public Criteria andRecipientnameIsNotNull() {
            addCriterion("recipientName is not null");
            return (Criteria) this;
        }

        public Criteria andRecipientnameEqualTo(String value) {
            addCriterion("recipientName =", value, "recipientname");
            return (Criteria) this;
        }

        public Criteria andRecipientnameNotEqualTo(String value) {
            addCriterion("recipientName <>", value, "recipientname");
            return (Criteria) this;
        }

        public Criteria andRecipientnameGreaterThan(String value) {
            addCriterion("recipientName >", value, "recipientname");
            return (Criteria) this;
        }

        public Criteria andRecipientnameGreaterThanOrEqualTo(String value) {
            addCriterion("recipientName >=", value, "recipientname");
            return (Criteria) this;
        }

        public Criteria andRecipientnameLessThan(String value) {
            addCriterion("recipientName <", value, "recipientname");
            return (Criteria) this;
        }

        public Criteria andRecipientnameLessThanOrEqualTo(String value) {
            addCriterion("recipientName <=", value, "recipientname");
            return (Criteria) this;
        }

        public Criteria andRecipientnameLike(String value) {
            addCriterion("recipientName like", value, "recipientname");
            return (Criteria) this;
        }

        public Criteria andRecipientnameNotLike(String value) {
            addCriterion("recipientName not like", value, "recipientname");
            return (Criteria) this;
        }

        public Criteria andRecipientnameIn(List<String> values) {
            addCriterion("recipientName in", values, "recipientname");
            return (Criteria) this;
        }

        public Criteria andRecipientnameNotIn(List<String> values) {
            addCriterion("recipientName not in", values, "recipientname");
            return (Criteria) this;
        }

        public Criteria andRecipientnameBetween(String value1, String value2) {
            addCriterion("recipientName between", value1, value2, "recipientname");
            return (Criteria) this;
        }

        public Criteria andRecipientnameNotBetween(String value1, String value2) {
            addCriterion("recipientName not between", value1, value2, "recipientname");
            return (Criteria) this;
        }

        public Criteria andRecipientphoneIsNull() {
            addCriterion("recipientPhone is null");
            return (Criteria) this;
        }

        public Criteria andRecipientphoneIsNotNull() {
            addCriterion("recipientPhone is not null");
            return (Criteria) this;
        }

        public Criteria andRecipientphoneEqualTo(String value) {
            addCriterion("recipientPhone =", value, "recipientphone");
            return (Criteria) this;
        }

        public Criteria andRecipientphoneNotEqualTo(String value) {
            addCriterion("recipientPhone <>", value, "recipientphone");
            return (Criteria) this;
        }

        public Criteria andRecipientphoneGreaterThan(String value) {
            addCriterion("recipientPhone >", value, "recipientphone");
            return (Criteria) this;
        }

        public Criteria andRecipientphoneGreaterThanOrEqualTo(String value) {
            addCriterion("recipientPhone >=", value, "recipientphone");
            return (Criteria) this;
        }

        public Criteria andRecipientphoneLessThan(String value) {
            addCriterion("recipientPhone <", value, "recipientphone");
            return (Criteria) this;
        }

        public Criteria andRecipientphoneLessThanOrEqualTo(String value) {
            addCriterion("recipientPhone <=", value, "recipientphone");
            return (Criteria) this;
        }

        public Criteria andRecipientphoneLike(String value) {
            addCriterion("recipientPhone like", value, "recipientphone");
            return (Criteria) this;
        }

        public Criteria andRecipientphoneNotLike(String value) {
            addCriterion("recipientPhone not like", value, "recipientphone");
            return (Criteria) this;
        }

        public Criteria andRecipientphoneIn(List<String> values) {
            addCriterion("recipientPhone in", values, "recipientphone");
            return (Criteria) this;
        }

        public Criteria andRecipientphoneNotIn(List<String> values) {
            addCriterion("recipientPhone not in", values, "recipientphone");
            return (Criteria) this;
        }

        public Criteria andRecipientphoneBetween(String value1, String value2) {
            addCriterion("recipientPhone between", value1, value2, "recipientphone");
            return (Criteria) this;
        }

        public Criteria andRecipientphoneNotBetween(String value1, String value2) {
            addCriterion("recipientPhone not between", value1, value2, "recipientphone");
            return (Criteria) this;
        }

        public Criteria andMailaddressIsNull() {
            addCriterion("mailAddress is null");
            return (Criteria) this;
        }

        public Criteria andMailaddressIsNotNull() {
            addCriterion("mailAddress is not null");
            return (Criteria) this;
        }

        public Criteria andMailaddressEqualTo(String value) {
            addCriterion("mailAddress =", value, "mailaddress");
            return (Criteria) this;
        }

        public Criteria andMailaddressNotEqualTo(String value) {
            addCriterion("mailAddress <>", value, "mailaddress");
            return (Criteria) this;
        }

        public Criteria andMailaddressGreaterThan(String value) {
            addCriterion("mailAddress >", value, "mailaddress");
            return (Criteria) this;
        }

        public Criteria andMailaddressGreaterThanOrEqualTo(String value) {
            addCriterion("mailAddress >=", value, "mailaddress");
            return (Criteria) this;
        }

        public Criteria andMailaddressLessThan(String value) {
            addCriterion("mailAddress <", value, "mailaddress");
            return (Criteria) this;
        }

        public Criteria andMailaddressLessThanOrEqualTo(String value) {
            addCriterion("mailAddress <=", value, "mailaddress");
            return (Criteria) this;
        }

        public Criteria andMailaddressLike(String value) {
            addCriterion("mailAddress like", value, "mailaddress");
            return (Criteria) this;
        }

        public Criteria andMailaddressNotLike(String value) {
            addCriterion("mailAddress not like", value, "mailaddress");
            return (Criteria) this;
        }

        public Criteria andMailaddressIn(List<String> values) {
            addCriterion("mailAddress in", values, "mailaddress");
            return (Criteria) this;
        }

        public Criteria andMailaddressNotIn(List<String> values) {
            addCriterion("mailAddress not in", values, "mailaddress");
            return (Criteria) this;
        }

        public Criteria andMailaddressBetween(String value1, String value2) {
            addCriterion("mailAddress between", value1, value2, "mailaddress");
            return (Criteria) this;
        }

        public Criteria andMailaddressNotBetween(String value1, String value2) {
            addCriterion("mailAddress not between", value1, value2, "mailaddress");
            return (Criteria) this;
        }

        public Criteria andPostcodeIsNull() {
            addCriterion("postCode is null");
            return (Criteria) this;
        }

        public Criteria andPostcodeIsNotNull() {
            addCriterion("postCode is not null");
            return (Criteria) this;
        }

        public Criteria andPostcodeEqualTo(String value) {
            addCriterion("postCode =", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotEqualTo(String value) {
            addCriterion("postCode <>", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeGreaterThan(String value) {
            addCriterion("postCode >", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeGreaterThanOrEqualTo(String value) {
            addCriterion("postCode >=", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeLessThan(String value) {
            addCriterion("postCode <", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeLessThanOrEqualTo(String value) {
            addCriterion("postCode <=", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeLike(String value) {
            addCriterion("postCode like", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotLike(String value) {
            addCriterion("postCode not like", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeIn(List<String> values) {
            addCriterion("postCode in", values, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotIn(List<String> values) {
            addCriterion("postCode not in", values, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeBetween(String value1, String value2) {
            addCriterion("postCode between", value1, value2, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotBetween(String value1, String value2) {
            addCriterion("postCode not between", value1, value2, "postcode");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNull() {
            addCriterion("province is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNotNull() {
            addCriterion("province is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceEqualTo(String value) {
            addCriterion("province =", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotEqualTo(String value) {
            addCriterion("province <>", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThan(String value) {
            addCriterion("province >", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("province >=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThan(String value) {
            addCriterion("province <", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThanOrEqualTo(String value) {
            addCriterion("province <=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLike(String value) {
            addCriterion("province like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotLike(String value) {
            addCriterion("province not like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceIn(List<String> values) {
            addCriterion("province in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotIn(List<String> values) {
            addCriterion("province not in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceBetween(String value1, String value2) {
            addCriterion("province between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotBetween(String value1, String value2) {
            addCriterion("province not between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andUtimeIsNull() {
            addCriterion("uTime is null");
            return (Criteria) this;
        }

        public Criteria andUtimeIsNotNull() {
            addCriterion("uTime is not null");
            return (Criteria) this;
        }

        public Criteria andUtimeEqualTo(Date value) {
            addCriterion("uTime =", value, "utime");
            return (Criteria) this;
        }

        public Criteria andUtimeNotEqualTo(Date value) {
            addCriterion("uTime <>", value, "utime");
            return (Criteria) this;
        }

        public Criteria andUtimeGreaterThan(Date value) {
            addCriterion("uTime >", value, "utime");
            return (Criteria) this;
        }

        public Criteria andUtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("uTime >=", value, "utime");
            return (Criteria) this;
        }

        public Criteria andUtimeLessThan(Date value) {
            addCriterion("uTime <", value, "utime");
            return (Criteria) this;
        }

        public Criteria andUtimeLessThanOrEqualTo(Date value) {
            addCriterion("uTime <=", value, "utime");
            return (Criteria) this;
        }

        public Criteria andUtimeIn(List<Date> values) {
            addCriterion("uTime in", values, "utime");
            return (Criteria) this;
        }

        public Criteria andUtimeNotIn(List<Date> values) {
            addCriterion("uTime not in", values, "utime");
            return (Criteria) this;
        }

        public Criteria andUtimeBetween(Date value1, Date value2) {
            addCriterion("uTime between", value1, value2, "utime");
            return (Criteria) this;
        }

        public Criteria andUtimeNotBetween(Date value1, Date value2) {
            addCriterion("uTime not between", value1, value2, "utime");
            return (Criteria) this;
        }

        public Criteria andCommentIsNull() {
            addCriterion("comment is null");
            return (Criteria) this;
        }

        public Criteria andCommentIsNotNull() {
            addCriterion("comment is not null");
            return (Criteria) this;
        }

        public Criteria andCommentEqualTo(String value) {
            addCriterion("comment =", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotEqualTo(String value) {
            addCriterion("comment <>", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThan(String value) {
            addCriterion("comment >", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThanOrEqualTo(String value) {
            addCriterion("comment >=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThan(String value) {
            addCriterion("comment <", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThanOrEqualTo(String value) {
            addCriterion("comment <=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLike(String value) {
            addCriterion("comment like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotLike(String value) {
            addCriterion("comment not like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentIn(List<String> values) {
            addCriterion("comment in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotIn(List<String> values) {
            addCriterion("comment not in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentBetween(String value1, String value2) {
            addCriterion("comment between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotBetween(String value1, String value2) {
            addCriterion("comment not between", value1, value2, "comment");
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