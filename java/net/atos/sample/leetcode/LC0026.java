package net.atos.sample.leetcode;

public class LC0026 {

	static class Solution {
		public int removeDuplicates(int[] nums) {
			if (nums == null || nums.length <= 0)
				return 0;
			int slow = 0, quick = 1;
			while (quick < nums.length) {
				if (nums[slow] != nums[quick]) {
					nums[slow + 1] = nums[quick];
					slow++;
				}
				quick++;
			}
			return slow + 1;
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.removeDuplicates(new int[] { 1, 1, 2 })); // 2
		System.out.println(s.removeDuplicates(new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 }));  //5
	}

}
