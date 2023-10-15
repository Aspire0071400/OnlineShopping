package com.aspire.onlineshopping.menu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.aspire.onlineshopping.LandingPage;
import com.aspire.onlineshopping.R;


public class AccountInfoFragment extends Fragment {
    TextView tvUname,tvUemail;
    ImageView ivDP;


    public AccountInfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_account_info, container, false);

        tvUname = rootView.findViewById(R.id.tvUname);
        tvUemail = rootView.findViewById(R.id.tvUemail);
        ivDP = rootView.findViewById(R.id.ivDP);

        tvUname.setText(LandingPage.Uname);
        tvUemail.setText(LandingPage.Uemail);
        ivDP.setImageResource(R.drawable.logo);

        return rootView;
    }
}