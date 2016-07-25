package com.black.frame.algorithm;

public class BalanceBinaryTree {
	
	public static boolean isBalance(Node node) {
		if(node == null) {
			return true;
		}
		int d = depth(node.left) - depth(node.right);
		return d == 0 || d == 1 || d == -1;
	}
	
	public static int depth(Node node) {
		if(node == null) {
			return 0;
		}
		int left = depth(node.left);
		int right = depth(node.right);
		return (left > right ? left : right) + 1;
	}
	
	
	
	
	
	
	
	
	
	
	private class Node {
		int val;
		Node left;
		Node right;
		public Node(int n) {
			this.val = n;
		}
	}

}
