package com.pppb.aplikasirumahsakit;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import com.pppb.aplikasirumahsakit.databinding.FragmentTambahdokterBinding;

import java.util.ArrayList;

public class fragment_tambahdokter extends Fragment {

FragmentTambahdokterBinding binding;
dbDokterAdapter db;
ArrayList<String> listItems;
private dokter dokters;

    public fragment_tambahdokter(){

    }
    public static fragment_tambahdokter newInstance(){
        fragment_tambahdokter fragment = new fragment_tambahdokter();
        return fragment;
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        binding = FragmentTambahdokterBinding.inflate(inflater);
        openDB();

        listItems = new ArrayList<>();
        binding.btnAdd.setOnClickListener(this::onClick);
        return binding.getRoot();
    }


    public void onClick(View view){
        String name = binding.etNamaDokter.getText().toString();
        String spesialis = binding.etSpesialis.getText().toString();
        String noTelp = binding.etNoTelp.getText().toString();

        if(!name.equals("")) {
            Toast.makeText(getContext(), "Isi nama dokter!", Toast.LENGTH_SHORT).show();
        }
        else if(!spesialis.equals("")){
            Toast.makeText(getContext(), "isi spesialis dokter!", Toast.LENGTH_SHORT).show();
        }
        else if(!noTelp.equals("")){
            Toast.makeText(getContext(), "isi no telpon dokter!", Toast.LENGTH_SHORT).show();
        }
        else{
            db.insertBaris(name,spesialis,noTelp);
            Toast.makeText(getContext(), "Data dokter berhasil disimpan!", Toast.LENGTH_SHORT).show();
        }
    }

    //ngisi listviewnya dengan data dari db
    public void isiListView(){
        Cursor cursor = db.getSmuaBaris();
        String[] fieldnames = new String[] {dbDokterAdapter.ID,dbDokterAdapter.NAMA,dbDokterAdapter.SPESIALIS,dbDokterAdapter.NOTELP};
        int[] viewIDS = new int[] {R.id.namaDokter,R.id.
    }
    //buka DBnya
    private void openDB(){
        db = new dbDokterAdapter(getContext());
        db.open();
    }

}
