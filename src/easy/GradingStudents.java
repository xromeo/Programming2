package easy;

import java.util.List;
import java.util.stream.Collectors;

/*
HackerLand University has the following grading policy:

Every student receives a grade in the inclusive range from 0 to 100.
Any grade less than 40 is a failing grade.
Sam is a professor at the university and likes to round each student's grade according to these rules:

If the difference between the grade and the next multiple of 5 is less than 3, round grade up to the next multiple of 5.
If the value of grade is less than 38, no rounding occurs as the result will still be a failing grade.
Examples

 grade = 84 round to 85 (85 - 84 is less than 3)
 grade = 29 do not round (result is less than 40)
 grade = 57 do not round (60 - 57 is 3 or higher)
Given the initial value of grade for each of Sam's  students, write code to automate the rounding process.

* */

public class GradingStudents {

    public static List<Integer> gradingStudents(List<Integer> grades) {
        return grades.stream().map(g -> getNext2(g)).collect(Collectors.toList());
    }

    public static int getNext(int value) {
        if (value < 38) {
            return value;
        }
        int digit = value % 10;
        int next = (value / 10) * 10;
        if (digit > 2 && digit <= 5) {
            return next + 5;
        }
        if (digit > 7 && digit <= 10) {
            return next + 10;
        }
        return next + digit;
    }

       public static int getNext2(int grade) {
        if (grade < 38) {
            return grade;
        }
        int x = 5;

        int next = ((grade / x) + 1) * x;
        
        int difference = next - grade;

        if (difference < 3) {
            return next;
        }
        return grade;
    }

    public static void main(String[] args) {
        System.out.println(gradingStudents(List.of(73, 67, 38, 33)));
        System.out.println(gradingStudents(List.of(84, 29, 57)));
    }

}
