/*
Question:

Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition 
nums[i] + nums[j] + nums[k] < target.

Example

Example1

Input:  nums = [-2,0,1,3], target = 2
Output: 2
Explanation:
Because there are two triplets which sums are less than 2:
[-2, 0, 1]
[-2, 0, 3]

Example2

Input: nums = [-2,0,-1,3], target = 2
Output: 3
Explanation:
Because there are three triplets which sums are less than 2:
[-2, 0, -1]
[-2, 0, 3]
[-2, -1, 3]


*/


// Solution

public class Solution {
public int threeSumSmaller(int[] nums, int target) {
    int L = nums.length;
    Arrays.sort(nums); // To not to do this in O(n^3)
    int count = 0;
    for(int i=0; i<L-2; i++) {
        int lo = i+1;
        int hi = L-1;
        while(lo<hi) {
            if(nums[i] + nums[lo] + nums[hi] < target) {
                count += hi-lo;
                lo++;
            }
            else
                hi--;
        }
    }
    return count;
}
}

// Time Complexity - O(n^2)
// Space Complexity - O(1)
