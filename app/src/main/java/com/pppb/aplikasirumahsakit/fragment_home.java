package com.pppb.aplikasirumahsakit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;

import com.pppb.aplikasirumahsakit.databinding.FragmentHomeBinding;

public class fragment_home extends Fragment {

    FragmentHomeBinding binding;
    public fragment_home(){

    }
    public static fragment_home newInstance(){
        fragment_home fragment = new fragment_home();
        return fragment;
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        binding = FragmentHomeBinding.inflate(inflater);
        binding.buatPertemuan.setOnClickListener(this::onClick);
        return binding.getRoot();
    }

    public static fragment_home newInstance(String title) {
        fragment_home fragment = new fragment_home();
        Bundle args = new Bundle();
        args.putString("home", title);
        fragment.setArguments(args);
        return fragment;
    }

    public void onClick(View view) {
        Bundle result = new Bundle();
        result.putInt("page", 2);
        this.getParentFragmentManager().setFragmentResult("changePage", result);
    }

}
