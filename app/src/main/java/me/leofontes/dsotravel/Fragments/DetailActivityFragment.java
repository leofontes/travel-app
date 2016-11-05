package me.leofontes.dsotravel.Fragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import me.leofontes.dsotravel.MainActivity;
import me.leofontes.dsotravel.Models.Attraction;
import me.leofontes.dsotravel.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetailActivityFragment extends Fragment {
    protected Attraction attraction;
    protected SharedPreferences myPrefs;
    protected SharedPreferences.Editor peditor;
    protected Boolean favorite;
    protected Button mButtonFavorite;

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
                attraction = ListFragment.attractions.get(position);
            } else if(intent.getStringExtra("origin").equals("favoritelist")) {

            }
        }

        myPrefs = PreferenceManager.getDefaultSharedPreferences(getContext());
        peditor = myPrefs.edit();

        favorite = checkFavorites(attraction.getId());

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
        // Set up map button
        Button buttonMap = (Button) rootview.findViewById(R.id.button_detail_map);
        buttonMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse("geo:" + attraction.getLatitude() + "," + attraction.getLongitude() + "?q=" + attraction.getName());
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });

        // Set up favorite button
        mButtonFavorite = (Button) rootview.findViewById(R.id.button_detail_favorite);
        configButton(favorite);

        mButtonFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(favorite) {
                    peditor.putString(saveFavorite(attraction.getId()), "false");
                    peditor.commit();
                    favorite = !favorite;
                    configButton(favorite);

                    Toast.makeText(getActivity(), attraction.getName() + " removido dos favoritos.", Toast.LENGTH_SHORT).show();
                } else {
                    peditor.putString(saveFavorite(attraction.getId()), "true");
                    peditor.commit();
                    favorite = !favorite;
                    configButton(favorite);

                    Toast.makeText(getActivity(), attraction.getName() + " adicionado aos favoritos.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return rootview;
    }

    private void configButton(Boolean bol) {
        if(bol) {
            mButtonFavorite.setText(getString(R.string.detail_button_unfavorite));
            mButtonFavorite.setBackgroundColor(getResources().getColor(R.color.defaultRed));
        } else {
            mButtonFavorite.setText(getString(R.string.detail_button_favorite));
            mButtonFavorite.setBackgroundColor(getResources().getColor(R.color.defaultLightBlue));
        }
    }

    private String saveFavorite(int id) {
        switch (id) {
            case 0:
                return getString(R.string.fav_koxixos);
            case 1:
                return getString(R.string.fav_ostradamus);
            case 2:
                return getString(R.string.fav_may);
            case 3:
                return getString(R.string.fav_guacamole);
            case 4:
                return getString(R.string.fav_me);
            case 5:
                return getString(R.string.fav_sanduicheria);
            case 6:
                return getString(R.string.fav_wamaki);
            case 7:
                return getString(R.string.fav_didge);
            case 8:
                return getString(R.string.fav_bits);
            case 9:
                return getString(R.string.fav_toro);
            default:
                return "false";
        }
    }

    public boolean checkFavorites(int i) {
        switch(i) {
            case 0:
                return myPrefs.getString(getString(R.string.fav_koxixos), "false").equals("true");
            case 1:
                return myPrefs.getString(getString(R.string.fav_ostradamus), "false").equals("true");
            case 2:
                return myPrefs.getString(getString(R.string.fav_may), "false").equals("true");
            case 3:
                return myPrefs.getString(getString(R.string.fav_guacamole), "false").equals("true");
            case 4:
                return myPrefs.getString(getString(R.string.fav_me), "false").equals("true");
            case 5:
                return myPrefs.getString(getString(R.string.fav_sanduicheria), "false").equals("true");
            case 6:
                return myPrefs.getString(getString(R.string.fav_wamaki), "false").equals("true");
            case 7:
                return myPrefs.getString(getString(R.string.fav_didge), "false").equals("true");
            case 8:
                return myPrefs.getString(getString(R.string.fav_bits), "false").equals("true");
            case 9:
                return myPrefs.getString(getString(R.string.fav_toro), "false").equals("true");
            default:
                return true;
        }
    }


}
