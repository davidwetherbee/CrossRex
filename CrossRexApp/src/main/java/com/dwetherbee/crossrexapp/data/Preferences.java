package com.dwetherbee.crossrexapp.data;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.dwetherbee.crossrexapp.CrossRexApplication;


@SuppressLint("NewApi")
public class Preferences {

    public static final String KEY_DEMO_DATA = "demodata";

    private final static String TAG = "Preferences";

    public static boolean getBoolean(String key, boolean defaultBool) {

        boolean value = defaultBool;

        try {

            value = getPrefs().getBoolean(key, defaultBool);

        } catch (Exception ex) {
        }

        return value;
    }

    public static int getInt(String key, int defValue) {

        int value = defValue;

        try {
            value = getPrefs().getInt(key, defValue);
        } catch (Exception ex) {
        }

        return value;
    }

    public static Long getLong(String key, Long defValue) {

        Long value = null;

        try {

            value = getPrefs().getLong(key, defValue);

        } catch (Exception ex) {
        }

        return value == null ? defValue : value;
    }


    public static String getString(String key, String defaultString) {

        String value = null;

        try {

            value = getPrefs().getString(key, defaultString);

        } catch (Exception ex) {
        }

        return value == null ? defaultString : value;
    }

    public static boolean remove(String key) {

        SharedPreferences prefs = getPrefs();
        Editor edit = prefs.edit();
        edit.remove(key);

        return edit.commit();
    }

    private static SharedPreferences getPrefs() {

        Context context = CrossRexApplication.getContext();

        if (context == null)
            return null;

        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static boolean saveBoolean(String key, boolean value) {

        SharedPreferences prefs = getPrefs();
        Editor edit = prefs.edit();
        edit.putBoolean(key, value);

        return edit.commit();
    }

    public static boolean saveInt(String key, int value) {

        SharedPreferences prefs = getPrefs();
        Editor edit = prefs.edit();
        edit.putInt(key, value);

        return edit.commit();
    }

    public static boolean saveLong(String key, Long value) {

        SharedPreferences prefs = getPrefs();
        Editor edit = prefs.edit();
        edit.putLong(key, value);

        return edit.commit();
    }

    public static boolean saveString(String key, String value) {

        SharedPreferences prefs = getPrefs();
        Editor edit = prefs.edit();
        edit.putString(key, value);

        return edit.commit();
    }
}
