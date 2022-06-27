package com.example.clickshop;

import java.util.ArrayList;
import java.util.List;

public class Utils {

   public static List<ProductOrder> getDummyList(){
        List<ProductOrder> list= new ArrayList<>();
        list.add(new ProductOrder("Bluetooth speaker","https://www.cloudways.com/blog/wp-content/uploads/Bluetooth-Speaker.jpg",2500,4.5, "1"));
        list.add(new ProductOrder("Smart watch","https://www.cloudways.com/blog/wp-content/uploads/Smart-Watch.jpg",2000,4.5, "2"));
        list.add(new ProductOrder("vegetable chopper","https://www.cloudways.com/blog/wp-content/uploads/Vegetable-Chopper.jpg",200,4.0, "3"));
        list.add(new ProductOrder("Car phone holder","https://www.cloudways.com/blog/wp-content/uploads/Car-Phone-Holder.jpg",500,4.5, "4"));
        list.add(new ProductOrder("Shoes","https://www.cloudways.com/blog/wp-content/uploads/Breathable-Mesh-Running-Shoes.jpg",2000,4.5, "5"));
        list.add(new ProductOrder("Touch gloves","https://www.cloudways.com/blog/wp-content/uploads/image4-189-288x300.png",400,4.0, "6"));
        list.add(new ProductOrder("Portable projector","https://www.cloudways.com/blog/wp-content/uploads/Portable-Projector.jpg",3000,4.5, "7"));
        list.add(new ProductOrder("Phone lenses","https://www.cloudways.com/blog/wp-content/uploads/Phone-Lenses.jpg",2000,4.5, "8"));
        list.add(new ProductOrder("Doormats","https://www.cloudways.com/blog/wp-content/uploads/Doormats.png",200,3.5, "9"));
        list.add(new ProductOrder("Security camera","https://www.cloudways.com/blog/wp-content/uploads/Home-Security-IP-Camera.jpg",5000,5.0, "10"));
        return list;
    }
}
