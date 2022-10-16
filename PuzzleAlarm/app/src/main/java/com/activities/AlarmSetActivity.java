package com.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.puzzlealarm.R;
import com.fragments.AlarmClockFragment;
import com.fragments.PuzzleDifficultyFragment;

public class AlarmSetActivity extends AppCompatActivity {

    private static final int currentApiVersion = Build.VERSION.SDK_INT;

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

//                case R.id.save:
//                    AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
//                    Calendar calendar = Calendar.getInstance();
//
//                    TimePicker timePicker = (TimePicker) view.findViewById(R.id.timepicker);
//
//                    int hour;
//                    int minute;
//                    if (currentApiVersion > Build.VERSION_CODES.LOLLIPOP_MR1){
//                        hour = timePicker.getHour();
//                        minute = timePicker.getMinute();
//                    }else{
//                        hour = timePicker.getCurrentHour();
//                        minute = timePicker.getCurrentMinute();
//                    }
//
//                    calendar.setTimeInMillis(System.currentTimeMillis());
//                    calendar.set(Calendar.HOUR_OF_DAY, hour);
//                    calendar.set(Calendar.MINUTE, minute);
//
//                    Toast.makeText(getApplicationContext(),"Set Timer", Toast.LENGTH_LONG).show();
//
//                    Intent intent = new Intent(getApplicationContext(), AlarmBroadcastReceiver.class);
//                    PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, intent, 0);
//                    alarmManager.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),pendingIntent);
//
//                    Toast.makeText(getApplicationContext(), "AlarmSet", Toast.LENGTH_LONG).show();

                case R.id.cancel:
                    finish();
                    break;
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

//        Button save_button = this.findViewById(R.id.save);
//        save_button.setOnClickListener(new ButtonClickListener());

        Button cancel_button = this.findViewById(R.id.cancel);
        cancel_button.setOnClickListener(new ButtonClickListener());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}