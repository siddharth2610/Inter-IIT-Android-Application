package com.abhishek.interiit2016.utils;

/**
 * Created by GUNDA ABHISHEK on 17-06-2016.
 */
public class APIConstants {
    public static final String API_GET_POINTS_TABLE ="/get_standings.php";
    public static final String API_ANALYTICS_DATA ="/transaction/get-aggregated-analytics-data";
    public static final String API_LOGIN ="/user/get";
    public static final String API_ATTENDEES_PAGINATION ="/transaction/getallwithpagination";
    public static final String API_NEW_ATTENDEES_PAGINATION ="/transaction/getwithpagination";
    public static final String API_USER_TICKETS ="/ticket/getall";
    public static final String API_UPDATE_GCM_TOKEN = "/user/updateorganizerappgcmid";
    public static final String API_DELETE_GCM_TOKEN = "/user/deleteorganizerappgcmid";
    public static final String API_SEARCH_ATTENDEES="/transaction/searchAttendee";
    public static final String API_GET_NOTIFICATION_PREFS="/pricing/get";
    public static final String API_POST_NOTIFICATION_PREFS="/pricing/updatenotificationpreference";
    public static final String API_POST_CHECKIN="/registration/updateattendeecheckin";
}
