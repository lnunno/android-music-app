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

    /**
     * For joining URL paths together. /foo/baz bar => /foo/baz/bar
     */
    public static final Joiner URL_JOINER = Joiner.on('/');

    /**
     * For joining key, value pairs in parameter lists in URLs.
     */
    public static final Joiner.MapJoiner PARAM_MAP_JOINER = Joiner
            .on('&')
            .withKeyValueSeparator("=");

    public static final Joiner PARAM_STRING_JOINER = Joiner.on('&');

    /**
     * For joining URLs with parameter lists in URLs.
     */
    public static final Joiner URL_PARAM_JOINER = Joiner
            .on('?')
            .skipNulls();

    /**
     *
     * @param baseUrl
     * @param optionalParamMap
     * @param optionalExtraParams Any extra raw URL parameters as a String.
     * @return The response as a String.
     */
    public static String request(String baseUrl,
                                 Optional<Map<String, String>> optionalParamMap,
                                 Optional<String> optionalExtraParams) {
        String charset = StandardCharsets.UTF_8.name();
        URLConnection connection;
        try {
            String paramStr = null;
            if (optionalParamMap.isPresent()) {
                paramStr = PARAM_MAP_JOINER.join(optionalParamMap.get());
            }
            if (optionalExtraParams.isPresent()) {
                paramStr = PARAM_STRING_JOINER.join(paramStr, optionalExtraParams.get());
            }
            String url = URL_PARAM_JOINER.join(baseUrl, paramStr);
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

    public static String request(String baseUrl){
        return request(baseUrl, Optional.<Map<String, String>>absent(), Optional.<String>absent());
    }

    public static String request(String baseUrl,
                                 Optional<Map<String, String>> optionalParamMap){
        return request(baseUrl, optionalParamMap, Optional.<String>absent());
    }
}
