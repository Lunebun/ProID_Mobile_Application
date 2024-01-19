package com.example.proidmobileapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Landing extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        configureBookButton();
    }

    private void configureBookButton() {
        Button bookingButton = (Button) findViewById(R.id.bookingButton);
        bookingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Landing.this, BookingDetails.class));
            }
        });
    }
}

