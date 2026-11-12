package com.example.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_COUNT = "com.example.activities.COUNT";
    private static final String STATE_COUNT = "count";

    private int count;
    private TextView textCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets bars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(bars.left, bars.top, bars.right, bars.bottom);
            return insets;
        });
        textCount = findViewById(R.id.textCount);
        if (savedInstanceState != null) {
            count = savedInstanceState.getInt(STATE_COUNT);
        }
        textCount.setText(String.valueOf(count));
    }
    public void countUp(View view) {
        count++;
        textCount.setText(String.valueOf(count));
    }
    public void goToActivity2(View view) {
        Intent intent = new Intent(this, HelloActivity.class);
        intent.putExtra(EXTRA_COUNT, count);
        startActivity(intent);
    }

    public void goToActivity3(View view) {
        Intent intent = new Intent(this, ThirdActivity.class);
        intent.putExtra(EXTRA_COUNT, count);
        startActivity(intent);
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(STATE_COUNT, count);
    }

}