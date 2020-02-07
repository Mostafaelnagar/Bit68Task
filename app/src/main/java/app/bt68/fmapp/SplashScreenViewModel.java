package app.bt68.fmapp;

import android.os.Handler;

import app.bt68.fmapp.base.BaseViewModel;
import app.bt68.fmapp.base.constantsutils.Codes;


public class SplashScreenViewModel extends BaseViewModel {
    public SplashScreenViewModel() {
    }

    public void startApp() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //                    getClicksMutableLiveData().setValue(Codes.HOME_SCREEN);
                getClicksMutableLiveData().setValue(Codes.ON_BOARD);
            }
        }, 3000);

    }

    public void skip() {
        getClicksMutableLiveData().setValue(Codes.CATEGORIES);
    }
}
