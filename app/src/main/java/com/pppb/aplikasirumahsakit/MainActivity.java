package com.pppb.aplikasirumahsakit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import com.pppb.aplikasirumahsakit.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    DrawerLayout drawer;
    protected fragment_home fragmentHome;
    protected FragmentManager fragmentManager;
    protected fragment_left fragmentLeft;
    protected fragment_dokter fragmentDokter;
    protected fragment_buatjanji fragmentBuatjanji;
    protected fragment_tambahdokter fragmentTambahdokter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        this.fragmentHome = fragment_home.newInstance();
        this.fragmentLeft = fragment_left.newInstance();
        this.fragmentDokter = fragment_dokter.newInstance();
        this.fragmentBuatjanji = fragment_buatjanji.newInstance();
        this.fragmentTambahdokter = fragment_tambahdokter.newInstance();
        drawer = binding.drawerLayout;

        fragmentManager = getSupportFragmentManager();

        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.add(binding.fragmentContainer.getId(),fragmentHome,"main").setReorderingAllowed(true).commit();
        ActionBarDrawerToggle abdt = new ActionBarDrawerToggle(this,binding.drawerLayout,binding.toolbar,R.string.open,R.string.close);
        drawer.addDrawerListener(abdt);
        abdt.syncState();

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
            ft.replace(binding.fragmentContainer.getId(),this.fragmentDokter).addToBackStack(null).setReorderingAllowed(true);
        }
        else if(page==0){
            this.moveTaskToBack(true);
            this.finish();
        }
        else if (page==3){
            ft.replace(binding.fragmentContainer.getId(),this.fragmentBuatjanji).addToBackStack(null).setReorderingAllowed(true);
        }
        else if(page==4){
            ft.replace(binding.fragmentContainer.getId(),this.fragmentTambahdokter).addToBackStack(null).setReorderingAllowed(true);
        }
        ft.commit();
        drawer.closeDrawers();
    }

}