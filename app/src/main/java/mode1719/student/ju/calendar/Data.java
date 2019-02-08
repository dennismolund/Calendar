package mode1719.student.ju.calendar;


import java.util.ArrayList;

public class Data {

    public static ArrayList<Events> eventItem = new ArrayList<>();
    static {
        eventItem.add(new Events("Title A"));
        eventItem.add(new Events("Title B"));
        eventItem.add(new Events("Title C"));
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
