package commons;

import java.util.List;

public class Array {

    public void print(int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println();
    }

    public void print(Integer[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println();
    }

    public void print(List<Integer> array){
        for (int i = 0; i < array.size(); i++) {
            System.out.print(array.get(i) + "\t");
        }
        System.out.println();
    }

    public void printMatrix(List<int[]> array){
        for (int i = 0; i < array.size(); i++) {
            System.out.print(array.get(i)[0] + "," + array.get(i)[1] + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
