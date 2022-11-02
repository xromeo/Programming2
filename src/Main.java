public class Main {
    public static String timeConversion(String s) {
        // Write your code here

        String hour = s.substring(0, 2);
        int h = Integer.parseInt(hour);
        String type = s.substring(s.length() - 2, s.length());
        if ("AM".equals(type) && h != 12) {
            return s.substring(0, s.length() - 2);
        }
        if ("PM".equals(type) && h == 12) {
            return s.substring(0, s.length() - 2);
        }
        int result = (h + 12) % 24;
        String f = String.format("%02d", result);
        return f + s.substring(2, s.length() - 2);
    }

    public static void main(String[] args) {
        String r = Main.timeConversion("12:01:00PM");
        System.out.println(r);
        r = Main.timeConversion("12:01:00AM");
        System.out.println(r);
        r = Main.timeConversion("11:41:00PM");
        System.out.println(r);
    }
}
