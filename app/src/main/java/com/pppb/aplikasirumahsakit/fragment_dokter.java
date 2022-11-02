package com.pppb.aplikasirumahsakit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.pppb.aplikasirumahsakit.databinding.FragmentListDokterBinding;

import java.util.ArrayList;

public class fragment_dokter extends Fragment {
    FragmentListDokterBinding binding;
    private listDokterAdapter adapter;
    private ArrayList<dokter> dokterList;
    // Make sure to use the FloatingActionButton for all the FABs
    FloatingActionButton mAddFab, mAddAlarmFab, mAddPersonFab;

    // These are taken to make visible and invisible along with FABs
    TextView addAlarmActionText, addPersonActionText;

    // to check whether sub FAB buttons are visible or not.
    Boolean isAllFabsVisible;

    public fragment_dokter(){

    }
    public static fragment_dokter newInstance(){
        fragment_dokter fragment_dokter = new fragment_dokter();
        return fragment_dokter;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        binding = FragmentListDokterBinding.inflate(inflater);
        dokterList = new ArrayList<>();
        binding.addAlarmActionText.setVisibility(View.GONE);
        mAddAlarmFab.setVisibility(View.GONE);
        mAddPersonFab.setVisibility(View.GONE);
        binding.addDokter.setVisibility(View.GONE);

        isAllFabsVisible = false;
        binding.addFab.setOnClickListener(this::onClickFAB);

        return binding.getRoot();
    }

    public void onClickFAB(View view){
        if(!isAllFabsVisible){
            mAddAlarmFab.show();
            mAddPersonFab.show();
            binding.addAlarmActionText.setVisibility(View.VISIBLE);
            binding.addDokter.setVisibility(View.VISIBLE);

            isAllFabsVisible = true;
        }
        else{
            mAddAlarmFab.hide();
            mAddPersonFab.hide();
            binding.addAlarmActionText.setVisibility(View.GONE);
            binding.addDokter.setVisibility(View.GONE);
            isAllFabsVisible = false;
        }
    }

}
