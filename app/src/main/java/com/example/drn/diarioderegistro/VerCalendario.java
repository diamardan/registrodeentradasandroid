package com.example.drn.diarioderegistro;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.Toast;

public class VerCalendario extends AppCompatActivity {
    CalendarView calendario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_calendario);

        calendario = (CalendarView)findViewById(R.id.cvRegistros);
        calendario.setFirstDayOfWeek(2);
        calendario.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth){

            }
        });

    }
}
