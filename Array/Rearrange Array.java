
/*
Question: 
Rearrange a given array so that Arr[i] becomes Arr[Arr[i]] with O(1) extra space.

Example 1:

Input : [1, 0]
Return : [0, 1]

Example 2:
Input : [0, 3, 1, 2]
Return: [0, 2, 3, 1]

 Lets say N = size of the array. Then, following holds true :
All elements in the array are in the range [0, N-1]
N * N does not overflow for a signed integer

*/

// Solution
public class Solution {
	public void arrange(ArrayList<Integer> a) {
	    int size = a.size();
	    for(int i = 0 ; i < size ; i++){
	        a.set(i, a.get(i) + (a.get(a.get(i))%size)*size);
	    }
	    for(int i = 0 ; i < size ; i++){
	        a.set(i, a.get(i)/size);
	    }
	}
}

/*
Explanation: 
Since we can't take extra space(mention in the Question) we have to think something which we will give us ans on the spot or in O(1) space.
So here we have used a simple Mathmatics formula for equation:
y = am + b
So if you want "a" from the above equation we can do y/m
but if we want "b" from the above equation we can do y%m
Let's take an Example:
Give array with values A = [0, 3, 1, 2], Size = 4
According to our formula we are setting array element as:
Index 0 --> 0 + (0%4) = 0;
Index 1 --> 3 + (2%4)*4 = 11;
Index 2 --> 1 + (3%4)*4 = 13;
Index 3 --> 2 + (1%4)*4 = 6;
So the array become after the line 25 in the above code is A = [0, 11, 13, 6]
Now We just have to divide by size: 
A = [0/4, 11/4, 13/4, 6/4] = [0, 2, 3, 1]
*/
