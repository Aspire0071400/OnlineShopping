package com.aspire.onlineshopping.menu;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aspire.onlineshopping.ItemAdapter;
import com.aspire.onlineshopping.ItemPOJO;
import com.aspire.onlineshopping.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private List<ItemPOJO> itemList;
    private RecyclerView homeRecyclerView;
    private ItemAdapter itemAdapter;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        itemList = generateItem();

        homeRecyclerView = rootView.findViewById(R.id.home_recycler);
        homeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        itemAdapter = new ItemAdapter(itemList);
        homeRecyclerView.setAdapter(itemAdapter);

        return rootView;
    }

    @NonNull
    private List<ItemPOJO> generateItem(){
        List<ItemPOJO> itemsList = new ArrayList<>();
        itemsList.add(new ItemPOJO(R.drawable.boat_air_dopes_141,"BOaT","Truly Wireless TWS from BOat, BLACK","1100",R.drawable.cart1));
        itemsList.add(new ItemPOJO(R.drawable.boat_air_dopes_141_grey,"BOat","Truly Wireless TWS from BOat, GREY","1150",R.drawable.cart1));
        itemsList.add(new ItemPOJO(R.drawable.boat_hawk_buds_black,"BOat","Stylish Wired EarPhones from BOat with HAWK design, BLACK","850",R.drawable.cart1));
        itemsList.add(new ItemPOJO(R.drawable.bpunk_sba150_bt_speaker,"BPUNK","Wireless speaker from BPUNK ,15W","1350",R.drawable.cart1));
        itemsList.add(new ItemPOJO(R.drawable.stone_352_bt_speaker,"STONE","Wireless speaker from STONE, 10W","1250",R.drawable.cart1));
        itemsList.add(new ItemPOJO(R.drawable.fire_bolt_msd_watch,"FIRE_BOLT","SmartWatch from FIRE_BOLT with MSD face","1800",R.drawable.cart1));
        itemsList.add(new ItemPOJO(R.drawable.fire_bolt_vk_watch,"FIRE_BOLT","SmartWatch from FIRE_BOLT with VK face","1800",R.drawable.cart1));
        itemsList.add(new ItemPOJO(R.drawable.fire_bolt_ss_watch,"FIRE_BOLT","SmartWatch from FIRE_BOLT with SS face","1800",R.drawable.cart1));
        itemsList.add(new ItemPOJO(R.drawable.realme_digi_watch,"REALmE","SmartWatch with Calling feature","2100",R.drawable.cart1));
        itemsList.add(new ItemPOJO(R.drawable.mi_red_bag,"MI","Smart bag from Mi with Inbuilt Powerbank","2450",R.drawable.cart1));
        itemsList.add(new ItemPOJO(R.drawable.lenovo_grey_bag,"LENOVO","Smart bag from LENOVO with Solar charger","2600",R.drawable.cart1));

        return itemsList;
    }
 }