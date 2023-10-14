package com.aspire.onlineshopping;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    private List<ItemPOJO> itemList;

    public ItemAdapter(List<ItemPOJO> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item_layout,parent,false);

        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        ItemPOJO itemPOJO = itemList.get(position);
        holder.ivProduct.setImageResource(itemPOJO.getProductView());
        holder.tvBrand.setText(itemPOJO.getBrandName());
        holder.tvPrice.setText(itemPOJO.getPrice());
        holder.tvDescription.setText(itemPOJO.getProductDescription());
        holder.ivCart.setImageResource(itemPOJO.getCart());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder{
        ImageView ivProduct,ivCart;
        TextView tvBrand,tvPrice,tvDescription;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            ivProduct = itemView.findViewById(R.id.ivProduct);
            ivCart = itemView.findViewById(R.id.ivCart);
            tvBrand = itemView.findViewById(R.id.tvBrand);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            tvDescription = itemView.findViewById(R.id.tvDescription);

        }
    }
}
