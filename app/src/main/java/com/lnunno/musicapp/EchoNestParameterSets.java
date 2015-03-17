package com.lnunno.musicapp;

import com.echonest.api.v4.ArtistParams;

/**
 * Sets of parameters for using Echo Nest.
 * <p/>
 * Includes Artist parameters.
 * <p/>
 * Created by Lucas on 3/17/2015.
 */
public class EchoNestParameterSets {

    private EchoNestParameterSets() {
    }

    public static ArtistParams hotArtistsParams(int numResults) {
        ArtistParams params = new ArtistParams();
        params.setResults(numResults);
        params.includeImages();
        params.sortBy(ArtistParams.SORT_HOTTTNESSS, false);
        return params;
    }

    public static ArtistParams artistNameParams(String name) {
        ArtistParams params = new ArtistParams();
        params.addName(name);
        return params;
    }
}
