package com.lhind.util;

public final class Queries {
    public static String FIND_ALL_USERS = "SELECT u FROM User u";
    public static String FIND_USER_BY_USERNAME = "SELECT u FROM User u WHERE u.username = ?1";
    public static String FIND_USER_BY_USERNAME_METHOD_2 = "SELECT u FROM User u WHERE u.username = :username";

    public static String FIND_ALL_BOOKINGS = "SELECT b FROM Booking b";
    public static String FIND_ALL_FLIGHTS = "SELECT f FROM Flight f";
    public static String FIND_FLIGHT_BY_ORIGIN = "SELECT f FROM Flight f WHERE f.origin = ?1";

    private Queries() {}
}
