package model;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;

import com.example.week1.R;

public class loading {
    private Activity activity;
    private AlertDialog dialog;


    public loading(Activity myActivity){
        activity = myActivity;
    }

    public void startLoadingDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        LayoutInflater inflater = activity.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.custom_loading, null));
        builder.setCancelable(false);

        dialog = builder.create();
        dialog.show();


    }
    public void dismissDialog(){
        dialog.dismiss();
    }

}
