package com.black.frame.algorithm;

import java.util.ArrayList;

import org.junit.Test;

public class BinaryTree {
	private class Node {
		int val;
		Node left;
		Node right;
		public Node(int n) {
			this.val = n;
		}
	}
	
	private Node root;
	private int size;
	
	public BinaryTree() {
		this.root = null;
		this.size = 0;
	}
	
	public int size() {
		return size;
	}
	
	public void insert(int n) {
		if(root == null) {
			root = new Node(n);
			size++;
		} else {
			if (insert(root, n)) {
				size++;
			}
		}
	}
	
	private boolean insert(Node node, int n) {
		if(node.val < n ) {
			if (node.right == null) {
				node.right = new Node(n);	
				return true;
			} else {
				return insert(node.right, n);
			}
		} else if (node.val > n) {
			if (node.left == null) {
				node.left = new Node(n);
				return true;
			} else {
				return insert(node.left, n);
			}
		} else {
			return false;
		} 
	}
	
	public int min() {
		if(size() == 0) {
			return -1;
		}
		Node cur = root;
		while(cur.left != null) {
			cur = cur.left;
		}
		return cur.val;
	}
	
	public int max() {
		if(size() == 0) {
			return -1;
		}
		Node cur = root;
		while(cur.right != null) {
			cur = cur.right;
		}
		return cur.val;
	}
	
	public int depth() {
		return depth(root);
	}
	
	private int depth(Node node) {
		if(node == null) {
			return 0;
		}
		int left = depth(node.left);
		int right = depth(node.right);
		
		return (left > right ? left : right) + 1;
	}
	
	
	public boolean contains(int n) {
		return contains(root, n);
	}
	
	private boolean contains(Node node, int n) {
		if(node == null) {
			return false;
		}
		if(node.val == n) {
			return true;
		} else if (node.val > n) {
			return contains(node.left, n);
		} else {
			return contains(node.right, n);
		}	
	}
	
	public boolean remove(int n) {
		/*if(node == null) {
			return false;
		}
		if(node.val == n) {
			return true;
		} else if (node.val > n) {
			return contains(node.left, n);
		} else {
			return contains(node.right, n);
		}*/
		return false;
	}
	
	
	public int[] toArray() {
		int[] nums = new int[size];
		toArray(nums, root, 0);
		return nums;
	}
	
	private int toArray(int[] nums, Node node, int idx) {
		if(node == null) {
			return idx;
		}
		
		if(node.left != null) {
			idx = toArray(nums, node.left, idx);
		} 
		nums[idx++] = node.val;
		
		if(node.right != null) {
			idx = toArray(nums, node.right, idx++);
		} 
		return idx;
	}
	
	public void midOrder() {
		midOrder(root);
	}
	
	//中序遍历
	private void midOrder(Node node) {
		if(node == null) {
			return;
		}
		
		if(node.left != null) {
			midOrder(node.left);
		} 
		System.out.println(node.val);
		
		if(node.right != null) {
			midOrder(node.right);
		} 
	}
	
	public void preOrder() {
		preOrder(root);
	}
	
	private void preOrder(Node node) {
		if(node == null) {
			return;
		}
		
		System.out.println(node.val);
		
		preOrder(node.left);
		preOrder(node.right);
	}
	
	public void levelOrder() {
		levelOrder(root);		
	}
	
	private void levelOrder(Node node){
        if(node==null){
            return;
        }
        ArrayList<Node> list = new ArrayList<Node>();//使用了List的动态扩展
        list.add(node);
        int cur = 0;
        int last = 1;
        //cur小于list.size()时，说明当前层尚未被访问.因此，依次访问cur到last直接的所有节点
        //并依次将被访问节点的左右子节点压入list
        //cur==last，说明该层已被访问完，此时数组中还有未被访问到的节点，
        while(cur < list.size()){        
            last = list.size();//记录了当前层最后一个节点的位置。           
            while(cur < last){           
                //当当前节点序号小于list中最后一个节点序号时，就输出当前的节点，并把左右节点插入到list中
                System.out.print(list.get(cur).val+" ");
                if(list.get(cur).left != null){
                    list.add(list.get(cur).left);
                }
                if(list.get(cur).right != null){
                    list.add(list.get(cur).right);
                }
                cur++;//当前节点遍历完，沿list顺序后移。
            }
        }
         
    }
	
	public void reverse() {
		reverseBinaryTree(root);
	}
	
	private Node reverseBinaryTree(Node node) {
		if(node == null || (node.left == null && node.right == null)) {
			return node;
		}
		Node tmp = node.left;
		node.left = node.right;
		node.right = tmp;
		reverseBinaryTree(node.left);
		reverseBinaryTree(node.right);
		return node;	
	}
	@Test
	public void test1() {
		BinaryTree tree = new BinaryTree();
		int[] test = {5, 3, 4, 2, 6, 8, 7};
		for(int i = 0; i < test.length; i++) {
			tree.insert(test[i]);
		}
		//System.out.println(tree.size + ":" + tree.min() +":" + tree.max());
		tree.midOrder();
		int[] nums = tree.toArray();
		for(int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]);
		}
		
		System.out.println(tree.contains(10) + ":" + tree.contains(9));
		
		System.out.println(tree.depth());
	}
	
	@Test
	public void test2() {
		BinaryTree tree = new BinaryTree();
		int[] test = {5, 3, 4, 2,7,6,8};
		for(int i = 0; i < test.length; i++) {
			tree.insert(test[i]);
		}
		System.out.println(tree.depth());

	}
	
	@Test
	public void test3() {
		BinaryTree tree = new BinaryTree();
		int[] test = {5, 3, 4, 2,1,7,6,8};
		for(int i = 0; i < test.length; i++) {
			tree.insert(test[i]);
		}
		tree.preOrder();
	}
	
	@Test
	public void test4() {
		/**
		 *             5
		 *          3     7
		 *        2   4  6  8
		 *       1 
		 */
		BinaryTree tree = new BinaryTree();
		int[] test = {5, 3, 4, 2,1,7,6,8};
		for(int i = 0; i < test.length; i++) {
			tree.insert(test[i]);
		}
		tree.levelOrder();
	}
	
	@Test
	public void test5() {
		/**
		 *             5
		 *          3     7
		 *        2   4  6  8
		 *       1 
		 */
		BinaryTree tree = new BinaryTree();
		int[] test = {5, 3, 4, 2,1,7,6,8};
		for(int i = 0; i < test.length; i++) {
			tree.insert(test[i]);
		}
		tree.reverse();
		tree.levelOrder();
	}
	
	
}
