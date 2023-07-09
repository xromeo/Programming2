package easy;

import java.util.List;

public class LisaWorkbook {

    public static int workbook(int n, int k, List<Integer> arr) {

        int c = 0;
        int page = 0;
        for (int chapter = 0; chapter < n; chapter++) {
            int problems = arr.get(chapter);
           
            for (int j = 1; j <= problems; j++) {
                if (j % k == 1 || k == 1) {
                    page++;
                }
                if(j == page){
                    c++;
                }
            }            
        }
      
        return c;

    }

    public static void main(String[] args) {
        System.out.println(workbook(5, 3, List.of(4, 2, 6, 1, 10)));

    }
}
