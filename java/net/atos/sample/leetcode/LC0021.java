package net.atos.sample.leetcode;

public class LC0021 {

	/**
	 * Definition for singly-linked list.
	 */
	static class ListNode {
		private int val;
		private ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}

		public String toString() {
			return "" + val + "  ";
		}
	}

	static class Solution {

		public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
			ListNode prehead = new ListNode(-1);

			ListNode prev = prehead;
			while (l1 != null && l2 != null) {
				if (l1.val <= l2.val) {
					prev.next = l1;
					l1 = l1.next;
				} else {
					prev.next = l2;
					l2 = l2.next;
				}
				prev = prev.next;
			}

			// 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
			prev.next = l1 == null ? l2 : l1;

			return prehead.next;
		}

		// 使用递归来解题， 将两个链表头部较小的一个与剩下的元素合并，并返回排好序的链表头，当两条链表中的一条为空时终止递归。
		// 掌握链表数据结构
		// 考虑边界情况 2
		public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
			if (l1 == null)
				return l2;
			if (l2 == null)
				return l1;
			if (l1.val < l2.val) {
				l1.next = mergeTwoLists(l1.next, l2);
				return l1;
			} else {
				l2.next = mergeTwoLists(l1, l2.next);
				return l2;
			}
		}

//		input  1->2->4, 1->3->4
//		output 1->1->2->3->4->4
//		4  
//		4  4  
//		3  4  4  
//		2  3  4  4  
//		1  2  3  4  4  
//		1  1  2  3  4  4  

		public ListNode mergeTwoListsDetail(ListNode l1, ListNode l2) {
			if (l1 == null)
				return output(l2);
			if (l2 == null)
				return output(l1);
			if (l1.val < l2.val) {
				l1.next = mergeTwoListsDetail(l1.next, l2);
				return output(l1);
			} else {
				l2.next = mergeTwoListsDetail(l1, l2.next);
				return output(l2);
			}
		}
	}

	public static void main(String args[]) {

		ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
		// output(l1);
		ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
		// output(l2);
		ListNode all = new Solution().mergeTwoListsDetail(l1, l2);
		// output(all);
	}

	private static ListNode output(ListNode listNode) {
		System.out.print(listNode);
		ListNode temp = listNode.next;
		while (temp != null) {
			System.out.print(temp);
			temp = temp.next;
		}
		System.out.println();
		return listNode;
	}

}
