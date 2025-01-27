package com.akshayram.contests;

import java.util.*;

public class MaxSumSubmatrix {

    public static int maxSumSubmatrix(int[][] matrix, int size) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int maxSum = Integer.MIN_VALUE;
        Set<Integer> maxSumSubmatrixSet = new HashSet<>();

        for (int i = 0; i <= rows - size; i++) {
            for (int j = 0; j <= cols - size; j++) {
                // Calculate the sum of the current size x size submatrix
                int submatrixSum = 0;
                Set<Integer> submatrixSet = new HashSet<>();
                for (int x = i; x < i + size; x++) {
                    for (int y = j; y < j + size; y++) {
                        submatrixSum += matrix[x][y];
                        submatrixSet.add(matrix[x][y]);
                    }
                }

                // Update maxSum and maxSumSubmatrixSet if necessary
                if (submatrixSum > maxSum) {
                    maxSum = submatrixSum;
                    maxSumSubmatrixSet = new HashSet<>(submatrixSet);
                }
            }
        }

        // Sum up distinct numbers from maxSumSubmatrixSet
        int distinctSum = 0;
        for (int num : maxSumSubmatrixSet) {
            distinctSum += num;
        }

        return distinctSum;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0, 1, 5, 6},
                {3, 3, 0, 3, 3},
                {2, 9, 2, 1, 2},
                {0, 2, 4, 2, 0}
        };
        int size = 2;
        int result = maxSumSubmatrix(matrix, size);
        System.out.println(result);  // Output: 29
    }
}
