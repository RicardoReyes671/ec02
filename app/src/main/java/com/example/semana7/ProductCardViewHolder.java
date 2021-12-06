package com.example.semana7;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.toolbox.NetworkImageView;

public class ProductCardViewHolder extends RecyclerView.ViewHolder {
    public NetworkImageView productImage;
    public TextView productTitle;
    public TextView productPrice;
    public TextView productAvailability;
    public View productId;

    public ProductCardViewHolder(@NonNull View itemView){
        super(itemView);
        productId = itemView.findViewById(R.id.linearLayout_product);
        productImage = itemView.findViewById(R.id.product_image);
        productTitle = itemView.findViewById(R.id.product_title);
        productPrice = itemView.findViewById(R.id.product_price);
        productAvailability = itemView.findViewById(R.id.product_availability);
    }
}
