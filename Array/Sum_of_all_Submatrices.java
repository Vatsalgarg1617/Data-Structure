

/*
Problem Description
Given a 2D Matrix A of dimensions N*N, we need to return sum of all possible submatrices.



Problem Constraints
1 <= N <=30

0 <= A[i][j] <= 10



Input Format
Single argument representing a 2-D array A of size N x N.



Output Format
Return an integer denoting the sum of all possible submatrices in the given matrix.



Example Input
A = [ [1, 1]
      [1, 1] ]


Example Output
16


Example Explanation
Number of submatrices with 1 elements = 4, so sum of all such submatrices = 4 * 1 = 4
Number of submatrices with 2 elements = 4, so sum of all such submatrices = 4 * 2 = 8
Number of submatrices with 3 elements = 0
Number of submatrices with 4 elements = 1, so sum of such submatrix = 4
Total Sum = 4+8+4 = 16
*/

// Solution
public class Solution {
    
    public int solve(int[][] matrix) {
        int sum = 0;
        int row = matrix.length;
        if(row == 0){
            return sum;
        }
        for(int i = 0 ; i < row ; i++){
            for(int j = 0; j < row ; j++){
                int topLeftArea = (i + 1)*(j + 1);
                int bottomRightArea = (row - i)*(row - j);
                sum += (topLeftArea*bottomRightArea*matrix[i][j]);
            }
        }
        return sum;
    }
}
// Time Complexity - O(n^2)
// Space Complexity - O(1) // we are not using any extra space
/*
Explanation: 
So in this question we have to f/o all the submatrixes and return the sum of elements of them. 
Brute Force Approach:
If we go by the brute force approach we first have to find out the number of submatrixes.
So formula for the find out the is (N*(N+1)/2)^2 and after that we have to take the sum of each submatrixes which will be O(n^2).
So time complexity would be O(n^6)

Better Approach:
In the end we have to provide the sum of all the summatrixes. So other way to think this question is that we have to find out the how many times
the number a particular number is present in the submarixes.
So we can just mulitply that number with number of time appearing in the sub matrxies. 
Now the problem become how can we calculate the particular number is appearing in how many of sub matrxies. 
So for that we can see if we took that number as BottomRight and TopLeft of any matrix then it will apear in all the submatrix which that number are making.
So our formula becomes:
If element is part of bottom right -> (i + 1)*(j + 1);
If element is part of top left -> (N - i + 1)* (N - j + 1);
S(i,j) = ((i + 1)*(j + 1))*((N - i + 1)*(N - j + 1));
So this will give the count of number of submatrixes.

*/
