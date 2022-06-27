package com.example.clickshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class ActCart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_cart);
        getSupportActionBar().hide();

        RecyclerView recyclerView = findViewById(R.id.recycler_cart);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,true);
        recyclerView.setLayoutManager(gridLayoutManager);
        CartAdapter adapter = new CartAdapter(getCartList(),this);
        recyclerView.setAdapter(adapter);


     //   Log.d("TAG", "onCreate: "+getCartList().size());
    }

    private List<ProductOrder> getCartList(){
        List<String> listOfIds= Mpreference.retriveCart(this);
        List<ProductOrder> allProducts= Utils.getDummyList();
        List<ProductOrder> addedProducts= new ArrayList<>();

        for(ProductOrder productOrder : allProducts){
            if(listOfIds.contains(productOrder.id))
                addedProducts.add(productOrder);
        }
        return addedProducts;
    }
}