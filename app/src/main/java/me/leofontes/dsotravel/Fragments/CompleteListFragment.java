package me.leofontes.dsotravel.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import me.leofontes.dsotravel.Adapters.AttractionAdapter;
import me.leofontes.dsotravel.DetailActivity;
import me.leofontes.dsotravel.Models.Attraction;
import me.leofontes.dsotravel.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CompleteListFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CompleteListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CompleteListFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    public static ArrayList<Attraction> attractions;

    public CompleteListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CompleteListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CompleteListFragment newInstance(String param1, String param2) {
        CompleteListFragment fragment = new CompleteListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_complete_list, container, false);

        attractions = setupAttractions();

        ListView listView = (ListView) rootview.findViewById(R.id.listview_complete);
        AttractionAdapter adapter = new AttractionAdapter(attractions);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra("origin", "completelist");
                intent.putExtra("position", "" + position);
                startActivity(intent);
            }
        });

        return rootview;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    public ArrayList<Attraction> setupAttractions() {
        ArrayList<Attraction> attractions = new ArrayList<>();

        String[] names = getResources().getStringArray(R.array.arr_attraction_name);
        String[] categories = getResources().getStringArray(R.array.arr_attraction_category);
        String[] desc = getResources().getStringArray(R.array.arr_attraction_description);
        String[] photos = getResources().getStringArray(R.array.arr_attraction_picture);
        String[] couverts = getResources().getStringArray(R.array.arr_attraction_couvert);
        String[] latitudes = getResources().getStringArray(R.array.arr_latitudes);
        String[] longitudes = getResources().getStringArray(R.array.arr_longitudes);

        Attraction attraction;

        for(int i = 0; i < names.length; i++) {
            attraction = new Attraction(i, names[i], categories[i], desc[i], getSchedule(i), photos[i], Boolean.parseBoolean(couverts[i]), latitudes[i], longitudes[i]);
            attractions.add(attraction);
        }

        return attractions;
    }

    public String[] getSchedule(int id) {
        switch(id) {
            case 0:
                return getResources().getStringArray(R.array.arr_koxixos_hours);
            case 1:
                return getResources().getStringArray(R.array.arr_ostradamus_hours);
            case 2:
                return getResources().getStringArray(R.array.arr_may_hours);
            case 3:
                return getResources().getStringArray(R.array.arr_guacamole_hours);
            case 4:
                return getResources().getStringArray(R.array.arr_meuescritorio_hours);
            case 5:
                return getResources().getStringArray(R.array.arr_sanduicheria_hours);
            case 6:
                return getResources().getStringArray(R.array.arr_wamaki_hours);
            case 7:
                return getResources().getStringArray(R.array.arr_didge_hours);
            case 8:
                return getResources().getStringArray(R.array.arr_bits_hours);
            case 9:
                return getResources().getStringArray(R.array.arr_toro_hours);
            default:
                return null;
        }
    }
}
