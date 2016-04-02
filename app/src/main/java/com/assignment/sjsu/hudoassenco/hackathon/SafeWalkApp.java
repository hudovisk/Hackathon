package com.assignment.sjsu.hudoassenco.hackathon;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;
import android.util.Log;

import com.facebook.FacebookSdk;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by hudoassenco on 4/2/16.
 */
public class SafeWalkApp extends Application {

    public final String TAG = "SafeWalkApp";

    @Override
    public void onCreate() {
        Log.v(TAG, "onCreate()");
        FacebookSdk.sdkInitialize(getApplicationContext());

        printKeyHash();

        super.onCreate();
    }

    public void printKeyHash() {
        try {
            PackageInfo info = getPackageManager().getPackageInfo("com.assignment.sjsu.hudoassenco.hackathon", PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.v(TAG, Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(TAG, e.getMessage());
        } catch (NoSuchAlgorithmException e) {
            Log.e(TAG, e.getMessage());
        }
    }

}
