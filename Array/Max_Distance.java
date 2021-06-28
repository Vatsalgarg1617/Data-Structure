/*
Max Distance
Problem Description

Given an array A of integers of size N. Find the maximum of value of j - i such that A[i] <= A[j].



Problem Constraints
1 <= N <= 1000000

-109 <= A[i] <= 109



Input Format
First argument is an integer array A of size N.



Output Format
Return an integer denoting the maximum value of j - i.



Example Input
Input 1:

A = [3, 5, 4, 2]


Example Output
Output 1:

2


Example Explanation
Explanation 1:

For A[0] = 3 and A[2] = 4, the ans is (2 - 0) = 2. 
*/

// Solutions
 public int method1(final int[] nums) {
        int size = nums.length;
        int[] left = new int[size];
        int[] right = new int[size];
        left[0] = nums[0];
        for(int i = 1; i < size ; i++) {
            left[i] = Math.min(left[i - 1],nums[i]);
        }
        right[size - 1] = nums[size - 1];
        for(int i = size - 2; i >= 0 ; i--){
            right[i] = Math.max(right[i + 1] , nums[i]);
        }
        
        int i = 0;
        int j = 0;
        int maxDiff = 0;
        while(i < size & j < size) {
            if(left[i] <= right[j]){
                maxDiff = Math.max(maxDiff, j - i);
                j++;
            }else{
                i++;
            }
        }
        return maxDiff;
    }
    // Time Complexity -> O(n)
   // Space Complexity -> O(n + n)
    
    public int method2(final int[] nums) {
       ArrayList<ArrayList<Integer>> list = new ArrayList<>();
       int size = nums.length;
       for(int i = 0 ; i < size ; i++){
           ArrayList<Integer> temp = new ArrayList<>();
           temp.add(nums[i]);
           temp.add(i);
           list.add(temp);
       }
       
       Collections.sort(list, (ArrayList<Integer> a, ArrayList<Integer> b) -> {
           if(a.get(0) < b.get(0)){
               return -1;
           }else if((a.get(0) == b.get(0)) && a.get(1) < b.get(1)){
               return -1;
           }else{
               return 1;
           }
       });
       int maxDiff = 0;
       int j = 0;
       for(int i = size - 1; i >= 0 ; i--){
           ArrayList<Integer> temp = new ArrayList<Integer>(list.get(i));
           int currIndex = temp.get(1);
           j = Math.max(j, currIndex);
           maxDiff = Math.max(maxDiff, j - currIndex);
       }
       return maxDiff;
    }

   // Time Complexity -> O(nlogn)
   // Space Complexity -> O(n)

