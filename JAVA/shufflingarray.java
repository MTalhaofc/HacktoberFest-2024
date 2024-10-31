class Solution {
    public int[] shuffle(int[] nums, int n) {
        int [] a = new int[n];
        int [] b = new int[n];
        for(int i = 0; i<n; i++){
            a[i]=nums[i];
        }
        for(int i = n, j = 0; i<2*n && j<n; i++, j++){
            b[j]=nums[i];
        }
        for(int i = 0, j=0; i<2*n && j<n; i=i+2, j++){
            nums[i] = a[j];
        }
        for(int i = 1, j=0; i<2*n && j<n; i=i+2, j++){
            nums[i] = b[j];
        }
        return nums;

    }
}
