package com.lnunno.musicutils;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.lnunno.musicutils.echonest.EchoNestUtils;
import com.lnunno.musicutils.echonest.Secret;
import com.lnunno.musicutils.echonest.artist.ArtistBucket;
import com.lnunno.musicutils.http.HttpUtils;

import java.util.List;
import java.util.Map;

/**
 * Created by Lucas on 1/17/2015.
 */
public class Testing {

    public static void main(String[] args) {
        Map<String, String> params = ImmutableMap.of("api_key", Secret.API_KEY, "name", "minus+the+bear");
        System.out.println(HttpUtils.request(
                "http://developer.echonest.com/api/v4/artist/biographies",
                Optional.of(params)));

        List<ArtistBucket> artistBucketList = ImmutableList.of(ArtistBucket.BIOGRAPHIES, ArtistBucket.IMAGES, ArtistBucket.GENRE);
        System.out.println(EchoNestUtils.artistQuery(
                Optional.of(params),
                Optional.of(artistBucketList)
        ));
    }
}
