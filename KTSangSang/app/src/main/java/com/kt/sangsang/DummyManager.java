package com.kt.sangsang;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created By sinhyeongseob on 2019-06-02
 */
public class DummyManager {

    private static ArrayList<Sales> sales;
    private static ArrayList<Order> orderItems;

    public static void init() {
        sales = new ArrayList<>();
        orderItems = new ArrayList<>();

        Calendar startCal = Calendar.getInstance();
        startCal.set(2019,3,27);

        Calendar endCal = Calendar.getInstance();
        endCal.set(2019,3,28);

        sales.add(new Sales(0, "KT&G 상상마당 프리마켓",startCal.getTimeInMillis(), endCal.getTimeInMillis(),  "4/27 ~ 4/28"));

        startCal = Calendar.getInstance();
        startCal.set(2019,4,4);

        endCal = Calendar.getInstance();
        endCal.set(2019,4,8);

        sales.add(new Sales(1,"종로 청년 숳",startCal.getTimeInMillis(), endCal.getTimeInMillis(),  "5/4 ~ 5/8"));

        orderItems.clear();
        orderItems.add(new Order(0,"상품명 A",4000));
        orderItems.add(new Order(1,"상품명 B",5000));
        orderItems.add(new Order(2,"상품명 C",3000));
        orderItems.add(new Order(3,"상품명 D", 1000));
        orderItems.add(new Order(4,"상품명 E",4000));
        orderItems.add(new Order(5,"상품명 F",4000));
        orderItems.add(new Order(6,"상품명 G",2000));
        orderItems.add(new Order(7,"상품명 H",9000));
        orderItems.add(new Order(8,"상품명 I",1000));
    }

    public static ArrayList<Sales> getSalesItem() {
        return sales;
    }

    public static ArrayList<Order> getOrdersItem() {
        return orderItems;
    }

    public static void addOrder(Order order) {
        orderItems.add(order);
    }

    public static void modifyOrder(int index, Order order) {
        orderItems.set(index, order);
    }

    public static void addSalesItem(Sales s) {
        sales.add(s);
    }

    public static void modifySalesItem(int index, Sales s) {
        sales.set(index, s);
    }
}
