package easy;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {
    int firstNonRepeatingCharacter(String string) {
        final Map<Character, Integer> frequencies = new LinkedHashMap<>();
        for (int i = 0; i < string.length(); i++) {
            Character charAt = string.charAt(i);
            if (!frequencies.containsKey(charAt)) {
                frequencies.put(charAt, 0);
            }
            frequencies.put(charAt, frequencies.get(charAt) + 1);
        }

        for (int i = 0; i < string.length(); i++) {
            Character charAt = string.charAt(i);
            if(frequencies.get(charAt) == 1){
                return i;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        String string = "abcdbeaz";
        System.out.println(new FirstNonRepeatingCharacter().firstNonRepeatingCharacter(string));

    }
}
