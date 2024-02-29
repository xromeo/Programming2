package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 There are a number of people who will be attending ACM-ICPC World Finals. Each of them may be well versed in a number of topics. Given a list of topics known by each attendee, presented as binary strings, determine the maximum number of topics a 2-person team can know. Each subject has a column in the binary string, and a '1' means the subject is known while '0' means it is not. Also determine the number of teams that know the maximum number of topics. Return an integer array with two elements. The first is the maximum number of topics known, and the second is the number of teams that know that number of topics.

Example

n = 3
topics = [10101, 11110, 00010]

The attendee data is aligned for clarity below:

10101
11110
00010
These are all possible teams that can be formed:

Members Subjects
(1,2)   [1,2,3,4,5]
(1,3)   [1,3,4,5]
(2,3)   [1,2,3,4]
In this case, the first team will know all 5 subjects. They are the only team that can be created that knows that many subjects, so [5,1] is returned.  
 */

public class ACMICPCTeam {
    public static List<Integer> acmTeam(List<String> topic) {
    
        int n = topic.size();

        Integer[] r = new Integer[]{0,0};


        for (int i = 0; i < n; i++) {
             char[] a = topic.get(i).toCharArray();
            for (int j =  i + 1; j < n; j++) {
                char[] b = topic.get(j).toCharArray();                
                int x = 0;                
                for (int k = 0; k < b.length; k++) {
                    if(a[k] == '1' || b[k] == '1'){
                        x++;
                    }

                }
                if(x > r[0]){
                    r[0] = x;
                    r[1] = 1; 
                } else if(x == r[0]){                    
                    r[1]++; 
                }

            }
            
        }

        
        return Arrays.asList(r);

    }

    public static void main(String[] args) {
        List<String> list = List.of("10101", "11110", "00010");
        System.out.println(acmTeam(list));

        List<String> list2 = List.of("10101",
        "11100",
        "11010",        
        "00101");
        System.out.println(acmTeam(list2));


    }
}
