package com.lnunno.musicutils.echonest.artist;

import com.echonest.api.v4.Params;
import com.lnunno.musicutils.echonest.EchoNestUtils;

/**
 * Enum for artist bucket on echo nest.
 * <p/>
 * Created by Lucas on 1/18/2015.
 */
public enum ArtistBucket {
    BIOGRAPHIES("biographies"),
    BLOGS("blogs"),
    DISCOVERY("discovery"),
    DISCOVERY_RANK("discovery_rank"),
    DOC_COUNTS("doc_counts"),
    FAMILIARITY("familiarity"),
    FAMILIARITY_RANK("familiarity_rank"),
    GENRE("genre"),
    HOTTTNESSS("hotttnesss"),
    HOTTTNESSS_RANK("hotttnesss_rank"),
    IMAGES("images"),
    ARTIST_LOCATION("artist_location"),
    NEWS("news"),
    REVIEWS("reviews"),
    SONGS("songs"),
    TERMS("terms"),
    URLS("urls"),
    VIDEO("video"),
    YEARS_ACTIVE("years_active");

    private final String name;

    private ArtistBucket(String s) {
        name = s;
    }

    public String getName() {
        return name;
    }

    public void addAsParam(Params params) {
        params.add(EchoNestUtils.BUCKET, name);
    }
}
