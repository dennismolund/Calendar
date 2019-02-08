package mode1719.student.ju.calendar;


import java.util.ArrayList;

public class Data {

    public static ArrayList<Events> EventItem = new ArrayList<>();
    static {
        EventItem.add(new Events("Title A"));
        EventItem.add(new Events("Title B"));
        EventItem.add(new Events("Title C"));
    }

    public static class Events{
        public String title;
        public Events(String title){
            this.title = title;
        }
        @Override
        public String toString(){ return "Title: " + title;}
    }

}
