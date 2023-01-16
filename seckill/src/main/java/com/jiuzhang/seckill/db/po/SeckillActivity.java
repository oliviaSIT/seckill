package com.jiuzhang.seckill.db.po;

import java.util.Date;

public class SeckillActivity {
    private Long id;

    private String name;

    private Long commodityId;

    private Short seckillPrice;

    private Date startTime;

    private Date endTime;

    private Long totalStock;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Long getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Long commodityId) {
        this.commodityId = commodityId;
    }

    public Short getSeckillPrice() {
        return seckillPrice;
    }

    public void setSeckillPrice(Short seckillPrice) {
        this.seckillPrice = seckillPrice;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Long getTotalStock() {
        return totalStock;
    }

    public void setTotalStock(Long totalStock) {
        this.totalStock = totalStock;
    }
}