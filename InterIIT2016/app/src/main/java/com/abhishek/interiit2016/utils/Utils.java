package com.abhishek.interiit2016.utils;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.widget.RecyclerView;
import android.widget.RelativeLayout;

import com.abhishek.interiit2016.adapters.SimpleRecyclerAdapter;

/**
 * Created by GUNDA ABHISHEK on 23-06-2016.
 */
public class Utils {
    public static boolean isInterNetUp(Context ctx) {
        boolean connected = false;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) ctx
                    .getSystemService(Context.CONNECTIVITY_SERVICE);

            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            connected = networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected();
            return connected;


        } catch (Exception e) {
            //exception
        }
        return connected;
    }
    public static void setImageFromAssetsForRelativeLayout(RelativeLayout rLayout, Drawable d){
        final int sdk = android.os.Build.VERSION.SDK_INT;
        if(sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
            rLayout.setBackgroundDrawable(d);
        } else {
            rLayout.setBackground(d);
        }
    }

    public static void animatelist(RecyclerView.ViewHolder versionViewHolder, boolean isScrolldown) {
        AnimatorSet animatorSet=new AnimatorSet();
        //ObjectAnimator scaleX = ObjectAnimator.ofFloat(versionViewHolder.itemView, "scaleX",0f , 1f);
        //ObjectAnimator scaleY = ObjectAnimator.ofFloat(versionViewHolder.itemView, "scaleY",0f, 1f);
       // scaleX.setDuration(100);
        //scaleY.setDuration(100);
        ObjectAnimator objectAnimator =ObjectAnimator.ofFloat(versionViewHolder.itemView,"translationY",300,0);
        objectAnimator.setDuration(500);
        animatorSet.playSequentially(objectAnimator);
        animatorSet.start();
    }
}
