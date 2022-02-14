package com.example.ygo.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CardExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer offset;

    protected Integer rows;

    public CardExample() {
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

    public CardExample orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    public CardExample orderBy(String ... orderByClauses) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < orderByClauses.length; i++) {
            sb.append(orderByClauses[i]);
            if (i < orderByClauses.length - 1) {
                sb.append(" , ");
            }
        }
        this.setOrderByClause(sb.toString());
        return this;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria(this);
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
        rows = null;
        offset = null;
    }

    public static Criteria newAndCreateCriteria() {
        CardExample example = new CardExample();
        return example.createCriteria();
    }

    public CardExample when(boolean condition, IExampleWhen then) {
        if (condition) {
            then.example(this);
        }
        return this;
    }

    public CardExample when(boolean condition, IExampleWhen then, IExampleWhen otherwise) {
        if (condition) {
            then.example(this);
        } else {
            otherwise.example(this);
        }
        return this;
    }

    public CardExample distinct(boolean distinct) {
        this.setDistinct(distinct);
        return this;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return this.offset;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getRows() {
        return this.rows;
    }

    public CardExample limit(Integer rows) {
        this.rows = rows;
        return this;
    }

    public CardExample limit(Integer offset, Integer rows) {
        this.offset = offset;
        this.rows = rows;
        return this;
    }

    public CardExample page(Integer page, Integer pageSize) {
        this.offset = (page - 1) * pageSize;
        this.rows = pageSize;
        return this;
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("id = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("id <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanColumn(Card.Column column) {
            addCriterion(new StringBuilder("id > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("id >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanColumn(Card.Column column) {
            addCriterion(new StringBuilder("id < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("id <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("password = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("password <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanColumn(Card.Column column) {
            addCriterion(new StringBuilder("password > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("password >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanColumn(Card.Column column) {
            addCriterion(new StringBuilder("password < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("password <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("name = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("name <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanColumn(Card.Column column) {
            addCriterion(new StringBuilder("name > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("name >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanColumn(Card.Column column) {
            addCriterion(new StringBuilder("name < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("name <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andBanIsNull() {
            addCriterion("ban is null");
            return (Criteria) this;
        }

        public Criteria andBanIsNotNull() {
            addCriterion("ban is not null");
            return (Criteria) this;
        }

        public Criteria andBanEqualTo(String value) {
            addCriterion("ban =", value, "ban");
            return (Criteria) this;
        }

        public Criteria andBanEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("ban = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBanNotEqualTo(String value) {
            addCriterion("ban <>", value, "ban");
            return (Criteria) this;
        }

        public Criteria andBanNotEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("ban <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBanGreaterThan(String value) {
            addCriterion("ban >", value, "ban");
            return (Criteria) this;
        }

        public Criteria andBanGreaterThanColumn(Card.Column column) {
            addCriterion(new StringBuilder("ban > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBanGreaterThanOrEqualTo(String value) {
            addCriterion("ban >=", value, "ban");
            return (Criteria) this;
        }

        public Criteria andBanGreaterThanOrEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("ban >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBanLessThan(String value) {
            addCriterion("ban <", value, "ban");
            return (Criteria) this;
        }

        public Criteria andBanLessThanColumn(Card.Column column) {
            addCriterion(new StringBuilder("ban < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBanLessThanOrEqualTo(String value) {
            addCriterion("ban <=", value, "ban");
            return (Criteria) this;
        }

        public Criteria andBanLessThanOrEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("ban <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBanLike(String value) {
            addCriterion("ban like", value, "ban");
            return (Criteria) this;
        }

        public Criteria andBanNotLike(String value) {
            addCriterion("ban not like", value, "ban");
            return (Criteria) this;
        }

        public Criteria andBanIn(List<String> values) {
            addCriterion("ban in", values, "ban");
            return (Criteria) this;
        }

        public Criteria andBanNotIn(List<String> values) {
            addCriterion("ban not in", values, "ban");
            return (Criteria) this;
        }

        public Criteria andBanBetween(String value1, String value2) {
            addCriterion("ban between", value1, value2, "ban");
            return (Criteria) this;
        }

        public Criteria andBanNotBetween(String value1, String value2) {
            addCriterion("ban not between", value1, value2, "ban");
            return (Criteria) this;
        }

        public Criteria andLocaleIsNull() {
            addCriterion("locale is null");
            return (Criteria) this;
        }

        public Criteria andLocaleIsNotNull() {
            addCriterion("locale is not null");
            return (Criteria) this;
        }

        public Criteria andLocaleEqualTo(String value) {
            addCriterion("locale =", value, "locale");
            return (Criteria) this;
        }

        public Criteria andLocaleEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("locale = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andLocaleNotEqualTo(String value) {
            addCriterion("locale <>", value, "locale");
            return (Criteria) this;
        }

        public Criteria andLocaleNotEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("locale <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andLocaleGreaterThan(String value) {
            addCriterion("locale >", value, "locale");
            return (Criteria) this;
        }

        public Criteria andLocaleGreaterThanColumn(Card.Column column) {
            addCriterion(new StringBuilder("locale > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andLocaleGreaterThanOrEqualTo(String value) {
            addCriterion("locale >=", value, "locale");
            return (Criteria) this;
        }

        public Criteria andLocaleGreaterThanOrEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("locale >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andLocaleLessThan(String value) {
            addCriterion("locale <", value, "locale");
            return (Criteria) this;
        }

        public Criteria andLocaleLessThanColumn(Card.Column column) {
            addCriterion(new StringBuilder("locale < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andLocaleLessThanOrEqualTo(String value) {
            addCriterion("locale <=", value, "locale");
            return (Criteria) this;
        }

        public Criteria andLocaleLessThanOrEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("locale <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andLocaleLike(String value) {
            addCriterion("locale like", value, "locale");
            return (Criteria) this;
        }

        public Criteria andLocaleNotLike(String value) {
            addCriterion("locale not like", value, "locale");
            return (Criteria) this;
        }

        public Criteria andLocaleIn(List<String> values) {
            addCriterion("locale in", values, "locale");
            return (Criteria) this;
        }

        public Criteria andLocaleNotIn(List<String> values) {
            addCriterion("locale not in", values, "locale");
            return (Criteria) this;
        }

        public Criteria andLocaleBetween(String value1, String value2) {
            addCriterion("locale between", value1, value2, "locale");
            return (Criteria) this;
        }

        public Criteria andLocaleNotBetween(String value1, String value2) {
            addCriterion("locale not between", value1, value2, "locale");
            return (Criteria) this;
        }

        public Criteria andTypeFIsNull() {
            addCriterion("type_f is null");
            return (Criteria) this;
        }

        public Criteria andTypeFIsNotNull() {
            addCriterion("type_f is not null");
            return (Criteria) this;
        }

        public Criteria andTypeFEqualTo(String value) {
            addCriterion("type_f =", value, "typeF");
            return (Criteria) this;
        }

        public Criteria andTypeFEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("type_f = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTypeFNotEqualTo(String value) {
            addCriterion("type_f <>", value, "typeF");
            return (Criteria) this;
        }

        public Criteria andTypeFNotEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("type_f <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTypeFGreaterThan(String value) {
            addCriterion("type_f >", value, "typeF");
            return (Criteria) this;
        }

        public Criteria andTypeFGreaterThanColumn(Card.Column column) {
            addCriterion(new StringBuilder("type_f > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTypeFGreaterThanOrEqualTo(String value) {
            addCriterion("type_f >=", value, "typeF");
            return (Criteria) this;
        }

        public Criteria andTypeFGreaterThanOrEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("type_f >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTypeFLessThan(String value) {
            addCriterion("type_f <", value, "typeF");
            return (Criteria) this;
        }

        public Criteria andTypeFLessThanColumn(Card.Column column) {
            addCriterion(new StringBuilder("type_f < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTypeFLessThanOrEqualTo(String value) {
            addCriterion("type_f <=", value, "typeF");
            return (Criteria) this;
        }

        public Criteria andTypeFLessThanOrEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("type_f <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTypeFLike(String value) {
            addCriterion("type_f like", value, "typeF");
            return (Criteria) this;
        }

        public Criteria andTypeFNotLike(String value) {
            addCriterion("type_f not like", value, "typeF");
            return (Criteria) this;
        }

        public Criteria andTypeFIn(List<String> values) {
            addCriterion("type_f in", values, "typeF");
            return (Criteria) this;
        }

        public Criteria andTypeFNotIn(List<String> values) {
            addCriterion("type_f not in", values, "typeF");
            return (Criteria) this;
        }

        public Criteria andTypeFBetween(String value1, String value2) {
            addCriterion("type_f between", value1, value2, "typeF");
            return (Criteria) this;
        }

        public Criteria andTypeFNotBetween(String value1, String value2) {
            addCriterion("type_f not between", value1, value2, "typeF");
            return (Criteria) this;
        }

        public Criteria andTypeCIsNull() {
            addCriterion("type_c is null");
            return (Criteria) this;
        }

        public Criteria andTypeCIsNotNull() {
            addCriterion("type_c is not null");
            return (Criteria) this;
        }

        public Criteria andTypeCEqualTo(String value) {
            addCriterion("type_c =", value, "typeC");
            return (Criteria) this;
        }

        public Criteria andTypeCEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("type_c = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTypeCNotEqualTo(String value) {
            addCriterion("type_c <>", value, "typeC");
            return (Criteria) this;
        }

        public Criteria andTypeCNotEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("type_c <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTypeCGreaterThan(String value) {
            addCriterion("type_c >", value, "typeC");
            return (Criteria) this;
        }

        public Criteria andTypeCGreaterThanColumn(Card.Column column) {
            addCriterion(new StringBuilder("type_c > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTypeCGreaterThanOrEqualTo(String value) {
            addCriterion("type_c >=", value, "typeC");
            return (Criteria) this;
        }

        public Criteria andTypeCGreaterThanOrEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("type_c >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTypeCLessThan(String value) {
            addCriterion("type_c <", value, "typeC");
            return (Criteria) this;
        }

        public Criteria andTypeCLessThanColumn(Card.Column column) {
            addCriterion(new StringBuilder("type_c < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTypeCLessThanOrEqualTo(String value) {
            addCriterion("type_c <=", value, "typeC");
            return (Criteria) this;
        }

        public Criteria andTypeCLessThanOrEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("type_c <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTypeCLike(String value) {
            addCriterion("type_c like", value, "typeC");
            return (Criteria) this;
        }

        public Criteria andTypeCNotLike(String value) {
            addCriterion("type_c not like", value, "typeC");
            return (Criteria) this;
        }

        public Criteria andTypeCIn(List<String> values) {
            addCriterion("type_c in", values, "typeC");
            return (Criteria) this;
        }

        public Criteria andTypeCNotIn(List<String> values) {
            addCriterion("type_c not in", values, "typeC");
            return (Criteria) this;
        }

        public Criteria andTypeCBetween(String value1, String value2) {
            addCriterion("type_c between", value1, value2, "typeC");
            return (Criteria) this;
        }

        public Criteria andTypeCNotBetween(String value1, String value2) {
            addCriterion("type_c not between", value1, value2, "typeC");
            return (Criteria) this;
        }

        public Criteria andPicIsNull() {
            addCriterion("pic is null");
            return (Criteria) this;
        }

        public Criteria andPicIsNotNull() {
            addCriterion("pic is not null");
            return (Criteria) this;
        }

        public Criteria andPicEqualTo(String value) {
            addCriterion("pic =", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("pic = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPicNotEqualTo(String value) {
            addCriterion("pic <>", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicNotEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("pic <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPicGreaterThan(String value) {
            addCriterion("pic >", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicGreaterThanColumn(Card.Column column) {
            addCriterion(new StringBuilder("pic > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPicGreaterThanOrEqualTo(String value) {
            addCriterion("pic >=", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicGreaterThanOrEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("pic >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPicLessThan(String value) {
            addCriterion("pic <", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicLessThanColumn(Card.Column column) {
            addCriterion(new StringBuilder("pic < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPicLessThanOrEqualTo(String value) {
            addCriterion("pic <=", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicLessThanOrEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("pic <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPicLike(String value) {
            addCriterion("pic like", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicNotLike(String value) {
            addCriterion("pic not like", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicIn(List<String> values) {
            addCriterion("pic in", values, "pic");
            return (Criteria) this;
        }

        public Criteria andPicNotIn(List<String> values) {
            addCriterion("pic not in", values, "pic");
            return (Criteria) this;
        }

        public Criteria andPicBetween(String value1, String value2) {
            addCriterion("pic between", value1, value2, "pic");
            return (Criteria) this;
        }

        public Criteria andPicNotBetween(String value1, String value2) {
            addCriterion("pic not between", value1, value2, "pic");
            return (Criteria) this;
        }

        public Criteria andLevelIsNull() {
            addCriterion("level is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("level is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(Integer value) {
            addCriterion("level =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("level = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(Integer value) {
            addCriterion("level <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("level <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(Integer value) {
            addCriterion("level >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanColumn(Card.Column column) {
            addCriterion(new StringBuilder("level > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("level >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("level >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(Integer value) {
            addCriterion("level <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanColumn(Card.Column column) {
            addCriterion(new StringBuilder("level < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(Integer value) {
            addCriterion("level <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("level <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<Integer> values) {
            addCriterion("level in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<Integer> values) {
            addCriterion("level not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(Integer value1, Integer value2) {
            addCriterion("level between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("level not between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andAttributeIsNull() {
            addCriterion("attribute is null");
            return (Criteria) this;
        }

        public Criteria andAttributeIsNotNull() {
            addCriterion("attribute is not null");
            return (Criteria) this;
        }

        public Criteria andAttributeEqualTo(String value) {
            addCriterion("attribute =", value, "attribute");
            return (Criteria) this;
        }

        public Criteria andAttributeEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("attribute = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAttributeNotEqualTo(String value) {
            addCriterion("attribute <>", value, "attribute");
            return (Criteria) this;
        }

        public Criteria andAttributeNotEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("attribute <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAttributeGreaterThan(String value) {
            addCriterion("attribute >", value, "attribute");
            return (Criteria) this;
        }

        public Criteria andAttributeGreaterThanColumn(Card.Column column) {
            addCriterion(new StringBuilder("attribute > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAttributeGreaterThanOrEqualTo(String value) {
            addCriterion("attribute >=", value, "attribute");
            return (Criteria) this;
        }

        public Criteria andAttributeGreaterThanOrEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("attribute >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAttributeLessThan(String value) {
            addCriterion("attribute <", value, "attribute");
            return (Criteria) this;
        }

        public Criteria andAttributeLessThanColumn(Card.Column column) {
            addCriterion(new StringBuilder("attribute < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAttributeLessThanOrEqualTo(String value) {
            addCriterion("attribute <=", value, "attribute");
            return (Criteria) this;
        }

        public Criteria andAttributeLessThanOrEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("attribute <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAttributeLike(String value) {
            addCriterion("attribute like", value, "attribute");
            return (Criteria) this;
        }

        public Criteria andAttributeNotLike(String value) {
            addCriterion("attribute not like", value, "attribute");
            return (Criteria) this;
        }

        public Criteria andAttributeIn(List<String> values) {
            addCriterion("attribute in", values, "attribute");
            return (Criteria) this;
        }

        public Criteria andAttributeNotIn(List<String> values) {
            addCriterion("attribute not in", values, "attribute");
            return (Criteria) this;
        }

        public Criteria andAttributeBetween(String value1, String value2) {
            addCriterion("attribute between", value1, value2, "attribute");
            return (Criteria) this;
        }

        public Criteria andAttributeNotBetween(String value1, String value2) {
            addCriterion("attribute not between", value1, value2, "attribute");
            return (Criteria) this;
        }

        public Criteria andRaceIsNull() {
            addCriterion("race is null");
            return (Criteria) this;
        }

        public Criteria andRaceIsNotNull() {
            addCriterion("race is not null");
            return (Criteria) this;
        }

        public Criteria andRaceEqualTo(String value) {
            addCriterion("race =", value, "race");
            return (Criteria) this;
        }

        public Criteria andRaceEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("race = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRaceNotEqualTo(String value) {
            addCriterion("race <>", value, "race");
            return (Criteria) this;
        }

        public Criteria andRaceNotEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("race <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRaceGreaterThan(String value) {
            addCriterion("race >", value, "race");
            return (Criteria) this;
        }

        public Criteria andRaceGreaterThanColumn(Card.Column column) {
            addCriterion(new StringBuilder("race > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRaceGreaterThanOrEqualTo(String value) {
            addCriterion("race >=", value, "race");
            return (Criteria) this;
        }

        public Criteria andRaceGreaterThanOrEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("race >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRaceLessThan(String value) {
            addCriterion("race <", value, "race");
            return (Criteria) this;
        }

        public Criteria andRaceLessThanColumn(Card.Column column) {
            addCriterion(new StringBuilder("race < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRaceLessThanOrEqualTo(String value) {
            addCriterion("race <=", value, "race");
            return (Criteria) this;
        }

        public Criteria andRaceLessThanOrEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("race <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRaceLike(String value) {
            addCriterion("race like", value, "race");
            return (Criteria) this;
        }

        public Criteria andRaceNotLike(String value) {
            addCriterion("race not like", value, "race");
            return (Criteria) this;
        }

        public Criteria andRaceIn(List<String> values) {
            addCriterion("race in", values, "race");
            return (Criteria) this;
        }

        public Criteria andRaceNotIn(List<String> values) {
            addCriterion("race not in", values, "race");
            return (Criteria) this;
        }

        public Criteria andRaceBetween(String value1, String value2) {
            addCriterion("race between", value1, value2, "race");
            return (Criteria) this;
        }

        public Criteria andRaceNotBetween(String value1, String value2) {
            addCriterion("race not between", value1, value2, "race");
            return (Criteria) this;
        }

        public Criteria andAtkIsNull() {
            addCriterion("atk is null");
            return (Criteria) this;
        }

        public Criteria andAtkIsNotNull() {
            addCriterion("atk is not null");
            return (Criteria) this;
        }

        public Criteria andAtkEqualTo(String value) {
            addCriterion("atk =", value, "atk");
            return (Criteria) this;
        }

        public Criteria andAtkEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("atk = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAtkNotEqualTo(String value) {
            addCriterion("atk <>", value, "atk");
            return (Criteria) this;
        }

        public Criteria andAtkNotEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("atk <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAtkGreaterThan(String value) {
            addCriterion("atk >", value, "atk");
            return (Criteria) this;
        }

        public Criteria andAtkGreaterThanColumn(Card.Column column) {
            addCriterion(new StringBuilder("atk > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAtkGreaterThanOrEqualTo(String value) {
            addCriterion("atk >=", value, "atk");
            return (Criteria) this;
        }

        public Criteria andAtkGreaterThanOrEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("atk >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAtkLessThan(String value) {
            addCriterion("atk <", value, "atk");
            return (Criteria) this;
        }

        public Criteria andAtkLessThanColumn(Card.Column column) {
            addCriterion(new StringBuilder("atk < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAtkLessThanOrEqualTo(String value) {
            addCriterion("atk <=", value, "atk");
            return (Criteria) this;
        }

        public Criteria andAtkLessThanOrEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("atk <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAtkLike(String value) {
            addCriterion("atk like", value, "atk");
            return (Criteria) this;
        }

        public Criteria andAtkNotLike(String value) {
            addCriterion("atk not like", value, "atk");
            return (Criteria) this;
        }

        public Criteria andAtkIn(List<String> values) {
            addCriterion("atk in", values, "atk");
            return (Criteria) this;
        }

        public Criteria andAtkNotIn(List<String> values) {
            addCriterion("atk not in", values, "atk");
            return (Criteria) this;
        }

        public Criteria andAtkBetween(String value1, String value2) {
            addCriterion("atk between", value1, value2, "atk");
            return (Criteria) this;
        }

        public Criteria andAtkNotBetween(String value1, String value2) {
            addCriterion("atk not between", value1, value2, "atk");
            return (Criteria) this;
        }

        public Criteria andDefIsNull() {
            addCriterion("def is null");
            return (Criteria) this;
        }

        public Criteria andDefIsNotNull() {
            addCriterion("def is not null");
            return (Criteria) this;
        }

        public Criteria andDefEqualTo(String value) {
            addCriterion("def =", value, "def");
            return (Criteria) this;
        }

        public Criteria andDefEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("def = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDefNotEqualTo(String value) {
            addCriterion("def <>", value, "def");
            return (Criteria) this;
        }

        public Criteria andDefNotEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("def <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDefGreaterThan(String value) {
            addCriterion("def >", value, "def");
            return (Criteria) this;
        }

        public Criteria andDefGreaterThanColumn(Card.Column column) {
            addCriterion(new StringBuilder("def > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDefGreaterThanOrEqualTo(String value) {
            addCriterion("def >=", value, "def");
            return (Criteria) this;
        }

        public Criteria andDefGreaterThanOrEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("def >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDefLessThan(String value) {
            addCriterion("def <", value, "def");
            return (Criteria) this;
        }

        public Criteria andDefLessThanColumn(Card.Column column) {
            addCriterion(new StringBuilder("def < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDefLessThanOrEqualTo(String value) {
            addCriterion("def <=", value, "def");
            return (Criteria) this;
        }

        public Criteria andDefLessThanOrEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("def <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDefLike(String value) {
            addCriterion("def like", value, "def");
            return (Criteria) this;
        }

        public Criteria andDefNotLike(String value) {
            addCriterion("def not like", value, "def");
            return (Criteria) this;
        }

        public Criteria andDefIn(List<String> values) {
            addCriterion("def in", values, "def");
            return (Criteria) this;
        }

        public Criteria andDefNotIn(List<String> values) {
            addCriterion("def not in", values, "def");
            return (Criteria) this;
        }

        public Criteria andDefBetween(String value1, String value2) {
            addCriterion("def between", value1, value2, "def");
            return (Criteria) this;
        }

        public Criteria andDefNotBetween(String value1, String value2) {
            addCriterion("def not between", value1, value2, "def");
            return (Criteria) this;
        }

        public Criteria andPendIsNull() {
            addCriterion("pend is null");
            return (Criteria) this;
        }

        public Criteria andPendIsNotNull() {
            addCriterion("pend is not null");
            return (Criteria) this;
        }

        public Criteria andPendEqualTo(Integer value) {
            addCriterion("pend =", value, "pend");
            return (Criteria) this;
        }

        public Criteria andPendEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("pend = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPendNotEqualTo(Integer value) {
            addCriterion("pend <>", value, "pend");
            return (Criteria) this;
        }

        public Criteria andPendNotEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("pend <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPendGreaterThan(Integer value) {
            addCriterion("pend >", value, "pend");
            return (Criteria) this;
        }

        public Criteria andPendGreaterThanColumn(Card.Column column) {
            addCriterion(new StringBuilder("pend > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPendGreaterThanOrEqualTo(Integer value) {
            addCriterion("pend >=", value, "pend");
            return (Criteria) this;
        }

        public Criteria andPendGreaterThanOrEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("pend >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPendLessThan(Integer value) {
            addCriterion("pend <", value, "pend");
            return (Criteria) this;
        }

        public Criteria andPendLessThanColumn(Card.Column column) {
            addCriterion(new StringBuilder("pend < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPendLessThanOrEqualTo(Integer value) {
            addCriterion("pend <=", value, "pend");
            return (Criteria) this;
        }

        public Criteria andPendLessThanOrEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("pend <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPendIn(List<Integer> values) {
            addCriterion("pend in", values, "pend");
            return (Criteria) this;
        }

        public Criteria andPendNotIn(List<Integer> values) {
            addCriterion("pend not in", values, "pend");
            return (Criteria) this;
        }

        public Criteria andPendBetween(Integer value1, Integer value2) {
            addCriterion("pend between", value1, value2, "pend");
            return (Criteria) this;
        }

        public Criteria andPendNotBetween(Integer value1, Integer value2) {
            addCriterion("pend not between", value1, value2, "pend");
            return (Criteria) this;
        }

        public Criteria andLinkIsNull() {
            addCriterion("link is null");
            return (Criteria) this;
        }

        public Criteria andLinkIsNotNull() {
            addCriterion("link is not null");
            return (Criteria) this;
        }

        public Criteria andLinkEqualTo(Integer value) {
            addCriterion("link =", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("link = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andLinkNotEqualTo(Integer value) {
            addCriterion("link <>", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkNotEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("link <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andLinkGreaterThan(Integer value) {
            addCriterion("link >", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkGreaterThanColumn(Card.Column column) {
            addCriterion(new StringBuilder("link > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andLinkGreaterThanOrEqualTo(Integer value) {
            addCriterion("link >=", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkGreaterThanOrEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("link >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andLinkLessThan(Integer value) {
            addCriterion("link <", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkLessThanColumn(Card.Column column) {
            addCriterion(new StringBuilder("link < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andLinkLessThanOrEqualTo(Integer value) {
            addCriterion("link <=", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkLessThanOrEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("link <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andLinkIn(List<Integer> values) {
            addCriterion("link in", values, "link");
            return (Criteria) this;
        }

        public Criteria andLinkNotIn(List<Integer> values) {
            addCriterion("link not in", values, "link");
            return (Criteria) this;
        }

        public Criteria andLinkBetween(Integer value1, Integer value2) {
            addCriterion("link between", value1, value2, "link");
            return (Criteria) this;
        }

        public Criteria andLinkNotBetween(Integer value1, Integer value2) {
            addCriterion("link not between", value1, value2, "link");
            return (Criteria) this;
        }

        public Criteria andLinkArrowIsNull() {
            addCriterion("link_arrow is null");
            return (Criteria) this;
        }

        public Criteria andLinkArrowIsNotNull() {
            addCriterion("link_arrow is not null");
            return (Criteria) this;
        }

        public Criteria andLinkArrowEqualTo(String value) {
            addCriterion("link_arrow =", value, "linkArrow");
            return (Criteria) this;
        }

        public Criteria andLinkArrowEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("link_arrow = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andLinkArrowNotEqualTo(String value) {
            addCriterion("link_arrow <>", value, "linkArrow");
            return (Criteria) this;
        }

        public Criteria andLinkArrowNotEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("link_arrow <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andLinkArrowGreaterThan(String value) {
            addCriterion("link_arrow >", value, "linkArrow");
            return (Criteria) this;
        }

        public Criteria andLinkArrowGreaterThanColumn(Card.Column column) {
            addCriterion(new StringBuilder("link_arrow > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andLinkArrowGreaterThanOrEqualTo(String value) {
            addCriterion("link_arrow >=", value, "linkArrow");
            return (Criteria) this;
        }

        public Criteria andLinkArrowGreaterThanOrEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("link_arrow >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andLinkArrowLessThan(String value) {
            addCriterion("link_arrow <", value, "linkArrow");
            return (Criteria) this;
        }

        public Criteria andLinkArrowLessThanColumn(Card.Column column) {
            addCriterion(new StringBuilder("link_arrow < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andLinkArrowLessThanOrEqualTo(String value) {
            addCriterion("link_arrow <=", value, "linkArrow");
            return (Criteria) this;
        }

        public Criteria andLinkArrowLessThanOrEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("link_arrow <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andLinkArrowLike(String value) {
            addCriterion("link_arrow like", value, "linkArrow");
            return (Criteria) this;
        }

        public Criteria andLinkArrowNotLike(String value) {
            addCriterion("link_arrow not like", value, "linkArrow");
            return (Criteria) this;
        }

        public Criteria andLinkArrowIn(List<String> values) {
            addCriterion("link_arrow in", values, "linkArrow");
            return (Criteria) this;
        }

        public Criteria andLinkArrowNotIn(List<String> values) {
            addCriterion("link_arrow not in", values, "linkArrow");
            return (Criteria) this;
        }

        public Criteria andLinkArrowBetween(String value1, String value2) {
            addCriterion("link_arrow between", value1, value2, "linkArrow");
            return (Criteria) this;
        }

        public Criteria andLinkArrowNotBetween(String value1, String value2) {
            addCriterion("link_arrow not between", value1, value2, "linkArrow");
            return (Criteria) this;
        }

        public Criteria andPendDescIsNull() {
            addCriterion("pend_desc is null");
            return (Criteria) this;
        }

        public Criteria andPendDescIsNotNull() {
            addCriterion("pend_desc is not null");
            return (Criteria) this;
        }

        public Criteria andPendDescEqualTo(String value) {
            addCriterion("pend_desc =", value, "pendDesc");
            return (Criteria) this;
        }

        public Criteria andPendDescEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("pend_desc = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPendDescNotEqualTo(String value) {
            addCriterion("pend_desc <>", value, "pendDesc");
            return (Criteria) this;
        }

        public Criteria andPendDescNotEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("pend_desc <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPendDescGreaterThan(String value) {
            addCriterion("pend_desc >", value, "pendDesc");
            return (Criteria) this;
        }

        public Criteria andPendDescGreaterThanColumn(Card.Column column) {
            addCriterion(new StringBuilder("pend_desc > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPendDescGreaterThanOrEqualTo(String value) {
            addCriterion("pend_desc >=", value, "pendDesc");
            return (Criteria) this;
        }

        public Criteria andPendDescGreaterThanOrEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("pend_desc >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPendDescLessThan(String value) {
            addCriterion("pend_desc <", value, "pendDesc");
            return (Criteria) this;
        }

        public Criteria andPendDescLessThanColumn(Card.Column column) {
            addCriterion(new StringBuilder("pend_desc < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPendDescLessThanOrEqualTo(String value) {
            addCriterion("pend_desc <=", value, "pendDesc");
            return (Criteria) this;
        }

        public Criteria andPendDescLessThanOrEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("pend_desc <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPendDescLike(String value) {
            addCriterion("pend_desc like", value, "pendDesc");
            return (Criteria) this;
        }

        public Criteria andPendDescNotLike(String value) {
            addCriterion("pend_desc not like", value, "pendDesc");
            return (Criteria) this;
        }

        public Criteria andPendDescIn(List<String> values) {
            addCriterion("pend_desc in", values, "pendDesc");
            return (Criteria) this;
        }

        public Criteria andPendDescNotIn(List<String> values) {
            addCriterion("pend_desc not in", values, "pendDesc");
            return (Criteria) this;
        }

        public Criteria andPendDescBetween(String value1, String value2) {
            addCriterion("pend_desc between", value1, value2, "pendDesc");
            return (Criteria) this;
        }

        public Criteria andPendDescNotBetween(String value1, String value2) {
            addCriterion("pend_desc not between", value1, value2, "pendDesc");
            return (Criteria) this;
        }

        public Criteria andDescIsNull() {
            addCriterion("desc is null");
            return (Criteria) this;
        }

        public Criteria andDescIsNotNull() {
            addCriterion("desc is not null");
            return (Criteria) this;
        }

        public Criteria andDescEqualTo(String value) {
            addCriterion("desc =", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("desc = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDescNotEqualTo(String value) {
            addCriterion("desc <>", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescNotEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("desc <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDescGreaterThan(String value) {
            addCriterion("desc >", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescGreaterThanColumn(Card.Column column) {
            addCriterion(new StringBuilder("desc > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDescGreaterThanOrEqualTo(String value) {
            addCriterion("desc >=", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescGreaterThanOrEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("desc >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDescLessThan(String value) {
            addCriterion("desc <", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescLessThanColumn(Card.Column column) {
            addCriterion(new StringBuilder("desc < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDescLessThanOrEqualTo(String value) {
            addCriterion("desc <=", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescLessThanOrEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("desc <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDescLike(String value) {
            addCriterion("desc like", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescNotLike(String value) {
            addCriterion("desc not like", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescIn(List<String> values) {
            addCriterion("desc in", values, "desc");
            return (Criteria) this;
        }

        public Criteria andDescNotIn(List<String> values) {
            addCriterion("desc not in", values, "desc");
            return (Criteria) this;
        }

        public Criteria andDescBetween(String value1, String value2) {
            addCriterion("desc between", value1, value2, "desc");
            return (Criteria) this;
        }

        public Criteria andDescNotBetween(String value1, String value2) {
            addCriterion("desc not between", value1, value2, "desc");
            return (Criteria) this;
        }

        public Criteria andRareIsNull() {
            addCriterion("rare is null");
            return (Criteria) this;
        }

        public Criteria andRareIsNotNull() {
            addCriterion("rare is not null");
            return (Criteria) this;
        }

        public Criteria andRareEqualTo(String value) {
            addCriterion("rare =", value, "rare");
            return (Criteria) this;
        }

        public Criteria andRareEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("rare = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRareNotEqualTo(String value) {
            addCriterion("rare <>", value, "rare");
            return (Criteria) this;
        }

        public Criteria andRareNotEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("rare <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRareGreaterThan(String value) {
            addCriterion("rare >", value, "rare");
            return (Criteria) this;
        }

        public Criteria andRareGreaterThanColumn(Card.Column column) {
            addCriterion(new StringBuilder("rare > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRareGreaterThanOrEqualTo(String value) {
            addCriterion("rare >=", value, "rare");
            return (Criteria) this;
        }

        public Criteria andRareGreaterThanOrEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("rare >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRareLessThan(String value) {
            addCriterion("rare <", value, "rare");
            return (Criteria) this;
        }

        public Criteria andRareLessThanColumn(Card.Column column) {
            addCriterion(new StringBuilder("rare < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRareLessThanOrEqualTo(String value) {
            addCriterion("rare <=", value, "rare");
            return (Criteria) this;
        }

        public Criteria andRareLessThanOrEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("rare <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRareLike(String value) {
            addCriterion("rare like", value, "rare");
            return (Criteria) this;
        }

        public Criteria andRareNotLike(String value) {
            addCriterion("rare not like", value, "rare");
            return (Criteria) this;
        }

        public Criteria andRareIn(List<String> values) {
            addCriterion("rare in", values, "rare");
            return (Criteria) this;
        }

        public Criteria andRareNotIn(List<String> values) {
            addCriterion("rare not in", values, "rare");
            return (Criteria) this;
        }

        public Criteria andRareBetween(String value1, String value2) {
            addCriterion("rare between", value1, value2, "rare");
            return (Criteria) this;
        }

        public Criteria andRareNotBetween(String value1, String value2) {
            addCriterion("rare not between", value1, value2, "rare");
            return (Criteria) this;
        }

        public Criteria andHrefIsNull() {
            addCriterion("href is null");
            return (Criteria) this;
        }

        public Criteria andHrefIsNotNull() {
            addCriterion("href is not null");
            return (Criteria) this;
        }

        public Criteria andHrefEqualTo(String value) {
            addCriterion("href =", value, "href");
            return (Criteria) this;
        }

        public Criteria andHrefEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("href = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andHrefNotEqualTo(String value) {
            addCriterion("href <>", value, "href");
            return (Criteria) this;
        }

        public Criteria andHrefNotEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("href <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andHrefGreaterThan(String value) {
            addCriterion("href >", value, "href");
            return (Criteria) this;
        }

        public Criteria andHrefGreaterThanColumn(Card.Column column) {
            addCriterion(new StringBuilder("href > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andHrefGreaterThanOrEqualTo(String value) {
            addCriterion("href >=", value, "href");
            return (Criteria) this;
        }

        public Criteria andHrefGreaterThanOrEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("href >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andHrefLessThan(String value) {
            addCriterion("href <", value, "href");
            return (Criteria) this;
        }

        public Criteria andHrefLessThanColumn(Card.Column column) {
            addCriterion(new StringBuilder("href < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andHrefLessThanOrEqualTo(String value) {
            addCriterion("href <=", value, "href");
            return (Criteria) this;
        }

        public Criteria andHrefLessThanOrEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("href <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andHrefLike(String value) {
            addCriterion("href like", value, "href");
            return (Criteria) this;
        }

        public Criteria andHrefNotLike(String value) {
            addCriterion("href not like", value, "href");
            return (Criteria) this;
        }

        public Criteria andHrefIn(List<String> values) {
            addCriterion("href in", values, "href");
            return (Criteria) this;
        }

        public Criteria andHrefNotIn(List<String> values) {
            addCriterion("href not in", values, "href");
            return (Criteria) this;
        }

        public Criteria andHrefBetween(String value1, String value2) {
            addCriterion("href between", value1, value2, "href");
            return (Criteria) this;
        }

        public Criteria andHrefNotBetween(String value1, String value2) {
            addCriterion("href not between", value1, value2, "href");
            return (Criteria) this;
        }

        public Criteria andLikeNumIsNull() {
            addCriterion("like_num is null");
            return (Criteria) this;
        }

        public Criteria andLikeNumIsNotNull() {
            addCriterion("like_num is not null");
            return (Criteria) this;
        }

        public Criteria andLikeNumEqualTo(Long value) {
            addCriterion("like_num =", value, "likeNum");
            return (Criteria) this;
        }

        public Criteria andLikeNumEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("like_num = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andLikeNumNotEqualTo(Long value) {
            addCriterion("like_num <>", value, "likeNum");
            return (Criteria) this;
        }

        public Criteria andLikeNumNotEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("like_num <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andLikeNumGreaterThan(Long value) {
            addCriterion("like_num >", value, "likeNum");
            return (Criteria) this;
        }

        public Criteria andLikeNumGreaterThanColumn(Card.Column column) {
            addCriterion(new StringBuilder("like_num > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andLikeNumGreaterThanOrEqualTo(Long value) {
            addCriterion("like_num >=", value, "likeNum");
            return (Criteria) this;
        }

        public Criteria andLikeNumGreaterThanOrEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("like_num >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andLikeNumLessThan(Long value) {
            addCriterion("like_num <", value, "likeNum");
            return (Criteria) this;
        }

        public Criteria andLikeNumLessThanColumn(Card.Column column) {
            addCriterion(new StringBuilder("like_num < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andLikeNumLessThanOrEqualTo(Long value) {
            addCriterion("like_num <=", value, "likeNum");
            return (Criteria) this;
        }

        public Criteria andLikeNumLessThanOrEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("like_num <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andLikeNumIn(List<Long> values) {
            addCriterion("like_num in", values, "likeNum");
            return (Criteria) this;
        }

        public Criteria andLikeNumNotIn(List<Long> values) {
            addCriterion("like_num not in", values, "likeNum");
            return (Criteria) this;
        }

        public Criteria andLikeNumBetween(Long value1, Long value2) {
            addCriterion("like_num between", value1, value2, "likeNum");
            return (Criteria) this;
        }

        public Criteria andLikeNumNotBetween(Long value1, Long value2) {
            addCriterion("like_num not between", value1, value2, "likeNum");
            return (Criteria) this;
        }

        public Criteria andViewNumIsNull() {
            addCriterion("view_num is null");
            return (Criteria) this;
        }

        public Criteria andViewNumIsNotNull() {
            addCriterion("view_num is not null");
            return (Criteria) this;
        }

        public Criteria andViewNumEqualTo(Long value) {
            addCriterion("view_num =", value, "viewNum");
            return (Criteria) this;
        }

        public Criteria andViewNumEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("view_num = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andViewNumNotEqualTo(Long value) {
            addCriterion("view_num <>", value, "viewNum");
            return (Criteria) this;
        }

        public Criteria andViewNumNotEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("view_num <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andViewNumGreaterThan(Long value) {
            addCriterion("view_num >", value, "viewNum");
            return (Criteria) this;
        }

        public Criteria andViewNumGreaterThanColumn(Card.Column column) {
            addCriterion(new StringBuilder("view_num > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andViewNumGreaterThanOrEqualTo(Long value) {
            addCriterion("view_num >=", value, "viewNum");
            return (Criteria) this;
        }

        public Criteria andViewNumGreaterThanOrEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("view_num >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andViewNumLessThan(Long value) {
            addCriterion("view_num <", value, "viewNum");
            return (Criteria) this;
        }

        public Criteria andViewNumLessThanColumn(Card.Column column) {
            addCriterion(new StringBuilder("view_num < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andViewNumLessThanOrEqualTo(Long value) {
            addCriterion("view_num <=", value, "viewNum");
            return (Criteria) this;
        }

        public Criteria andViewNumLessThanOrEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("view_num <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andViewNumIn(List<Long> values) {
            addCriterion("view_num in", values, "viewNum");
            return (Criteria) this;
        }

        public Criteria andViewNumNotIn(List<Long> values) {
            addCriterion("view_num not in", values, "viewNum");
            return (Criteria) this;
        }

        public Criteria andViewNumBetween(Long value1, Long value2) {
            addCriterion("view_num between", value1, value2, "viewNum");
            return (Criteria) this;
        }

        public Criteria andViewNumNotBetween(Long value1, Long value2) {
            addCriterion("view_num not between", value1, value2, "viewNum");
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
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("create_time = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("create_time <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanColumn(Card.Column column) {
            addCriterion(new StringBuilder("create_time > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("create_time >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanColumn(Card.Column column) {
            addCriterion(new StringBuilder("create_time < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("create_time <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("update_time = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("update_time <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanColumn(Card.Column column) {
            addCriterion(new StringBuilder("update_time > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("update_time >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanColumn(Card.Column column) {
            addCriterion(new StringBuilder("update_time < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("update_time <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeIsNull() {
            addCriterion("delete_time is null");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeIsNotNull() {
            addCriterion("delete_time is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeEqualTo(Date value) {
            addCriterion("delete_time =", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("delete_time = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDeleteTimeNotEqualTo(Date value) {
            addCriterion("delete_time <>", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeNotEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("delete_time <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDeleteTimeGreaterThan(Date value) {
            addCriterion("delete_time >", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeGreaterThanColumn(Card.Column column) {
            addCriterion(new StringBuilder("delete_time > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDeleteTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("delete_time >=", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeGreaterThanOrEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("delete_time >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDeleteTimeLessThan(Date value) {
            addCriterion("delete_time <", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeLessThanColumn(Card.Column column) {
            addCriterion(new StringBuilder("delete_time < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDeleteTimeLessThanOrEqualTo(Date value) {
            addCriterion("delete_time <=", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeLessThanOrEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("delete_time <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDeleteTimeIn(List<Date> values) {
            addCriterion("delete_time in", values, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeNotIn(List<Date> values) {
            addCriterion("delete_time not in", values, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeBetween(Date value1, Date value2) {
            addCriterion("delete_time between", value1, value2, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeNotBetween(Date value1, Date value2) {
            addCriterion("delete_time not between", value1, value2, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("status = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("status <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanColumn(Card.Column column) {
            addCriterion(new StringBuilder("status > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("status >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanColumn(Card.Column column) {
            addCriterion(new StringBuilder("status < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualToColumn(Card.Column column) {
            addCriterion(new StringBuilder("status <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        private CardExample example;

        protected Criteria(CardExample example) {
            super();
            this.example = example;
        }

        public CardExample example() {
            return this.example;
        }

        @Deprecated
        public Criteria andIf(boolean ifAdd, ICriteriaAdd add) {
            if (ifAdd) {
                add.add(this);
            }
            return this;
        }

        public Criteria when(boolean condition, ICriteriaWhen then) {
            if (condition) {
                then.criteria(this);
            }
            return this;
        }

        public Criteria when(boolean condition, ICriteriaWhen then, ICriteriaWhen otherwise) {
            if (condition) {
                then.criteria(this);
            } else {
                otherwise.criteria(this);
            }
            return this;
        }

        public Criteria andLogicalDeleted(boolean deleted) {
            return deleted ? andStatusEqualTo(Card.Status.IS_DELETED.value()) : andStatusNotEqualTo(Card.Status.IS_DELETED.value());
        }

        @Deprecated
        public interface ICriteriaAdd {
            Criteria add(Criteria add);
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

    public interface ICriteriaWhen {
        void criteria(Criteria criteria);
    }

    public interface IExampleWhen {
        void example(com.example.ygo.entity.CardExample example);
    }
}