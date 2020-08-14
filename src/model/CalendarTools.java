package model;

import com.atc.momo.Jiwaii.servlets.Connexion;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

enum DayOfWeek{Lundi,Mardi,Mercredi,Jeudi,Vendredi,Samedi,Dimanche};

public class CalendarTools {
    final static Logger logger           = Logger.getLogger( CalendarTools.class );

    public static List<List> getAWeek() {
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        calendar.set(year,month,1);
        int FirstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        List<List> Lst_Semaines = new ArrayList<List>();
        List<String> Lst_Jours;

        for (int iSemaine = 0;iSemaine<6;iSemaine++){
            Lst_Jours= new ArrayList<String>();
            //Lst_Jours.clear();
            for (int iJourDeLaSemaine=1;iJourDeLaSemaine<=7;iJourDeLaSemaine++){

                int JourSurLaSemaine= (iSemaine * 7)+(iJourDeLaSemaine-FirstDayOfWeek+2); // int JourSurLaSemaine= (iSemaine * 7)+(iJourDeLaSemaine-FirstDayOfWeek+1); 20:55
                if (JourSurLaSemaine > getMaxDaysInActualyMonth() || JourSurLaSemaine < 1)
                {
                    //Other month
                        Lst_Jours.add("--");
                        logger.log(Level.INFO,"date: --");
                }
                else
                {
                    Lst_Jours.add(String.valueOf(JourSurLaSemaine));
                    //<td title="@JourCalendrier/@month/@year">@(JourCalendrier)</td>
                    logger.log(Level.INFO,"date: "+JourSurLaSemaine);
                }
            }
            Lst_Semaines.add(Lst_Jours);
        }
        logger.log(Level.INFO,"VOIR LISTE :  "+Lst_Semaines);
    return Lst_Semaines;
    }

    public static int getMaxDaysInActualyMonth(){
        /*
        Month/Mois commence a partir de 0 (Zéro) ex: Janvier = 1;

         */
        Calendar myCalendar = Calendar.getInstance();
        return myCalendar.getActualMaximum(myCalendar.DAY_OF_MONTH);
    }

//    public static int getNbJours(String pDateDebut, String pDateFin){
//        int nbJoursPris =0 ;
//        SimpleDateFormat FormatDateDebut = new SimpleDateFormat("yyyy-MM-dd");
//        Date  dateDebut = null,
//                dateFin = null;
//        Calendar calendardateDebut = Calendar.getInstance(),
//                calendardateFin= Calendar.getInstance();
//        try {
//            dateDebut = FormatDateDebut.parse(pDateDebut);
//            dateFin = FormatDateDebut.parse(pDateFin);
//            calendardateDebut.setTime(dateDebut);
//            calendardateFin.setTime(dateFin);
//
//        } catch (ParseException e) {
//            e.getMessage();
//        }
//        while (dateDebut != dateFin){
//
//        }
//
//
//        return  nbJoursPris;
//    }

    public static int getNbJours(String pDateDebut, String pDateFin){
        int joursPris = 0;
        LocalDate dateDebut = LocalDate.parse(pDateDebut);
        LocalDate dateFin = LocalDate.parse(pDateFin);
        while(dateDebut.isBefore(dateFin.plusDays(1))){
            if (dateDebut.getDayOfWeek().getValue() != 6 && dateDebut.getDayOfWeek().getValue() != 7){
                joursPris ++;
            }
            dateDebut = dateDebut.plusDays(1);
        }

        return joursPris;
    }

    public static List<LocalDate> getListOfBetwenDates(LocalDate startDate,LocalDate endDate){
        List<LocalDate> lst_localDate = new ArrayList<LocalDate>();
        LocalDate localDateItem = startDate;
        while (localDateItem.isBefore(endDate.plusDays(1))){
            lst_localDate.add(localDateItem);
            localDateItem = localDateItem.plusDays(1);
        }
        return lst_localDate;
    }


}
