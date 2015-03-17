package com.lnunno.musicapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lnunno.musicapp.R;
import com.lnunno.musicapp.views.DrawerElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lucas on 3/14/2015.
 */
public class DrawerAdapter extends TrackerAdapter<DrawerElement> {

    private ArrayList<View> viewList = new ArrayList<>();

    public DrawerAdapter(Context context) {
        super(context, R.layout.drawer_element, R.id.drawer_item_text);
    }

    public DrawerAdapter(Context context, List<DrawerElement> elementList) {
        super(context, R.layout.drawer_element, R.id.drawer_item_text, elementList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Context context = getContext();
        List<DrawerElement> list = getData();
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (position < viewList.size() && viewList.get(position) != null) {
            return viewList.get(position);
        }
        View listView = inflater.inflate(R.layout.drawer_element, parent, false);
        if (list.size() == 0) {
            return listView;
        }
        TextView textView = (TextView) listView.findViewById(R.id.drawer_item_text);
        ImageView imageView = (ImageView) listView.findViewById(R.id.drawer_item_icon);
        DrawerElement drawerElement = list.get(position);
        String artistName = drawerElement.getText();
        textView.setText(artistName);
        viewList.add(position, listView);
        return listView;
    }
}
