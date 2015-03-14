package com.lnunno.musicapp.components;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.echonest.api.v4.Artist;
import com.lnunno.musicapp.R;

import java.util.List;

/**
 * Created by Lucas on 3/14/2015.
 */
public class ArtistAdapter extends ArrayAdapter<Artist> {

    public ArtistAdapter(Context context, List<Artist> artists) {
        super(context, R.layout.artist_list_layout, artists);
    }
}
