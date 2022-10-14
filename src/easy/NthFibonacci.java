package easy;
import java.util.HashMap;

import java.util.Map;

public class NthFibonacci {
    // O(n²) | O(n) space
    int nthFib(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        return nthFib(n - 1) + nthFib(n - 2);
    }

    // O(n) time | O(n) space
    int nthFib2(int n) {
        Map<Integer, Integer> memoize = new HashMap<>();
        memoize.put(1, 0);
        memoize.put(2, 1);
        return nthFib(n, memoize);
    }

    int nthFib(int n, Map<Integer, Integer> memoize) {
        if (memoize.containsKey(n)) {
            return memoize.get(n);
        }
        int fib = nthFib(n - 1, memoize) + nthFib(n - 2, memoize);
        memoize.put(n, fib);
        return fib;
    }

    // O(n) time | O(1) space
    int nthFib3(int n) {
        int[] fib = { 0, 1 };
        if(n<=2){
            return fib[n-1];
        }
        int c = 3;
        while ( c <= n){
            int nextFib = fib[0] + fib[1];
            fib[0] = fib[1];
            fib[1] = nextFib;
            c++;
        }
        return fib[1];
    }

    public static void main(String[] args) {
        int n = 5;
        int fib = new NthFibonacci().nthFib(n);
        System.out.println(fib);
        int fib2 = new NthFibonacci().nthFib2(n);
        System.out.println(fib2);

        int fib3 = new NthFibonacci().nthFib3(n);
        System.out.println(fib3);


    }
}
