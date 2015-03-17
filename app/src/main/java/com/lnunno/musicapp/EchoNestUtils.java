package com.lnunno.musicapp;

import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.ImageView;

import com.echonest.api.v4.Artist;
import com.echonest.api.v4.ArtistParams;
import com.echonest.api.v4.EchoNestException;
import com.echonest.api.v4.Image;
import com.google.common.base.Optional;
import com.lnunno.musicapp.tasks.DownloadImageTask;

import java.util.List;

import static com.lnunno.musicapp.Constants.EN;

/**
 * Created by Lucas on 3/14/2015.
 */
public class EchoNestUtils {

    public static final String ECHO_NEST_TAG = "EchoNest";

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
        params.includeImages();
        params.sortBy(ArtistParams.SORT_HOTTTNESSS, false);
        List<Artist> hot_artists = EN.searchArtists(params);
        return hot_artists;
    }

    public static String safeGetName(Artist artist) {
        String name = "NAME NOT FOUND";
        try {
            name = artist.getName();
        } catch (EchoNestException e) {
            Log.e(ECHO_NEST_TAG, e.getMessage());
        }
        return name;
    }

    /**
     * Sets the artist image view in a separate thread.
     *
     * @param artist
     * @param imageView
     */
    public static void setArtistImageView(Artist artist, ImageView imageView) {
        Optional<Image> imageOptional = getArtistDisplayImage(artist);
        if (!imageOptional.isPresent()) {
            return;
        }
        Image image = imageOptional.get();
        DownloadImageTask downloadImageTask = new DownloadImageTask(imageView);
        BitmapFactory.Options downloadOptions = new BitmapFactory.Options();
        downloadOptions.inSampleSize = 4; // Reduce memory usage for downloading the images.
        downloadImageTask.setBitmapOptions(downloadOptions);
        downloadImageTask.execute(image.getURL());
    }

    public static Optional<Image> getArtistDisplayImage(Artist artist) {
        try {
            List<com.echonest.api.v4.Image> imageList = artist.getImages();
            if (imageList.size() == 0) {
                // No images for artist.
                return Optional.absent();
            }
            return Optional.of(imageList.get(0));
        } catch (EchoNestException e) {
            Log.e(ECHO_NEST_TAG, e.getMessage());
            return Optional.absent();
        }
    }

}
