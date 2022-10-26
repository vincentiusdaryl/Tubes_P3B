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

public class fragment_home extends Fragment {

    private FragmentManager fragmentManager;
    public fragment_home(){

    }
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_home,container,false);

        this.getParentFragmentManager().setFragmentResultListener("msg", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                String msg = result.getString("msg");
                setMessage(msg);
            }
        });

        return view;
    }

    public static fragment_home newInstance(String title) {
        fragment_home fragment = new fragment_home();
        Bundle args = new Bundle();
        args.putString("title", title);
        fragment.setArguments(args);
        return fragment;
    }

    public void onClick(View view) {
        Bundle result = new Bundle();
        result.putInt("page", 2);
        this.getParentFragmentManager().setFragmentResult("changePage", result);
    }

    public void setMessage(String msg) {

    }

}
