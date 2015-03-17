package com.lnunno.musicapp.adapters;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Keeps track of items in itself.
 * <p/>
 * Use getContext from ArrayAdapter to get the Context.
 * <p/>
 * Created by Lucas on 3/17/2015.
 */
public class TrackerAdapter<T> extends ArrayAdapter<T> {

    private Context context;
    private List<T> list = new ArrayList<>();

    public TrackerAdapter(Context context, int resource) {
        super(context, resource);
    }

    public TrackerAdapter(Context context, int resource, int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }

    public TrackerAdapter(Context context, int resource, int textViewResourceId, List<T> objects) {
        super(context, resource, textViewResourceId);
        this.list = objects;
    }

    public TrackerAdapter(Context context, int resource, List<T> objects) {
        super(context, resource, objects);
        this.list = objects;
    }

    @Override
    public void addAll(Collection<? extends T> collection) {
        super.addAll(collection);
        list.addAll(collection);
    }

    @Override
    public void clear() {
        super.clear();
        list.clear();
    }

    public List<T> getData() {
        return list;
    }
}
