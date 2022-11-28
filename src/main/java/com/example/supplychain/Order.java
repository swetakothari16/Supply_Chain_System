package com.example.supplychain;

import javafx.scene.chart.PieChart;

public class Order {
    public static boolean placeSingleOrder(Product product,String customerEmail){

        String orderQuery = String.format("INSERT INTO orders (quantity, customer_id, product_id, status) VALUES (1, (SELECT cid FROM customer WHERE email = '%s'), %s, 'ORDERED')",
                customerEmail, product.getId()
        );
        DatabaseConnection dbconn = new DatabaseConnection();

        if(dbconn.insertData(orderQuery)>=1){
            return true;
        }
        System.out.println(orderQuery);
      return false;
    }
}
