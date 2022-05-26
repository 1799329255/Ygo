package com.example.ygo.entity;

/**
 * @author 林屹峰
 * @version 1.0
 * @className CardModel
 * @description TODO
 * @since 2022/2/23 22:52
 */
public class CardModel extends Card{

    private String order;
    private Integer pageNum;
    private Integer pageSize;

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "CardModel{" +
                "order='" + order + '\'' +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                "} " + super.toString();
    }
}
