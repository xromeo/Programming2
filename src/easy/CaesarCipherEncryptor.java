package easy;

/*
 * 
 Julius Caesar protected his confidential information by encrypting it using a cipher. Caesar's cipher shifts each letter by a number of letters. If the shift takes you past the end of the alphabet, just rotate back to the front of the alphabet. In the case of a rotation by 3, w, x, y and z would map to z, a, b and c.

Original alphabet:      abcdefghijklmnopqrstuvwxyz
Alphabet rotated +3:    defghijklmnopqrstuvwxyzabc


Note: The cipher only encrypts letters; symbols, such as -, remain unencrypted.

Sample Input

11
middle-Outz
2
Sample Output

okffng-Qwvb
Explanation

Original alphabet:      abcdefghijklmnopqrstuvwxyz
Alphabet rotated +2:    cdefghijklmnopqrstuvwxyzab

m -> o
i -> k
d -> f
d -> f
l -> n
e -> g
-    -
O -> Q
u -> w
t -> v
z -> b

 */

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

    public static String caesarCipher(String s, int k) {
        String newLetters = "";
        k = k % 26;
        for (Character character : s.toCharArray()) {
            boolean isLowerCase = false;
            if ((character >= 65 && character <= 90) || (character >= 97 && character <= 122)) {
                if (character >= 65 && character <= 90) {
                    isLowerCase = true;
                }
                int letter = character + k;

                if (isLowerCase) {
                    letter = ((letter - 65) % 26) + 65;
                } else {
                    letter = ((letter - 97) % 26) + 97;
                }

                newLetters += (char) letter;

            } else {
                newLetters += character;
            }
        }     
        return newLetters;
    }

    public static String caesarCipher2(String s, int k) {
       
        k = k % 26;
    
        StringBuilder newLetters = new StringBuilder();
    
        for (char character : s.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isLowerCase(character) ? 'a' : 'A';
                char encryptedChar = (char) (base + (character - base + k) % 26);
                newLetters.append(encryptedChar);
            } else {               
                newLetters.append(character);
            }
        }
    
        return newLetters.toString();
    }

    public static void main(String[] args) {
        String string = "middle-Outz";
        var encryptor = new CaesarCipherEncryptor().caesarCipherEncryptor(string, 2);
        System.out.println(encryptor);
        var encryptor2 = new CaesarCipherEncryptor().caesarCipherEncryptor2(string, 2);
        System.out.println(encryptor2);

        System.out.println(caesarCipher(string, 2));
        System.out.println(caesarCipher2(string, 2));
    }
}
