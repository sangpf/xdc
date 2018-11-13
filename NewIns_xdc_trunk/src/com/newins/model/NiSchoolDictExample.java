package com.newins.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NiSchoolDictExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NiSchoolDictExample() {
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

        public Criteria andSchoolidIsNull() {
            addCriterion("schoolId is null");
            return (Criteria) this;
        }

        public Criteria andSchoolidIsNotNull() {
            addCriterion("schoolId is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolidEqualTo(Integer value) {
            addCriterion("schoolId =", value, "schoolid");
            return (Criteria) this;
        }

        public Criteria andSchoolidNotEqualTo(Integer value) {
            addCriterion("schoolId <>", value, "schoolid");
            return (Criteria) this;
        }

        public Criteria andSchoolidGreaterThan(Integer value) {
            addCriterion("schoolId >", value, "schoolid");
            return (Criteria) this;
        }

        public Criteria andSchoolidGreaterThanOrEqualTo(Integer value) {
            addCriterion("schoolId >=", value, "schoolid");
            return (Criteria) this;
        }

        public Criteria andSchoolidLessThan(Integer value) {
            addCriterion("schoolId <", value, "schoolid");
            return (Criteria) this;
        }

        public Criteria andSchoolidLessThanOrEqualTo(Integer value) {
            addCriterion("schoolId <=", value, "schoolid");
            return (Criteria) this;
        }

        public Criteria andSchoolidIn(List<Integer> values) {
            addCriterion("schoolId in", values, "schoolid");
            return (Criteria) this;
        }

        public Criteria andSchoolidNotIn(List<Integer> values) {
            addCriterion("schoolId not in", values, "schoolid");
            return (Criteria) this;
        }

        public Criteria andSchoolidBetween(Integer value1, Integer value2) {
            addCriterion("schoolId between", value1, value2, "schoolid");
            return (Criteria) this;
        }

        public Criteria andSchoolidNotBetween(Integer value1, Integer value2) {
            addCriterion("schoolId not between", value1, value2, "schoolid");
            return (Criteria) this;
        }

        public Criteria andSchoolnameIsNull() {
            addCriterion("schoolName is null");
            return (Criteria) this;
        }

        public Criteria andSchoolnameIsNotNull() {
            addCriterion("schoolName is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolnameEqualTo(String value) {
            addCriterion("schoolName =", value, "schoolname");
            return (Criteria) this;
        }

        public Criteria andSchoolnameNotEqualTo(String value) {
            addCriterion("schoolName <>", value, "schoolname");
            return (Criteria) this;
        }

        public Criteria andSchoolnameGreaterThan(String value) {
            addCriterion("schoolName >", value, "schoolname");
            return (Criteria) this;
        }

        public Criteria andSchoolnameGreaterThanOrEqualTo(String value) {
            addCriterion("schoolName >=", value, "schoolname");
            return (Criteria) this;
        }

        public Criteria andSchoolnameLessThan(String value) {
            addCriterion("schoolName <", value, "schoolname");
            return (Criteria) this;
        }

        public Criteria andSchoolnameLessThanOrEqualTo(String value) {
            addCriterion("schoolName <=", value, "schoolname");
            return (Criteria) this;
        }

        public Criteria andSchoolnameLike(String value) {
            addCriterion("schoolName like", value, "schoolname");
            return (Criteria) this;
        }

        public Criteria andSchoolnameNotLike(String value) {
            addCriterion("schoolName not like", value, "schoolname");
            return (Criteria) this;
        }

        public Criteria andSchoolnameIn(List<String> values) {
            addCriterion("schoolName in", values, "schoolname");
            return (Criteria) this;
        }

        public Criteria andSchoolnameNotIn(List<String> values) {
            addCriterion("schoolName not in", values, "schoolname");
            return (Criteria) this;
        }

        public Criteria andSchoolnameBetween(String value1, String value2) {
            addCriterion("schoolName between", value1, value2, "schoolname");
            return (Criteria) this;
        }

        public Criteria andSchoolnameNotBetween(String value1, String value2) {
            addCriterion("schoolName not between", value1, value2, "schoolname");
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

        public Criteria andBelongtoIsNull() {
            addCriterion("belongTo is null");
            return (Criteria) this;
        }

        public Criteria andBelongtoIsNotNull() {
            addCriterion("belongTo is not null");
            return (Criteria) this;
        }

        public Criteria andBelongtoEqualTo(String value) {
            addCriterion("belongTo =", value, "belongto");
            return (Criteria) this;
        }

        public Criteria andBelongtoNotEqualTo(String value) {
            addCriterion("belongTo <>", value, "belongto");
            return (Criteria) this;
        }

        public Criteria andBelongtoGreaterThan(String value) {
            addCriterion("belongTo >", value, "belongto");
            return (Criteria) this;
        }

        public Criteria andBelongtoGreaterThanOrEqualTo(String value) {
            addCriterion("belongTo >=", value, "belongto");
            return (Criteria) this;
        }

        public Criteria andBelongtoLessThan(String value) {
            addCriterion("belongTo <", value, "belongto");
            return (Criteria) this;
        }

        public Criteria andBelongtoLessThanOrEqualTo(String value) {
            addCriterion("belongTo <=", value, "belongto");
            return (Criteria) this;
        }

        public Criteria andBelongtoLike(String value) {
            addCriterion("belongTo like", value, "belongto");
            return (Criteria) this;
        }

        public Criteria andBelongtoNotLike(String value) {
            addCriterion("belongTo not like", value, "belongto");
            return (Criteria) this;
        }

        public Criteria andBelongtoIn(List<String> values) {
            addCriterion("belongTo in", values, "belongto");
            return (Criteria) this;
        }

        public Criteria andBelongtoNotIn(List<String> values) {
            addCriterion("belongTo not in", values, "belongto");
            return (Criteria) this;
        }

        public Criteria andBelongtoBetween(String value1, String value2) {
            addCriterion("belongTo between", value1, value2, "belongto");
            return (Criteria) this;
        }

        public Criteria andBelongtoNotBetween(String value1, String value2) {
            addCriterion("belongTo not between", value1, value2, "belongto");
            return (Criteria) this;
        }

        public Criteria andDegreelevelIsNull() {
            addCriterion("degreeLevel is null");
            return (Criteria) this;
        }

        public Criteria andDegreelevelIsNotNull() {
            addCriterion("degreeLevel is not null");
            return (Criteria) this;
        }

        public Criteria andDegreelevelEqualTo(String value) {
            addCriterion("degreeLevel =", value, "degreelevel");
            return (Criteria) this;
        }

        public Criteria andDegreelevelNotEqualTo(String value) {
            addCriterion("degreeLevel <>", value, "degreelevel");
            return (Criteria) this;
        }

        public Criteria andDegreelevelGreaterThan(String value) {
            addCriterion("degreeLevel >", value, "degreelevel");
            return (Criteria) this;
        }

        public Criteria andDegreelevelGreaterThanOrEqualTo(String value) {
            addCriterion("degreeLevel >=", value, "degreelevel");
            return (Criteria) this;
        }

        public Criteria andDegreelevelLessThan(String value) {
            addCriterion("degreeLevel <", value, "degreelevel");
            return (Criteria) this;
        }

        public Criteria andDegreelevelLessThanOrEqualTo(String value) {
            addCriterion("degreeLevel <=", value, "degreelevel");
            return (Criteria) this;
        }

        public Criteria andDegreelevelLike(String value) {
            addCriterion("degreeLevel like", value, "degreelevel");
            return (Criteria) this;
        }

        public Criteria andDegreelevelNotLike(String value) {
            addCriterion("degreeLevel not like", value, "degreelevel");
            return (Criteria) this;
        }

        public Criteria andDegreelevelIn(List<String> values) {
            addCriterion("degreeLevel in", values, "degreelevel");
            return (Criteria) this;
        }

        public Criteria andDegreelevelNotIn(List<String> values) {
            addCriterion("degreeLevel not in", values, "degreelevel");
            return (Criteria) this;
        }

        public Criteria andDegreelevelBetween(String value1, String value2) {
            addCriterion("degreeLevel between", value1, value2, "degreelevel");
            return (Criteria) this;
        }

        public Criteria andDegreelevelNotBetween(String value1, String value2) {
            addCriterion("degreeLevel not between", value1, value2, "degreelevel");
            return (Criteria) this;
        }

        public Criteria andSchoolclassIsNull() {
            addCriterion("schoolClass is null");
            return (Criteria) this;
        }

        public Criteria andSchoolclassIsNotNull() {
            addCriterion("schoolClass is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolclassEqualTo(String value) {
            addCriterion("schoolClass =", value, "schoolclass");
            return (Criteria) this;
        }

        public Criteria andSchoolclassNotEqualTo(String value) {
            addCriterion("schoolClass <>", value, "schoolclass");
            return (Criteria) this;
        }

        public Criteria andSchoolclassGreaterThan(String value) {
            addCriterion("schoolClass >", value, "schoolclass");
            return (Criteria) this;
        }

        public Criteria andSchoolclassGreaterThanOrEqualTo(String value) {
            addCriterion("schoolClass >=", value, "schoolclass");
            return (Criteria) this;
        }

        public Criteria andSchoolclassLessThan(String value) {
            addCriterion("schoolClass <", value, "schoolclass");
            return (Criteria) this;
        }

        public Criteria andSchoolclassLessThanOrEqualTo(String value) {
            addCriterion("schoolClass <=", value, "schoolclass");
            return (Criteria) this;
        }

        public Criteria andSchoolclassLike(String value) {
            addCriterion("schoolClass like", value, "schoolclass");
            return (Criteria) this;
        }

        public Criteria andSchoolclassNotLike(String value) {
            addCriterion("schoolClass not like", value, "schoolclass");
            return (Criteria) this;
        }

        public Criteria andSchoolclassIn(List<String> values) {
            addCriterion("schoolClass in", values, "schoolclass");
            return (Criteria) this;
        }

        public Criteria andSchoolclassNotIn(List<String> values) {
            addCriterion("schoolClass not in", values, "schoolclass");
            return (Criteria) this;
        }

        public Criteria andSchoolclassBetween(String value1, String value2) {
            addCriterion("schoolClass between", value1, value2, "schoolclass");
            return (Criteria) this;
        }

        public Criteria andSchoolclassNotBetween(String value1, String value2) {
            addCriterion("schoolClass not between", value1, value2, "schoolclass");
            return (Criteria) this;
        }

        public Criteria andSchooltypeIsNull() {
            addCriterion("schoolType is null");
            return (Criteria) this;
        }

        public Criteria andSchooltypeIsNotNull() {
            addCriterion("schoolType is not null");
            return (Criteria) this;
        }

        public Criteria andSchooltypeEqualTo(String value) {
            addCriterion("schoolType =", value, "schooltype");
            return (Criteria) this;
        }

        public Criteria andSchooltypeNotEqualTo(String value) {
            addCriterion("schoolType <>", value, "schooltype");
            return (Criteria) this;
        }

        public Criteria andSchooltypeGreaterThan(String value) {
            addCriterion("schoolType >", value, "schooltype");
            return (Criteria) this;
        }

        public Criteria andSchooltypeGreaterThanOrEqualTo(String value) {
            addCriterion("schoolType >=", value, "schooltype");
            return (Criteria) this;
        }

        public Criteria andSchooltypeLessThan(String value) {
            addCriterion("schoolType <", value, "schooltype");
            return (Criteria) this;
        }

        public Criteria andSchooltypeLessThanOrEqualTo(String value) {
            addCriterion("schoolType <=", value, "schooltype");
            return (Criteria) this;
        }

        public Criteria andSchooltypeLike(String value) {
            addCriterion("schoolType like", value, "schooltype");
            return (Criteria) this;
        }

        public Criteria andSchooltypeNotLike(String value) {
            addCriterion("schoolType not like", value, "schooltype");
            return (Criteria) this;
        }

        public Criteria andSchooltypeIn(List<String> values) {
            addCriterion("schoolType in", values, "schooltype");
            return (Criteria) this;
        }

        public Criteria andSchooltypeNotIn(List<String> values) {
            addCriterion("schoolType not in", values, "schooltype");
            return (Criteria) this;
        }

        public Criteria andSchooltypeBetween(String value1, String value2) {
            addCriterion("schoolType between", value1, value2, "schooltype");
            return (Criteria) this;
        }

        public Criteria andSchooltypeNotBetween(String value1, String value2) {
            addCriterion("schoolType not between", value1, value2, "schooltype");
            return (Criteria) this;
        }

        public Criteria and985IsNull() {
            addCriterion("985 is null");
            return (Criteria) this;
        }

        public Criteria and985IsNotNull() {
            addCriterion("985 is not null");
            return (Criteria) this;
        }

        public Criteria and985EqualTo(Byte value) {
            addCriterion("985 =", value, "985");
            return (Criteria) this;
        }

        public Criteria and985NotEqualTo(Byte value) {
            addCriterion("985 <>", value, "985");
            return (Criteria) this;
        }

        public Criteria and985GreaterThan(Byte value) {
            addCriterion("985 >", value, "985");
            return (Criteria) this;
        }

        public Criteria and985GreaterThanOrEqualTo(Byte value) {
            addCriterion("985 >=", value, "985");
            return (Criteria) this;
        }

        public Criteria and985LessThan(Byte value) {
            addCriterion("985 <", value, "985");
            return (Criteria) this;
        }

        public Criteria and985LessThanOrEqualTo(Byte value) {
            addCriterion("985 <=", value, "985");
            return (Criteria) this;
        }

        public Criteria and985In(List<Byte> values) {
            addCriterion("985 in", values, "985");
            return (Criteria) this;
        }

        public Criteria and985NotIn(List<Byte> values) {
            addCriterion("985 not in", values, "985");
            return (Criteria) this;
        }

        public Criteria and985Between(Byte value1, Byte value2) {
            addCriterion("985 between", value1, value2, "985");
            return (Criteria) this;
        }

        public Criteria and985NotBetween(Byte value1, Byte value2) {
            addCriterion("985 not between", value1, value2, "985");
            return (Criteria) this;
        }

        public Criteria and211IsNull() {
            addCriterion("211 is null");
            return (Criteria) this;
        }

        public Criteria and211IsNotNull() {
            addCriterion("211 is not null");
            return (Criteria) this;
        }

        public Criteria and211EqualTo(Byte value) {
            addCriterion("211 =", value, "211");
            return (Criteria) this;
        }

        public Criteria and211NotEqualTo(Byte value) {
            addCriterion("211 <>", value, "211");
            return (Criteria) this;
        }

        public Criteria and211GreaterThan(Byte value) {
            addCriterion("211 >", value, "211");
            return (Criteria) this;
        }

        public Criteria and211GreaterThanOrEqualTo(Byte value) {
            addCriterion("211 >=", value, "211");
            return (Criteria) this;
        }

        public Criteria and211LessThan(Byte value) {
            addCriterion("211 <", value, "211");
            return (Criteria) this;
        }

        public Criteria and211LessThanOrEqualTo(Byte value) {
            addCriterion("211 <=", value, "211");
            return (Criteria) this;
        }

        public Criteria and211In(List<Byte> values) {
            addCriterion("211 in", values, "211");
            return (Criteria) this;
        }

        public Criteria and211NotIn(List<Byte> values) {
            addCriterion("211 not in", values, "211");
            return (Criteria) this;
        }

        public Criteria and211Between(Byte value1, Byte value2) {
            addCriterion("211 between", value1, value2, "211");
            return (Criteria) this;
        }

        public Criteria and211NotBetween(Byte value1, Byte value2) {
            addCriterion("211 not between", value1, value2, "211");
            return (Criteria) this;
        }

        public Criteria andPostgraduateIsNull() {
            addCriterion("postgraduate is null");
            return (Criteria) this;
        }

        public Criteria andPostgraduateIsNotNull() {
            addCriterion("postgraduate is not null");
            return (Criteria) this;
        }

        public Criteria andPostgraduateEqualTo(Byte value) {
            addCriterion("postgraduate =", value, "postgraduate");
            return (Criteria) this;
        }

        public Criteria andPostgraduateNotEqualTo(Byte value) {
            addCriterion("postgraduate <>", value, "postgraduate");
            return (Criteria) this;
        }

        public Criteria andPostgraduateGreaterThan(Byte value) {
            addCriterion("postgraduate >", value, "postgraduate");
            return (Criteria) this;
        }

        public Criteria andPostgraduateGreaterThanOrEqualTo(Byte value) {
            addCriterion("postgraduate >=", value, "postgraduate");
            return (Criteria) this;
        }

        public Criteria andPostgraduateLessThan(Byte value) {
            addCriterion("postgraduate <", value, "postgraduate");
            return (Criteria) this;
        }

        public Criteria andPostgraduateLessThanOrEqualTo(Byte value) {
            addCriterion("postgraduate <=", value, "postgraduate");
            return (Criteria) this;
        }

        public Criteria andPostgraduateIn(List<Byte> values) {
            addCriterion("postgraduate in", values, "postgraduate");
            return (Criteria) this;
        }

        public Criteria andPostgraduateNotIn(List<Byte> values) {
            addCriterion("postgraduate not in", values, "postgraduate");
            return (Criteria) this;
        }

        public Criteria andPostgraduateBetween(Byte value1, Byte value2) {
            addCriterion("postgraduate between", value1, value2, "postgraduate");
            return (Criteria) this;
        }

        public Criteria andPostgraduateNotBetween(Byte value1, Byte value2) {
            addCriterion("postgraduate not between", value1, value2, "postgraduate");
            return (Criteria) this;
        }

        public Criteria andWanxschoolcodeIsNull() {
            addCriterion("wanxSchoolCode is null");
            return (Criteria) this;
        }

        public Criteria andWanxschoolcodeIsNotNull() {
            addCriterion("wanxSchoolCode is not null");
            return (Criteria) this;
        }

        public Criteria andWanxschoolcodeEqualTo(String value) {
            addCriterion("wanxSchoolCode =", value, "wanxschoolcode");
            return (Criteria) this;
        }

        public Criteria andWanxschoolcodeNotEqualTo(String value) {
            addCriterion("wanxSchoolCode <>", value, "wanxschoolcode");
            return (Criteria) this;
        }

        public Criteria andWanxschoolcodeGreaterThan(String value) {
            addCriterion("wanxSchoolCode >", value, "wanxschoolcode");
            return (Criteria) this;
        }

        public Criteria andWanxschoolcodeGreaterThanOrEqualTo(String value) {
            addCriterion("wanxSchoolCode >=", value, "wanxschoolcode");
            return (Criteria) this;
        }

        public Criteria andWanxschoolcodeLessThan(String value) {
            addCriterion("wanxSchoolCode <", value, "wanxschoolcode");
            return (Criteria) this;
        }

        public Criteria andWanxschoolcodeLessThanOrEqualTo(String value) {
            addCriterion("wanxSchoolCode <=", value, "wanxschoolcode");
            return (Criteria) this;
        }

        public Criteria andWanxschoolcodeLike(String value) {
            addCriterion("wanxSchoolCode like", value, "wanxschoolcode");
            return (Criteria) this;
        }

        public Criteria andWanxschoolcodeNotLike(String value) {
            addCriterion("wanxSchoolCode not like", value, "wanxschoolcode");
            return (Criteria) this;
        }

        public Criteria andWanxschoolcodeIn(List<String> values) {
            addCriterion("wanxSchoolCode in", values, "wanxschoolcode");
            return (Criteria) this;
        }

        public Criteria andWanxschoolcodeNotIn(List<String> values) {
            addCriterion("wanxSchoolCode not in", values, "wanxschoolcode");
            return (Criteria) this;
        }

        public Criteria andWanxschoolcodeBetween(String value1, String value2) {
            addCriterion("wanxSchoolCode between", value1, value2, "wanxschoolcode");
            return (Criteria) this;
        }

        public Criteria andWanxschoolcodeNotBetween(String value1, String value2) {
            addCriterion("wanxSchoolCode not between", value1, value2, "wanxschoolcode");
            return (Criteria) this;
        }

        public Criteria andWanxschoolnameIsNull() {
            addCriterion("wanxSchoolName is null");
            return (Criteria) this;
        }

        public Criteria andWanxschoolnameIsNotNull() {
            addCriterion("wanxSchoolName is not null");
            return (Criteria) this;
        }

        public Criteria andWanxschoolnameEqualTo(String value) {
            addCriterion("wanxSchoolName =", value, "wanxschoolname");
            return (Criteria) this;
        }

        public Criteria andWanxschoolnameNotEqualTo(String value) {
            addCriterion("wanxSchoolName <>", value, "wanxschoolname");
            return (Criteria) this;
        }

        public Criteria andWanxschoolnameGreaterThan(String value) {
            addCriterion("wanxSchoolName >", value, "wanxschoolname");
            return (Criteria) this;
        }

        public Criteria andWanxschoolnameGreaterThanOrEqualTo(String value) {
            addCriterion("wanxSchoolName >=", value, "wanxschoolname");
            return (Criteria) this;
        }

        public Criteria andWanxschoolnameLessThan(String value) {
            addCriterion("wanxSchoolName <", value, "wanxschoolname");
            return (Criteria) this;
        }

        public Criteria andWanxschoolnameLessThanOrEqualTo(String value) {
            addCriterion("wanxSchoolName <=", value, "wanxschoolname");
            return (Criteria) this;
        }

        public Criteria andWanxschoolnameLike(String value) {
            addCriterion("wanxSchoolName like", value, "wanxschoolname");
            return (Criteria) this;
        }

        public Criteria andWanxschoolnameNotLike(String value) {
            addCriterion("wanxSchoolName not like", value, "wanxschoolname");
            return (Criteria) this;
        }

        public Criteria andWanxschoolnameIn(List<String> values) {
            addCriterion("wanxSchoolName in", values, "wanxschoolname");
            return (Criteria) this;
        }

        public Criteria andWanxschoolnameNotIn(List<String> values) {
            addCriterion("wanxSchoolName not in", values, "wanxschoolname");
            return (Criteria) this;
        }

        public Criteria andWanxschoolnameBetween(String value1, String value2) {
            addCriterion("wanxSchoolName between", value1, value2, "wanxschoolname");
            return (Criteria) this;
        }

        public Criteria andWanxschoolnameNotBetween(String value1, String value2) {
            addCriterion("wanxSchoolName not between", value1, value2, "wanxschoolname");
            return (Criteria) this;
        }

        public Criteria andRegioncodeIsNull() {
            addCriterion("regionCode is null");
            return (Criteria) this;
        }

        public Criteria andRegioncodeIsNotNull() {
            addCriterion("regionCode is not null");
            return (Criteria) this;
        }

        public Criteria andRegioncodeEqualTo(String value) {
            addCriterion("regionCode =", value, "regioncode");
            return (Criteria) this;
        }

        public Criteria andRegioncodeNotEqualTo(String value) {
            addCriterion("regionCode <>", value, "regioncode");
            return (Criteria) this;
        }

        public Criteria andRegioncodeGreaterThan(String value) {
            addCriterion("regionCode >", value, "regioncode");
            return (Criteria) this;
        }

        public Criteria andRegioncodeGreaterThanOrEqualTo(String value) {
            addCriterion("regionCode >=", value, "regioncode");
            return (Criteria) this;
        }

        public Criteria andRegioncodeLessThan(String value) {
            addCriterion("regionCode <", value, "regioncode");
            return (Criteria) this;
        }

        public Criteria andRegioncodeLessThanOrEqualTo(String value) {
            addCriterion("regionCode <=", value, "regioncode");
            return (Criteria) this;
        }

        public Criteria andRegioncodeLike(String value) {
            addCriterion("regionCode like", value, "regioncode");
            return (Criteria) this;
        }

        public Criteria andRegioncodeNotLike(String value) {
            addCriterion("regionCode not like", value, "regioncode");
            return (Criteria) this;
        }

        public Criteria andRegioncodeIn(List<String> values) {
            addCriterion("regionCode in", values, "regioncode");
            return (Criteria) this;
        }

        public Criteria andRegioncodeNotIn(List<String> values) {
            addCriterion("regionCode not in", values, "regioncode");
            return (Criteria) this;
        }

        public Criteria andRegioncodeBetween(String value1, String value2) {
            addCriterion("regionCode between", value1, value2, "regioncode");
            return (Criteria) this;
        }

        public Criteria andRegioncodeNotBetween(String value1, String value2) {
            addCriterion("regionCode not between", value1, value2, "regioncode");
            return (Criteria) this;
        }

        public Criteria andRegionnameIsNull() {
            addCriterion("regionName is null");
            return (Criteria) this;
        }

        public Criteria andRegionnameIsNotNull() {
            addCriterion("regionName is not null");
            return (Criteria) this;
        }

        public Criteria andRegionnameEqualTo(String value) {
            addCriterion("regionName =", value, "regionname");
            return (Criteria) this;
        }

        public Criteria andRegionnameNotEqualTo(String value) {
            addCriterion("regionName <>", value, "regionname");
            return (Criteria) this;
        }

        public Criteria andRegionnameGreaterThan(String value) {
            addCriterion("regionName >", value, "regionname");
            return (Criteria) this;
        }

        public Criteria andRegionnameGreaterThanOrEqualTo(String value) {
            addCriterion("regionName >=", value, "regionname");
            return (Criteria) this;
        }

        public Criteria andRegionnameLessThan(String value) {
            addCriterion("regionName <", value, "regionname");
            return (Criteria) this;
        }

        public Criteria andRegionnameLessThanOrEqualTo(String value) {
            addCriterion("regionName <=", value, "regionname");
            return (Criteria) this;
        }

        public Criteria andRegionnameLike(String value) {
            addCriterion("regionName like", value, "regionname");
            return (Criteria) this;
        }

        public Criteria andRegionnameNotLike(String value) {
            addCriterion("regionName not like", value, "regionname");
            return (Criteria) this;
        }

        public Criteria andRegionnameIn(List<String> values) {
            addCriterion("regionName in", values, "regionname");
            return (Criteria) this;
        }

        public Criteria andRegionnameNotIn(List<String> values) {
            addCriterion("regionName not in", values, "regionname");
            return (Criteria) this;
        }

        public Criteria andRegionnameBetween(String value1, String value2) {
            addCriterion("regionName between", value1, value2, "regionname");
            return (Criteria) this;
        }

        public Criteria andRegionnameNotBetween(String value1, String value2) {
            addCriterion("regionName not between", value1, value2, "regionname");
            return (Criteria) this;
        }

        public Criteria andAddtimeIsNull() {
            addCriterion("addTime is null");
            return (Criteria) this;
        }

        public Criteria andAddtimeIsNotNull() {
            addCriterion("addTime is not null");
            return (Criteria) this;
        }

        public Criteria andAddtimeEqualTo(Date value) {
            addCriterion("addTime =", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotEqualTo(Date value) {
            addCriterion("addTime <>", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeGreaterThan(Date value) {
            addCriterion("addTime >", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("addTime >=", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeLessThan(Date value) {
            addCriterion("addTime <", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeLessThanOrEqualTo(Date value) {
            addCriterion("addTime <=", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeIn(List<Date> values) {
            addCriterion("addTime in", values, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotIn(List<Date> values) {
            addCriterion("addTime not in", values, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeBetween(Date value1, Date value2) {
            addCriterion("addTime between", value1, value2, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotBetween(Date value1, Date value2) {
            addCriterion("addTime not between", value1, value2, "addtime");
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