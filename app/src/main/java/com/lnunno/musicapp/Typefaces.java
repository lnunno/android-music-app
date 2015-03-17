package com.lnunno.musicapp;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;

import java.util.Hashtable;

/**
 * Use this for caching typefaces.
 * <p/>
 * Built off the following:
 * http://stackoverflow.com/questions/15210548/how-to-use-a-icons-and-symbols-from-font-awesome-on-native-android-application
 * https://code.google.com/p/android/issues/detail?id=9904#c7
 * <p/>
 * Created by Lucas on 3/15/2015.
 */
public class Typefaces {
    private static final String TAG = "Typefaces";

    private static final Hashtable<String, Typeface> cache = new Hashtable<String, Typeface>();

    private Typefaces() {
    }

    public static Typeface get(Context c, String assetPath) {
        synchronized (cache) {
            if (!cache.containsKey(assetPath)) {
                try {
                    Typeface t = Typeface.createFromAsset(c.getAssets(),
                            assetPath);
                    cache.put(assetPath, t);
                } catch (Exception e) {
                    Log.e(TAG, "Could not get typeface '" + assetPath
                            + "' because " + e.getMessage());
                    return null;
                }
            }
            return cache.get(assetPath);
        }
    }

    public static Typeface getFontAwesomeTypeface(Context c) {
        return get(c, Constants.FONTAWESOME_FILENAME);
    }
}