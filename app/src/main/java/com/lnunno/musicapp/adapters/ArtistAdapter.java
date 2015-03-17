package com.lnunno.musicapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.echonest.api.v4.Artist;
import com.lnunno.musicapp.EchoNestUtils;
import com.lnunno.musicapp.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Lucas on 3/14/2015.
 */
public class ArtistAdapter extends TrackerAdapter<Artist> {

    private ArrayList<View> artistViews = new ArrayList<>();

    public ArtistAdapter(Context context) {
        super(context, R.layout.artist_list_layout, R.id.label);
    }

    public ArtistAdapter(Context context, List<Artist> artists) {
        super(context, R.layout.artist_list_layout, R.id.label, artists);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Context context = getContext();
        List<Artist> artists = getData();
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (position < artistViews.size() && artistViews.get(position) != null) {
            return artistViews.get(position);
        }
        View artistListView = inflater.inflate(R.layout.artist_list_layout, parent, false);
        if (artists.size() == 0) {
            return artistListView;
        }
        TextView textView = (TextView) artistListView.findViewById(R.id.label);
        ImageView imageView = (ImageView) artistListView.findViewById(R.id.icon);
        Artist artist = artists.get(position);
        String artistName = EchoNestUtils.safeGetName(artist);
        EchoNestUtils.setArtistImageView(artist, imageView);
        textView.setText(artistName);
        artistViews.add(position, artistListView);
        return artistListView;
    }
}
