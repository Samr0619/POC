package com.api.shippingService.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Users")
public class Users {

    private int id;
    private String username;

    private Address address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public static class Address{

        private String addr_line1;
        private String addr_line2;

        private String pincode;

        private String city;
        private String state;

        public String getAddr_line1() {
            return addr_line1;
        }

        public void setAddr_line1(String addr_line1) {
            this.addr_line1 = addr_line1;
        }

        public String getAddr_line2() {
            return addr_line2;
        }

        public void setAddr_line2(String addr_line2) {
            this.addr_line2 = addr_line2;
        }

        public String getPincode() {
            return pincode;
        }

        public void setPincode(String pincode) {
            this.pincode = pincode;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }
    }
}
