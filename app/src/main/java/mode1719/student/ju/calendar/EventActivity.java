package mode1719.student.ju.calendar;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class EventActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        Intent intent = getIntent();
        int titleName = intent.getIntExtra("EventIndex",-1);

        TextView displayName = (TextView) findViewById(R.id.eventTitle);
        displayName.setText(Data.eventItem.get(titleName).toString());
    }
}
