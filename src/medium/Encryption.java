package medium;

public class Encryption {
    public static String encryption(String s) {
        String withoutSpaces = s.replaceAll(" ", "");
        int L = withoutSpaces.length();
    
        double sqrt = Math.sqrt(L);
        int rows = (int) Math.floor(sqrt);
        int columns = (int) Math.ceil(sqrt);
    
        if (rows * columns < L) {
            rows++;
        }
    
        char[][] grid = new char[rows][columns];
        for (int l = 0; l < L; l++) {
            int i = l / columns;
            int j = l % columns;
            grid[i][j] = withoutSpaces.charAt(l);
        }
    
        StringBuilder resultBuilder = new StringBuilder();
        for (int j = 0; j < columns; j++) {
            for (int i = 0; i < rows; i++) {
                if (grid[i][j] != 0) {
                    resultBuilder.append(grid[i][j]);
                }
            }
            resultBuilder.append(" ");
        }
    
        return resultBuilder.toString().trim();
    }
    

    public static String encryption2(String s) {
        double squareString = Math.sqrt(s.length());
        int ceil = (int) Math.ceil(squareString);
        String result = "";

        for (int i = 0; i < ceil; i++) {
            int j = 0;
            while (i + j < s.length()) {
                result += s.charAt(i + j);
                j += ceil;
            }
            result += " ";
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(encryption("haveaniceday")); // hae and via ecy
        System.out.println(encryption("feedthedog")); // fto ehg ee dd
        System.out.println(encryption("chillout")); // clu hlt io
        System.out.println(encryption("if man was meant to stay on the ground god would have given us roots")); // imtgdvs
                                                                                                                // fearwer
                                                                                                                // mayoogo
                                                                                                                // anouuio
                                                                                                                // ntnnlvt
                                                                                                                // wttddes
                                                                                                                // aohghn
                                                                                                                // sseoau

    }
}
