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

public class ThirdActivity extends AppCompatActivity {
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_third);

        View root = findViewById(R.id.thirdLayout);
        ViewCompat.setOnApplyWindowInsetsListener(root, (view, insets) -> {
            Insets bars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            view.setPadding(bars.left, bars.top, bars.right, bars.bottom);
            return insets;
        });

        count = getIntent().getIntExtra(MainActivity.EXTRA_COUNT, 0);
        TextView textCount = findViewById(R.id.textCount);
        textCount.setText(String.valueOf(count));

        View layout = findViewById(R.id.thirdLayout);
        if (layout != null) {
            layout.setOnTouchListener(new OnSwipeTouchListener(this) {
                @Override
                public void onSwipeLeft() {
                    goToActivity1();
                }

                @Override
                public void onSwipeRight() {
                    goToActivity2();
                }
            });
        }
    }

    public void goToActivity1(View view) {
        goToActivity1();
    }

    public void goToActivity2(View view) {
        goToActivity2();
    }

    private void goToActivity1() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }

    private void goToActivity2() {
        Intent intent = new Intent(this, HelloActivity.class);
        intent.putExtra(MainActivity.EXTRA_COUNT, count);
        startActivity(intent);
        finish();
    }
}
