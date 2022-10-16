package com.fragments;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import com.receivers.AlarmBroadcastReceiver;
import com.example.puzzlealarm.R;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AlarmClockFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AlarmClockFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final int currentApiVersion = Build.VERSION.SDK_INT;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private TimePicker timePicker;
    private AlarmClockFragmentListener alarmClockFragmentListener;


    public AlarmClockFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AlarmClockFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AlarmClockFragment newInstance(String param1, String param2) {
        AlarmClockFragment fragment = new AlarmClockFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public interface AlarmClockFragmentListener {
        void onCLickSave(String value);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof AlarmClockFragmentListener){
            alarmClockFragmentListener = (AlarmClockFragmentListener) context;
        }
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
        View view = inflater.inflate(R.layout.fragment_alarm_clock, container, false);

        // Get TimePicker View
        timePicker = (TimePicker) view.findViewById(R.id.timepicker);

        return view;
//        return inflater.inflate(R.layout.fragment_alarm_clock, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        Button save_button = (Button) getActivity().findViewById(R.id.save);
        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int hour;
                int minute;
                if (currentApiVersion > Build.VERSION_CODES.LOLLIPOP_MR1){
                    hour = timePicker.getHour();
                    minute = timePicker.getMinute();
                }else{
                    hour = timePicker.getCurrentHour();
                    minute = timePicker.getCurrentMinute();
                }

                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(System.currentTimeMillis());
                calendar.set(Calendar.HOUR_OF_DAY, hour);
                calendar.set(Calendar.MINUTE, minute);

                Toast.makeText(getContext(),"Set Timer", Toast.LENGTH_LONG).show();

                AlarmManager alarmManager = (AlarmManager) getActivity().getSystemService(Context.ALARM_SERVICE);
                Intent intent = new Intent(getContext(), AlarmBroadcastReceiver.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(getContext(), 0, intent, 0);
                alarmManager.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),pendingIntent);

                Toast.makeText(getContext(), "AlarmSet", Toast.LENGTH_LONG).show();
            }
        });
    }



}