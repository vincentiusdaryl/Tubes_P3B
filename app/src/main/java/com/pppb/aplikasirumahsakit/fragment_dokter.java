package com.pppb.aplikasirumahsakit;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.pppb.aplikasirumahsakit.databinding.FragmentListDokterBinding;

import java.util.ArrayList;

public class fragment_dokter extends Fragment {
    FragmentListDokterBinding binding;
    listDokterAdapter adapter;
    ArrayList<dokter> arrayList;
    dbDokterAdapter db;
    SimpleCursorAdapter myAdapter;
    ListView listView;

    FloatingActionButton mAddFab, mTambahDokter, mEditDokter, mDeleteDokter;

    // to check whether sub FAB buttons are visible or not.
    Boolean isAllFabsVisible;

    public fragment_dokter(){

    }
    public static fragment_dokter newInstance(){
        fragment_dokter fragment_dokter = new fragment_dokter();
        return fragment_dokter;
    }

    @Override
    public void onStart() {
        super.onStart();
        db = new dbDokterAdapter(getActivity());
//        this.listView = getActivity().findViewById(R.id.lstViewDokter);
//        showDokterData();

        isiListView();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        binding = FragmentListDokterBinding.inflate(inflater);
//        isiListView();

        mAddFab = binding.addFab;
        mDeleteDokter = binding.fabDeleteDokter;
        mEditDokter = binding.fabEditDokter;
        mTambahDokter = binding.fabTambahDokter;

        binding.tvEditDokter.setVisibility(View.GONE);
        mDeleteDokter.setVisibility(View.GONE);
        mTambahDokter.setVisibility(View.GONE);
        mEditDokter.setVisibility(View.GONE);
        binding.tvTambahDokter.setVisibility(View.GONE);
        binding.tvDeleteDokter.setVisibility(View.GONE);

        isAllFabsVisible = false;
        binding.addFab.setOnClickListener(this::onClickFAB);
        mTambahDokter.setOnClickListener(this::onClickTambahDokter);
        mEditDokter.setOnClickListener(this::onClickEditDokter);
        mDeleteDokter.setOnClickListener(this::onClickDeleteDokter);
        return binding.getRoot();
    }

    private void showDokterData() {
        arrayList = db.getDokterData();
        adapter = new listDokterAdapter(getActivity(), arrayList);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    public void onClickFAB(View view){
        if(!isAllFabsVisible){
            mEditDokter.show();
            mTambahDokter.show();
            mDeleteDokter.show();
            binding.tvDeleteDokter.setVisibility(View.VISIBLE);
            binding.tvTambahDokter.setVisibility(View.VISIBLE);
            binding.tvEditDokter.setVisibility(View.VISIBLE);

            isAllFabsVisible = true;
        }
        else{
            mDeleteDokter.hide();
            mTambahDokter.hide();
            mEditDokter.hide();
            binding.tvEditDokter.setVisibility(View.GONE);
            binding.tvDeleteDokter.setVisibility(View.GONE);
            binding.tvTambahDokter.setVisibility(View.GONE);
            isAllFabsVisible = false;
        }
    }
    public void onClickTambahDokter(View view){
        Bundle result = new Bundle();
        result.putInt("page",4);
        getParentFragmentManager().setFragmentResult("changePage",result);
    }
    public void onClickEditDokter(View view){

    }
    public void onClickDeleteDokter(View view){
    Bundle result = new Bundle();
    result.putInt("page",5);
    getParentFragmentManager().setFragmentResult("changePage",result);
    }
    //    ngisi listviewnya dengan data dari db
    public void isiListView(){
        db.open();
        Cursor cursor = db.getSemuaBaris();
        String[] fieldnames = new String[] {dbDokterAdapter.KEY_ID,dbDokterAdapter.KEY_NAMA,dbDokterAdapter.KEY_SPESIALIS,dbDokterAdapter.KEY_NOTELP};
        int[] viewIDS = new int[] {R.id.idDokter,R.id.namaDokter,R.id.spesialisDokter,R.id.noTelp};
        myAdapter = new SimpleCursorAdapter(requireActivity(),R.layout.list_dokter,cursor,fieldnames,viewIDS,0);
        ListView myList = getActivity().findViewById(R.id.lstViewDokter);
        myList.setAdapter(myAdapter);
    }

}
