package mode1719.student.ju.calendar;


import android.app.usage.UsageEvents;

import java.util.ArrayList;

public class Data {

    public static ArrayList<Events> eventItem = new ArrayList<>();
    static {
        eventItem.add(new Events("Sun Feb 17 00:00:00 GMT+01:00 2019","Frissör","11:00 - 11:30", "Johanna, rydgatan 23B"));
        eventItem.add(new Events("Mon Feb 18 00:00:00 GMT+01:00 2019","Arbete", "12:00 - 17:00", "Bar"));
        eventItem.add(new Events("Sat Feb 16 00:00:00 GMT+01:00 2019","Filmkväll", "21:00", "Fast and furious"));
    }

    public static class Events{
        public String date;
        public String title;
        public String description;
        public String time;


        public Events(String date, String title, String time , String description){
            this.date = date;
            this.title = title;
            this.description = description;
            this.time = time;
        }
        @Override
        public String toString(){ return "Title: " + title + "\n" + "Time: " + time + "\n" + "Description: " + description;}

    }



}
