package com.newins.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class NiUserEducationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NiUserEducationExample() {
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
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
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

        public Criteria andDegreeIsNull() {
            addCriterion("degree is null");
            return (Criteria) this;
        }

        public Criteria andDegreeIsNotNull() {
            addCriterion("degree is not null");
            return (Criteria) this;
        }

        public Criteria andDegreeEqualTo(Byte value) {
            addCriterion("degree =", value, "degree");
            return (Criteria) this;
        }

        public Criteria andDegreeNotEqualTo(Byte value) {
            addCriterion("degree <>", value, "degree");
            return (Criteria) this;
        }

        public Criteria andDegreeGreaterThan(Byte value) {
            addCriterion("degree >", value, "degree");
            return (Criteria) this;
        }

        public Criteria andDegreeGreaterThanOrEqualTo(Byte value) {
            addCriterion("degree >=", value, "degree");
            return (Criteria) this;
        }

        public Criteria andDegreeLessThan(Byte value) {
            addCriterion("degree <", value, "degree");
            return (Criteria) this;
        }

        public Criteria andDegreeLessThanOrEqualTo(Byte value) {
            addCriterion("degree <=", value, "degree");
            return (Criteria) this;
        }

        public Criteria andDegreeIn(List<Byte> values) {
            addCriterion("degree in", values, "degree");
            return (Criteria) this;
        }

        public Criteria andDegreeNotIn(List<Byte> values) {
            addCriterion("degree not in", values, "degree");
            return (Criteria) this;
        }

        public Criteria andDegreeBetween(Byte value1, Byte value2) {
            addCriterion("degree between", value1, value2, "degree");
            return (Criteria) this;
        }

        public Criteria andDegreeNotBetween(Byte value1, Byte value2) {
            addCriterion("degree not between", value1, value2, "degree");
            return (Criteria) this;
        }

        public Criteria andRegisterstatusIsNull() {
            addCriterion("registerStatus is null");
            return (Criteria) this;
        }

        public Criteria andRegisterstatusIsNotNull() {
            addCriterion("registerStatus is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterstatusEqualTo(Byte value) {
            addCriterion("registerStatus =", value, "registerstatus");
            return (Criteria) this;
        }

        public Criteria andRegisterstatusNotEqualTo(Byte value) {
            addCriterion("registerStatus <>", value, "registerstatus");
            return (Criteria) this;
        }

        public Criteria andRegisterstatusGreaterThan(Byte value) {
            addCriterion("registerStatus >", value, "registerstatus");
            return (Criteria) this;
        }

        public Criteria andRegisterstatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("registerStatus >=", value, "registerstatus");
            return (Criteria) this;
        }

        public Criteria andRegisterstatusLessThan(Byte value) {
            addCriterion("registerStatus <", value, "registerstatus");
            return (Criteria) this;
        }

        public Criteria andRegisterstatusLessThanOrEqualTo(Byte value) {
            addCriterion("registerStatus <=", value, "registerstatus");
            return (Criteria) this;
        }

        public Criteria andRegisterstatusIn(List<Byte> values) {
            addCriterion("registerStatus in", values, "registerstatus");
            return (Criteria) this;
        }

        public Criteria andRegisterstatusNotIn(List<Byte> values) {
            addCriterion("registerStatus not in", values, "registerstatus");
            return (Criteria) this;
        }

        public Criteria andRegisterstatusBetween(Byte value1, Byte value2) {
            addCriterion("registerStatus between", value1, value2, "registerstatus");
            return (Criteria) this;
        }

        public Criteria andRegisterstatusNotBetween(Byte value1, Byte value2) {
            addCriterion("registerStatus not between", value1, value2, "registerstatus");
            return (Criteria) this;
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

        public Criteria andRegionidIsNull() {
            addCriterion("regionId is null");
            return (Criteria) this;
        }

        public Criteria andRegionidIsNotNull() {
            addCriterion("regionId is not null");
            return (Criteria) this;
        }

        public Criteria andRegionidEqualTo(Integer value) {
            addCriterion("regionId =", value, "regionid");
            return (Criteria) this;
        }

        public Criteria andRegionidNotEqualTo(Integer value) {
            addCriterion("regionId <>", value, "regionid");
            return (Criteria) this;
        }

        public Criteria andRegionidGreaterThan(Integer value) {
            addCriterion("regionId >", value, "regionid");
            return (Criteria) this;
        }

        public Criteria andRegionidGreaterThanOrEqualTo(Integer value) {
            addCriterion("regionId >=", value, "regionid");
            return (Criteria) this;
        }

        public Criteria andRegionidLessThan(Integer value) {
            addCriterion("regionId <", value, "regionid");
            return (Criteria) this;
        }

        public Criteria andRegionidLessThanOrEqualTo(Integer value) {
            addCriterion("regionId <=", value, "regionid");
            return (Criteria) this;
        }

        public Criteria andRegionidIn(List<Integer> values) {
            addCriterion("regionId in", values, "regionid");
            return (Criteria) this;
        }

        public Criteria andRegionidNotIn(List<Integer> values) {
            addCriterion("regionId not in", values, "regionid");
            return (Criteria) this;
        }

        public Criteria andRegionidBetween(Integer value1, Integer value2) {
            addCriterion("regionId between", value1, value2, "regionid");
            return (Criteria) this;
        }

        public Criteria andRegionidNotBetween(Integer value1, Integer value2) {
            addCriterion("regionId not between", value1, value2, "regionid");
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

        public Criteria andCollegeIsNull() {
            addCriterion("college is null");
            return (Criteria) this;
        }

        public Criteria andCollegeIsNotNull() {
            addCriterion("college is not null");
            return (Criteria) this;
        }

        public Criteria andCollegeEqualTo(String value) {
            addCriterion("college =", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeNotEqualTo(String value) {
            addCriterion("college <>", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeGreaterThan(String value) {
            addCriterion("college >", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeGreaterThanOrEqualTo(String value) {
            addCriterion("college >=", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeLessThan(String value) {
            addCriterion("college <", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeLessThanOrEqualTo(String value) {
            addCriterion("college <=", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeLike(String value) {
            addCriterion("college like", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeNotLike(String value) {
            addCriterion("college not like", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeIn(List<String> values) {
            addCriterion("college in", values, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeNotIn(List<String> values) {
            addCriterion("college not in", values, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeBetween(String value1, String value2) {
            addCriterion("college between", value1, value2, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeNotBetween(String value1, String value2) {
            addCriterion("college not between", value1, value2, "college");
            return (Criteria) this;
        }

        public Criteria andDepartmentIsNull() {
            addCriterion("department is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIsNotNull() {
            addCriterion("department is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentEqualTo(String value) {
            addCriterion("department =", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotEqualTo(String value) {
            addCriterion("department <>", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentGreaterThan(String value) {
            addCriterion("department >", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("department >=", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLessThan(String value) {
            addCriterion("department <", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLessThanOrEqualTo(String value) {
            addCriterion("department <=", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLike(String value) {
            addCriterion("department like", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotLike(String value) {
            addCriterion("department not like", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentIn(List<String> values) {
            addCriterion("department in", values, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotIn(List<String> values) {
            addCriterion("department not in", values, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentBetween(String value1, String value2) {
            addCriterion("department between", value1, value2, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotBetween(String value1, String value2) {
            addCriterion("department not between", value1, value2, "department");
            return (Criteria) this;
        }

        public Criteria andMajorIsNull() {
            addCriterion("major is null");
            return (Criteria) this;
        }

        public Criteria andMajorIsNotNull() {
            addCriterion("major is not null");
            return (Criteria) this;
        }

        public Criteria andMajorEqualTo(String value) {
            addCriterion("major =", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotEqualTo(String value) {
            addCriterion("major <>", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorGreaterThan(String value) {
            addCriterion("major >", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorGreaterThanOrEqualTo(String value) {
            addCriterion("major >=", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorLessThan(String value) {
            addCriterion("major <", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorLessThanOrEqualTo(String value) {
            addCriterion("major <=", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorLike(String value) {
            addCriterion("major like", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotLike(String value) {
            addCriterion("major not like", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorIn(List<String> values) {
            addCriterion("major in", values, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotIn(List<String> values) {
            addCriterion("major not in", values, "major");
            return (Criteria) this;
        }

        public Criteria andMajorBetween(String value1, String value2) {
            addCriterion("major between", value1, value2, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotBetween(String value1, String value2) {
            addCriterion("major not between", value1, value2, "major");
            return (Criteria) this;
        }

        public Criteria andClassnameIsNull() {
            addCriterion("className is null");
            return (Criteria) this;
        }

        public Criteria andClassnameIsNotNull() {
            addCriterion("className is not null");
            return (Criteria) this;
        }

        public Criteria andClassnameEqualTo(String value) {
            addCriterion("className =", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameNotEqualTo(String value) {
            addCriterion("className <>", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameGreaterThan(String value) {
            addCriterion("className >", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameGreaterThanOrEqualTo(String value) {
            addCriterion("className >=", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameLessThan(String value) {
            addCriterion("className <", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameLessThanOrEqualTo(String value) {
            addCriterion("className <=", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameLike(String value) {
            addCriterion("className like", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameNotLike(String value) {
            addCriterion("className not like", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameIn(List<String> values) {
            addCriterion("className in", values, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameNotIn(List<String> values) {
            addCriterion("className not in", values, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameBetween(String value1, String value2) {
            addCriterion("className between", value1, value2, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameNotBetween(String value1, String value2) {
            addCriterion("className not between", value1, value2, "classname");
            return (Criteria) this;
        }

        public Criteria andUsersnIsNull() {
            addCriterion("userSn is null");
            return (Criteria) this;
        }

        public Criteria andUsersnIsNotNull() {
            addCriterion("userSn is not null");
            return (Criteria) this;
        }

        public Criteria andUsersnEqualTo(String value) {
            addCriterion("userSn =", value, "usersn");
            return (Criteria) this;
        }

        public Criteria andUsersnNotEqualTo(String value) {
            addCriterion("userSn <>", value, "usersn");
            return (Criteria) this;
        }

        public Criteria andUsersnGreaterThan(String value) {
            addCriterion("userSn >", value, "usersn");
            return (Criteria) this;
        }

        public Criteria andUsersnGreaterThanOrEqualTo(String value) {
            addCriterion("userSn >=", value, "usersn");
            return (Criteria) this;
        }

        public Criteria andUsersnLessThan(String value) {
            addCriterion("userSn <", value, "usersn");
            return (Criteria) this;
        }

        public Criteria andUsersnLessThanOrEqualTo(String value) {
            addCriterion("userSn <=", value, "usersn");
            return (Criteria) this;
        }

        public Criteria andUsersnLike(String value) {
            addCriterion("userSn like", value, "usersn");
            return (Criteria) this;
        }

        public Criteria andUsersnNotLike(String value) {
            addCriterion("userSn not like", value, "usersn");
            return (Criteria) this;
        }

        public Criteria andUsersnIn(List<String> values) {
            addCriterion("userSn in", values, "usersn");
            return (Criteria) this;
        }

        public Criteria andUsersnNotIn(List<String> values) {
            addCriterion("userSn not in", values, "usersn");
            return (Criteria) this;
        }

        public Criteria andUsersnBetween(String value1, String value2) {
            addCriterion("userSn between", value1, value2, "usersn");
            return (Criteria) this;
        }

        public Criteria andUsersnNotBetween(String value1, String value2) {
            addCriterion("userSn not between", value1, value2, "usersn");
            return (Criteria) this;
        }

        public Criteria andRoleIsNull() {
            addCriterion("role is null");
            return (Criteria) this;
        }

        public Criteria andRoleIsNotNull() {
            addCriterion("role is not null");
            return (Criteria) this;
        }

        public Criteria andRoleEqualTo(Byte value) {
            addCriterion("role =", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotEqualTo(Byte value) {
            addCriterion("role <>", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleGreaterThan(Byte value) {
            addCriterion("role >", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleGreaterThanOrEqualTo(Byte value) {
            addCriterion("role >=", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleLessThan(Byte value) {
            addCriterion("role <", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleLessThanOrEqualTo(Byte value) {
            addCriterion("role <=", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleIn(List<Byte> values) {
            addCriterion("role in", values, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotIn(List<Byte> values) {
            addCriterion("role not in", values, "role");
            return (Criteria) this;
        }

        public Criteria andRoleBetween(Byte value1, Byte value2) {
            addCriterion("role between", value1, value2, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotBetween(Byte value1, Byte value2) {
            addCriterion("role not between", value1, value2, "role");
            return (Criteria) this;
        }

        public Criteria andBindcardIsNull() {
            addCriterion("bindCard is null");
            return (Criteria) this;
        }

        public Criteria andBindcardIsNotNull() {
            addCriterion("bindCard is not null");
            return (Criteria) this;
        }

        public Criteria andBindcardEqualTo(Byte value) {
            addCriterion("bindCard =", value, "bindcard");
            return (Criteria) this;
        }

        public Criteria andBindcardNotEqualTo(Byte value) {
            addCriterion("bindCard <>", value, "bindcard");
            return (Criteria) this;
        }

        public Criteria andBindcardGreaterThan(Byte value) {
            addCriterion("bindCard >", value, "bindcard");
            return (Criteria) this;
        }

        public Criteria andBindcardGreaterThanOrEqualTo(Byte value) {
            addCriterion("bindCard >=", value, "bindcard");
            return (Criteria) this;
        }

        public Criteria andBindcardLessThan(Byte value) {
            addCriterion("bindCard <", value, "bindcard");
            return (Criteria) this;
        }

        public Criteria andBindcardLessThanOrEqualTo(Byte value) {
            addCriterion("bindCard <=", value, "bindcard");
            return (Criteria) this;
        }

        public Criteria andBindcardIn(List<Byte> values) {
            addCriterion("bindCard in", values, "bindcard");
            return (Criteria) this;
        }

        public Criteria andBindcardNotIn(List<Byte> values) {
            addCriterion("bindCard not in", values, "bindcard");
            return (Criteria) this;
        }

        public Criteria andBindcardBetween(Byte value1, Byte value2) {
            addCriterion("bindCard between", value1, value2, "bindcard");
            return (Criteria) this;
        }

        public Criteria andBindcardNotBetween(Byte value1, Byte value2) {
            addCriterion("bindCard not between", value1, value2, "bindcard");
            return (Criteria) this;
        }

        public Criteria andBindstudentIsNull() {
            addCriterion("bindStudent is null");
            return (Criteria) this;
        }

        public Criteria andBindstudentIsNotNull() {
            addCriterion("bindStudent is not null");
            return (Criteria) this;
        }

        public Criteria andBindstudentEqualTo(Byte value) {
            addCriterion("bindStudent =", value, "bindstudent");
            return (Criteria) this;
        }

        public Criteria andBindstudentNotEqualTo(Byte value) {
            addCriterion("bindStudent <>", value, "bindstudent");
            return (Criteria) this;
        }

        public Criteria andBindstudentGreaterThan(Byte value) {
            addCriterion("bindStudent >", value, "bindstudent");
            return (Criteria) this;
        }

        public Criteria andBindstudentGreaterThanOrEqualTo(Byte value) {
            addCriterion("bindStudent >=", value, "bindstudent");
            return (Criteria) this;
        }

        public Criteria andBindstudentLessThan(Byte value) {
            addCriterion("bindStudent <", value, "bindstudent");
            return (Criteria) this;
        }

        public Criteria andBindstudentLessThanOrEqualTo(Byte value) {
            addCriterion("bindStudent <=", value, "bindstudent");
            return (Criteria) this;
        }

        public Criteria andBindstudentIn(List<Byte> values) {
            addCriterion("bindStudent in", values, "bindstudent");
            return (Criteria) this;
        }

        public Criteria andBindstudentNotIn(List<Byte> values) {
            addCriterion("bindStudent not in", values, "bindstudent");
            return (Criteria) this;
        }

        public Criteria andBindstudentBetween(Byte value1, Byte value2) {
            addCriterion("bindStudent between", value1, value2, "bindstudent");
            return (Criteria) this;
        }

        public Criteria andBindstudentNotBetween(Byte value1, Byte value2) {
            addCriterion("bindStudent not between", value1, value2, "bindstudent");
            return (Criteria) this;
        }

        public Criteria andWanxscoreIsNull() {
            addCriterion("wanxScore is null");
            return (Criteria) this;
        }

        public Criteria andWanxscoreIsNotNull() {
            addCriterion("wanxScore is not null");
            return (Criteria) this;
        }

        public Criteria andWanxscoreEqualTo(Integer value) {
            addCriterion("wanxScore =", value, "wanxscore");
            return (Criteria) this;
        }

        public Criteria andWanxscoreNotEqualTo(Integer value) {
            addCriterion("wanxScore <>", value, "wanxscore");
            return (Criteria) this;
        }

        public Criteria andWanxscoreGreaterThan(Integer value) {
            addCriterion("wanxScore >", value, "wanxscore");
            return (Criteria) this;
        }

        public Criteria andWanxscoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("wanxScore >=", value, "wanxscore");
            return (Criteria) this;
        }

        public Criteria andWanxscoreLessThan(Integer value) {
            addCriterion("wanxScore <", value, "wanxscore");
            return (Criteria) this;
        }

        public Criteria andWanxscoreLessThanOrEqualTo(Integer value) {
            addCriterion("wanxScore <=", value, "wanxscore");
            return (Criteria) this;
        }

        public Criteria andWanxscoreIn(List<Integer> values) {
            addCriterion("wanxScore in", values, "wanxscore");
            return (Criteria) this;
        }

        public Criteria andWanxscoreNotIn(List<Integer> values) {
            addCriterion("wanxScore not in", values, "wanxscore");
            return (Criteria) this;
        }

        public Criteria andWanxscoreBetween(Integer value1, Integer value2) {
            addCriterion("wanxScore between", value1, value2, "wanxscore");
            return (Criteria) this;
        }

        public Criteria andWanxscoreNotBetween(Integer value1, Integer value2) {
            addCriterion("wanxScore not between", value1, value2, "wanxscore");
            return (Criteria) this;
        }

        public Criteria andWanxaccountIsNull() {
            addCriterion("wanxAccount is null");
            return (Criteria) this;
        }

        public Criteria andWanxaccountIsNotNull() {
            addCriterion("wanxAccount is not null");
            return (Criteria) this;
        }

        public Criteria andWanxaccountEqualTo(String value) {
            addCriterion("wanxAccount =", value, "wanxaccount");
            return (Criteria) this;
        }

        public Criteria andWanxaccountNotEqualTo(String value) {
            addCriterion("wanxAccount <>", value, "wanxaccount");
            return (Criteria) this;
        }

        public Criteria andWanxaccountGreaterThan(String value) {
            addCriterion("wanxAccount >", value, "wanxaccount");
            return (Criteria) this;
        }

        public Criteria andWanxaccountGreaterThanOrEqualTo(String value) {
            addCriterion("wanxAccount >=", value, "wanxaccount");
            return (Criteria) this;
        }

        public Criteria andWanxaccountLessThan(String value) {
            addCriterion("wanxAccount <", value, "wanxaccount");
            return (Criteria) this;
        }

        public Criteria andWanxaccountLessThanOrEqualTo(String value) {
            addCriterion("wanxAccount <=", value, "wanxaccount");
            return (Criteria) this;
        }

        public Criteria andWanxaccountLike(String value) {
            addCriterion("wanxAccount like", value, "wanxaccount");
            return (Criteria) this;
        }

        public Criteria andWanxaccountNotLike(String value) {
            addCriterion("wanxAccount not like", value, "wanxaccount");
            return (Criteria) this;
        }

        public Criteria andWanxaccountIn(List<String> values) {
            addCriterion("wanxAccount in", values, "wanxaccount");
            return (Criteria) this;
        }

        public Criteria andWanxaccountNotIn(List<String> values) {
            addCriterion("wanxAccount not in", values, "wanxaccount");
            return (Criteria) this;
        }

        public Criteria andWanxaccountBetween(String value1, String value2) {
            addCriterion("wanxAccount between", value1, value2, "wanxaccount");
            return (Criteria) this;
        }

        public Criteria andWanxaccountNotBetween(String value1, String value2) {
            addCriterion("wanxAccount not between", value1, value2, "wanxaccount");
            return (Criteria) this;
        }

        public Criteria andEnroldateIsNull() {
            addCriterion("enrolDate is null");
            return (Criteria) this;
        }

        public Criteria andEnroldateIsNotNull() {
            addCriterion("enrolDate is not null");
            return (Criteria) this;
        }

        public Criteria andEnroldateEqualTo(Date value) {
            addCriterionForJDBCDate("enrolDate =", value, "enroldate");
            return (Criteria) this;
        }

        public Criteria andEnroldateNotEqualTo(Date value) {
            addCriterionForJDBCDate("enrolDate <>", value, "enroldate");
            return (Criteria) this;
        }

        public Criteria andEnroldateGreaterThan(Date value) {
            addCriterionForJDBCDate("enrolDate >", value, "enroldate");
            return (Criteria) this;
        }

        public Criteria andEnroldateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("enrolDate >=", value, "enroldate");
            return (Criteria) this;
        }

        public Criteria andEnroldateLessThan(Date value) {
            addCriterionForJDBCDate("enrolDate <", value, "enroldate");
            return (Criteria) this;
        }

        public Criteria andEnroldateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("enrolDate <=", value, "enroldate");
            return (Criteria) this;
        }

        public Criteria andEnroldateIn(List<Date> values) {
            addCriterionForJDBCDate("enrolDate in", values, "enroldate");
            return (Criteria) this;
        }

        public Criteria andEnroldateNotIn(List<Date> values) {
            addCriterionForJDBCDate("enrolDate not in", values, "enroldate");
            return (Criteria) this;
        }

        public Criteria andEnroldateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("enrolDate between", value1, value2, "enroldate");
            return (Criteria) this;
        }

        public Criteria andEnroldateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("enrolDate not between", value1, value2, "enroldate");
            return (Criteria) this;
        }

        public Criteria andGraduatedateIsNull() {
            addCriterion("graduateDate is null");
            return (Criteria) this;
        }

        public Criteria andGraduatedateIsNotNull() {
            addCriterion("graduateDate is not null");
            return (Criteria) this;
        }

        public Criteria andGraduatedateEqualTo(Date value) {
            addCriterionForJDBCDate("graduateDate =", value, "graduatedate");
            return (Criteria) this;
        }

        public Criteria andGraduatedateNotEqualTo(Date value) {
            addCriterionForJDBCDate("graduateDate <>", value, "graduatedate");
            return (Criteria) this;
        }

        public Criteria andGraduatedateGreaterThan(Date value) {
            addCriterionForJDBCDate("graduateDate >", value, "graduatedate");
            return (Criteria) this;
        }

        public Criteria andGraduatedateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("graduateDate >=", value, "graduatedate");
            return (Criteria) this;
        }

        public Criteria andGraduatedateLessThan(Date value) {
            addCriterionForJDBCDate("graduateDate <", value, "graduatedate");
            return (Criteria) this;
        }

        public Criteria andGraduatedateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("graduateDate <=", value, "graduatedate");
            return (Criteria) this;
        }

        public Criteria andGraduatedateIn(List<Date> values) {
            addCriterionForJDBCDate("graduateDate in", values, "graduatedate");
            return (Criteria) this;
        }

        public Criteria andGraduatedateNotIn(List<Date> values) {
            addCriterionForJDBCDate("graduateDate not in", values, "graduatedate");
            return (Criteria) this;
        }

        public Criteria andGraduatedateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("graduateDate between", value1, value2, "graduatedate");
            return (Criteria) this;
        }

        public Criteria andGraduatedateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("graduateDate not between", value1, value2, "graduatedate");
            return (Criteria) this;
        }

        public Criteria andLeavestatusIsNull() {
            addCriterion("leaveStatus is null");
            return (Criteria) this;
        }

        public Criteria andLeavestatusIsNotNull() {
            addCriterion("leaveStatus is not null");
            return (Criteria) this;
        }

        public Criteria andLeavestatusEqualTo(Byte value) {
            addCriterion("leaveStatus =", value, "leavestatus");
            return (Criteria) this;
        }

        public Criteria andLeavestatusNotEqualTo(Byte value) {
            addCriterion("leaveStatus <>", value, "leavestatus");
            return (Criteria) this;
        }

        public Criteria andLeavestatusGreaterThan(Byte value) {
            addCriterion("leaveStatus >", value, "leavestatus");
            return (Criteria) this;
        }

        public Criteria andLeavestatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("leaveStatus >=", value, "leavestatus");
            return (Criteria) this;
        }

        public Criteria andLeavestatusLessThan(Byte value) {
            addCriterion("leaveStatus <", value, "leavestatus");
            return (Criteria) this;
        }

        public Criteria andLeavestatusLessThanOrEqualTo(Byte value) {
            addCriterion("leaveStatus <=", value, "leavestatus");
            return (Criteria) this;
        }

        public Criteria andLeavestatusIn(List<Byte> values) {
            addCriterion("leaveStatus in", values, "leavestatus");
            return (Criteria) this;
        }

        public Criteria andLeavestatusNotIn(List<Byte> values) {
            addCriterion("leaveStatus not in", values, "leavestatus");
            return (Criteria) this;
        }

        public Criteria andLeavestatusBetween(Byte value1, Byte value2) {
            addCriterion("leaveStatus between", value1, value2, "leavestatus");
            return (Criteria) this;
        }

        public Criteria andLeavestatusNotBetween(Byte value1, Byte value2) {
            addCriterion("leaveStatus not between", value1, value2, "leavestatus");
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