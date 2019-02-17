package mode1719.student.ju.calendar;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class DateEventActivity extends AppCompatActivity {
    Dialog myDialog;
    String _eventTitle = "";
    String _eventTime = "";
    String _eventDescription ="";
    String _date = "";





    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_event);
        myDialog = new Dialog(this);
        Button addEventButton = findViewById(R.id.addEventButton);


        //get Data
        Bundle MainIntent = getIntent().getExtras();
        if (MainIntent != null){
            _date = MainIntent.getString("date");
        }
        System.out.println(_date);

        //Creating eventList for clicked day.
        ArrayList<Data.Events> dayList = new ArrayList<>();

        for(int i = 0; i < Data.eventItem.size();i++){
            if(_date.equals(Data.eventItem.get(i).date)){
                dayList.add(Data.eventItem.get(i));
            }
        }

        //Display list
        ListView EventList = (ListView) findViewById(R.id.eventList);
        EventList.setAdapter(new ArrayAdapter<Data.Events>(
                this, android.R.layout.simple_list_item_1, dayList));

        //Triggers when a list item is clicked.
        EventList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showPopup(DateEventActivity.this, position);

            }
        });

        //Show popup window where you enter info for new event.
        addEventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopup(DateEventActivity.this, -1);
            }
        });

        }

    //Display popupwindow with Editable text for our events. Create/delete functionality
    public void showPopup(DateEventActivity view, final int position){
        myDialog.setContentView(R.layout.activity_event_popup_window);
        myDialog.show();


        Button doneButton = myDialog.findViewById(R.id.doneButton);
        Button deleteButton = myDialog.findViewById(R.id.deleteButton);
        final EditText title = myDialog.findViewById(R.id.eventTitle);
        final EditText time = myDialog.findViewById(R.id.eventTime);
        final EditText description = myDialog.findViewById(R.id.eventDescription);


        if(position == -1){deleteButton.setVisibility(View.GONE);

        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _eventTitle = title.getText().toString();
                _eventTime = time.getText().toString();
                _eventDescription = description.getText().toString();
                addEvent();
                myDialog.dismiss();
            }
        });
        }
        else {
            title.setText(Data.eventItem.get(position).title);
            time.setText(Data.eventItem.get(position).time);
            description.setText(Data.eventItem.get(position).description);

            doneButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    _eventTitle = title.getText().toString();
                    _eventTime = time.getText().toString();
                    _eventDescription = description.getText().toString();
                    deleteEvent(position);
                    addEvent();
                    myDialog.dismiss();
                }
            });

            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    deleteEvent(position);
                    myDialog.dismiss();
                    onResume();
                }
            });


        }

    }

    @Override
    protected void onResume() {

        ArrayList<Data.Events> dayList = new ArrayList<>();

        for(int i = 0; i < Data.eventItem.size();i++){
            if(_date.equals(Data.eventItem.get(i).date)){
                dayList.add(Data.eventItem.get(i));
            }
        }

        ListView EventList = (ListView) findViewById(R.id.eventList);
        EventList.setAdapter(new ArrayAdapter<Data.Events>(
                this, android.R.layout.simple_list_item_1, dayList));

        super.onResume();
    }


    public void addEvent(){
        Data.eventItem.add(new Data.Events(_date, _eventTitle, _eventTime, _eventDescription));
    }

    public void deleteEvent(int position){
        Data.eventItem.remove(position);
    }


}


