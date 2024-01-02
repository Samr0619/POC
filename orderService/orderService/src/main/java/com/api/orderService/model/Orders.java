package com.api.orderService.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Document(collection = "orders")
public class Orders implements Serializable {

    private int orderId;
    private long userId;
    private String orderNum;

    private List<Item> items;
    public static class Item{
        private long prodId;
        private long qty;
        private float price;

        public Item() {
        }

        public Item(long prodId, long qty, float price) {
            this.prodId = prodId;
            this.qty = qty;
            this.price = price;
        }

        public long getProdId() {
            return prodId;
        }

        public void setProdId(long prodId) {
            this.prodId = prodId;
        }

        public long getQty() {
            return qty;
        }

        public void setQty(long qty) {
            this.qty = qty;
        }

        public float getPrice() {
            return price;
        }

        public void setPrice(float price) {
            this.price = price;
        }
    }

    public Orders() {

    }

    public Orders(int orderId, long userId, String orderNum, List<Item> items) {
        this.orderId = orderId;
        this.userId = userId;
        this.orderNum = orderNum;
        this.items = items;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
