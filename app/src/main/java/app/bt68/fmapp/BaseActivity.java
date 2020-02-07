package app.bt68.fmapp;


import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.databinding.DataBindingUtil;


import app.bt68.fmapp.base.MovementManager;
import app.bt68.fmapp.base.ParentActivity;
import app.bt68.fmapp.base.constantsutils.Codes;
import app.bt68.fmapp.base.constantsutils.Params;
import app.bt68.fmapp.databinding.ActivityBaseBinding;
import app.bt68.fmapp.home.HomeFragment;
import app.bt68.fmapp.onBoard.OnBoardFragment;
import app.bt68.fmapp.products.Product_DetailsFragment;
import app.bt68.fmapp.products.ProductsFragment;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;

public class BaseActivity extends ParentActivity {
    public ActivityBaseBinding activityBaseBinding;
    public String lang;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/font1.otf")
                .setFontAttrId(R.attr.fontPath)
                .build());
        super.onCreate(savedInstanceState);
        activityBaseBinding = DataBindingUtil.setContentView(this, R.layout.activity_base);
        ActivityCompat.requestPermissions(this, new String[]{ACCESS_FINE_LOCATION}, 1);
        if (getIntent().hasExtra(Params.INTENT_PAGE)) {
            addFragment(getIntent().getIntExtra(Params.INTENT_PAGE, 0));
        }
    }


    private void addFragment(int page) {
        if (page == Codes.ON_BOARD) {
            MovementManager.addFragment(this, new OnBoardFragment(), "");
        } else if (page == Codes.CATEGORIES) {
            MovementManager.addFragment(this, new HomeFragment(), "");
        } else if (page == Codes.PRODUCTS) {
            ProductsFragment fragment = new ProductsFragment();
            Bundle bundle = new Bundle();
            bundle.putString(Params.BUNDLE, getIntent().getStringExtra(Params.BUNDLE));
            fragment.setArguments(bundle);
            MovementManager.addFragment(this, fragment, "");
        } else if (page == Codes.PRODUCTS_DETAILS) {
            Product_DetailsFragment fragment = new Product_DetailsFragment();
            Bundle bundle = new Bundle();
            bundle.putString(Params.BUNDLE, getIntent().getStringExtra(Params.BUNDLE));
            fragment.setArguments(bundle);
            MovementManager.addFragment(this, fragment, "");
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}