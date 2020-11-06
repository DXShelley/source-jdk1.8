package demo.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class twoSum {

    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {

        List<Integer> sums = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j || sums.contains(i + j)) {
                    break;

                }
                if ((nums[i] + nums[j] == target)) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[2];
    }

    public int[] twoSum2(int[] nums, int target) {

        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                return new int[]{hashMap.get(target - nums[i]), i};

            } else {
                hashMap.put(nums[i], i);
            }
        }
        return new int[]{};
    }

}
