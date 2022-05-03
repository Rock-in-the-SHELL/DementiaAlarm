package com.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.puzzlealarm.R;
import com.fragments.AlarmClockFragment;
import com.fragments.PuzzleDifficultyFragment;

import java.util.List;

public class AlarmSetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_set);
        Intent intentMain = getIntent();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        int buttonCode = intentMain.getIntExtra(MainActivity.EXTRA_DATA,R.id.to_alarm_clock_fragment_button);
        switch(buttonCode){
            case R.id.to_alarm_clock_fragment_button:
                fragmentTransaction.replace(R.id.container, AlarmClockFragment.class,null)
                        .commit();
                break;
            case R.id.to_puzzle_difficulty_fragment_button:
                fragmentTransaction.replace(R.id.container, PuzzleDifficultyFragment.class,null)
                        .commit();
                break;
        }
    }

        private class ButtonClickListener implements View.OnClickListener{
        // tap the button
        @Override
        public void onClick(View view) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            switch(view.getId()){
                case R.id.save:
//                    List<Fragment> fragmentList = fragmentManager.getFragments();

//                    fragmentTransaction.replace(R.id.container,AlarmClockFragment.class,null)
//                            .commit();
                    break;

                case R.id.cancel:
                    finish();
                    break;
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Button to_alarm_clock_button = this.findViewById(R.id.save);
        to_alarm_clock_button.setOnClickListener(new ButtonClickListener());

        Button to_puzzle_difficulty_button = this.findViewById(R.id.cancel);
        to_puzzle_difficulty_button.setOnClickListener(new ButtonClickListener());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}