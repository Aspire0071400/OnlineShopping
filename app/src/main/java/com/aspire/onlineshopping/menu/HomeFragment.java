package com.aspire.onlineshopping.menu;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aspire.onlineshopping.homeutils.ItemAdapter;
import com.aspire.onlineshopping.homeutils.ItemPOJO;
import com.aspire.onlineshopping.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private List<ItemPOJO> itemList,itemsList;
    private RecyclerView homeRecyclerView;
    private ItemAdapter itemAdapter;
    public static String img1 =  String.valueOf(R.drawable.boat_air_dopes_141);
    public static String img2 =  String.valueOf(R.drawable.boat_air_dopes_141_grey);
    public static String img3 =  String.valueOf(R.drawable.boat_hawk_buds_black);
    public static String img4 =  String.valueOf(R.drawable.bpunk_sba150_bt_speaker);
    public static String img5 =  String.valueOf(R.drawable.stone_352_bt_speaker);
    public static String img6 =  String.valueOf(R.drawable.fire_bolt_msd_watch);
    public static String img7 =  String.valueOf(R.drawable.fire_bolt_vk_watch);
    public static String img8 =  String.valueOf(R.drawable.fire_bolt_ss_watch);
    public static String img9 =  String.valueOf(R.drawable.realme_digi_watch);
    public static String img10 =  String.valueOf(R.drawable.mi_red_bag);
    public static String img11 =  String.valueOf(R.drawable.lenovo_grey_bag);


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
        itemsList = new ArrayList<>();

        itemsList.add(new ItemPOJO(img1,"BOaT","Truly Wireless TWS from BOat, BLACK","1100",R.drawable.cart1));
        itemsList.add(new ItemPOJO(img2,"BOat","Truly Wireless TWS from BOat, GREY","1150",R.drawable.cart1));
        itemsList.add(new ItemPOJO(img3,"BOat","Stylish Wired EarPhones from BOat with HAWK design, BLACK","850",R.drawable.cart1));
        itemsList.add(new ItemPOJO(img4,"BPUNK","Wireless speaker from BPUNK ,15W","1350",R.drawable.cart1));
        itemsList.add(new ItemPOJO(img5,"STONE","Wireless speaker from STONE, 10W","1250",R.drawable.cart1));
        itemsList.add(new ItemPOJO(img6,"FIRE_BOLT","SmartWatch from FIRE_BOLT with MSD face","1800",R.drawable.cart1));
        itemsList.add(new ItemPOJO(img7,"FIRE_BOLT","SmartWatch from FIRE_BOLT with VK face","1800",R.drawable.cart1));
        itemsList.add(new ItemPOJO(img8,"FIRE_BOLT","SmartWatch from FIRE_BOLT with SS face","1800",R.drawable.cart1));
        itemsList.add(new ItemPOJO(img9,"REALmE","SmartWatch with Calling feature","2100",R.drawable.cart1));
        itemsList.add(new ItemPOJO(img10,"MI","Smart bag from Mi with Inbuilt Powerbank","2450",R.drawable.cart1));
        itemsList.add(new ItemPOJO(img11,"LENOVO","Smart bag from LENOVO with Solar charger","2600",R.drawable.cart1));

        return itemsList;
    }
 }