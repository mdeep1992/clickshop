package Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.clickshop.ActCart;
import com.example.clickshop.ProductAdapter;
import com.example.clickshop.R;
import com.example.clickshop.Utils;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class ProductView extends AppCompatActivity {
ImageView cart_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.productview);
        getSupportActionBar().hide();
        RecyclerView recyclerView = findViewById(R.id.recycler);
        cart_btn= findViewById(R.id.cart_img_btn);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(gridLayoutManager);
        ProductAdapter adapter = new ProductAdapter(Utils.getDummyList(),this);
        recyclerView.setAdapter(adapter);
        cart_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ProductView.this, ActCart.class);
                startActivity(intent);
            }
        });
    }

    }
