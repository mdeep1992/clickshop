package com.example.clickshop;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.ArraySet;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Mpreference {
    static String preference_name = "clickShop";

    public static void setLogin(Context context) {
        SharedPreferences.Editor editor = context.getSharedPreferences(preference_name, MODE_PRIVATE).edit();
        editor.putBoolean("isLogin", true);
        editor.apply();

    }

    public static void setLogOut(Context context) {
        SharedPreferences.Editor editor = context.getSharedPreferences(preference_name, MODE_PRIVATE).edit();
        editor.putBoolean("isLogin", false);
        editor.apply();

    }

    public static boolean retrive(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(preference_name, MODE_PRIVATE);
        boolean isLogin = prefs.getBoolean("isLogin", false);//"No name defined" is the default value
        return isLogin;

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public static void addProduct(String id, Context context) {
        SharedPreferences prefs = context.getSharedPreferences(preference_name, MODE_PRIVATE);
        Set<String> cartList = prefs.getStringSet("addproduct", Collections.emptySet());
        Set<String> clonedList = new ArraySet<>();
        clonedList.addAll(cartList);
        clonedList.add(id);
        SharedPreferences.Editor editor = context.getSharedPreferences(preference_name, MODE_PRIVATE).edit();
        editor.putStringSet("addproduct", clonedList);
        editor.apply();

    }

    public static List<String> retriveCart(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(preference_name, MODE_PRIVATE);

        return new ArrayList<>(prefs.getStringSet("addproduct", Collections.emptySet()));

    }
}
