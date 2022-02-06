package com.example.ygo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@ApiModel(value="com.example.ygo.entity.Article")
public class Article implements Serializable {
    public static final Integer IS_DELETED = Status.IS_DELETED.value();

    public static final Integer NOT_DELETED = Status.NOT_DELETED.value();

    @ApiModelProperty(value="idID")
    private Long id;

    @ApiModelProperty(value="userId用户ID")
    private Long userId;

    @ApiModelProperty(value="categoryId分类关联表ID")
    private Long categoryId;

    @ApiModelProperty(value="title标题")
    private String title;

    @ApiModelProperty(value="pic图片地址")
    private String pic;

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

    @ApiModelProperty(value="content内容")
    private String content;

    @ApiModelProperty(value="分类名字")
    private String categoryName;

    @ApiModelProperty(value="标签集合")
    private List<Articlelabel> articlelabels;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Articlelabel> getArticlelabels() {
        return articlelabels;
    }

    public void setArticlelabels(List<Articlelabel> articlelabels) {
        this.articlelabels = articlelabels;
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
        Article other = (Article) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getCategoryId() == null ? other.getCategoryId() == null : this.getCategoryId().equals(other.getCategoryId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getPic() == null ? other.getPic() == null : this.getPic().equals(other.getPic()))
            && (this.getLikeNum() == null ? other.getLikeNum() == null : this.getLikeNum().equals(other.getLikeNum()))
            && (this.getViewNum() == null ? other.getViewNum() == null : this.getViewNum().equals(other.getViewNum()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getDeleteTime() == null ? other.getDeleteTime() == null : this.getDeleteTime().equals(other.getDeleteTime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getCategoryId() == null) ? 0 : getCategoryId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getPic() == null) ? 0 : getPic().hashCode());
        result = prime * result + ((getLikeNum() == null) ? 0 : getLikeNum().hashCode());
        result = prime * result + ((getViewNum() == null) ? 0 : getViewNum().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getDeleteTime() == null) ? 0 : getDeleteTime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
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
        sb.append(", userId=").append(userId);
        sb.append(", categoryId=").append(categoryId);
        sb.append(", title=").append(title);
        sb.append(", pic=").append(pic);
        sb.append(", likeNum=").append(likeNum);
        sb.append(", viewNum=").append(viewNum);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", deleteTime=").append(deleteTime);
        sb.append(", status=").append(status);
        sb.append(", content=").append(content);
        sb.append(", categoryName=").append(categoryName);
        sb.append(", articlelabels=").append(articlelabels);
        sb.append("]");
        return sb.toString();
    }

    public static Article.Builder builder() {
        return new Article.Builder();
    }

    public static class Builder {
        private Article obj;

        public Builder() {
            this.obj = new Article();
        }

        public Builder id(Long id) {
            obj.setId(id);
            return this;
        }

        public Builder userId(Long userId) {
            obj.setUserId(userId);
            return this;
        }

        public Builder categoryId(Long categoryId) {
            obj.setCategoryId(categoryId);
            return this;
        }

        public Builder title(String title) {
            obj.setTitle(title);
            return this;
        }

        public Builder pic(String pic) {
            obj.setPic(pic);
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

        public Builder content(String content) {
            obj.setContent(content);
            return this;
        }

        public Article build() {
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
        userId("user_id", "userId", "BIGINT", false),
        categoryId("category_id", "categoryId", "BIGINT", false),
        title("title", "title", "VARCHAR", false),
        pic("pic", "pic", "VARCHAR", false),
        likeNum("like_num", "likeNum", "BIGINT", false),
        viewNum("view_num", "viewNum", "BIGINT", false),
        createTime("create_time", "createTime", "TIMESTAMP", false),
        updateTime("update_time", "updateTime", "TIMESTAMP", false),
        deleteTime("delete_time", "deleteTime", "TIMESTAMP", false),
        status("status", "status", "INTEGER", false),
        content("content", "content", "LONGVARCHAR", false);

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