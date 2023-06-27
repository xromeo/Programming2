package easy;
import java.util.Arrays;
import java.util.Collections;


/**
 * ClassPhotos
 */
public class ClassPhotos {

    public boolean classPhotos(Integer[] redShirts, Integer[] blueShirts) {
        Arrays.sort(redShirts, Collections.reverseOrder());
        Arrays.sort(blueShirts, Collections.reverseOrder());
        String shirtColorInFirstRow = redShirts[0] < blueShirts[0] ? "RED": "BLUE";

        for (int i = 0; i < blueShirts.length; i++) {
            int redShirtsHeight = redShirts[i];
            int blueShirtsHeight = blueShirts[i];
            if(shirtColorInFirstRow.equals("RED")){
                if(redShirtsHeight >= blueShirtsHeight){
                    return false;
                }
            } else{
                if(blueShirtsHeight >= redShirtsHeight){
                    return false;
                }
            }

        }
        
        return true;
    }

    public static void main(String[] args) {
        Integer[] red = new Integer[] { 2, 4, 5, 7, 9, 4 };
        Integer[] blue = new Integer[] { 1, 3, 4, 6, 8, 3 };

        var classPhotos = new ClassPhotos();
        System.out.println(classPhotos.classPhotos(red, blue));
    }
}