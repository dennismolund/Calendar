package mode1719.student.ju.calendar;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DateEventActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_event);

        ListView EventList = (ListView) findViewById(R.id.eventList);
        EventList.setAdapter(new ArrayAdapter<Data.Events>(
                this, android.R.layout.simple_list_item_1, Data.eventItem));

        EventList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Data.Events clickedEvent = Data.eventItem.get(position);
                System.out.println(clickedEvent);
                Intent intent = new Intent(DateEventActivity.this, EventActivity.class);
                intent.putExtra("EventIndex", position);
                startActivity(intent);
            }
        });

        }
}

