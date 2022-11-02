package com.pppb.aplikasirumahsakit;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.pppb.aplikasirumahsakit.databinding.BuatJanjiBinding;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class fragment_buatjanji extends Fragment implements View.OnClickListener{
    BuatJanjiBinding binding ;
    private TextView tvDate;
    private TextView tvTime;
    private DatePickerDialog.OnDateSetListener dateSetListener;
    private int day, month, year, hour, minute;

    public fragment_buatjanji(){
    }
    public static fragment_buatjanji newInstance(){
        fragment_buatjanji fragment_buatjanji = new fragment_buatjanji();
        return fragment_buatjanji;
    }

    public View onCreateView(View view, @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        view = inflater.inflate(R.layout.buat_janji, container, false);
        this.tvDate = view.findViewById(R.id.tvDate);
        this.tvTime = view.findViewById(R.id.tvTime);

        tvDate.setOnClickListener(view1 -> {
            Calendar calendar = Calendar.getInstance();
            this.year = calendar.get(Calendar.YEAR);
            this.month = calendar.get(Calendar.MONTH);
            this.day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog dialog = new DatePickerDialog(getContext(), android.R.style.Theme_DeviceDefault, dateSetListener, year, month, day);
            dialog.show();
        });

        dateSetListener = (datePicker, day, month, year) -> {
            month = month + 1;

            String date = day + "/" + month + "/" + year;
            tvDate.setText(date);
        };

        tvTime.setOnClickListener(view1 -> {
            Calendar mcurrentTime = Calendar.getInstance();
            int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
            int minute = mcurrentTime.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog;
            timePickerDialog = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                    tvTime.setText(selectedHour + ":" + selectedMinute);
                }
            }, hour, minute, false);
            timePickerDialog.setTitle("Select Time");
            timePickerDialog.show();
        });

        return view;
    }


    public void onClick(View view){
        Bundle result = new Bundle();
        result.putInt("page",1);
        getParentFragmentManager().setFragmentResult("changePage",result);
    }

}
