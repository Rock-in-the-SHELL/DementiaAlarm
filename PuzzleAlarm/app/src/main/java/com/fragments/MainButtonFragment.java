package com.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
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

    OnClickListener _clicklistener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public MainButtonFragment() {
    }

    public interface OnClickListener {
        public void onClick(Fragment fragment);
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
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            _clicklistener = (OnClickListener) context;
        } catch(ClassCastException e){
            throw new ClassCastException(getActivity().toString() + "must implement OnArticleSelectedListener.");
        }
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
        to_alarm_clock_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _clicklistener.onClick(AlarmClockFragment.newInstance("from Main", "To AlarmClock"));
            }
        });

        Button to_puzzle_difficulty_button = view.findViewById(R.id.to_puzzle_difficulty_fragment_button);
        to_puzzle_difficulty_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _clicklistener.onClick(PuzzleDifficultyFragment.newInstance("from Main", "To PuzzleDifficulty"));
            }
        });
        return view;
    }

}