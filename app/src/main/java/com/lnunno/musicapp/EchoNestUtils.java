package com.lnunno.musicapp;

import com.echonest.api.v4.Artist;
import com.echonest.api.v4.ArtistParams;
import com.echonest.api.v4.EchoNestException;

import java.util.List;

import static com.lnunno.musicapp.Constants.EN; // We want direct access to the API.

/**
 * Created by Lucas on 3/14/2015.
 */
public class EchoNestUtils {

    private EchoNestUtils() {
    }

    /**
     * @param numResults The number of Artists to return.
     * @return A list of the hotttessst artists descending.
     * @throws EchoNestException
     */
    public static List<Artist> getHotArtists(int numResults) throws EchoNestException {
        ArtistParams params = new ArtistParams();
        params.setResults(numResults);
        params.sortBy(ArtistParams.SORT_HOTTTNESSS, false);
        List<Artist> hot_artists = EN.searchArtists(params);
        return hot_artists;
    }

}