package com.example.clickshop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.Myviewholder> {
    private List<ProductOrder> mData;
    private LayoutInflater mInflater;
    private Context context;

    public CartAdapter(List<ProductOrder> data, Context context) {
        this.mData = data;
        this.mInflater = mInflater.from(context);
        this.context = context;
    }


    @NonNull
    @Override
    public Myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.cart_row, parent, false);
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

        public Myviewholder(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.product_card);
            txtPrice = itemView.findViewById(R.id.price_card);
            ratingBar = itemView.findViewById(R.id.ratingbar);
            img = itemView.findViewById(R.id.img_card);
        }
    }
}
