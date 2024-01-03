package easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 A computer has a certain number of cores and a list of files that need to be executed. If a file is executed by a single core, the execution time equals the number of lines of code in the file. If the lines of code can be divided by the number of cores, another option is to execute the file in parallel using all the cores, In which case the execution time is divided by the number of cores. However, there is a limit as to how many files can be executed in parallel. Given the lengths of the code files, the number of cores, and the limit, what is the minimum amount of time needed to execute all the files?

Example, let's say that there are n=5 files, where files [4, 1, 3, 2, 8] (Indicating the number of lines of code in each file), numCores = 4, and limit = 1. Even though both the first and fifth files can be executed in parallel, you must choose only one of them because the limit is 1. The optimal way is to parallelize the last file, so the minimum execution time required is 4+1+3+2+(8/4) = 12. Therefore, the answer is 12.

Function Description

Complete the function minTime in the editor below.

minTime has the following parameter(s):

int files[n) an array of integers where files[i] indicates the number of lines of code in the ith file

Int numCores: the number of cores in the computer

Int limit the maximum number of files that can be executed in parallel

Returns:

long int: the minimum units of time needed to execute all the files
 */

public class ParallelProcessing {
    public static long minTime(List<Integer> files, int numCores, int limit) {
        long result = 0;
        int k = 1;
        List<Integer> d = new ArrayList<>();

        for (int file : files) {
            if (file % numCores != 0) {
                result += file;
            } else {
                d.add(file);
            }
        }

        Collections.sort(d);

        for (int i = d.size() - 1; i >= 0; i--) {
            if (k <= limit) {
                result += d.get(i) / numCores;
                k++;
            } else {
                result += d.get(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> files = List.of(10, 15, 20, 25, 30);
        int numCores = 5;
        int limit = 2;

        long result = minTime(files, numCores, limit);
        System.out.println(result);
    }
}
