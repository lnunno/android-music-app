package com.lnunno.musicutils.echonest;

import com.echonest.api.v4.Artist;
import com.echonest.api.v4.EchoNestAPI;
import com.echonest.api.v4.Params;
import com.google.common.base.Optional;
import com.lnunno.musicutils.echonest.artist.ArtistBucket;
import com.lnunno.musicutils.http.HttpUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Lucas on 1/17/2015.
 */
public class EchoNestUtils {

    // Can't initialize.
    private EchoNestUtils() {
    }

    public static final String BUCKET = "bucket";

    public static final String BASE_URL = "http://developer.echonest.com/api/v4";
    public static final String ARTIST_SUFFIX = "artist/profile";
    public static final String BASE_ARTIST_URL;

    private static boolean TRACE = false;

    /**
     * Echo Nest API access point.
     */
    public static final EchoNestAPI EN;

    static {
        EN = new EchoNestAPI(Secret.API_KEY);
        EN.setTraceSends(TRACE);
        EN.setTraceRecvs(TRACE);
    }

    /**
     * @param bucketList
     * @return
     * @deprecated Use the Echo Nest API instead.
     */
    public static String makeBucketParamStr(List<ArtistBucket> bucketList) {
        List<String> paramStrs = new ArrayList<>(bucketList.size());
        for (ArtistBucket artistBucket : bucketList) {
            paramStrs.add("bucket=" + artistBucket.getName());
        }
        return HttpUtils.PARAM_STRING_JOINER.join(paramStrs);
    }

    static {
        BASE_ARTIST_URL = HttpUtils.URL_JOINER.join(BASE_URL, ARTIST_SUFFIX);
    }

    /**
     * @param optionalParamMap
     * @param artistBuckets
     * @return
     * @deprecated Use the Echo Nest API instead.
     */
    public static String artistQuery(
            Optional<Map<String, String>> optionalParamMap,
            Optional<List<ArtistBucket>> artistBuckets) {
        if (artistBuckets.isPresent()) {
            String artistBucketParamStr = makeBucketParamStr(artistBuckets.get());
            return HttpUtils.request(BASE_ARTIST_URL,
                    optionalParamMap,
                    Optional.of(artistBucketParamStr)
            );
        } else {
            return HttpUtils.request(BASE_ARTIST_URL,
                    optionalParamMap,
                    Optional.<String>absent());
        }
    }

}
