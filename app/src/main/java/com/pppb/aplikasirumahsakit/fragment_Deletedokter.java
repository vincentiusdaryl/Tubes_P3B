package com.pppb.aplikasirumahsakit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import com.pppb.aplikasirumahsakit.databinding.FragmentDeletedokterBinding;

public class fragment_Deletedokter extends Fragment {
    FragmentDeletedokterBinding binding;
    dbDokterAdapter db;

    public fragment_Deletedokter(){

    }
    public static fragment_Deletedokter newInstance(){
        fragment_Deletedokter fragment = new fragment_Deletedokter();
        return fragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        binding = FragmentDeletedokterBinding.inflate(inflater);
        binding.buttonHapus.setOnClickListener(this::onClick);
        binding.buttonHapusSemua.setOnClickListener(this::onClickhapusSemua);
        db = new dbDokterAdapter(getActivity());
        return binding.getRoot();
    }

    private void onClick(View view) {
        String namaDokter = binding.etNamaDokterDihapus.getText().toString();
        if(namaDokter == ""){
            Toast.makeText(getActivity(), "Nama Dokter Kosong", Toast.LENGTH_SHORT).show();
        }else{
            db.deleteBarisNama(namaDokter);
            Toast.makeText(getActivity(), "Data dokter berhasil dihapus", Toast.LENGTH_SHORT).show();
            Bundle result = new Bundle();
            result.putInt("page",2);
            getParentFragmentManager().setFragmentResult("changePage",result);
        }
    }

    private void onClickhapusSemua(View view){
        db.deleteAll();
        Toast.makeText(getActivity(), "Data dokter berhasil dihapus semua", Toast.LENGTH_SHORT).show();
        Bundle result = new Bundle();
        result.putInt("page",2);
        getParentFragmentManager().setFragmentResult("changePage",result);
    }

}
