package com.pppb.aplikasirumahsakit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import com.pppb.aplikasirumahsakit.databinding.ListDokterBinding;
public class listDokterAdapter extends BaseAdapter{

private Context context;
ListDokterBinding binding;
private ArrayList<dokter> listDokter;


    public listDokterAdapter(Context context,ArrayList<dokter> listDokter){
        this.context = context;
        this.listDokter = listDokter;
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
    private class ViewHolder{

        ViewHolder(View view){

        }
        void add(dokter dokter){
            binding.idDokter.setText(dokter.getId());
            binding.namaDokter.setText(dokter.getNama());
            binding.spesialisDokter.setText(dokter.getSpesialis());
            binding.noTelp.setText(dokter.getNoTelp());
        }
    }

}
