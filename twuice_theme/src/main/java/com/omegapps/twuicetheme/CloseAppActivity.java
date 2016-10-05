package com.omegapps.twuicetheme;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.IntentCompat;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by danie on 10/5/2016.
 */

public class CloseAppActivity extends AppCompatActivity
{
    public static final void closeApp(Activity activity)
    {
        Intent intent = new Intent(activity, CloseAppActivity.class);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
                IntentCompat.FLAG_ACTIVITY_CLEAR_TASK);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        finish();
    }
}