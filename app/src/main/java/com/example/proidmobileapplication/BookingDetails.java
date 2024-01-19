package com.example.proidmobileapplication;

import static androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM;
import static androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class BookingDetails extends AppCompatActivity {

    private TextView textView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_details);

        textView = findViewById(R.id.text);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openDatePicker(); // Open date picker dialog

                openTimePicker(); //Open time picker dialog
            }
        });

        configureConfirmButton();
    }

    private void openDatePicker(){
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, R.style.DialogTheme , new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                //Showing the picked value in the textView
                textView.setText(String.valueOf(year)+ "."+String.valueOf(month)+ "."+String.valueOf(day));

            }
        }, 2023, 01, 20);

        datePickerDialog.show();
    }

    private void openTimePicker(){

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, R.style.DialogTheme, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hour, int minute) {


                //Showing the picked value in the textView
                textView.setText(String.valueOf(hour)+ ":"+String.valueOf(minute));

            }
        }, 15, 30, false);

        timePickerDialog.show();
    }

    private void configureConfirmButton() {
        Button bookingButton = (Button) findViewById(R.id.confirmButton);
        bookingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(BookingDetails.this, "Booking Successful!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(BookingDetails.this, Landing.class));
            }
        });
    }

}