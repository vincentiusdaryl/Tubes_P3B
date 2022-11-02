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
ArrayList<dokter> listDokter = new ArrayList<>();

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
    private class ViewHolder{

        ViewHolder(View view){

        }
        void add(dokter dokter){
            binding.namaDokter.setText(dokter.getNama());
            binding.spesialisDokter.setText(dokter.getSpesialis());
        }
    }

}
