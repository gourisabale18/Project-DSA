package com.akshayram.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MathOps {

  public static boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
    int width = Math.abs(sx - fx);
    int height = Math.abs(sy - fy);
    if (width == 0 && height == 0 && t == 1) {
      return false;
    }
    return t >= Math.max(width, height);
  }

  private static List<Integer> findPrimeFactors(int number) {
    List<Integer> factors = new ArrayList<>();
    // Divide by 2 to remove all even factors
    while (number % 2 == 0) {
      factors.add(2);
      number /= 2;
    }
    // At this point, number must be odd. So we can skip one element (Note i = i +2)
    for (int i = 3; i <= Math.sqrt(number); i += 2) {
      // While i divides number, add i and divide number
      while (number % i == 0) {
        factors.add(i);
        number /= i;
      }
    }
    // If number is a prime number greater than 2
    if (number > 2) {
      factors.add(number);
    }
    return factors;
  }

  // TC: O(n) SC: O(1)
  public static int numberOfArithmeticSlices(int[] nums) {
    if(nums == null || nums.length == 0) return 0;
    int n = nums.length;
    int currSum = 0;
    int totalSum = 0;
    for(int i=2;i<n;i++){
      //check AP property
      if(nums[i] - nums[i-1] == nums[i-1] - nums[i-2]){
        currSum+=1;
        totalSum += currSum;
      } else {
        currSum=0;
      }
    }
    return totalSum;
  }

  public static void main(String[] args) {
//    int sx = 1;
//    int sy = 1;
//    int fx = 3;
//    int fy = 4;
//    int t = 1;
//    boolean isReachable = isReachableAtTime(sx, sy, fx, fy, t);
//    System.out.println("Is the destination reachable at time " + t + " ? " + isReachable);
//
//    int number = 60; // Change this to the number you want to factorize.
//    List<Integer> primeFactors = findPrimeFactors(number);
//
//    System.out.println("Prime factors of " + number + " are: " + primeFactors);

    int[] nums = new int[]{1,2,3,4};
    System.out.println("Possible AP subarrays are : "  + numberOfArithmeticSlices(nums));
  }
}
