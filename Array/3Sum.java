/*

Question

Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

 

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.

Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.

Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.

*/

// Solution

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>(); // Using set to handle the duplicate triplets
        Arrays.sort(nums); // Sort the number
        for(int i = 0; i < nums.length - 2; i++){
            int start = i + 1, end = nums.length - 1;
            while(start < end){ // Take o(n) time to complete for one number to find other two value to get the zero ans
                int sum = nums[i] + nums[start]  + nums[end]; // To get the sum
                
                if(sum == 0){ // if Sum is zero then add to result set
                    result.add(Arrays.asList(nums[i], nums[start], nums[end]));
                }
                if(sum < 0){
                    start++;
                }else{
                    end--;
                }
            }
        }
        return new ArrayList<>(result);
    }
}

// Time Complexity - O(n^2  + nlogn)
// Space Complexity - O(1)
