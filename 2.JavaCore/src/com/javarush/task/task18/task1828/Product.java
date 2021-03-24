package com.javarush.task.task18.task1828;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class Product {
    private int id;
    private String productName;
    private double price;
    private int quantity;

    public Product(String productName, double price, int quantity) {
        if (productName.length() > 30) {
            this.productName = productName.substring(0, 30);
        }
        else {
            this.productName = productName;
        }

        this.price = price;
        this.quantity = quantity;
    }

    public Product(int id, String productName, double price, int quantity) {
        if (productName.length() > 30) {
            this.productName = productName.substring(0, 30);
        }
        else {
            this.productName = productName;
        }

        this.id = id;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        String id = Integer.toString(this.id);
        String productName = this.productName;
        String formatPrice = new DecimalFormat("#0.00").format(this.price);

        String quantity = Integer.toString(this.quantity);

        StringBuilder temp = new StringBuilder(id);
        while (temp.length() < 8) {
            temp.append(" ");
        }

        temp.append(productName);
        while (temp.length() < 38) {
            temp.append(" ");
        }



        temp.append(formatPrice.replace(',', '.'));
        while (temp.length() < 46) {
            temp.append(" ");
        }

        temp.append(quantity);
        while (temp.length() < 50) {
            temp.append(" ");
        }

        return temp.toString();
    }
}
