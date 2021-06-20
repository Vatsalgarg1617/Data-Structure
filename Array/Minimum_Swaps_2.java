/* 
Problem Description

Given an array of integers A of size N that is a permutation of [0, 1, 2, ..., (N-1)]. It is allowed to swap any two elements (not necessarily consecutive).

Find the minimum number of swaps required to sort the array in ascending order.



Problem Constraints
1 <= N <= 100000
0 <= A[i] < N



Input Format
The only argument given is the integer array A.



Output Format
Return the minimum number of swaps.



Example Input
Input 1:

A = [1, 2, 3, 4, 0]
Input 2:

A = [2, 0, 1, 3]


Example Output
Output 1:

4
Output 2:

2


Example Explanation
Explanation 1:

 If you swap (1, 2) -> (2, 3) -> (4, 0) -> (3, 0). You will get a sorted array.
 You cannot sort it with lesser swaps.
Explanation 2:

 You cannot sort it with lesser than 2 swaps.
 */
 
// Solution
public class Solution {
    public int solve(int[] A) {
        int ans = 0;
        for(int i = 0; i < A.length; i++){
            while(i != A[i]){
                ans++;
                int temp = A[i];
                A[i] = A[temp];  // Scope of Error --> Be aware to put temp as A[A[i]]. If you put A[A[i]] value this will be change after this line.
                A[temp] = temp;
            }
        }
        return ans;
    }
}
// Time Complexity - O(n)
/*
At first glance this look like O(n^2) but if you really look carefully inner loop will not every time for outer loop. Inner loop will only run for number of
circular loop. For more understanding look into the explanation.
*/

// Space Complexity O(1)
/*
We doesn't use any extra space i.e we are not using any array, stack trace(recursion) or anything.
*/


 /* 
 Explanation:
 For this question we have to look carefully at the example. There are some loops which we try to fix that.
 lets take an example:
 Input A = [1, 2, 3, 4, 0]
 So here the loop is 1 is sitting on 0 position and 2 is sitting on 1 position and so on.
 
 */
 
 
