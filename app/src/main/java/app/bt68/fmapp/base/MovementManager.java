package app.bt68.fmapp.base;


import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.gson.Gson;

import app.bt68.fmapp.BaseActivity;
 import app.bt68.fmapp.R;
import app.bt68.fmapp.base.constantsutils.Params;
import app.bt68.fmapp.home.models.Categories;


public class MovementManager {


    //---------Fragments----------//
    private static final int CONTAINER_ID = R.id.fl_home_container;

    public static void addFragment(Context context, Fragment fragment, String backStackText) {
        FragmentManager fragmentManager = ((FragmentActivity) context).getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction().add(CONTAINER_ID, fragment);
        if (!backStackText.equals("")) {
            fragmentTransaction.addToBackStack(backStackText);
        }
        fragmentTransaction.commit();
    }


    //-----------Activities-----------------//

    public static void startBaseActivity(Context context, int page) {
        Intent intent = new Intent(context, BaseActivity.class);
        intent.putExtra(Params.INTENT_PAGE, page);
        context.startActivity(intent);
        ((Activity) context).finishAffinity();
    }


    public static void startActivityWithBundle(Context context, int page, String from) {
        Intent intent = new Intent(context, BaseActivity.class);
        intent.putExtra(Params.INTENT_PAGE, page);
        intent.putExtra(Params.BUNDLE, from);
        context.startActivity(intent);
    }

    public static void startActivityWithObject(Context context, int page, Categories object) {
         Intent intent = new Intent(context, BaseActivity.class);
        intent.putExtra(Params.INTENT_PAGE, page);
        intent.putExtra(Params.BUNDLE, new Gson().toJson(object));
        context.startActivity(intent);
    }

}
