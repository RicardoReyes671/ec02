package com.example.semana7;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.semana7.network.ImageRequest;
import com.example.semana7.network.MarcaEntry;
import com.example.semana7.network.ProductEntry;

import java.util.List;

public class ProductCardRecyclerViewAdapter extends RecyclerView.Adapter<ProductCardViewHolder> {
    private List<ProductEntry> productList;
    private ImageRequest imageRequest;

    ProductCardRecyclerViewAdapter(List<ProductEntry> productList){
        this.productList = productList;
        imageRequest = ImageRequest.getInstance();
    }

    @NonNull
    @Override
    public ProductCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_card, parent, false);
        return new ProductCardViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductCardViewHolder holder, int position){
        if(productList != null && position < productList.size()){
            ProductEntry product = productList.get(position);
            holder.productId.setId(product.idProducto);
            holder.productTitle.setText(product.descripcion);
            holder.productPrice.setText("S/."+product.precio.toString());
            imageRequest.setImageFromUrl(holder.productImage, product.url);
            if(product.stock > 0){
                holder.productAvailability.setText("");
            } else {
                holder.productAvailability.setText("Agotado");
                holder.productAvailability.setTextColor(Color.RED);
            }
        }
    }

    @Override
    public int getItemCount(){ return productList.size(); }
}
