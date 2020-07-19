package net.atos.sample.leetcode;

import java.util.*;

public class LC0001 {

	static class Solution {
		public int[] twoSum(int[] nums, int target) {
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

	public static void main(String args[]) {
		final int[] nums = { 2, 7, 11, 15 };
		final int target = 13;
		int[] ret = new Solution().twoSum(nums, target);
		System.out.println(ret[0] + " " + ret[1]);
	}

}
