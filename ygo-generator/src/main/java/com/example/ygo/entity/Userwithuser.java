package com.example.ygo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

@ApiModel(value="com.example.ygo.entity.Userwithuser")
public class Userwithuser implements Serializable {
    @ApiModelProperty(value="idID")
    private Long id;

    @ApiModelProperty(value="fanId粉丝ID")
    private Long fanId;

    @ApiModelProperty(value="followId关注者ID")
    private Long followId;

    private static final long serialVersionUID = 1L;

    public Userwithuser() {
        super();
    }

    public Userwithuser(Long fanId, Long followId) {
        this.fanId = fanId;
        this.followId = followId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFanId() {
        return fanId;
    }

    public void setFanId(Long fanId) {
        this.fanId = fanId;
    }

    public Long getFollowId() {
        return followId;
    }

    public void setFollowId(Long followId) {
        this.followId = followId;
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
        Userwithuser other = (Userwithuser) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getFanId() == null ? other.getFanId() == null : this.getFanId().equals(other.getFanId()))
            && (this.getFollowId() == null ? other.getFollowId() == null : this.getFollowId().equals(other.getFollowId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getFanId() == null) ? 0 : getFanId().hashCode());
        result = prime * result + ((getFollowId() == null) ? 0 : getFollowId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", fanId=").append(fanId);
        sb.append(", followId=").append(followId);
        sb.append("]");
        return sb.toString();
    }

    public static Userwithuser.Builder builder() {
        return new Userwithuser.Builder();
    }

    public static class Builder {
        private Userwithuser obj;

        public Builder() {
            this.obj = new Userwithuser();
        }

        public Builder id(Long id) {
            obj.setId(id);
            return this;
        }

        public Builder fanId(Long fanId) {
            obj.setFanId(fanId);
            return this;
        }

        public Builder followId(Long followId) {
            obj.setFollowId(followId);
            return this;
        }

        public Userwithuser build() {
            return this.obj;
        }
    }

    public enum Column {
        id("id", "id", "BIGINT", false),
        fanId("fan_id", "fanId", "BIGINT", false),
        followId("follow_id", "followId", "BIGINT", false);

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