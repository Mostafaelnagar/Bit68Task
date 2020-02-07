package app.bt68.fmapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.os.Bundle;


import app.bt68.fmapp.base.MovementManager;

public class SplashActivity extends AppCompatActivity {
    SplashScreenViewModel screenViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        screenViewModel = new SplashScreenViewModel();
        screenViewModel.startApp();
        liveDataListeners();
    }

    private void liveDataListeners() {
        screenViewModel.getClicksMutableLiveData().observe(this, new Observer<Integer>() {
                    @Override
                    public void onChanged(Integer integer) {
                        MovementManager.startBaseActivity(SplashActivity.this, integer);
                    }
                }
        );
    }

}
