package com.example.alarm;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button start,startButton,cancelButton;
    EditText et_time;
    TimePicker alarmPicker;
    int hours,minutes,current_hour,current_minute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = findViewById(R.id.start);
        et_time = findViewById(R.id.time);
        alarmPicker = findViewById(R.id.timepicker);
        startButton = findViewById(R.id.startButton);
        cancelButton = findViewById(R.id.cancelButton);

        //alarmPicker.setIs24HourView(false);
        current_hour = alarmPicker.getCurrentHour();
        current_minute = alarmPicker.getCurrentMinute();

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alarmPicker.setVisibility(View.VISIBLE);
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alarmPicker.setVisibility(View.INVISIBLE);
            }
        });
        
        alarmPicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                Toast.makeText(MainActivity.this, "Current time : "+Integer.toString(hourOfDay)+":"+Integer.toString(minute), Toast.LENGTH_SHORT).show();
                hours = hourOfDay;
                minutes = minute;
            }
        });


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAlarm();
            }
        });
    }

    public void setAlarm(){
        //int t = Integer.parseInt(et_time.getText().toString());

        Intent intent = new Intent(MainActivity.this,MyBroadcastReceiver.class);
        PendingIntent pi = PendingIntent.getBroadcast(this.getApplicationContext(),1234,intent,0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        int alarm_hours = hours - current_hour;
        int alarm_minutes = minutes - current_minute;

        alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis() + alarm_minutes*(60*1000) + alarm_hours*(60*60*1000),pi);
        Toast.makeText(this, "Alarm set for " + alarm_hours + " hours : "+alarm_minutes+" minutes", Toast.LENGTH_SHORT).show();
    }
}
