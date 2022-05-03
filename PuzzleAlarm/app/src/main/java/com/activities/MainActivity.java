package com.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.puzzlealarm.R;

public class MainActivity extends AppCompatActivity {

    private ListView listview;
    public static final String EXTRA_DATA
            = "com.activities";
    private static final int REQUEST_CODE = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private class ButtonClickListener implements View.OnClickListener{
        // tap the button
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplication(), AlarmSetActivity.class);
            switch(view.getId()){
                case R.id.to_alarm_clock_fragment_button:
                    intent.putExtra(EXTRA_DATA,R.id.to_alarm_clock_fragment_button);
                    break;
                case R.id.to_puzzle_difficulty_fragment_button:
                    intent.putExtra(EXTRA_DATA,R.id.to_puzzle_difficulty_fragment_button);
                    break;
            }

//            startActivity(intent);
            startActivityForResult(intent, REQUEST_CODE);

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