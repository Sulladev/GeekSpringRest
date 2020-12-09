package com.geekbrains.spring.lesson6.entities.views;

public final class CustomerView extends CommonView {

    public interface IdName extends CommonFull{}
    public interface FullCustomer extends IdName{}
    public interface FullCustomerOrder extends FullCustomer, OrderView.IdCode{}

}
