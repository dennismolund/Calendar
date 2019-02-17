package mode1719.student.ju.calendar;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.timessquare.CalendarPickerView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Date currentday = new Date();
        Calendar nextYear = Calendar.getInstance();
        nextYear.add(Calendar.YEAR, 3);

        CalendarPickerView datePicker = findViewById(R.id.calendarView);
        datePicker.init(currentday, nextYear.getTime()).withSelectedDate(currentday);


        ArrayList<Date> dateList = new ArrayList<>();
        for (int x = 0; x < Data.eventItem.size(); x++){

            Date dayX = new Date();
            String eventDay = Data.eventItem.get(x).date;

            if(dayX.toString().equals(eventDay)){
                dateList.add(dayX);
            }

        }
        datePicker.highlightDates(dateList);



        datePicker.setOnDateSelectedListener(new CalendarPickerView.OnDateSelectedListener() {
            @Override
            public void onDateSelected(Date date) {
                Intent intent = new Intent(MainActivity.this, DateEventActivity.class);
                intent.putExtra("date", date.toString());
                //date = Fri Feb 08 00:00:00 GMT+01:00 2019
                startActivity(intent);
            }

            @Override
            public void onDateUnselected(Date date) {

            }
        });
    }
}


