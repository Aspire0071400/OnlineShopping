package com.aspire.onlineshopping.cartutils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aspire.onlineshopping.R;
import com.aspire.onlineshopping.homeutils.ItemPOJO;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    private List<CartPOJO> cartList;
    public CartAdapter(List<CartPOJO> itemList) {
        this.cartList = itemList;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View cartView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_view_layout,parent,false);


        return new CartViewHolder(cartView);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        CartPOJO cartPOJO = cartList.get(position);
        holder.ivCartProduct.setImageResource(Integer.parseInt(cartPOJO.getProductView()));
        holder.tvCartBrand.setText(cartPOJO.getBrandName());
        holder.tvCartPrice.setText(cartPOJO.getPrice());
        holder.tvCartDescription.setText(cartPOJO.getProductDescription());

    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }

    public static class CartViewHolder extends RecyclerView.ViewHolder{
        ImageView ivCartProduct;
        TextView tvCartBrand,tvCartPrice,tvCartDescription;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            ivCartProduct = itemView.findViewById(R.id.ivCartProduct);
            tvCartBrand = itemView.findViewById(R.id.tvCartBrand);
            tvCartPrice = itemView.findViewById(R.id.tvCartPrice);
            tvCartDescription = itemView.findViewById(R.id.tvCartDescription);

        }
    }
}
