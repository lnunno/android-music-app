package com.lnunno.musicutils.echonest;

import com.echonest.api.v4.Artist;
import com.echonest.api.v4.ArtistParams;
import com.echonest.api.v4.EchoNestException;

import java.util.List;

import static com.lnunno.musicutils.echonest.EchoNestUtils.EN;

/**
 * Created by Lucas on 1/19/2015.
 */
public class EchoNestExamples {

    public static void runArtistExample() throws EchoNestException {
        ArtistParams artistParams = new ArtistParams();
        artistParams.addName("snakadaktal");

        List<Artist> results = EN.searchArtists(artistParams);
        for(Artist artist : results){
            System.out.println(artist);
        }
    }

    public static void main(String[] args) throws EchoNestException {
        runArtistExample();
    }

}
