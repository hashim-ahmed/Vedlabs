package app.horoscope.vedlabs.ui.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.snackbar.Snackbar;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import app.horoscope.vedlabs.R;


public class Utils {

    public static float[] getRadius(float value) {
        return new float[]{value, value, value, value, value, value, value, value};
    }

    public static void hideKeyboard(Activity _activity) {
        View view = _activity.getCurrentFocus();
        if (view != null) {
            InputMethodManager inputManager = (InputMethodManager) _activity
                    .getSystemService(Context.INPUT_METHOD_SERVICE);
            inputManager.hideSoftInputFromWindow(view.getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }



    public static HashMap<String,String> getMap()
    {
        return new HashMap<String,String>();
    }

    public static void changeColor(Activity activity, String color, boolean isDark) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Window window = activity.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            if (isDark) {
                window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            }
            window.setStatusBarColor(Color.parseColor(color));
        } else if (Build.VERSION.SDK_INT == Build.VERSION_CODES.LOLLIPOP) {
            Window window = activity.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            window.setStatusBarColor(Color.parseColor(color));
        }
    }

/*

    public static void showToast(Activity activity, String mes, String type) {
        String msg = "Something gone wrong.";
        if (mes == null) {
            mes = msg;
        } else if (mes.equalsIgnoreCase("")) {
            mes = msg;
        }
        hideKeyboard(activity);
        LayoutInflater inflater = activity.getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast_layout, activity.findViewById(R.id.toast_layout_root));
        LinearLayout root = layout.findViewById(R.id.toast_layout_root);
        TextView toastTextView = layout.findViewById(R.id.toastTextView);
        toastTextView.setText(mes);
        Toast toast = new Toast(activity);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }

*/


    public static void routeToActivity(Intent intent, Activity activity) {
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }

    public static String getAddressFromLatLng(Context context,  Double latitude,Double longitude){
        String addressString = "";
        Geocoder geocoder;
        List<Address> addresses;
        geocoder = new Geocoder(context, Locale.getDefault());
        try {
            addresses = geocoder.getFromLocation(latitude, longitude, 1);// Here 1 represent max location result to returned, by documents it recommended 1 to 5
            addressString = addresses.get(0).getAddressLine(0); // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
            /*String city = addresses.get(0).getLocality();
            String state = addresses.get(0).getAdminArea();
            String country = addresses.get(0).getCountryName();
            String postalCode = addresses.get(0).getPostalCode();
            String knownName = addresses.get(0).getFeatureName();*/
        } catch (IOException e) {
            e.printStackTrace();
        }
        return addressString;
    }




    public static void showSnackBar(Activity con, String message) {
        hideKeyboardFrom(con);
        Snackbar.make(con.findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG).show();
    }

 /*   public static UserBean.ResultBean getUserInfo(){
        return new Gson().fromJson(PrefManager.getString(AppConstant.Companion.getUserInfo(),""),UserBean.class).getResult();
    }*/

    public static void hideKeyboardFrom(Activity context) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        View view = context.getCurrentFocus();
        if (view == null) {
            view = new View(context);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }


    public static void routeToActivityResult(Intent intent, Activity activity, int code) {
        activity.startActivityForResult(intent, code);
        activity.overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }

    public static void transparentStatusBar(Activity activity) {
        if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21) {
            setWindowFlag(activity, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, true);
        }
        if (Build.VERSION.SDK_INT >= 19) {
            activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(activity, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false);
            activity.getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }

    private static void setWindowFlag(Activity activity, final int bits, boolean on) {
        Window win = activity.getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }
    @SuppressLint("CheckResult")
    public static void setImageView(Context mContext, ImageView imageView, String path) {
        if (!path.equalsIgnoreCase("") && !path.equalsIgnoreCase("null")) {
            RequestOptions requestOptions = new RequestOptions();
            requestOptions.placeholder(R.drawable.ic_launcher_background);
            Glide.with(mContext).load(path).apply(requestOptions).into(imageView);
            imageView.setVisibility(View.VISIBLE);
        }else {
            Glide.with(mContext).load(R.drawable.ic_launcher_background).into(imageView);
            imageView.setVisibility(View.VISIBLE);
        }
    }

    public static void setImageView(Context mContext, ImageView imageView, int drawableId) {
        RequestOptions requestOptions = new RequestOptions();
        Glide.with(mContext).load(drawableId).apply(requestOptions).into(imageView);
        imageView.setVisibility(View.VISIBLE);
    }

    public static void checkPermission (Activity activity, String permissionString, int permissionCode) {
        if ((Build.VERSION.SDK_INT < Build.VERSION_CODES.M)) return;
        int existingPermissionStatus = ContextCompat.checkSelfPermission(activity,
                permissionString);
        if (existingPermissionStatus == PackageManager.PERMISSION_GRANTED) return;
        ActivityCompat.requestPermissions(activity, new String[]{permissionString}, permissionCode);
    }

}
