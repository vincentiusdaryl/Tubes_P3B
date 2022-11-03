package com.pppb.aplikasirumahsakit;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import com.pppb.aplikasirumahsakit.databinding.FragmentTambahdokterBinding;

import java.util.ArrayList;

public class fragment_tambahdokter extends Fragment {
SimpleCursorAdapter myAdapter;
FragmentTambahdokterBinding binding;
dbDokterAdapter db;
ListView dokterList;
ArrayList<String> listItems;
ArrayAdapter adapter;
private dokter dokters;

    public fragment_tambahdokter(){

    }
    public static fragment_tambahdokter newInstance(){
        fragment_tambahdokter fragment = new fragment_tambahdokter();
        return fragment;
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        binding = FragmentTambahdokterBinding.inflate(inflater);
//        viewData();
        db = new dbDokterAdapter(getActivity());

        listItems = new ArrayList<>();
        binding.btnAdd.setOnClickListener(this::onClick);
        return binding.getRoot();
    }


    public void onClick(View view){
        String name = binding.etNamaDokter.getText().toString();
        String spesialis = binding.etSpesialis.getText().toString();
        String noTelp = binding.etNoTelp.getText().toString();

        if(name.equals("")) {
            Toast.makeText(getContext(), "Isi nama dokter!", Toast.LENGTH_SHORT).show();
        }
        else if(spesialis.equals("")){
            Toast.makeText(getContext(), "isi spesialis dokter!", Toast.LENGTH_SHORT).show();
        }
        else if(noTelp.equals("")){
            Toast.makeText(getContext(), "isi no telpon dokter!", Toast.LENGTH_SHORT).show();
        }
        else{
            db.insertBaris(name,spesialis,noTelp);
            Toast.makeText(getContext(), "Data dokter berhasil disimpan!", Toast.LENGTH_SHORT).show();
        }
    }


//    private void viewData(){ method view data masih error
//        Cursor cursor = db.viewData();
//        if(cursor.getCount()==0){
//            Toast.makeText(getActivity(), "Tabel Doktor kosong", Toast.LENGTH_SHORT).show();
//        }else{
//            while(cursor.moveToNext()){
//                listItems.add(cursor.getString(0));
//                listItems.add(cursor.getString(1));
//                listItems.add(cursor.getString(2));
//                listItems.add(cursor.getString(3));
//            }
//            adapter = new ArrayAdapter(getContext(),R.layout.list_dokter,listItems);
//            dokterList.setAdapter(adapter);
//        }
//    }
}
