package com.pppb.aplikasirumahsakit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.pppb.aplikasirumahsakit.databinding.FragmentListDokterBinding;

import java.util.ArrayList;

public class fragment_dokter extends Fragment {
    FragmentListDokterBinding binding;
    private listDokterAdapter adapter;
    private ArrayList<dokter> dokterList;

    public fragment_dokter(){

    }
    public static fragment_dokter newInstance(){
        fragment_dokter fragment_dokter = new fragment_dokter();
        return fragment_dokter;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        binding = FragmentListDokterBinding.inflate(inflater);
        dokterList = new ArrayList<>();
        return binding.getRoot();
    }

}
