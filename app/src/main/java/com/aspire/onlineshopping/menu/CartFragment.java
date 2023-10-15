package com.aspire.onlineshopping.menu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.aspire.onlineshopping.R;
import com.aspire.onlineshopping.cartutils.CartAdapter;
import com.aspire.onlineshopping.cartutils.CartPOJO;
import com.aspire.onlineshopping.homeutils.ItemAdapter;
import com.aspire.onlineshopping.screens.LoginPage;

import java.util.ArrayList;
import java.util.List;


public class CartFragment extends Fragment {
    Button btnOrder;
    RecyclerView re;
    private List<CartPOJO> cartList;
    private RecyclerView cartRecyclerView;
    private CartAdapter cartAdapter;
    public ArrayList cartsList;
    public CartFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_cart, container, false);
        cartList = generateCart();


        cartRecyclerView = rootView.findViewById(R.id.cart_recycler);
        cartRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        cartAdapter = new CartAdapter(cartList);
        cartRecyclerView.setAdapter(cartAdapter);
        btnOrder= rootView.findViewById(R.id.btnOrder);
        re= rootView.findViewById(R.id.cart_recycler);
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), LoginPage.class);
                startActivity(i);
            }
        });

        return rootView;
    }

    private List<CartPOJO> generateCart(){
        cartsList = new ArrayList<>();

        cartsList.add(new CartPOJO(HomeFragment.img1,"BOaT","Truly Wireless TWS from BOat, BLACK","1100"));
        //cartsList.add(new CartPOJO(ItemAdapter.product,ItemAdapter.brand,ItemAdapter.description,ItemAdapter.price));

        return cartsList;
    }
}