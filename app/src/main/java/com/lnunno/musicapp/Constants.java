package com.lnunno.musicapp;

import com.echonest.api.v4.EchoNestAPI;

/**
 * Created by Lucas on 3/14/2015.
 */
public class Constants {

    private Constants() {
    }

    private static boolean TRACE = false;

    /**
     * Echo Nest API access point.
     */
    public static final EchoNestAPI EN;

    static {
        EN = new EchoNestAPI(Secret.EchoNest.API_KEY);
        EN.setTraceSends(TRACE);
        EN.setTraceRecvs(TRACE);
    }

    public static final String FONTAWESOME_FILENAME = "fontawesome-webfont.ttf";
}
