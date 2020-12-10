package com.geekbrains.spring.lesson6.data;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import com.geekbrains.spring.lesson6.entities.Order;
import com.geekbrains.spring.lesson6.entities.views.CustomerView;

import java.util.Date;
import java.util.List;

public class CustomerData {
    @JsonView(CustomerView.FullCustomer.class)
    private long id;

    @JsonView(CustomerView.FullCustomer.class)
    private String name;

    @JsonView(CustomerView.FullCustomer.class)
    private String email;

    @JsonView(CustomerView.FullCustomer.class)
    private String phone;

    @JsonView(CustomerView.FullCustomer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date birthday;

    @JsonView(CustomerView.FullCustomer.class)
    private String address;

    @JsonView(CustomerView.FullCustomer.class)
    private String description;

    @JsonView(CustomerView.FullCustomerOrder.class)
    private List<Order> orders;

    @JsonView(CustomerView.FullCustomer.class)
    private String ordersNames;

    @JsonView(CustomerView.FullCustomer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;

    @JsonView(CustomerView.FullCustomer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifyDate;

    public CustomerData() {
    }


    public CustomerData(long id, String name, String email, String phone, Date birthday, String address, String description, String ordersNames, Date createDate, Date modifyDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.birthday = birthday;
        this.address = address;
        this.description = description;
        this.ordersNames = ordersNames;
        this.createDate = createDate;
        this.modifyDate = modifyDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }


    @Override
    public String toString() {
        return "CustomerData{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                ", orders=" + orders +
                ", createDate=" + createDate +
                ", modifyDate=" + modifyDate +
                '}';
    }
}
