package com.lnunno.musicapp.views;

import android.graphics.drawable.Drawable;
import android.media.Image;

/**
 * Created by root on 3/17/15.
 */
public class DrawerElement {

    private Drawable icon;
    private String text;

    public DrawerElement(String text, Drawable icon){
        this.icon = icon;
        this.text = text;
    }

    public Drawable getIcon() {
        return icon;
    }

    public String getText() {
        return text;
    }
}
