package com.jiuzhang.seckill.db.po;

public class SeckillCommodity {
    private Long id;

    private String commodityName;

    private String commodityDesc;

    private Short commodityPrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName == null ? null : commodityName.trim();
    }

    public String getCommodityDesc() {
        return commodityDesc;
    }

    public void setCommodityDesc(String commodityDesc) {
        this.commodityDesc = commodityDesc == null ? null : commodityDesc.trim();
    }

    public Short getCommodityPrice() {
        return commodityPrice;
    }

    public void setCommodityPrice(Short commodityPrice) {
        this.commodityPrice = commodityPrice;
    }
}