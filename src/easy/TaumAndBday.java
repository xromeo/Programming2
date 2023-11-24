package easy;

public class TaumAndBday {

    public static long taumBday2(int b, int w, int bc, int wc, int z) {
        if (bc > wc + z) {
            return (long) ((b + w) * wc) + (long) b * z;
        }
        if (wc > bc + z) {
            return (long) ((b + w) * bc) + (long) w * z;
        }
        return (long) b * bc + (long) w * wc;
    }

    public static long taumBday(int b, int w, int bc, int wc, int z) {
            long totalCost = 0;
            
            long blackTotalCost = Math.min(bc, wc + z);
            long whiteTotalCost = Math.min(wc, bc + z);
            
            totalCost = blackTotalCost * b + whiteTotalCost * w;
            
            return totalCost;
        }

    public static void main(String[] args) {
        System.out.println(taumBday(10, 10, 1, 1, 1));
        System.out.println(taumBday(5, 9, 2, 3, 4));
        System.out.println(taumBday(3, 6, 9, 1, 1));
        System.out.println(taumBday(7, 7, 4, 2, 1));
        System.out.println(taumBday(3, 3, 1, 9, 2));

        System.out.println(taumBday(15242, 95521, 712721, 628729, 396706)); // 70920116291
        System.out.println(taumBday(62990, 61330, 310144, 312251, 93023)); // 38686324390
        System.out.println(taumBday(11152, 43844, 788543, 223872, 972572)); // 18609275504
        System.out.println(taumBday(15242, 95521, 712721, 628729, 396706)); // 70920116291
        System.out.println(taumBday(83666934, 10563001, 961640, 539051, 424245)); // 86151466663811
    }
}
