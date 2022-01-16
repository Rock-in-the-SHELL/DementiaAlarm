package com.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.puzzlealarm.R;

/**
 * A fragment representing a list of Items.
 */
public class MainButtonFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public MainButtonFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static MainButtonFragment newInstance(int columnCount) {
        MainButtonFragment fragment = new MainButtonFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main_button, container, false);

        Button to_alarm_clock_button = view.findViewById(R.id.to_alarm_clock_fragment_button);
        Button to_puzzle_difficulty_button = view.findViewById(R.id.to_puzzle_difficulty_fragment_button);
        Button to_play_puzzle_button = view.findViewById(R.id.to_play_puzzle_fragment_button);

        to_alarm_clock_button.setOnClickListener(new ButtonClickListener());
        to_puzzle_difficulty_button.setOnClickListener(new ButtonClickListener());
        to_play_puzzle_button.setOnClickListener(new ButtonClickListener());

        return view;
    }

    // when push button
    private class ButtonClickListener implements View.OnClickListener{

        // Declare the method onClick
        @Override
        public void onClick(View view) {
            FragmentManager fragmentManager = getChildFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            switch (view.getId()){
                case R.id.to_alarm_clock_fragment_button:
                    fragmentTransaction.add(R.id.fragment_alarm_clock, AlarmClockFragment.newInstance("from main", "to alarm clock"));
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
            }
        }
    }
}