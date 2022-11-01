package com.pppb.aplikasirumahsakit;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TimePicker;

import androidx.fragment.app.Fragment;
import com.pppb.aplikasirumahsakit.databinding.BuatJanjiBinding;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class fragment_buatjanji extends Fragment{
    BuatJanjiBinding binding ;
    int day;
    int month;
    int year;
    int hour;
    int minute;

    public fragment_buatjanji(){
    }
    public static fragment_buatjanji newInstance(){
        fragment_buatjanji fragment_buatjanji = new fragment_buatjanji();
        return fragment_buatjanji;
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        binding = BuatJanjiBinding.inflate(inflater);
        binding.buatPertemuan.setOnClickListener(this::onClick);


        final Calendar calendar = Calendar.getInstance();

        binding.etDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                day = calendar.get(Calendar.DAY_OF_MONTH);
                month = calendar.get(Calendar.MONTH);
                year = calendar.get(Calendar.YEAR);

                DatePickerDialog datePickerDialog = new DatePickerDialog(fragment_buatjanji.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int day, int month, int year) {
                        binding.etDate.setText(SimpleDateFormat.getDateInstance().format(calendar.getTime()));
                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });

        binding.etTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                hour = calendar.get(Calendar.HOUR_OF_DAY);
                minute = calendar.get(Calendar.MINUTE);
                TimePickerDialog timePickerDialog = new TimePickerDialog(BuatJanji.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
                        binding.etTime.setText(hourOfDay + ":" + minute);
                    }
                }, hour, minute, true);
                timePickerDialog.show();
            }
        });
        return binding.getRoot();
    }

    private void onClick(View view){
        Bundle result = new Bundle();
        result.putInt("page",1);
        getParentFragmentManager().setFragmentResult("changePage",result);
    }
}
