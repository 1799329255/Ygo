package com.example.ygo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

@ApiModel(value="com.example.ygo.entity.Card")
public class Card implements Serializable {
    public static final Integer IS_DELETED = Status.IS_DELETED.value();

    public static final Integer NOT_DELETED = Status.NOT_DELETED.value();

    @ApiModelProperty(value="idID")
    private Long id;

    @ApiModelProperty(value="password卡牌密码*")
    private String password;

    @ApiModelProperty(value="name名字*")
    private String name;

    @ApiModelProperty(value="ban禁止/限制/准限制*")
    private String ban;

    @ApiModelProperty(value="localeOCG ，TCG，MD，DL*")
    private String locale;

    @ApiModelProperty(value="typeF类型：怪兽/魔法/陷阱*")
    private String typeF;

    @ApiModelProperty(value="typeC类型：效果，融合，反击*")
    private String typeC;

    @ApiModelProperty(value="pic图片*")
    private String pic;

    @ApiModelProperty(value="level星/阶：0~12*")
    private Integer level;

    @ApiModelProperty(value="attribute属性：光、地、暗、水、炎、神、风*")
    private String attribute;

    @ApiModelProperty(value="race种族")
    private String race;

    @ApiModelProperty(value="atk攻击力*")
    private String atk;

    @ApiModelProperty(value="def防御力*")
    private String def;

    @ApiModelProperty(value="pend灵摆数：0~12*")
    private Integer pend;

    @ApiModelProperty(value="link连接数：1~9*")
    private Integer link;

    @ApiModelProperty(value="linkArrow连接箭头：1~9*")
    private String linkArrow;

    @ApiModelProperty(value="pendDesc灵摆效果*")
    private String pendDesc;

    @ApiModelProperty(value="desc效果文本*")
    private String desc;

    @ApiModelProperty(value="rare罕贵度")
    private String rare;

    @ApiModelProperty(value="href卡牌详细页面*")
    private String href;

    @ApiModelProperty(value="likeNum点赞量")
    private Long likeNum;

    @ApiModelProperty(value="viewNum浏览量")
    private Long viewNum;

    @ApiModelProperty(value="createTime创建时间")
    private Date createTime;

    @ApiModelProperty(value="updateTime更新时间")
    private Date updateTime;

    @ApiModelProperty(value="deleteTime删除时间")
    private Date deleteTime;

    @ApiModelProperty(value="status状态 0：删除  1：可用")
    private Integer status;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getBan() {
        return ban;
    }

    public void setBan(String ban) {
        this.ban = ban == null ? null : ban.trim();
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale == null ? null : locale.trim();
    }

    public String getTypeF() {
        return typeF;
    }

    public void setTypeF(String typeF) {
        this.typeF = typeF == null ? null : typeF.trim();
    }

    public String getTypeC() {
        return typeC;
    }

    public void setTypeC(String typeC) {
        this.typeC = typeC == null ? null : typeC.trim();
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute == null ? null : attribute.trim();
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race == null ? null : race.trim();
    }

    public String getAtk() {
        return atk;
    }

    public void setAtk(String atk) {
        this.atk = atk == null ? null : atk.trim();
    }

    public String getDef() {
        return def;
    }

    public void setDef(String def) {
        this.def = def == null ? null : def.trim();
    }

    public Integer getPend() {
        return pend;
    }

    public void setPend(Integer pend) {
        this.pend = pend;
    }

    public Integer getLink() {
        return link;
    }

    public void setLink(Integer link) {
        this.link = link;
    }

    public String getLinkArrow() {
        return linkArrow;
    }

    public void setLinkArrow(String linkArrow) {
        this.linkArrow = linkArrow == null ? null : linkArrow.trim();
    }

    public String getPendDesc() {
        return pendDesc;
    }

    public void setPendDesc(String pendDesc) {
        this.pendDesc = pendDesc == null ? null : pendDesc.trim();
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    public String getRare() {
        return rare;
    }

    public void setRare(String rare) {
        this.rare = rare == null ? null : rare.trim();
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href == null ? null : href.trim();
    }

    public Long getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(Long likeNum) {
        this.likeNum = likeNum;
    }

    public Long getViewNum() {
        return viewNum;
    }

    public void setViewNum(Long viewNum) {
        this.viewNum = viewNum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }

    public void andLogicalDeleted(boolean deleted) {
        setStatus(deleted ? Status.IS_DELETED.value() : Status.NOT_DELETED.value());
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Card other = (Card) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getBan() == null ? other.getBan() == null : this.getBan().equals(other.getBan()))
            && (this.getLocale() == null ? other.getLocale() == null : this.getLocale().equals(other.getLocale()))
            && (this.getTypeF() == null ? other.getTypeF() == null : this.getTypeF().equals(other.getTypeF()))
            && (this.getTypeC() == null ? other.getTypeC() == null : this.getTypeC().equals(other.getTypeC()))
            && (this.getPic() == null ? other.getPic() == null : this.getPic().equals(other.getPic()))
            && (this.getLevel() == null ? other.getLevel() == null : this.getLevel().equals(other.getLevel()))
            && (this.getAttribute() == null ? other.getAttribute() == null : this.getAttribute().equals(other.getAttribute()))
            && (this.getRace() == null ? other.getRace() == null : this.getRace().equals(other.getRace()))
            && (this.getAtk() == null ? other.getAtk() == null : this.getAtk().equals(other.getAtk()))
            && (this.getDef() == null ? other.getDef() == null : this.getDef().equals(other.getDef()))
            && (this.getPend() == null ? other.getPend() == null : this.getPend().equals(other.getPend()))
            && (this.getLink() == null ? other.getLink() == null : this.getLink().equals(other.getLink()))
            && (this.getLinkArrow() == null ? other.getLinkArrow() == null : this.getLinkArrow().equals(other.getLinkArrow()))
            && (this.getPendDesc() == null ? other.getPendDesc() == null : this.getPendDesc().equals(other.getPendDesc()))
            && (this.getDesc() == null ? other.getDesc() == null : this.getDesc().equals(other.getDesc()))
            && (this.getRare() == null ? other.getRare() == null : this.getRare().equals(other.getRare()))
            && (this.getHref() == null ? other.getHref() == null : this.getHref().equals(other.getHref()))
            && (this.getLikeNum() == null ? other.getLikeNum() == null : this.getLikeNum().equals(other.getLikeNum()))
            && (this.getViewNum() == null ? other.getViewNum() == null : this.getViewNum().equals(other.getViewNum()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getDeleteTime() == null ? other.getDeleteTime() == null : this.getDeleteTime().equals(other.getDeleteTime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getBan() == null) ? 0 : getBan().hashCode());
        result = prime * result + ((getLocale() == null) ? 0 : getLocale().hashCode());
        result = prime * result + ((getTypeF() == null) ? 0 : getTypeF().hashCode());
        result = prime * result + ((getTypeC() == null) ? 0 : getTypeC().hashCode());
        result = prime * result + ((getPic() == null) ? 0 : getPic().hashCode());
        result = prime * result + ((getLevel() == null) ? 0 : getLevel().hashCode());
        result = prime * result + ((getAttribute() == null) ? 0 : getAttribute().hashCode());
        result = prime * result + ((getRace() == null) ? 0 : getRace().hashCode());
        result = prime * result + ((getAtk() == null) ? 0 : getAtk().hashCode());
        result = prime * result + ((getDef() == null) ? 0 : getDef().hashCode());
        result = prime * result + ((getPend() == null) ? 0 : getPend().hashCode());
        result = prime * result + ((getLink() == null) ? 0 : getLink().hashCode());
        result = prime * result + ((getLinkArrow() == null) ? 0 : getLinkArrow().hashCode());
        result = prime * result + ((getPendDesc() == null) ? 0 : getPendDesc().hashCode());
        result = prime * result + ((getDesc() == null) ? 0 : getDesc().hashCode());
        result = prime * result + ((getRare() == null) ? 0 : getRare().hashCode());
        result = prime * result + ((getHref() == null) ? 0 : getHref().hashCode());
        result = prime * result + ((getLikeNum() == null) ? 0 : getLikeNum().hashCode());
        result = prime * result + ((getViewNum() == null) ? 0 : getViewNum().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getDeleteTime() == null) ? 0 : getDeleteTime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", IS_DELETED=").append(IS_DELETED);
        sb.append(", NOT_DELETED=").append(NOT_DELETED);
        sb.append(", id=").append(id);
        sb.append(", password=").append(password);
        sb.append(", name=").append(name);
        sb.append(", ban=").append(ban);
        sb.append(", locale=").append(locale);
        sb.append(", typeF=").append(typeF);
        sb.append(", typeC=").append(typeC);
        sb.append(", pic=").append(pic);
        sb.append(", level=").append(level);
        sb.append(", attribute=").append(attribute);
        sb.append(", race=").append(race);
        sb.append(", atk=").append(atk);
        sb.append(", def=").append(def);
        sb.append(", pend=").append(pend);
        sb.append(", link=").append(link);
        sb.append(", linkArrow=").append(linkArrow);
        sb.append(", pendDesc=").append(pendDesc);
        sb.append(", desc=").append(desc);
        sb.append(", rare=").append(rare);
        sb.append(", href=").append(href);
        sb.append(", likeNum=").append(likeNum);
        sb.append(", viewNum=").append(viewNum);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", deleteTime=").append(deleteTime);
        sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
    }

    public static Card.Builder builder() {
        return new Card.Builder();
    }

    public static class Builder {
        private Card obj;

        public Builder() {
            this.obj = new Card();
        }

        public Builder id(Long id) {
            obj.setId(id);
            return this;
        }

        public Builder password(String password) {
            obj.setPassword(password);
            return this;
        }

        public Builder name(String name) {
            obj.setName(name);
            return this;
        }

        public Builder ban(String ban) {
            obj.setBan(ban);
            return this;
        }

        public Builder locale(String locale) {
            obj.setLocale(locale);
            return this;
        }

        public Builder typeF(String typeF) {
            obj.setTypeF(typeF);
            return this;
        }

        public Builder typeC(String typeC) {
            obj.setTypeC(typeC);
            return this;
        }

        public Builder pic(String pic) {
            obj.setPic(pic);
            return this;
        }

        public Builder level(Integer level) {
            obj.setLevel(level);
            return this;
        }

        public Builder attribute(String attribute) {
            obj.setAttribute(attribute);
            return this;
        }

        public Builder race(String race) {
            obj.setRace(race);
            return this;
        }

        public Builder atk(String atk) {
            obj.setAtk(atk);
            return this;
        }

        public Builder def(String def) {
            obj.setDef(def);
            return this;
        }

        public Builder pend(Integer pend) {
            obj.setPend(pend);
            return this;
        }

        public Builder pendDesc(String pendDesc) {
            obj.setPendDesc(pendDesc);
            return this;
        }

        public Builder link(Integer link) {
            obj.setLink(link);
            return this;
        }

        public Builder linkArrow(String linkArrow) {
            obj.setLinkArrow(linkArrow);
            return this;
        }

        public Builder desc(String desc) {
            obj.setDesc(desc);
            return this;
        }

        public Builder rare(String rare) {
            obj.setRare(rare);
            return this;
        }

        public Builder href(String href) {
            obj.setHref(href);
            return this;
        }

        public Builder likeNum(Long likeNum) {
            obj.setLikeNum(likeNum);
            return this;
        }

        public Builder viewNum(Long viewNum) {
            obj.setViewNum(viewNum);
            return this;
        }

        public Builder createTime(Date createTime) {
            obj.setCreateTime(createTime);
            return this;
        }

        public Builder updateTime(Date updateTime) {
            obj.setUpdateTime(updateTime);
            return this;
        }

        public Builder deleteTime(Date deleteTime) {
            obj.setDeleteTime(deleteTime);
            return this;
        }

        public Builder status(Integer status) {
            obj.setStatus(status);
            return this;
        }

        public Card build() {
            return this.obj;
        }
    }

    public enum Status {
        NOT_DELETED(new Integer("1"), "未删除"),
        IS_DELETED(new Integer("0"), "已删除");

        private final Integer value;

        private final String name;

        Status(Integer value, String name) {
            this.value = value;
            this.name = name;
        }

        public Integer getValue() {
            return this.value;
        }

        public Integer value() {
            return this.value;
        }

        public String getName() {
            return this.name;
        }

        public static Status parseValue(Integer value) {
            if (value != null) {
                for (Status item : values()) {
                    if (item.value.equals(value)) {
                        return item;
                    }
                }
            }
            return null;
        }

        public static Status parseName(String name) {
            if (name != null) {
                for (Status item : values()) {
                    if (item.name.equals(name)) {
                        return item;
                    }
                }
            }
            return null;
        }
    }

    public enum Column {
        id("id", "id", "BIGINT", false),
        password("password", "password", "VARCHAR", false),
        name("name", "name", "VARCHAR", false),
        ban("ban", "ban", "VARCHAR", false),
        locale("locale", "locale", "VARCHAR", false),
        typeF("type_f", "typeF", "VARCHAR", false),
        typeC("type_c", "typeC", "VARCHAR", false),
        pic("pic", "pic", "VARCHAR", false),
        level("level", "level", "INTEGER", false),
        attribute("attribute", "attribute", "VARCHAR", false),
        race("race", "race", "VARCHAR", false),
        atk("atk", "atk", "VARCHAR", false),
        def("def", "def", "VARCHAR", false),
        pend("pend", "pend", "INTEGER", false),
        link("link", "link", "INTEGER", false),
        linkArrow("link_arrow", "linkArrow", "VARCHAR", false),
        pendDesc("pend_desc", "pendDesc", "VARCHAR", false),
        desc("desc", "desc", "VARCHAR", false),
        rare("rare", "rare", "VARCHAR", false),
        href("href", "href", "VARCHAR", false),
        likeNum("like_num", "likeNum", "BIGINT", false),
        viewNum("view_num", "viewNum", "BIGINT", false),
        createTime("create_time", "createTime", "TIMESTAMP", false),
        updateTime("update_time", "updateTime", "TIMESTAMP", false),
        deleteTime("delete_time", "deleteTime", "TIMESTAMP", false),
        status("status", "status", "INTEGER", false);

        private static final String BEGINNING_DELIMITER = "\"";

        private static final String ENDING_DELIMITER = "\"";

        private final String column;

        private final boolean isColumnNameDelimited;

        private final String javaProperty;

        private final String jdbcType;

        public String value() {
            return this.column;
        }

        public String getValue() {
            return this.column;
        }

        public String getJavaProperty() {
            return this.javaProperty;
        }

        public String getJdbcType() {
            return this.jdbcType;
        }

        Column(String column, String javaProperty, String jdbcType, boolean isColumnNameDelimited) {
            this.column = column;
            this.javaProperty = javaProperty;
            this.jdbcType = jdbcType;
            this.isColumnNameDelimited = isColumnNameDelimited;
        }

        public String desc() {
            return this.getEscapedColumnName() + " DESC";
        }

        public String asc() {
            return this.getEscapedColumnName() + " ASC";
        }

        public static Column[] excludes(Column ... excludes) {
            ArrayList<Column> columns = new ArrayList<>(Arrays.asList(Column.values()));
            if (excludes != null && excludes.length > 0) {
                columns.removeAll(new ArrayList<>(Arrays.asList(excludes)));
            }
            return columns.toArray(new Column[]{});
        }

        public static Column[] all() {
            return Column.values();
        }

        public String getEscapedColumnName() {
            if (this.isColumnNameDelimited) {
                return new StringBuilder().append(BEGINNING_DELIMITER).append(this.column).append(ENDING_DELIMITER).toString();
            } else {
                return this.column;
            }
        }

        public String getAliasedEscapedColumnName() {
            return this.getEscapedColumnName();
        }
    }
}