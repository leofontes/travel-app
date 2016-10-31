package me.leofontes.dsotravel.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import me.leofontes.dsotravel.Models.Attraction;
import me.leofontes.dsotravel.R;

/**
 * Created by Leo on 10/31/16.
 */

public class AttractionAdapter extends BaseAdapter {
    protected ArrayList<Attraction> attractions;

    public AttractionAdapter(ArrayList<Attraction> attractions) {
        this.attractions = attractions;
    }

    @Override
    public int getCount() {
        return attractions.size();
    }

    @Override
    public Object getItem(int position) {
        return attractions.get(position);
    }

    @Override
    public long getItemId(int position) {
        return attractions.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_attraction, parent, false);

        if(convertView != null) {
            TextView textViewName = (TextView) convertView.findViewById(R.id.textview_list_name);
            textViewName.setText(attractions.get(position).getName());
        }

        return convertView;
    }
}
