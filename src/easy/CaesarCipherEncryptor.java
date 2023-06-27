package easy;


public class CaesarCipherEncryptor {

    String caesarCipherEncryptor(String string, int key) {
        String newLetters = "";
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        key = key % alphabet.length();
        for (Character character : string.toCharArray()) {
            int unicode = (int) character;
            int newChar = unicode + key;
            if (newChar <= 122) {
                newLetters += (char) newChar;
            } else {
                newLetters += (char) (newChar % 122 + 96);
            }

        }

        // return String.join("", newLetters);
        return newLetters;
    }

    String caesarCipherEncryptor2(String string, int key) {
        String newLetters = "";
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        key = key % alphabet.length();
        for (Character character : string.toCharArray()) {
            int letter = alphabet.indexOf(character);
            int newLetter = letter + key;
            if (newLetter < 26) {
                newLetters += alphabet.charAt(newLetter);
            } else {
                int idx = (newLetter) % 26;
                newLetters += alphabet.charAt(idx);
            }

        }

        // return String.join("", newLetters);
        return newLetters;
    }

    public static void main(String[] args) {
        String string = "xyz";
        var encryptor = new CaesarCipherEncryptor().caesarCipherEncryptor(string, 2);
        System.out.println(encryptor);
        var encryptor2 = new CaesarCipherEncryptor().caesarCipherEncryptor2(string, 2);
        System.out.println(encryptor2);
    }
}
