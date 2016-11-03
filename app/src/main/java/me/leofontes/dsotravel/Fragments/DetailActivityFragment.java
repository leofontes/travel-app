package me.leofontes.dsotravel.Fragments;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import me.leofontes.dsotravel.Models.Attraction;
import me.leofontes.dsotravel.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetailActivityFragment extends Fragment {
    Attraction attraction;

    public DetailActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_detail, container, false);

        Intent intent = getActivity().getIntent();
        if(intent != null) {
            int position;
            if(intent.getStringExtra("origin").equals("completelist")) {
                position = Integer.parseInt(intent.getStringExtra("position"));
                attraction = CompleteListFragment.attractions.get(position);
            } else if(intent.getStringExtra("origin").equals("favoritelist")) {

            }
        }

        // Set name
        TextView textViewName = (TextView) rootview.findViewById(R.id.textview_detail_name);
        textViewName.setText(attraction.getName());
        // Set image
        ImageView imageView = (ImageView) rootview.findViewById(R.id.imageview_detail);
        Picasso.with(getActivity()).load(attraction.getPhoto()).into(imageView);
        // Set category
        TextView textViewCategory = (TextView) rootview.findViewById(R.id.textview_detail_category);
        textViewCategory.setText(attraction.getCategory());
        // Set description
        TextView textViewDescription = (TextView) rootview.findViewById(R.id.textview_detail_desc);
        textViewDescription.setText(attraction.getDescription());
        // Set couvert
        TextView textViewCouvert = (TextView) rootview.findViewById(R.id.textview_detail_couvert);
        if(attraction.getCouvert()) {
            textViewCouvert.setText(getResources().getString(R.string.detail_couvert_yes));
        } else {
            textViewCouvert.setText(getResources().getString(R.string.detail_couvert_no));
        }
        // Set up hours
        SeekBar seekBar = (SeekBar) rootview.findViewById(R.id.seekBar);
        final TextView textViewWeekday = (TextView) rootview.findViewById(R.id.textview_detail_weekday);
        final TextView textViewHours = (TextView) rootview.findViewById(R.id.textview_detail_hours);
        textViewWeekday.setText(getResources().getStringArray(R.array.arr_weekdays)[0]);
        textViewHours.setText(attraction.getSchedule()[0]);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textViewWeekday.setText(getResources().getStringArray(R.array.arr_weekdays)[progress]);
                textViewHours.setText(attraction.getSchedule()[progress]);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        return rootview;
    }
}
