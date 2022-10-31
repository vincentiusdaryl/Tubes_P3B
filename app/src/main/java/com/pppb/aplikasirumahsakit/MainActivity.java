package com.pppb.aplikasirumahsakit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import com.pppb.aplikasirumahsakit.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    protected fragment_home fragmentHome;
    protected FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        this.fragmentHome = fragment_home.newInstance();

        fragmentManager = getSupportFragmentManager();

        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.add(binding.fragmentContainer.getId(),fragmentHome,"main").setReorderingAllowed(true).commit();

        this.getSupportFragmentManager().setFragmentResultListener(
                "changePage", this, new FragmentResultListener() {
                    @Override
                    public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                        int page = result.getInt("page");
                        changePage(page);
                    }
                }
        );

    }

    public void changePage(int page){
        FragmentTransaction ft = fragmentManager.beginTransaction();
        if(page==1){
            ft.replace(binding.fragmentContainer.getId(),this.fragmentHome).addToBackStack(null).setReorderingAllowed(true);
        }
        else if(page==2){

        }
        ft.commit();
    }

}