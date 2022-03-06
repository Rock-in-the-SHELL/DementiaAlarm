package com.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.puzzlealarm.R;
import com.fragments.AlarmClockFragment;
import com.fragments.PuzzleDifficultyFragment;

public class MainActivity extends AppCompatActivity {

    private ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private class ButtonClickListener implements View.OnClickListener{
        // tap the button

        @Override
        public void onClick(View view) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.addToBackStack(null);
            switch(view.getId()){
                case R.id.to_alarm_clock_fragment_button:
                    fragmentTransaction.replace(R.id.container,AlarmClockFragment.class,null)
                            .commit();
                    break;

                case R.id.to_puzzle_difficulty_fragment_button:
                    fragmentTransaction.replace(R.id.container, PuzzleDifficultyFragment.class,null)
                            .commit();
                    break;
            }
        }
    }


    @Override
    protected void onStart() {
        super.onStart();
        Button to_alarm_clock_button = this.findViewById(R.id.to_alarm_clock_fragment_button);
        to_alarm_clock_button.setOnClickListener(new ButtonClickListener());

        Button to_puzzle_difficulty_button = this.findViewById(R.id.to_puzzle_difficulty_fragment_button);
        to_puzzle_difficulty_button.setOnClickListener(new ButtonClickListener());

    }
}