package com.lnunno.musicapp.tasks;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.InputStream;

/**
 * @see: http://stackoverflow.com/questions/2471935/how-to-load-an-imageview-by-url-in-android
 * Created by Lucas on 3/17/2015.
 */
public class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
    private ImageView imageView;
    private BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();

    public void setBitmapOptions(BitmapFactory.Options bitmapOptions) {
        this.bitmapOptions = bitmapOptions;
    }

    public DownloadImageTask(ImageView imageView) {
        this.imageView = imageView;
    }

    protected Bitmap doInBackground(String... urls) {
        String url = urls[0];
        Bitmap mIcon11 = null;
        try {
            InputStream in = new java.net.URL(url).openStream();
            mIcon11 = BitmapFactory.decodeStream(in, null, bitmapOptions);
        } catch (Exception e) {
            Log.e("IMAGE", e.getMessage());
            e.printStackTrace();
        }
        return mIcon11;
    }

    protected void onPostExecute(Bitmap result) {
        imageView.setImageBitmap(result);
    }
}
