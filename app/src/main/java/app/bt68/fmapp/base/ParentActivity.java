package app.bt68.fmapp.base;

import android.content.Intent;
import android.graphics.Color;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


import app.bt68.fmapp.R;


public class ParentActivity extends AppCompatActivity {

    public void showMessage(String message, int type) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void setTitle(String title) {

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fl_home_container);
        fragment.onActivityResult(requestCode, resultCode, data);
    }


}
