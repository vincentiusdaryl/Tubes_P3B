package com.pppb.aplikasirumahsakit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.pppb.aplikasirumahsakit.databinding.FragmentLeftBinding;

public class fragment_left extends Fragment {
FragmentLeftBinding binding;

public fragment_left(){

}
public static fragment_left newInstance(){
    fragment_left fragment = new fragment_left();
    return fragment;
}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentLeftBinding.inflate(inflater);
        binding.buttonExit.setOnClickListener(this::onClick);
        binding.buttonHome.setOnClickListener(this::onClick);
        binding.buttonDokter.setOnClickListener(this::onClick);
        binding.buttonPertemuan.setOnClickListener(this::onClick);
        return binding.getRoot();
    }

    private void onClick(View view){
    if(view == binding.buttonHome){
        Bundle result = new Bundle();
        result.putInt("page",1);
        getParentFragmentManager().setFragmentResult("changePage", result);
    }
    else if(view == binding.buttonExit){
        Bundle result = new Bundle();
        result.putInt("page",0);
        getParentFragmentManager().setFragmentResult("changePage", result);
    }
    else if(view == binding.buttonDokter){
        Bundle result = new Bundle();
        result.putInt("page",2);
        getParentFragmentManager().setFragmentResult("changePage", result);
    }
    else if(view == binding.buttonPertemuan){
        Bundle result = new Bundle();
        result.putInt("page",3);
        getParentFragmentManager().setFragmentResult("changePage",result);
    }

    }
}
