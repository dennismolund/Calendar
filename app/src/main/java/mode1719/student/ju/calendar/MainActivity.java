package mode1719.student.ju.calendar;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.timessquare.CalendarPickerView;

import java.util.Calendar;
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



        datePicker.setOnDateSelectedListener(new CalendarPickerView.OnDateSelectedListener() {
            @Override
            public void onDateSelected(Date date) {
                Calendar calselected = Calendar.getInstance();
                calselected.setTime(date);
                String selectedDay = "" + calselected.get(Calendar.YEAR) + (calselected.get(Calendar.MONTH)+1) +
                        calselected.get(Calendar.DAY_OF_MONTH);

                Intent intent = new Intent(MainActivity.this, DateEventActivity.class);


                intent.putExtra("date", date.toString());
                System.out.println(selectedDay);
                //date = Fri Feb 08 00:00:00 GMT+01:00 2019
                startActivity(intent);
            }

            @Override
            public void onDateUnselected(Date date) {

            }
        });
    }
}
