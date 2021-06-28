/*
Maximum Unsorted Subarray
Problem Description

Given an array A of non-negative integers of size N. Find the minimum sub-array Al, Al+1 ,..., Ar such that if we sort(in ascending order) that sub-array, then the whole array should get sorted. If A is already sorted, output -1.



Problem Constraints
1 <= N <= 1000000
1 <= A[i] <= 1000000



Input Format
First and only argument is an array of non-negative integers of size N.



Output Format
Return an array of length 2 where First element denotes the starting index(0-based) and second element denotes the ending index(0-based) of the sub-array. If the array is already sorted, return an array containing only one element i.e. -1.



Example Input
Input 1:

A = [1, 3, 2, 4, 5]
Input 2:

A = [1, 2, 3, 4, 5]


Example Output
Output 1:

[1, 2]
Output 2:

[-1]


Example Explanation
Explanation 1:

If we sort the sub-array A1, A2, then the whole array A gets sorted.
Explanation 2:

A is already sorted.
*/
// Solution 
public class Solution {
    public int[] subUnsort(int[] nums) {
        
        int size = nums.length;
        int i = 0;
        while(i < (size- 1) && nums[i] <= nums[i + 1]){
            i++;
        }
        if(i == (size - 1)){
            int[] result = new int[1];
            result[0] = -1;
            return result;
        }
        
        int j = size - 1;
        while(j > 0 && nums[j - 1] <= nums[j]){
            j--;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int index = i ; index <= j; index++){
            min = Math.min(min, nums[index]);
            max = Math.max(max, nums[index]);
        }
        while( i > 0 && nums[i - 1] > min){
            i--;
        }
        while(j < (size -1) && nums[j + 1] < max){
            j++;
        }
        int[] result = new int[2];
        result[0] = i;
        result[1] = j;
        return result;
    }
}

// Time Complexity - O(n)
// Space Complexity - O(1)
