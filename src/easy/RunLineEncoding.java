package easy;
/**
 * RunLineEncoding
 */
public class RunLineEncoding {

    String runLineEncoding(String string) {
        String encodedStringCharacters = "";
        int currentRunLength = 1;
        for (int i = 1; i < string.length(); i++) {
            char currenCharacter = string.charAt(i);
            char previousCharacter = string.charAt(i - 1);
            if (currenCharacter != previousCharacter || currentRunLength == 9) {
                encodedStringCharacters += currentRunLength;
                encodedStringCharacters += previousCharacter;
                currentRunLength = 0;
            }
            currentRunLength++;
        }
        encodedStringCharacters += currentRunLength;
        encodedStringCharacters += string.charAt(string.length() - 1);
        return encodedStringCharacters;

    }

    public static void main(String[] args) {

        String string = "AAAAAAAAAAAAABBBCCCQQSSA";
        System.out.println(new RunLineEncoding().runLineEncoding(string));
        string = "A";
        System.out.println(new RunLineEncoding().runLineEncoding(string));
    }
}