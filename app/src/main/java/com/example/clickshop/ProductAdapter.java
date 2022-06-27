package com.example.clickshop;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import io.github.muddz.styleabletoast.StyleableToast;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.Myviewholder> {
    private List<ProductOrder> mData;
    private LayoutInflater mInflater;
    private Context context;

    public ProductAdapter(List<ProductOrder> data, Context context) {
        this.mData = data;
        this.mInflater = mInflater.from(context);
        this.context = context;
    }

    @NonNull
    @Override
    public Myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.row_item, parent, false);
        return new Myviewholder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull Myviewholder holder, int position) {
        ProductOrder productOrder = mData.get(position);
        holder.txtTitle.setText(productOrder.title);
        holder.txtPrice.setText("Rs "+productOrder.price);
        holder.ratingBar.setRating((float) productOrder.rating);
        Glide.with(context).load(productOrder.imageUrl).into(holder.img);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class Myviewholder extends RecyclerView.ViewHolder {
        TextView txtTitle;
        TextView txtPrice;
        RatingBar ratingBar;
        ImageView img;
        Button btn_cart;
        public Myviewholder(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.product_card);
            txtPrice =itemView.findViewById(R.id.price_card);
            ratingBar =itemView.findViewById(R.id.ratingbar);
            img =itemView.findViewById(R.id.img_card);
            btn_cart =itemView.findViewById(R.id.btn_cart);
            btn_cart.setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.M)
                @Override
                public void onClick(View view) {
                    Mpreference.addProduct(mData.get(getAdapterPosition()).id,context);
                    StyleableToast.makeText(view.getContext(),"successfully added to cart",R.style.mytoast).show();
                }
            });
        }
    }
}
