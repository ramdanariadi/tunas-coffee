package id.tunas.coffee;

import android.os.Bundle;
import android.widget.TextClock;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimeFormat;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        TextClock textClock = findViewById(R.id.textClock);
        textClock.setOnClickListener(view -> {
            MaterialTimePicker timePicker = new MaterialTimePicker.Builder()
                    .setTimeFormat(TimeFormat.CLOCK_24H)
                    .setTitleText("Chose Time")
                    .build();

            timePicker.show(getSupportFragmentManager(), "TIME_PICKER");
        });
    }
}
