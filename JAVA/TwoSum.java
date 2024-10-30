// A Program to solve the First Question of LEETCODE i.e TWOSUM

class Solution {
    public int[] twoSum(int[] arr, int target) {// arr variables refers to the array that we have inputed.
        //target variable is referring to the target sum for which we have to check 2 indexes of the array such that both the indexes be different.
        int[] ans = new int[2];
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    ans = new int[]{i,j};
                }
            }
        }
        return  ans;
        
    }
}
