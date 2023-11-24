package easy;

/*
 * Alice has a binary string. She thinks a binary string is beautiful if and only if it doesn't contain the substring "010".

In one step, Alice can change a 0 to a 1 or vice versa. Count and print the minimum number of steps needed to make Alice see the string as beautiful.

Example

b = 010

She can change any one element and have a beautiful string.

Function Description

Complete the beautifulBinaryString function in the editor below.

beautifulBinaryString has the following parameter(s):

string b: a string of binary digits
Returns

int: the minimum moves required
Input Format

The first line contains an integer n, the length of binary string.
The second line contains a single binary string b.

Constraints

* 1<=n<=100
* b[i] E {0,1}

Output Format

Print the minimum number of steps needed to make the string beautiful.
 * 
 */

public class BeautifulBinaryString {
    public static int beautifulBinaryString(String b) {
        int count = 0;
        int index = 0;
        
        while (index < b.length() - 2) {
            if (b.substring(index, index + 3).equals("010")) {
                count++;
                index += 3;
            } else {
                index++;
            }
        }
        
        return count;
    }

    public static void main(String[] args) {
        
        String b = "0101010";
        
        int result = beautifulBinaryString(b);
        System.out.println(result);
    }
}
