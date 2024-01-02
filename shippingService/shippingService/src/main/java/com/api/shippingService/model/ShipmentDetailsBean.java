package com.api.shippingService.model;

import com.api.shippingService.model.Orders;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;

@Document(collection = "Shipments")
public class ShipmentDetailsBean {

    private int Id;
    private long orderId;
    private long userId;
    private String username;
    private String ordNum;
    private List<Item> items;

    private float totalOrderAmount;


    public ShipmentDetailsBean(long orderId, long userId, String username, String ordNum, List<Item> items, float totalOrderAmount) {
        this.orderId = orderId;
        this.userId = userId;
        this.username = username;
        this.ordNum = ordNum;
        this.items = items;
        this.totalOrderAmount = totalOrderAmount;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public ShipmentDetailsBean() {
    }

    public float getTotalOrderAmount() {
        return totalOrderAmount;
    }

    public void setTotalOrderAmount(float totalOrderAmount) {
        this.totalOrderAmount = totalOrderAmount;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOrdNum() {
        return ordNum;
    }

    public void setOrdNum(String ordNum) {
        this.ordNum = ordNum;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public static class Item{

        private long prodId;
        private String prodName;
        private long qty;
        private Float price;

        public Item( long prodId, String prodName, long qty, Float price) {

            this.prodId = prodId;
            this.prodName = prodName;
            this.qty = qty;
            this.price = price;
        }

        public Item() {
        }

        public long getProdId() {
            return prodId;
        }

        public void setProdId(long prodId) {
            this.prodId = prodId;
        }

        public String getProdName() {
            return prodName;
        }

        public void setProdName(String prodName) {
            this.prodName = prodName;
        }

        public long getQty() {
            return qty;
        }

        public void setQty(long qty) {
            this.qty = qty;
        }

        public Float getPrice() {
            return price;
        }

        public void setPrice(Float price) {
            this.price = price;
        }
    }

}
