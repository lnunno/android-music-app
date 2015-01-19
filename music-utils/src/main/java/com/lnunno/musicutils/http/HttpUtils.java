package com.lnunno.musicutils.http;

import com.google.common.base.Joiner;
import com.google.common.base.Optional;
import com.google.common.base.Throwables;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import java.nio.charset.StandardCharsets;

/**
 * Created by Lucas on 1/17/2015.
 */
public class HttpUtils {

    private static final Joiner.MapJoiner paramJoiner = Joiner
            .on('&')
            .withKeyValueSeparator("=");

    private static final Joiner urlJoiner = Joiner
            .on('?')
            .skipNulls();

    public static String request(String baseUrl, Optional<Map<String,String>> optionalParamMap){
        String charset = StandardCharsets.UTF_8.name();
        URLConnection connection;
        try {
            String paramStr = null;
            if(optionalParamMap.isPresent()){
                paramStr = paramJoiner.join(optionalParamMap.get());
            }
            String url = urlJoiner.join(baseUrl,paramStr);
            connection = new URL(url).openConnection();
            connection.setRequestProperty("Accept-Charset", charset);
            InputStream response = connection.getInputStream();
            String responseStr = IOUtils.toString(response);
            return responseStr;
        } catch (IOException e) {
            e.printStackTrace();
            Throwables.propagate(e);
            return null;
        }
    }
}
