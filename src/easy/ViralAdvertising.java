package easy;

public class ViralAdvertising {

    public static int viralAdvertising(int n) {
        int shared = 5;
        int liked = 0;
        int cumulative = 0;
        for (int i = 1; i <= n; i++) {
            liked = shared / 2;
            shared = liked * 3;
            cumulative += liked; 
        }
        return cumulative;


        Holaff omar
    }

    public static void main(String[] args) {
        System.out.println(viralAdvertising(1));
        System.out.println(viralAdvertising(2));
        System.out.println(viralAdvertising(3));
        System.out.println(viralAdvertising(4));
        System.out.println(viralAdvertising(5));
        System.out.println(viralAdvertising(6));
        System.out.println(viralAdvertising(7));

    }
}
