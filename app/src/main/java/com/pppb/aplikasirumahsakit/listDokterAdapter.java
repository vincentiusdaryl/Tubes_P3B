package com.pppb.aplikasirumahsakit;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import java.util.ArrayList;

import com.pppb.aplikasirumahsakit.databinding.FragmentListDokterBinding;
import com.pppb.aplikasirumahsakit.databinding.ListDokterBinding;
public class listDokterAdapter extends BaseAdapter{

private Context context;
ListDokterBinding binding;
private ArrayList<dokter> listDokter = new ArrayList<>();
private Button telepon;

    public listDokterAdapter() {
        
    }

    private void setListDokter(ArrayList<dokter> listDokter){
    this.listDokter = listDokter;
}
    public listDokterAdapter(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return listDokter.size();
    }

    @Override
    public Object getItem(int i) {
        return listDokter.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        binding = ListDokterBinding.inflate(inflater);

        View itemView = view;

        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.list_dokter, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(itemView);
        dokter dokter = (dokter) getItem(i);
        System.out.println(dokter.getNama());

        viewHolder.add(dokter);
        return binding.getRoot();

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = ListDokterBinding.inflate(inflater);

        this.telepon = binding.telepon;
        this.telepon.setOnClickListener(this::onClick);
        return binding.getRoot();
    }

    public void onClick (View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:082227535478"));
//        startActivity(intent);
    }


    public static listDokterAdapter newInstance() {
        listDokterAdapter fragment = new listDokterAdapter();
        return fragment;
    }

    private class ViewHolder{

        ViewHolder(View view){

        }
        void add(dokter dokter){
            binding.namaDokter.setText(dokter.getNama());
            binding.spesialisDokter.setText(dokter.getSpesialis());
        }
    }

}
