package com.lnunno.musicapp.tasks;

import android.os.AsyncTask;
import android.util.Log;

import com.echonest.api.v4.Artist;
import com.echonest.api.v4.ArtistParams;
import com.echonest.api.v4.EchoNestException;
import com.lnunno.musicapp.EchoNestUtils;
import com.lnunno.musicapp.components.ArtistAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lucas on 3/14/2015.
 */
public class RetrieveArtistsTask extends AsyncTask<ArtistParams, Integer, List<Artist>> {

    private ArtistAdapter artistAdapter;

    public RetrieveArtistsTask(ArtistAdapter adapter) {
        this.artistAdapter = adapter;
    }

    @Override
    protected List<Artist> doInBackground(ArtistParams... params) {
        try {
            return EchoNestUtils.getHotArtists(100);
        } catch (EchoNestException e) {
            Log.e("ARTIST", e.getMessage());
            e.printStackTrace();
            return new ArrayList<Artist>(); //TODO change.
        }
    }

    @Override
    protected void onPostExecute(List<Artist> result) {
        artistAdapter.clear();
        artistAdapter.addAll(result);
        artistAdapter.notifyDataSetChanged();
    }
}
