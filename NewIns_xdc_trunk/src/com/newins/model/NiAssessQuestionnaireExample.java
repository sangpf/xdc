package com.newins.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NiAssessQuestionnaireExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NiAssessQuestionnaireExample() {
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

        public Criteria andAqnidIsNull() {
            addCriterion("aqnId is null");
            return (Criteria) this;
        }

        public Criteria andAqnidIsNotNull() {
            addCriterion("aqnId is not null");
            return (Criteria) this;
        }

        public Criteria andAqnidEqualTo(Integer value) {
            addCriterion("aqnId =", value, "aqnid");
            return (Criteria) this;
        }

        public Criteria andAqnidNotEqualTo(Integer value) {
            addCriterion("aqnId <>", value, "aqnid");
            return (Criteria) this;
        }

        public Criteria andAqnidGreaterThan(Integer value) {
            addCriterion("aqnId >", value, "aqnid");
            return (Criteria) this;
        }

        public Criteria andAqnidGreaterThanOrEqualTo(Integer value) {
            addCriterion("aqnId >=", value, "aqnid");
            return (Criteria) this;
        }

        public Criteria andAqnidLessThan(Integer value) {
            addCriterion("aqnId <", value, "aqnid");
            return (Criteria) this;
        }

        public Criteria andAqnidLessThanOrEqualTo(Integer value) {
            addCriterion("aqnId <=", value, "aqnid");
            return (Criteria) this;
        }

        public Criteria andAqnidIn(List<Integer> values) {
            addCriterion("aqnId in", values, "aqnid");
            return (Criteria) this;
        }

        public Criteria andAqnidNotIn(List<Integer> values) {
            addCriterion("aqnId not in", values, "aqnid");
            return (Criteria) this;
        }

        public Criteria andAqnidBetween(Integer value1, Integer value2) {
            addCriterion("aqnId between", value1, value2, "aqnid");
            return (Criteria) this;
        }

        public Criteria andAqnidNotBetween(Integer value1, Integer value2) {
            addCriterion("aqnId not between", value1, value2, "aqnid");
            return (Criteria) this;
        }

        public Criteria andAqnnameIsNull() {
            addCriterion("aqnName is null");
            return (Criteria) this;
        }

        public Criteria andAqnnameIsNotNull() {
            addCriterion("aqnName is not null");
            return (Criteria) this;
        }

        public Criteria andAqnnameEqualTo(String value) {
            addCriterion("aqnName =", value, "aqnname");
            return (Criteria) this;
        }

        public Criteria andAqnnameNotEqualTo(String value) {
            addCriterion("aqnName <>", value, "aqnname");
            return (Criteria) this;
        }

        public Criteria andAqnnameGreaterThan(String value) {
            addCriterion("aqnName >", value, "aqnname");
            return (Criteria) this;
        }

        public Criteria andAqnnameGreaterThanOrEqualTo(String value) {
            addCriterion("aqnName >=", value, "aqnname");
            return (Criteria) this;
        }

        public Criteria andAqnnameLessThan(String value) {
            addCriterion("aqnName <", value, "aqnname");
            return (Criteria) this;
        }

        public Criteria andAqnnameLessThanOrEqualTo(String value) {
            addCriterion("aqnName <=", value, "aqnname");
            return (Criteria) this;
        }

        public Criteria andAqnnameLike(String value) {
            addCriterion("aqnName like", value, "aqnname");
            return (Criteria) this;
        }

        public Criteria andAqnnameNotLike(String value) {
            addCriterion("aqnName not like", value, "aqnname");
            return (Criteria) this;
        }

        public Criteria andAqnnameIn(List<String> values) {
            addCriterion("aqnName in", values, "aqnname");
            return (Criteria) this;
        }

        public Criteria andAqnnameNotIn(List<String> values) {
            addCriterion("aqnName not in", values, "aqnname");
            return (Criteria) this;
        }

        public Criteria andAqnnameBetween(String value1, String value2) {
            addCriterion("aqnName between", value1, value2, "aqnname");
            return (Criteria) this;
        }

        public Criteria andAqnnameNotBetween(String value1, String value2) {
            addCriterion("aqnName not between", value1, value2, "aqnname");
            return (Criteria) this;
        }

        public Criteria andPublisheridIsNull() {
            addCriterion("publisherId is null");
            return (Criteria) this;
        }

        public Criteria andPublisheridIsNotNull() {
            addCriterion("publisherId is not null");
            return (Criteria) this;
        }

        public Criteria andPublisheridEqualTo(Integer value) {
            addCriterion("publisherId =", value, "publisherid");
            return (Criteria) this;
        }

        public Criteria andPublisheridNotEqualTo(Integer value) {
            addCriterion("publisherId <>", value, "publisherid");
            return (Criteria) this;
        }

        public Criteria andPublisheridGreaterThan(Integer value) {
            addCriterion("publisherId >", value, "publisherid");
            return (Criteria) this;
        }

        public Criteria andPublisheridGreaterThanOrEqualTo(Integer value) {
            addCriterion("publisherId >=", value, "publisherid");
            return (Criteria) this;
        }

        public Criteria andPublisheridLessThan(Integer value) {
            addCriterion("publisherId <", value, "publisherid");
            return (Criteria) this;
        }

        public Criteria andPublisheridLessThanOrEqualTo(Integer value) {
            addCriterion("publisherId <=", value, "publisherid");
            return (Criteria) this;
        }

        public Criteria andPublisheridIn(List<Integer> values) {
            addCriterion("publisherId in", values, "publisherid");
            return (Criteria) this;
        }

        public Criteria andPublisheridNotIn(List<Integer> values) {
            addCriterion("publisherId not in", values, "publisherid");
            return (Criteria) this;
        }

        public Criteria andPublisheridBetween(Integer value1, Integer value2) {
            addCriterion("publisherId between", value1, value2, "publisherid");
            return (Criteria) this;
        }

        public Criteria andPublisheridNotBetween(Integer value1, Integer value2) {
            addCriterion("publisherId not between", value1, value2, "publisherid");
            return (Criteria) this;
        }

        public Criteria andPublishernameIsNull() {
            addCriterion("publisherName is null");
            return (Criteria) this;
        }

        public Criteria andPublishernameIsNotNull() {
            addCriterion("publisherName is not null");
            return (Criteria) this;
        }

        public Criteria andPublishernameEqualTo(String value) {
            addCriterion("publisherName =", value, "publishername");
            return (Criteria) this;
        }

        public Criteria andPublishernameNotEqualTo(String value) {
            addCriterion("publisherName <>", value, "publishername");
            return (Criteria) this;
        }

        public Criteria andPublishernameGreaterThan(String value) {
            addCriterion("publisherName >", value, "publishername");
            return (Criteria) this;
        }

        public Criteria andPublishernameGreaterThanOrEqualTo(String value) {
            addCriterion("publisherName >=", value, "publishername");
            return (Criteria) this;
        }

        public Criteria andPublishernameLessThan(String value) {
            addCriterion("publisherName <", value, "publishername");
            return (Criteria) this;
        }

        public Criteria andPublishernameLessThanOrEqualTo(String value) {
            addCriterion("publisherName <=", value, "publishername");
            return (Criteria) this;
        }

        public Criteria andPublishernameLike(String value) {
            addCriterion("publisherName like", value, "publishername");
            return (Criteria) this;
        }

        public Criteria andPublishernameNotLike(String value) {
            addCriterion("publisherName not like", value, "publishername");
            return (Criteria) this;
        }

        public Criteria andPublishernameIn(List<String> values) {
            addCriterion("publisherName in", values, "publishername");
            return (Criteria) this;
        }

        public Criteria andPublishernameNotIn(List<String> values) {
            addCriterion("publisherName not in", values, "publishername");
            return (Criteria) this;
        }

        public Criteria andPublishernameBetween(String value1, String value2) {
            addCriterion("publisherName between", value1, value2, "publishername");
            return (Criteria) this;
        }

        public Criteria andPublishernameNotBetween(String value1, String value2) {
            addCriterion("publisherName not between", value1, value2, "publishername");
            return (Criteria) this;
        }

        public Criteria andEpilogueIsNull() {
            addCriterion("epilogue is null");
            return (Criteria) this;
        }

        public Criteria andEpilogueIsNotNull() {
            addCriterion("epilogue is not null");
            return (Criteria) this;
        }

        public Criteria andEpilogueEqualTo(String value) {
            addCriterion("epilogue =", value, "epilogue");
            return (Criteria) this;
        }

        public Criteria andEpilogueNotEqualTo(String value) {
            addCriterion("epilogue <>", value, "epilogue");
            return (Criteria) this;
        }

        public Criteria andEpilogueGreaterThan(String value) {
            addCriterion("epilogue >", value, "epilogue");
            return (Criteria) this;
        }

        public Criteria andEpilogueGreaterThanOrEqualTo(String value) {
            addCriterion("epilogue >=", value, "epilogue");
            return (Criteria) this;
        }

        public Criteria andEpilogueLessThan(String value) {
            addCriterion("epilogue <", value, "epilogue");
            return (Criteria) this;
        }

        public Criteria andEpilogueLessThanOrEqualTo(String value) {
            addCriterion("epilogue <=", value, "epilogue");
            return (Criteria) this;
        }

        public Criteria andEpilogueLike(String value) {
            addCriterion("epilogue like", value, "epilogue");
            return (Criteria) this;
        }

        public Criteria andEpilogueNotLike(String value) {
            addCriterion("epilogue not like", value, "epilogue");
            return (Criteria) this;
        }

        public Criteria andEpilogueIn(List<String> values) {
            addCriterion("epilogue in", values, "epilogue");
            return (Criteria) this;
        }

        public Criteria andEpilogueNotIn(List<String> values) {
            addCriterion("epilogue not in", values, "epilogue");
            return (Criteria) this;
        }

        public Criteria andEpilogueBetween(String value1, String value2) {
            addCriterion("epilogue between", value1, value2, "epilogue");
            return (Criteria) this;
        }

        public Criteria andEpilogueNotBetween(String value1, String value2) {
            addCriterion("epilogue not between", value1, value2, "epilogue");
            return (Criteria) this;
        }

        public Criteria andPerfaceIsNull() {
            addCriterion("perface is null");
            return (Criteria) this;
        }

        public Criteria andPerfaceIsNotNull() {
            addCriterion("perface is not null");
            return (Criteria) this;
        }

        public Criteria andPerfaceEqualTo(String value) {
            addCriterion("perface =", value, "perface");
            return (Criteria) this;
        }

        public Criteria andPerfaceNotEqualTo(String value) {
            addCriterion("perface <>", value, "perface");
            return (Criteria) this;
        }

        public Criteria andPerfaceGreaterThan(String value) {
            addCriterion("perface >", value, "perface");
            return (Criteria) this;
        }

        public Criteria andPerfaceGreaterThanOrEqualTo(String value) {
            addCriterion("perface >=", value, "perface");
            return (Criteria) this;
        }

        public Criteria andPerfaceLessThan(String value) {
            addCriterion("perface <", value, "perface");
            return (Criteria) this;
        }

        public Criteria andPerfaceLessThanOrEqualTo(String value) {
            addCriterion("perface <=", value, "perface");
            return (Criteria) this;
        }

        public Criteria andPerfaceLike(String value) {
            addCriterion("perface like", value, "perface");
            return (Criteria) this;
        }

        public Criteria andPerfaceNotLike(String value) {
            addCriterion("perface not like", value, "perface");
            return (Criteria) this;
        }

        public Criteria andPerfaceIn(List<String> values) {
            addCriterion("perface in", values, "perface");
            return (Criteria) this;
        }

        public Criteria andPerfaceNotIn(List<String> values) {
            addCriterion("perface not in", values, "perface");
            return (Criteria) this;
        }

        public Criteria andPerfaceBetween(String value1, String value2) {
            addCriterion("perface between", value1, value2, "perface");
            return (Criteria) this;
        }

        public Criteria andPerfaceNotBetween(String value1, String value2) {
            addCriterion("perface not between", value1, value2, "perface");
            return (Criteria) this;
        }

        public Criteria andAqnclassidIsNull() {
            addCriterion("aqnClassId is null");
            return (Criteria) this;
        }

        public Criteria andAqnclassidIsNotNull() {
            addCriterion("aqnClassId is not null");
            return (Criteria) this;
        }

        public Criteria andAqnclassidEqualTo(Integer value) {
            addCriterion("aqnClassId =", value, "aqnclassid");
            return (Criteria) this;
        }

        public Criteria andAqnclassidNotEqualTo(Integer value) {
            addCriterion("aqnClassId <>", value, "aqnclassid");
            return (Criteria) this;
        }

        public Criteria andAqnclassidGreaterThan(Integer value) {
            addCriterion("aqnClassId >", value, "aqnclassid");
            return (Criteria) this;
        }

        public Criteria andAqnclassidGreaterThanOrEqualTo(Integer value) {
            addCriterion("aqnClassId >=", value, "aqnclassid");
            return (Criteria) this;
        }

        public Criteria andAqnclassidLessThan(Integer value) {
            addCriterion("aqnClassId <", value, "aqnclassid");
            return (Criteria) this;
        }

        public Criteria andAqnclassidLessThanOrEqualTo(Integer value) {
            addCriterion("aqnClassId <=", value, "aqnclassid");
            return (Criteria) this;
        }

        public Criteria andAqnclassidIn(List<Integer> values) {
            addCriterion("aqnClassId in", values, "aqnclassid");
            return (Criteria) this;
        }

        public Criteria andAqnclassidNotIn(List<Integer> values) {
            addCriterion("aqnClassId not in", values, "aqnclassid");
            return (Criteria) this;
        }

        public Criteria andAqnclassidBetween(Integer value1, Integer value2) {
            addCriterion("aqnClassId between", value1, value2, "aqnclassid");
            return (Criteria) this;
        }

        public Criteria andAqnclassidNotBetween(Integer value1, Integer value2) {
            addCriterion("aqnClassId not between", value1, value2, "aqnclassid");
            return (Criteria) this;
        }

        public Criteria andCtimeIsNull() {
            addCriterion("cTime is null");
            return (Criteria) this;
        }

        public Criteria andCtimeIsNotNull() {
            addCriterion("cTime is not null");
            return (Criteria) this;
        }

        public Criteria andCtimeEqualTo(Date value) {
            addCriterion("cTime =", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotEqualTo(Date value) {
            addCriterion("cTime <>", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeGreaterThan(Date value) {
            addCriterion("cTime >", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("cTime >=", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeLessThan(Date value) {
            addCriterion("cTime <", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeLessThanOrEqualTo(Date value) {
            addCriterion("cTime <=", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeIn(List<Date> values) {
            addCriterion("cTime in", values, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotIn(List<Date> values) {
            addCriterion("cTime not in", values, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeBetween(Date value1, Date value2) {
            addCriterion("cTime between", value1, value2, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotBetween(Date value1, Date value2) {
            addCriterion("cTime not between", value1, value2, "ctime");
            return (Criteria) this;
        }

        public Criteria andStimeIsNull() {
            addCriterion("sTime is null");
            return (Criteria) this;
        }

        public Criteria andStimeIsNotNull() {
            addCriterion("sTime is not null");
            return (Criteria) this;
        }

        public Criteria andStimeEqualTo(Date value) {
            addCriterion("sTime =", value, "stime");
            return (Criteria) this;
        }

        public Criteria andStimeNotEqualTo(Date value) {
            addCriterion("sTime <>", value, "stime");
            return (Criteria) this;
        }

        public Criteria andStimeGreaterThan(Date value) {
            addCriterion("sTime >", value, "stime");
            return (Criteria) this;
        }

        public Criteria andStimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sTime >=", value, "stime");
            return (Criteria) this;
        }

        public Criteria andStimeLessThan(Date value) {
            addCriterion("sTime <", value, "stime");
            return (Criteria) this;
        }

        public Criteria andStimeLessThanOrEqualTo(Date value) {
            addCriterion("sTime <=", value, "stime");
            return (Criteria) this;
        }

        public Criteria andStimeIn(List<Date> values) {
            addCriterion("sTime in", values, "stime");
            return (Criteria) this;
        }

        public Criteria andStimeNotIn(List<Date> values) {
            addCriterion("sTime not in", values, "stime");
            return (Criteria) this;
        }

        public Criteria andStimeBetween(Date value1, Date value2) {
            addCriterion("sTime between", value1, value2, "stime");
            return (Criteria) this;
        }

        public Criteria andStimeNotBetween(Date value1, Date value2) {
            addCriterion("sTime not between", value1, value2, "stime");
            return (Criteria) this;
        }

        public Criteria andStausIsNull() {
            addCriterion("staus is null");
            return (Criteria) this;
        }

        public Criteria andStausIsNotNull() {
            addCriterion("staus is not null");
            return (Criteria) this;
        }

        public Criteria andStausEqualTo(Byte value) {
            addCriterion("staus =", value, "staus");
            return (Criteria) this;
        }

        public Criteria andStausNotEqualTo(Byte value) {
            addCriterion("staus <>", value, "staus");
            return (Criteria) this;
        }

        public Criteria andStausGreaterThan(Byte value) {
            addCriterion("staus >", value, "staus");
            return (Criteria) this;
        }

        public Criteria andStausGreaterThanOrEqualTo(Byte value) {
            addCriterion("staus >=", value, "staus");
            return (Criteria) this;
        }

        public Criteria andStausLessThan(Byte value) {
            addCriterion("staus <", value, "staus");
            return (Criteria) this;
        }

        public Criteria andStausLessThanOrEqualTo(Byte value) {
            addCriterion("staus <=", value, "staus");
            return (Criteria) this;
        }

        public Criteria andStausIn(List<Byte> values) {
            addCriterion("staus in", values, "staus");
            return (Criteria) this;
        }

        public Criteria andStausNotIn(List<Byte> values) {
            addCriterion("staus not in", values, "staus");
            return (Criteria) this;
        }

        public Criteria andStausBetween(Byte value1, Byte value2) {
            addCriterion("staus between", value1, value2, "staus");
            return (Criteria) this;
        }

        public Criteria andStausNotBetween(Byte value1, Byte value2) {
            addCriterion("staus not between", value1, value2, "staus");
            return (Criteria) this;
        }

        public Criteria andRecommandqtyIsNull() {
            addCriterion("recommandQty is null");
            return (Criteria) this;
        }

        public Criteria andRecommandqtyIsNotNull() {
            addCriterion("recommandQty is not null");
            return (Criteria) this;
        }

        public Criteria andRecommandqtyEqualTo(Integer value) {
            addCriterion("recommandQty =", value, "recommandqty");
            return (Criteria) this;
        }

        public Criteria andRecommandqtyNotEqualTo(Integer value) {
            addCriterion("recommandQty <>", value, "recommandqty");
            return (Criteria) this;
        }

        public Criteria andRecommandqtyGreaterThan(Integer value) {
            addCriterion("recommandQty >", value, "recommandqty");
            return (Criteria) this;
        }

        public Criteria andRecommandqtyGreaterThanOrEqualTo(Integer value) {
            addCriterion("recommandQty >=", value, "recommandqty");
            return (Criteria) this;
        }

        public Criteria andRecommandqtyLessThan(Integer value) {
            addCriterion("recommandQty <", value, "recommandqty");
            return (Criteria) this;
        }

        public Criteria andRecommandqtyLessThanOrEqualTo(Integer value) {
            addCriterion("recommandQty <=", value, "recommandqty");
            return (Criteria) this;
        }

        public Criteria andRecommandqtyIn(List<Integer> values) {
            addCriterion("recommandQty in", values, "recommandqty");
            return (Criteria) this;
        }

        public Criteria andRecommandqtyNotIn(List<Integer> values) {
            addCriterion("recommandQty not in", values, "recommandqty");
            return (Criteria) this;
        }

        public Criteria andRecommandqtyBetween(Integer value1, Integer value2) {
            addCriterion("recommandQty between", value1, value2, "recommandqty");
            return (Criteria) this;
        }

        public Criteria andRecommandqtyNotBetween(Integer value1, Integer value2) {
            addCriterion("recommandQty not between", value1, value2, "recommandqty");
            return (Criteria) this;
        }

        public Criteria andQuestionnumIsNull() {
            addCriterion("questionNum is null");
            return (Criteria) this;
        }

        public Criteria andQuestionnumIsNotNull() {
            addCriterion("questionNum is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionnumEqualTo(Integer value) {
            addCriterion("questionNum =", value, "questionnum");
            return (Criteria) this;
        }

        public Criteria andQuestionnumNotEqualTo(Integer value) {
            addCriterion("questionNum <>", value, "questionnum");
            return (Criteria) this;
        }

        public Criteria andQuestionnumGreaterThan(Integer value) {
            addCriterion("questionNum >", value, "questionnum");
            return (Criteria) this;
        }

        public Criteria andQuestionnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("questionNum >=", value, "questionnum");
            return (Criteria) this;
        }

        public Criteria andQuestionnumLessThan(Integer value) {
            addCriterion("questionNum <", value, "questionnum");
            return (Criteria) this;
        }

        public Criteria andQuestionnumLessThanOrEqualTo(Integer value) {
            addCriterion("questionNum <=", value, "questionnum");
            return (Criteria) this;
        }

        public Criteria andQuestionnumIn(List<Integer> values) {
            addCriterion("questionNum in", values, "questionnum");
            return (Criteria) this;
        }

        public Criteria andQuestionnumNotIn(List<Integer> values) {
            addCriterion("questionNum not in", values, "questionnum");
            return (Criteria) this;
        }

        public Criteria andQuestionnumBetween(Integer value1, Integer value2) {
            addCriterion("questionNum between", value1, value2, "questionnum");
            return (Criteria) this;
        }

        public Criteria andQuestionnumNotBetween(Integer value1, Integer value2) {
            addCriterion("questionNum not between", value1, value2, "questionnum");
            return (Criteria) this;
        }

        public Criteria andFilepathIsNull() {
            addCriterion("filePath is null");
            return (Criteria) this;
        }

        public Criteria andFilepathIsNotNull() {
            addCriterion("filePath is not null");
            return (Criteria) this;
        }

        public Criteria andFilepathEqualTo(String value) {
            addCriterion("filePath =", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathNotEqualTo(String value) {
            addCriterion("filePath <>", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathGreaterThan(String value) {
            addCriterion("filePath >", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathGreaterThanOrEqualTo(String value) {
            addCriterion("filePath >=", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathLessThan(String value) {
            addCriterion("filePath <", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathLessThanOrEqualTo(String value) {
            addCriterion("filePath <=", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathLike(String value) {
            addCriterion("filePath like", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathNotLike(String value) {
            addCriterion("filePath not like", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathIn(List<String> values) {
            addCriterion("filePath in", values, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathNotIn(List<String> values) {
            addCriterion("filePath not in", values, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathBetween(String value1, String value2) {
            addCriterion("filePath between", value1, value2, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathNotBetween(String value1, String value2) {
            addCriterion("filePath not between", value1, value2, "filepath");
            return (Criteria) this;
        }

        public Criteria andValidationIsNull() {
            addCriterion("validation is null");
            return (Criteria) this;
        }

        public Criteria andValidationIsNotNull() {
            addCriterion("validation is not null");
            return (Criteria) this;
        }

        public Criteria andValidationEqualTo(Byte value) {
            addCriterion("validation =", value, "validation");
            return (Criteria) this;
        }

        public Criteria andValidationNotEqualTo(Byte value) {
            addCriterion("validation <>", value, "validation");
            return (Criteria) this;
        }

        public Criteria andValidationGreaterThan(Byte value) {
            addCriterion("validation >", value, "validation");
            return (Criteria) this;
        }

        public Criteria andValidationGreaterThanOrEqualTo(Byte value) {
            addCriterion("validation >=", value, "validation");
            return (Criteria) this;
        }

        public Criteria andValidationLessThan(Byte value) {
            addCriterion("validation <", value, "validation");
            return (Criteria) this;
        }

        public Criteria andValidationLessThanOrEqualTo(Byte value) {
            addCriterion("validation <=", value, "validation");
            return (Criteria) this;
        }

        public Criteria andValidationIn(List<Byte> values) {
            addCriterion("validation in", values, "validation");
            return (Criteria) this;
        }

        public Criteria andValidationNotIn(List<Byte> values) {
            addCriterion("validation not in", values, "validation");
            return (Criteria) this;
        }

        public Criteria andValidationBetween(Byte value1, Byte value2) {
            addCriterion("validation between", value1, value2, "validation");
            return (Criteria) this;
        }

        public Criteria andValidationNotBetween(Byte value1, Byte value2) {
            addCriterion("validation not between", value1, value2, "validation");
            return (Criteria) this;
        }

        public Criteria andTag1idIsNull() {
            addCriterion("tag1Id is null");
            return (Criteria) this;
        }

        public Criteria andTag1idIsNotNull() {
            addCriterion("tag1Id is not null");
            return (Criteria) this;
        }

        public Criteria andTag1idEqualTo(Integer value) {
            addCriterion("tag1Id =", value, "tag1id");
            return (Criteria) this;
        }

        public Criteria andTag1idNotEqualTo(Integer value) {
            addCriterion("tag1Id <>", value, "tag1id");
            return (Criteria) this;
        }

        public Criteria andTag1idGreaterThan(Integer value) {
            addCriterion("tag1Id >", value, "tag1id");
            return (Criteria) this;
        }

        public Criteria andTag1idGreaterThanOrEqualTo(Integer value) {
            addCriterion("tag1Id >=", value, "tag1id");
            return (Criteria) this;
        }

        public Criteria andTag1idLessThan(Integer value) {
            addCriterion("tag1Id <", value, "tag1id");
            return (Criteria) this;
        }

        public Criteria andTag1idLessThanOrEqualTo(Integer value) {
            addCriterion("tag1Id <=", value, "tag1id");
            return (Criteria) this;
        }

        public Criteria andTag1idIn(List<Integer> values) {
            addCriterion("tag1Id in", values, "tag1id");
            return (Criteria) this;
        }

        public Criteria andTag1idNotIn(List<Integer> values) {
            addCriterion("tag1Id not in", values, "tag1id");
            return (Criteria) this;
        }

        public Criteria andTag1idBetween(Integer value1, Integer value2) {
            addCriterion("tag1Id between", value1, value2, "tag1id");
            return (Criteria) this;
        }

        public Criteria andTag1idNotBetween(Integer value1, Integer value2) {
            addCriterion("tag1Id not between", value1, value2, "tag1id");
            return (Criteria) this;
        }

        public Criteria andTag2idIsNull() {
            addCriterion("tag2Id is null");
            return (Criteria) this;
        }

        public Criteria andTag2idIsNotNull() {
            addCriterion("tag2Id is not null");
            return (Criteria) this;
        }

        public Criteria andTag2idEqualTo(Integer value) {
            addCriterion("tag2Id =", value, "tag2id");
            return (Criteria) this;
        }

        public Criteria andTag2idNotEqualTo(Integer value) {
            addCriterion("tag2Id <>", value, "tag2id");
            return (Criteria) this;
        }

        public Criteria andTag2idGreaterThan(Integer value) {
            addCriterion("tag2Id >", value, "tag2id");
            return (Criteria) this;
        }

        public Criteria andTag2idGreaterThanOrEqualTo(Integer value) {
            addCriterion("tag2Id >=", value, "tag2id");
            return (Criteria) this;
        }

        public Criteria andTag2idLessThan(Integer value) {
            addCriterion("tag2Id <", value, "tag2id");
            return (Criteria) this;
        }

        public Criteria andTag2idLessThanOrEqualTo(Integer value) {
            addCriterion("tag2Id <=", value, "tag2id");
            return (Criteria) this;
        }

        public Criteria andTag2idIn(List<Integer> values) {
            addCriterion("tag2Id in", values, "tag2id");
            return (Criteria) this;
        }

        public Criteria andTag2idNotIn(List<Integer> values) {
            addCriterion("tag2Id not in", values, "tag2id");
            return (Criteria) this;
        }

        public Criteria andTag2idBetween(Integer value1, Integer value2) {
            addCriterion("tag2Id between", value1, value2, "tag2id");
            return (Criteria) this;
        }

        public Criteria andTag2idNotBetween(Integer value1, Integer value2) {
            addCriterion("tag2Id not between", value1, value2, "tag2id");
            return (Criteria) this;
        }

        public Criteria andTag3idIsNull() {
            addCriterion("tag3Id is null");
            return (Criteria) this;
        }

        public Criteria andTag3idIsNotNull() {
            addCriterion("tag3Id is not null");
            return (Criteria) this;
        }

        public Criteria andTag3idEqualTo(Integer value) {
            addCriterion("tag3Id =", value, "tag3id");
            return (Criteria) this;
        }

        public Criteria andTag3idNotEqualTo(Integer value) {
            addCriterion("tag3Id <>", value, "tag3id");
            return (Criteria) this;
        }

        public Criteria andTag3idGreaterThan(Integer value) {
            addCriterion("tag3Id >", value, "tag3id");
            return (Criteria) this;
        }

        public Criteria andTag3idGreaterThanOrEqualTo(Integer value) {
            addCriterion("tag3Id >=", value, "tag3id");
            return (Criteria) this;
        }

        public Criteria andTag3idLessThan(Integer value) {
            addCriterion("tag3Id <", value, "tag3id");
            return (Criteria) this;
        }

        public Criteria andTag3idLessThanOrEqualTo(Integer value) {
            addCriterion("tag3Id <=", value, "tag3id");
            return (Criteria) this;
        }

        public Criteria andTag3idIn(List<Integer> values) {
            addCriterion("tag3Id in", values, "tag3id");
            return (Criteria) this;
        }

        public Criteria andTag3idNotIn(List<Integer> values) {
            addCriterion("tag3Id not in", values, "tag3id");
            return (Criteria) this;
        }

        public Criteria andTag3idBetween(Integer value1, Integer value2) {
            addCriterion("tag3Id between", value1, value2, "tag3id");
            return (Criteria) this;
        }

        public Criteria andTag3idNotBetween(Integer value1, Integer value2) {
            addCriterion("tag3Id not between", value1, value2, "tag3id");
            return (Criteria) this;
        }

        public Criteria andTag4idIsNull() {
            addCriterion("tag4Id is null");
            return (Criteria) this;
        }

        public Criteria andTag4idIsNotNull() {
            addCriterion("tag4Id is not null");
            return (Criteria) this;
        }

        public Criteria andTag4idEqualTo(Integer value) {
            addCriterion("tag4Id =", value, "tag4id");
            return (Criteria) this;
        }

        public Criteria andTag4idNotEqualTo(Integer value) {
            addCriterion("tag4Id <>", value, "tag4id");
            return (Criteria) this;
        }

        public Criteria andTag4idGreaterThan(Integer value) {
            addCriterion("tag4Id >", value, "tag4id");
            return (Criteria) this;
        }

        public Criteria andTag4idGreaterThanOrEqualTo(Integer value) {
            addCriterion("tag4Id >=", value, "tag4id");
            return (Criteria) this;
        }

        public Criteria andTag4idLessThan(Integer value) {
            addCriterion("tag4Id <", value, "tag4id");
            return (Criteria) this;
        }

        public Criteria andTag4idLessThanOrEqualTo(Integer value) {
            addCriterion("tag4Id <=", value, "tag4id");
            return (Criteria) this;
        }

        public Criteria andTag4idIn(List<Integer> values) {
            addCriterion("tag4Id in", values, "tag4id");
            return (Criteria) this;
        }

        public Criteria andTag4idNotIn(List<Integer> values) {
            addCriterion("tag4Id not in", values, "tag4id");
            return (Criteria) this;
        }

        public Criteria andTag4idBetween(Integer value1, Integer value2) {
            addCriterion("tag4Id between", value1, value2, "tag4id");
            return (Criteria) this;
        }

        public Criteria andTag4idNotBetween(Integer value1, Integer value2) {
            addCriterion("tag4Id not between", value1, value2, "tag4id");
            return (Criteria) this;
        }

        public Criteria andTag5idIsNull() {
            addCriterion("tag5Id is null");
            return (Criteria) this;
        }

        public Criteria andTag5idIsNotNull() {
            addCriterion("tag5Id is not null");
            return (Criteria) this;
        }

        public Criteria andTag5idEqualTo(Integer value) {
            addCriterion("tag5Id =", value, "tag5id");
            return (Criteria) this;
        }

        public Criteria andTag5idNotEqualTo(Integer value) {
            addCriterion("tag5Id <>", value, "tag5id");
            return (Criteria) this;
        }

        public Criteria andTag5idGreaterThan(Integer value) {
            addCriterion("tag5Id >", value, "tag5id");
            return (Criteria) this;
        }

        public Criteria andTag5idGreaterThanOrEqualTo(Integer value) {
            addCriterion("tag5Id >=", value, "tag5id");
            return (Criteria) this;
        }

        public Criteria andTag5idLessThan(Integer value) {
            addCriterion("tag5Id <", value, "tag5id");
            return (Criteria) this;
        }

        public Criteria andTag5idLessThanOrEqualTo(Integer value) {
            addCriterion("tag5Id <=", value, "tag5id");
            return (Criteria) this;
        }

        public Criteria andTag5idIn(List<Integer> values) {
            addCriterion("tag5Id in", values, "tag5id");
            return (Criteria) this;
        }

        public Criteria andTag5idNotIn(List<Integer> values) {
            addCriterion("tag5Id not in", values, "tag5id");
            return (Criteria) this;
        }

        public Criteria andTag5idBetween(Integer value1, Integer value2) {
            addCriterion("tag5Id between", value1, value2, "tag5id");
            return (Criteria) this;
        }

        public Criteria andTag5idNotBetween(Integer value1, Integer value2) {
            addCriterion("tag5Id not between", value1, value2, "tag5id");
            return (Criteria) this;
        }

        public Criteria andPicpathIsNull() {
            addCriterion("picPath is null");
            return (Criteria) this;
        }

        public Criteria andPicpathIsNotNull() {
            addCriterion("picPath is not null");
            return (Criteria) this;
        }

        public Criteria andPicpathEqualTo(String value) {
            addCriterion("picPath =", value, "picpath");
            return (Criteria) this;
        }

        public Criteria andPicpathNotEqualTo(String value) {
            addCriterion("picPath <>", value, "picpath");
            return (Criteria) this;
        }

        public Criteria andPicpathGreaterThan(String value) {
            addCriterion("picPath >", value, "picpath");
            return (Criteria) this;
        }

        public Criteria andPicpathGreaterThanOrEqualTo(String value) {
            addCriterion("picPath >=", value, "picpath");
            return (Criteria) this;
        }

        public Criteria andPicpathLessThan(String value) {
            addCriterion("picPath <", value, "picpath");
            return (Criteria) this;
        }

        public Criteria andPicpathLessThanOrEqualTo(String value) {
            addCriterion("picPath <=", value, "picpath");
            return (Criteria) this;
        }

        public Criteria andPicpathLike(String value) {
            addCriterion("picPath like", value, "picpath");
            return (Criteria) this;
        }

        public Criteria andPicpathNotLike(String value) {
            addCriterion("picPath not like", value, "picpath");
            return (Criteria) this;
        }

        public Criteria andPicpathIn(List<String> values) {
            addCriterion("picPath in", values, "picpath");
            return (Criteria) this;
        }

        public Criteria andPicpathNotIn(List<String> values) {
            addCriterion("picPath not in", values, "picpath");
            return (Criteria) this;
        }

        public Criteria andPicpathBetween(String value1, String value2) {
            addCriterion("picPath between", value1, value2, "picpath");
            return (Criteria) this;
        }

        public Criteria andPicpathNotBetween(String value1, String value2) {
            addCriterion("picPath not between", value1, value2, "picpath");
            return (Criteria) this;
        }

        public Criteria andAqnsummaryIsNull() {
            addCriterion("aqnSummary is null");
            return (Criteria) this;
        }

        public Criteria andAqnsummaryIsNotNull() {
            addCriterion("aqnSummary is not null");
            return (Criteria) this;
        }

        public Criteria andAqnsummaryEqualTo(String value) {
            addCriterion("aqnSummary =", value, "aqnsummary");
            return (Criteria) this;
        }

        public Criteria andAqnsummaryNotEqualTo(String value) {
            addCriterion("aqnSummary <>", value, "aqnsummary");
            return (Criteria) this;
        }

        public Criteria andAqnsummaryGreaterThan(String value) {
            addCriterion("aqnSummary >", value, "aqnsummary");
            return (Criteria) this;
        }

        public Criteria andAqnsummaryGreaterThanOrEqualTo(String value) {
            addCriterion("aqnSummary >=", value, "aqnsummary");
            return (Criteria) this;
        }

        public Criteria andAqnsummaryLessThan(String value) {
            addCriterion("aqnSummary <", value, "aqnsummary");
            return (Criteria) this;
        }

        public Criteria andAqnsummaryLessThanOrEqualTo(String value) {
            addCriterion("aqnSummary <=", value, "aqnsummary");
            return (Criteria) this;
        }

        public Criteria andAqnsummaryLike(String value) {
            addCriterion("aqnSummary like", value, "aqnsummary");
            return (Criteria) this;
        }

        public Criteria andAqnsummaryNotLike(String value) {
            addCriterion("aqnSummary not like", value, "aqnsummary");
            return (Criteria) this;
        }

        public Criteria andAqnsummaryIn(List<String> values) {
            addCriterion("aqnSummary in", values, "aqnsummary");
            return (Criteria) this;
        }

        public Criteria andAqnsummaryNotIn(List<String> values) {
            addCriterion("aqnSummary not in", values, "aqnsummary");
            return (Criteria) this;
        }

        public Criteria andAqnsummaryBetween(String value1, String value2) {
            addCriterion("aqnSummary between", value1, value2, "aqnsummary");
            return (Criteria) this;
        }

        public Criteria andAqnsummaryNotBetween(String value1, String value2) {
            addCriterion("aqnSummary not between", value1, value2, "aqnsummary");
            return (Criteria) this;
        }

        public Criteria andEditorIsNull() {
            addCriterion("editor is null");
            return (Criteria) this;
        }

        public Criteria andEditorIsNotNull() {
            addCriterion("editor is not null");
            return (Criteria) this;
        }

        public Criteria andEditorEqualTo(String value) {
            addCriterion("editor =", value, "editor");
            return (Criteria) this;
        }

        public Criteria andEditorNotEqualTo(String value) {
            addCriterion("editor <>", value, "editor");
            return (Criteria) this;
        }

        public Criteria andEditorGreaterThan(String value) {
            addCriterion("editor >", value, "editor");
            return (Criteria) this;
        }

        public Criteria andEditorGreaterThanOrEqualTo(String value) {
            addCriterion("editor >=", value, "editor");
            return (Criteria) this;
        }

        public Criteria andEditorLessThan(String value) {
            addCriterion("editor <", value, "editor");
            return (Criteria) this;
        }

        public Criteria andEditorLessThanOrEqualTo(String value) {
            addCriterion("editor <=", value, "editor");
            return (Criteria) this;
        }

        public Criteria andEditorLike(String value) {
            addCriterion("editor like", value, "editor");
            return (Criteria) this;
        }

        public Criteria andEditorNotLike(String value) {
            addCriterion("editor not like", value, "editor");
            return (Criteria) this;
        }

        public Criteria andEditorIn(List<String> values) {
            addCriterion("editor in", values, "editor");
            return (Criteria) this;
        }

        public Criteria andEditorNotIn(List<String> values) {
            addCriterion("editor not in", values, "editor");
            return (Criteria) this;
        }

        public Criteria andEditorBetween(String value1, String value2) {
            addCriterion("editor between", value1, value2, "editor");
            return (Criteria) this;
        }

        public Criteria andEditorNotBetween(String value1, String value2) {
            addCriterion("editor not between", value1, value2, "editor");
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