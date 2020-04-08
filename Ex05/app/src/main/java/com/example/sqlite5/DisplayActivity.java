package com.example.sqlite5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    TextView details_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        details_text = findViewById(R.id.details);

        Bundle extras = getIntent().getExtras();
        String details = extras.getString("det");
        details_text.setText(details);
    }
}
