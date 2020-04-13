import java.util.*;

public class Solution {

    public static void main(String[] args) {
        int[] nums = {1,6,10,20,2,4,3,7,6,8,11,9,12,14,13,16,15,19,18,17,26,21,22,23,24,25,28,27,29,30};
        Solution solution = new Solution();
        int[] nums1 = solution.findErrorNums(nums);
        for (int i:nums1) {
            System.out.println(i);
        }

    }

    public int[] findErrorNums(int[] nums) {
        int[] result = new int[2];
        Set<Integer> set = new HashSet<>();
        for(int i = 0;i<nums.length;i++){
            if(set.contains(nums[i])){
                result[0] = nums[i];
            }else {
                set.add(nums[i]);
            }
        }
        for(int j =1;j<=nums.length;j++){
            if(!set.contains(j)){
                result[1] = j;
            }
        }
        return result;
    }

}
