package model;

import org.eclipse.persistence.jpa.jpql.parser.DateTime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
enum DayOfWeek{Lundi,Mardi,Mercredi,Jeudi,Vendredi,Samedi,Dimanche};

public class CalendarTools {
    //public static List<Integer> getListOfCalendar(){
    //
    //}
    //public static List<List> getWeeks(){
    //
    //}
    public static void getAWeek() {
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        calendar.set(year,month,1);
        int FirstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);


    }



    public static int getMaxDaysInActualyMonth(){
        /*
        Month/Mois commence a partir de 0 (Zéro) ex: Janvier = 1;

         */
        Calendar myCalendar = Calendar.getInstance();
        return myCalendar.getActualMaximum(myCalendar.DAY_OF_MONTH);
    }


}
