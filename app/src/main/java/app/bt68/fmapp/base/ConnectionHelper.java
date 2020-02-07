package app.bt68.fmapp.base;

import android.util.Log;
import android.widget.ImageView;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.json.JSONObject;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import app.bt68.fmapp.R;


public class ConnectionHelper {

    private static DisplayImageOptions options = new DisplayImageOptions.Builder()
            .showImageForEmptyUri(R.color.overlayBackground)
            .showImageOnLoading(R.color.overlayBackground)
            .showImageOnFail(R.color.overlayBackground)
            .cacheInMemory(true)
            .cacheOnDisk(true).build();

    private static ImageLoader imageLoader = ImageLoader.getInstance();



    public static void loadImage(final ImageView image, String imageUrl) {
        imageLoader.displayImage(imageUrl, image, options);
    }

}