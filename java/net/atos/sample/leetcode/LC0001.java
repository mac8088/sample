package net.atos.sample.leetcode;

import java.util.*;

public class LC0001 {

	static class Solution {
		public int[] twoSumForUnsorted(int[] nums, int target) {
			int[] ret = { -1, -1 };
			Map<Integer, Integer> map = new HashMap<>();
			for (int i = 0; i < nums.length; i++) {
				final int diff = target - nums[i];
				if (map.containsKey(diff)) {
					ret[0] = map.get(diff);
					ret[1] = i;
				}
				map.put(nums[i], i);
			}
			return ret;
		}
	}

	// sorted time: O(n)  space: O(1)
	public int[] twoSumForSorted(int[] nums, int target) {
		if (nums == null || nums.length <= 1) return new int[2];
//		Arrays.sort(nums);  // O(log n)
		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			int sum = nums[left] + nums[right];
			if (sum < target) {
				left++;
			} else if (sum > target) {
				right--;
			} else {
				return new int[] { left, right };
			}
		}
		return new int[2];
	}

	public static void main(String args[]) {
		final int[] nums = { 2, 7, 11, 15 };
		final int target = 13;
		int[] ret = new Solution().twoSumForUnsorted(nums, target);
		System.out.println(ret[0] + " " + ret[1]);
	}

}
