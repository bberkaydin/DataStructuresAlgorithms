package Interview.Arrays;

/*
Given an integer array nums, find the contiguous subarray (containing at least one number)
which has the largest sum and return its sum.

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
*/
public class MaxSubArray {

    public int maxSubArray(int[] A) {
        int max = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < A.length; i++) {
            if (sum < 0)
                sum = A[i];
            else
                sum += A[i];
            if (sum > max)
                max = sum;
        }
        return max;
    }

    public int maxSubArrayKadanesAlgorithm(int[] nums) {
        int s = nums[0];
        int cs = s;
        for(int i = 1; i < nums.length; i++){
            cs = Math.max(nums[i], nums[i]+cs);
            s = Math.max(cs, s);
        }
        return s;
    }
}
