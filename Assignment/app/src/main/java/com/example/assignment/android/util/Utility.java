package com.example.assignment.android.util;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;

import com.example.assignment.R;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Utility {

    private static ProgressDialog mProgressDialog;

    public static String iStreamToString(InputStream is1)
    {
        BufferedReader rd = new BufferedReader(new InputStreamReader(is1), 4096);
        String line;
        StringBuilder sb =  new StringBuilder();
        try {
            while ((line = rd.readLine()) != null) {
                sb.append(line);
            }
            rd.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String contentOfMyInputStream = sb.toString();
        return contentOfMyInputStream;
    }

    public static JSONObject getJsonObject(String res){
        JSONObject resJsonObject =  null;
        try {
            resJsonObject =  new JSONObject(res);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return resJsonObject;
    }

    public static <T> T getGsonFormat(String json, Class<T> classOfT) {
        Gson gson =  new Gson();
        T objects = null;
        try {
            objects =  gson.fromJson(json, classOfT);
        }catch(Exception e){
            e.printStackTrace();
        }
        return objects;
    }


    public static void showProgressDialog(Context activity, String message, boolean cancelable) {
        try {
            if (mProgressDialog != null && mProgressDialog.isShowing()) {
                return;
            }

            mProgressDialog = new ProgressDialog(activity);
            if (message == null) {
                message = activity.getResources().getString(R.string.progress_dialog_message);
            }
            mProgressDialog.setMessage(message);
            mProgressDialog.setIndeterminate(true);
            mProgressDialog.setCancelable(cancelable);
            mProgressDialog.setCanceledOnTouchOutside(cancelable);
            mProgressDialog.show();
        } catch (Resources.NotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void hideProgressDialog() {
        try {
            if (mProgressDialog != null && mProgressDialog.isShowing()) {
                mProgressDialog.dismiss();
                mProgressDialog = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
