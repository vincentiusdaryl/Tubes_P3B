package com.pppb.aplikasirumahsakit;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import com.pppb.aplikasirumahsakit.databinding.FragmentTambahdokterBinding;

public class fragment_tambahdokter extends Fragment {

FragmentTambahdokterBinding binding;
databaseDokter db;
    public fragment_tambahdokter(){

    }
    public static fragment_tambahdokter newInstance(){
        fragment_tambahdokter fragment = new fragment_tambahdokter();
        return fragment;
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        binding = FragmentTambahdokterBinding.inflate(inflater);
        db = new databaseDokter(requireContext());
        binding.btnAdd.setOnClickListener(this::onClick);
        return binding.getRoot();
    }

    public void onClick(View view){
        String name = binding.etNamaDokter.getText().toString();
        String spesialis = binding.etSpesialis.getText().toString();

        if(!name.equals("")&&!spesialis.equals("")&&db.insertData(name,spesialis)){
            Toast.makeText(getContext(), "Data saved", Toast.LENGTH_SHORT).show();
            binding.tvNama.setText("");
            binding.tvNotelp.setText("");
            binding.tvSpesialis.setText("");
        }
        else{
            Toast.makeText(getContext(), "Data failed to be saved!", Toast.LENGTH_SHORT).show();
        }

    }

}
