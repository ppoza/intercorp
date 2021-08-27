package com.ppoza.intercorp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class BaseFragment extends Fragment {

    public void hideToolbar() {
        ((AppCompatActivity)getActivity()).getSupportActionBar().hide();
    }

    public void showToolbar() {
        ((AppCompatActivity)getActivity()).getSupportActionBar().show();
    }

}
