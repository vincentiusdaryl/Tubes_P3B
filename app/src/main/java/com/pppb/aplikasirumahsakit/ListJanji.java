package com.pppb.aplikasirumahsakit;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pppb.aplikasirumahsakit.databinding.FragmentListJanjiBinding;

public class ListJanji extends Fragment {
FragmentListJanjiBinding binding;
    public ListJanji() {

    }
    public static ListJanji newInstance(){
        ListJanji fragment = new ListJanji();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentListJanjiBinding.inflate(inflater);
        return binding.getRoot();
    }
}