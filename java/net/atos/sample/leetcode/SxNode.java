package net.atos.sample.leetcode;

public class SxNode {
	public Object e;
	public SxNode next;
	public SxNode pre;

	public SxNode() {

	}

	public SxNode(Object e) {
		this.e = e;
		next = null;
		pre = null;
	}
}