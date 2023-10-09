package easy;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/*
 * Given a time in 12-hour AM/PM format, convert it to military (24-hour) time.

Note: - 12:00:00AM on a 12-hour clock is 00:00:00 on a 24-hour clock.
- 12:00:00PM on a 12-hour clock is 12:00:00 on a 24-hour clock.

Example
s=12:01:00PM
Return '12:01:00'.

s=12:01:00AM
Return '00:01:00'.

Function Description

Complete the timeConversion function in the editor below. It should return a new string representing the input time in 24 hour format.

timeConversion has the following parameter(s):

string s: a time in 12 hour format
Returns

string: the time in 24 hour format
Input Format

A single string s that represents a time in 12-hour clock format (i.e.: hh:mm:ssPM or hh:mm:ssAM).
 * 
 */
public class TimeConversion {
    public static String timeConversion(String s) {
        String[] parts = s.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        int seconds = Integer.parseInt(parts[2].substring(0, 2));
        String meridian = parts[2].substring(2);

        if (meridian.equals("PM") && hours != 12) {
            hours += 12;
        }

        if (meridian.equals("AM") && hours == 12) {
            hours = 0;
        }

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    public static String timeConversion2(String s) {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("hh:mm:ssa");
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        LocalTime time = LocalTime.parse(s, inputFormatter);
        return time.format(outputFormatter);
    }

    public static void main(String[] args) {
        System.out.println(timeConversion("12:01:00PM"));
        System.out.println(timeConversion("12:01:00AM"));

        System.out.println(timeConversion2("12:01:00PM"));
        System.out.println(timeConversion2("12:01:00AM"));
    }
}
