package org.fundacionjala.core.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * [RH] Date helper.
 */
public class DateHelper {

    private static Date actualDate;
    private Map<String, String> dates;
    private static DateFormat calendarDay;
    private static DateFormat day;
    private static DateFormat hour;
    private Calendar calendar;
    private static final int DOS = -2;

    /**
     * Constructor.
     */
    public DateHelper() {
        actualDate = new Date();
        calendar =  Calendar.getInstance();
        calendarDay = new SimpleDateFormat("dd/MM/yyyy");
        day = new SimpleDateFormat("dd/MM/yyyy");
        hour = new SimpleDateFormat("HH:mm");
        dates = new HashMap();
        setMapDates();
    }

    /**
     * [RH] returns the date.
     * @param date
     * @return date
     */
    public String getDate(final String date) {
        return removeZeros(dates.get(date));
    }

    /**
     * set days in the map.
     */
    private void setMapDates() {
        setCalendar("TODAY", 0);
        setCalendar("YESTERDAY", -1);
        setCalendar("TOMORROW", 1);
        setCalendar("2 DAYS AGO", DOS);
        setCalendar("2 DAYS FROM NOW", 2);
    }

    /**
     * [RH] add a new date in the map.
     * @param date
     * @param days
     */
    private void setCalendar(final String date, final int days) {
        calendar.setTime(actualDate);
        calendar.add(Calendar.DAY_OF_YEAR, days);
        dates.put(date, calendarDay.format(calendar.getTime()));
    }

    /**
     * [RH] This method returns the actual date.
     * @return actual date.
     */
    public static String getActualDate() {
        return removeZeros(day.format(actualDate)) + " " + hour.format(actualDate);
    }

    /**
     * [RH] Format date.
     * @param date
     * @return date format.
     */
    private static String removeZeros(final String date) {
        String newDate = "";
        String[] dateSplit = date.split("/");
        for (int i = 0; i < dateSplit.length; i++) {
            newDate += dateSplit[i].replaceFirst("^0+(?!$)", "");
            if (i < dateSplit.length - 1) {
                newDate += "/";
            }
        }
        return newDate;
    }
}
