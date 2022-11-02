package com.pppb.aplikasirumahsakit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import com.pppb.aplikasirumahsakit.databinding.FragmentTambahdokterBinding;

public class fragment_tambahdokter extends Fragment {
FragmentTambahdokterBinding binding;

    public fragment_tambahdokter(){

    }
    public static fragment_tambahdokter newInstance(){
        fragment_tambahdokter fragment = new fragment_tambahdokter();
        return fragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        binding = FragmentTambahdokterBinding.inflate(inflater);

    }
}
