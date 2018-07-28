package com.bb.policelightbar;

import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private ImageView frame1, frame2;
    private final Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setPointer();
    }

    private void setPointer() {
        frame1 = findViewById(R.id.frame1);
        frame2 = findViewById(R.id.frame2);
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (((ColorDrawable) frame1.getBackground()).getColor() ==
                        getResources().getColor(R.color.colorBlue)) {
                    frame1.setBackgroundColor(getResources().getColor(R.color.colorRed));
                    frame2.setBackgroundColor(getResources().getColor(R.color.colorBlue));
                } else {
                    frame1.setBackgroundColor(getResources().getColor(R.color.colorBlue));
                    frame2.setBackgroundColor(getResources().getColor(R.color.colorRed));
                }
                handler.postDelayed(this, 1000);
            }
        };
        ToggleButton toggleButton = findViewById(R.id.toggleButton);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    frame1.setBackgroundColor(getResources().getColor(R.color.colorBlue));
                    frame2.setBackgroundColor(getResources().getColor(R.color.colorRed));
                    MainActivity.this.runOnUiThread(runnable);
                } else {
                    handler.removeCallbacks(runnable);
                    frame1.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                    frame2.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                }
            }
        });
    }
}
