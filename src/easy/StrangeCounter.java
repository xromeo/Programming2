package easy;
/*
 * There is a strange counter. At the first second, it displays the number . Each second, the number displayed by decrements by 1 until it reaches 1 . In next second, the timer resets to 2 x the initial number for the prior cycle  and continues counting down.  Find and print the value displayed by the counter at time .
 * 
 */

public class StrangeCounter {
    public static void main(String[] args) {
        long t = 6;
        long result = findValue(t);
        System.out.println("Value displayed at time " + t + ": " + result);
    }

    public static long findValue(long t) {
        long cycleLength = 3;
        long initialValue = cycleLength;
        
        while (t > cycleLength) {
            t -= cycleLength;
            cycleLength *= 2;
            initialValue = cycleLength;
        }

        return initialValue - (t - 1);
    }
}
