package easy;
import java.util.HashMap;
import java.util.Map;

public class GenerateDocument {

    boolean generateDocument(String characters, String document){
        Map<Character, Integer> counts = new HashMap<>();
        for (int i = 0; i < characters.length(); i++) {
            char charAt = characters.charAt(i);
            if(!counts.containsKey(charAt)){
                counts.put(charAt, 0);
            }
            Integer value = counts.get(charAt);
            counts.put(charAt, ++value);
        } 

        for (int i = 0; i < document.length(); i++) {
            char charAt = document.charAt(i);
            if(!counts.containsKey(charAt) || counts.get(charAt) == 0){
                return false;
            }
            Integer value = counts.get(charAt);
            counts.put(charAt, --value);
        } 
        return true;
    }
    public static void main(String[] args) {
        String characters = "Rivera Poma Zoe Sophia";
        String document = "Zoe Sophia Rivera Poma ";
        System.out.println(new GenerateDocument().generateDocument(characters, document));
    }
}
