package com.lnunno.musicutils;

import com.lnunno.musicutils.http.HttpUtils;

/**
 * Created by Lucas on 1/17/2015.
 */
public class Testing {

    public static void main(String[] args){
        System.out.println(HttpUtils.request("http://developer.echonest.com/api/v4/artist/biographies?api_key=VRAR8LY4DG2UIN56N&name=minus+the+bear&format=json&results=1&start=0&license=cc-by-sa"));
    }
}
