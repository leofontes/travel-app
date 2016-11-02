package me.leofontes.dsotravel.Adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

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

            TextView textViewCategory = (TextView) convertView.findViewById(R.id.textview_list_category);
            textViewCategory.setText(attractions.get(position).getCategory());

            TextView textViewDesc = (TextView) convertView.findViewById(R.id.textview_list_desc);
            textViewDesc.setText(attractions.get(position).getDescription());

            ImageView imageView = (ImageView) convertView.findViewById(R.id.imageview_list_attraction);
            Picasso.with(parent.getContext()).load(""+attractions.get(position).getPhoto()).into(imageView);
        }

        return convertView;
    }
}
