package com.vincent.hoangnguyen.FragmentExample1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;


public class SimpleFragment extends Fragment {
    private static final int YES = 0;
    private static final int NO = 1;

    public SimpleFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_simple,container,false);
        final RadioGroup radioGroup = rootView.findViewById(R.id.radio_group);
        // TODO: set the radio onCheckedChanged listener
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                View radioButton = radioGroup.findViewById(checkedId);
                int index = radioGroup.indexOfChild(radioButton);
                TextView textView = rootView.findViewById(R.id.fragment_header);
                switch (index){
                    case YES:
                        textView.setText(R.string.yes_message);
                        break;
                    case NO:
                        textView.setText(R.string.no_message);
                        break;
                    default:
                        break;
                }
            }
        });

        final RatingBar ratingBar = rootView.findViewById(R.id.rating);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                float rating_number = ratingBar.getRating();
                String message = "My Rating: " + Float.toString(rating_number);
              Toast.makeText(getContext(),message,Toast.LENGTH_SHORT).show();
            }
        });

        // return the view for the fragment's UI
        return rootView;
    }
}