package easy;
/*
 * 
 Implement a simple text editor. The editor initially contains an empty string, S. Perform Q operations of the following 4 types:

1 append(W) - Append string W to the end of S.
2 delete(k)- Delete the last k characters of S.
3 print(k)- Print the k^th character of S.
4 undo() - Undo the last (not previously undone) operation of type 1 or 2, reverting S to the state it was in prior to that operation.
Example
S = "abcde"
ops = ['1 fg', '3 6', '2 5', '4', '3 7', '4', '3 4']

operation
index   S       ops[index]  explanation
-----   ------  ----------  -----------
0       abcde   1 fg        append fg
1       abcdefg 3 6         print the 6th letter - f
2       abcdefg 2 5         delete the last 5 letters
3       ab      4           undo the last operation, index 2
4       abcdefg 3 7         print the 7th character - g
5       abcdefg 4           undo the last operation, index 0
6       abcde   3 4         print the 4th character - d

The results should be printed as:

f
g
d

 */

import java.util.Scanner;
import java.util.Stack;

class TextEditor {
    StringBuilder s;
    Stack<String> undos;

    TextEditor() {
        this.s = new StringBuilder();
        this.undos = new Stack<>();
    }

    public void append(String w) {
        undos.push(s.toString());
        s.append(w);
    }

    public void delete(int k) {
        undos.push(s.toString());
        s.delete(s.length() - k, s.length());
    }

    public void print(int k) {
        System.out.println(s.toString().charAt(k - 1));
    }

    public void undo() {
        s = new StringBuilder(undos.pop());
    }
}

public class SimpleTextEditor {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        TextEditor textEditor = new TextEditor();
        int q = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < q; i++) {
            int op = scan.nextInt();
            switch (op) {
                case 1:
                    textEditor.append(scan.next());
                    break;
                case 2:
                    textEditor.delete(scan.nextInt());
                    break;
                case 3:
                    textEditor.print(scan.nextInt());
                    break;
                case 4:
                    textEditor.undo();
                    break;
            }
        }
        scan.close();
    }
}
