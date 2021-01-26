package org.fundacionjala.core.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/**
 * [RH] Date helper
 */
public class DateHelper {

    private static Date actualDate;
    private Map<String, String> dates;
    private static DateFormat calendarDay;
    private Calendar calendar;

    public DateHelper() {
        actualDate = new Date();
        calendar =  Calendar.getInstance();
        calendarDay = new SimpleDateFormat("dd/MM/yyyy");
        setMapDates();
    }

    /**
     * [RH] returns the date.
     * @param date
     * @return date
     */
    public String getDate(final String date) {
        return dates.get(date);
    }

    /**
     * set days in the map.
     */
    private void setMapDates(){
        setCalendar("TODAY", 0);
        setCalendar("YESTERDAY", -1);
        setCalendar("TOMORROW", 1);
        setCalendar("2 DAYS AGO", -2);
        setCalendar("2 DAYS FROM NOW", 2);
    }

    /**
     * add a new date in the map.
     * @param date
     * @param days
     */
    private void setCalendar(final String date, final int days) {
        calendar.setTime(actualDate);
        calendar.add(Calendar.DAY_OF_YEAR,days);
        dates.put(date, calendarDay.format(calendar.getTime()));
    }
}
