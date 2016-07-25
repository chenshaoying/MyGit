package com.black.frame.algorithm;

import java.util.Random;

import org.junit.Test;

public class ArraySort {
	
	public static void buppleSort(int[] nums) {
		if(nums == null || nums.length == 0) {
			return;
		}
		/**
		 * 每次子循环都将高位确定，比较次数n(n-1)/2;交换次数n(n-1)/2
		 */
		for (int i = 0; i < nums.length-1; i++) {
			for (int j = 0; j < nums.length-1-i; j++) {
				if(nums[j] > nums[j+1]) {
					int tmp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = tmp;
				}
			}
		}
		return;
	}
	
	public static void selectSort(int[] nums) {
		if(nums == null || nums.length == 0) {
			return;
		}
		
		for (int i = 0; i < nums.length-1; i++) {
			int min = i;
			for ( int j = i+1; j < nums.length; j++) {
				if(nums[j] < nums[min]) {
					min = j;
				}
			}
			if(min != i) {
				int tmp = nums[i];		
				nums[i] = nums[min];
				nums[min] = tmp;				
			}
		}
	}
	
	public static void insertSort(int[] nums) {
		if(nums == null || nums.length == 0) {
			return;
		}
		
		for(int i = 1; i < nums.length; i++) {
			if(nums[i-1] <= nums[i]) {
				continue;
			}
			boolean isBreak = false;
			for(int j = i-1; j > -1; j--) {
				
				if(nums[j] < nums[i]) {
					int tmp = nums[i];
					System.arraycopy(nums, j+1, nums, j+2, i-j-1);
					nums[j+1] = tmp;
					isBreak = true;
					break;
				}
								
			}
			
			if(!isBreak) {
				int tmp = nums[i];
				System.arraycopy(nums, 0, nums, 1, i);
				nums[0] = tmp;
			}
			
			
		}
		
	}
	
	public static void insertSort2(int[] nums) {
		if(nums == null || nums.length == 0) {
			return;
		}
		
		for(int i = 1; i < nums.length; i++) {
			int tmp = nums[i];
			int j = i;
			while(j > 0 && nums[j-1] > tmp) {
				nums[j] = nums[j-1];
				j--;
			}
			nums[j] = tmp;						
		}
		
	}
	
	public static void shellSort(int[] nums) {
		int h = 1;

		while (h <= nums.length / 3) {
			h = 3 * h + 1;
		}

		while (h > 0) {
			for (int i = h; i < nums.length; i++) {
				int tmp = nums[i];
				int j = i;
				while (j > h - 1 && nums[j - h] > tmp) {
					nums[j] = nums[j - h];
					j -= h;
				}
				nums[j] = tmp;
			}
			h = (h - 1) / 3;
		}
	}
	
	public static void mergeSort(int[] nums) {
		
	}
	
	public static void removeDumplicate(int[] nums) {
		
	}
	
	
	
	
	
	public static int[] merge(int[] m, int[] n) {
		int[] mn = new int[m.length + n.length];
		int i = 0;
		int j = 0;
		while(i < m.length && j < n.length) {
			if(m[i] < n[j]) {
				mn[i+j] = m[i];
				i++;
			} else {
				mn[i+j] = n[j];
				j++;
			}
		}
		if(i == m.length) {
			System.arraycopy(n, j, mn, i+j, n.length - j);
		} else {
			System.arraycopy(m, i, mn, i+j, m.length - i);
		}		
		return mn;
	}
	@Test
	public void testMerge() {
		int[] m = gen(3);
		print(m);		
		shellSort(m);
		print(m);
		
		int[] n = gen(5);
		print(n);		
		shellSort(n);
		print(n);
		
		int[] mn = merge(m,n);
		print(mn);
	}
	
	@Test
	public void test1() {
		int[] nums = gen(10);
		print(nums);		
		buppleSort(nums);
		print(nums);
	}
	
	@Test
	public void test2() {
		int[] nums = gen(10);
		print(nums);		
		selectSort(nums);
		print(nums);
	}
	
	@Test
	public void test3() {
		int[] nums = gen(10);
		print(nums);		
		insertSort2(nums);
		print(nums);
	}
	
	@Test 
	public void test4() {
		int[] nums1 = gen(10000);
		int[] nums2 = nums1.clone();
		int[] nums3 = nums1.clone();
		int[] nums4 = nums1.clone();

		long s1 = System.currentTimeMillis();
		buppleSort(nums1);
		System.out.println("--:" + (System.currentTimeMillis()-s1));
		
		long s2 = System.currentTimeMillis();
		selectSort(nums2);
		System.out.println("--:" + (System.currentTimeMillis()-s2));
		
		long s3 = System.currentTimeMillis();
		insertSort(nums3);
		System.out.println("--:" + (System.currentTimeMillis()-s3));

		long s4 = System.currentTimeMillis();
		insertSort(nums4);
		System.out.println("--:" + (System.currentTimeMillis()-s4));
		/*print(nums1);
		print(nums2);
		print(nums3);*/

	}
	
	@Test
	public void test5() {
		int[] nums = gen(10);
		print(nums);		
		shellSort(nums);
		print(nums);
	}
	
	public static int[] gen(int length) {
		int[] nums = new int[length];
		Random r = new Random();
		for (int i = 0; i < length; i++) {
			nums[i] = r.nextInt(10000);
		}
		return nums;
	}
	
	public static void print(int nums[]) {
		StringBuffer sb = new StringBuffer();
		for (int i : nums) {
			sb.append(i + ", ");
		}
		System.out.println(sb.substring(0, sb.length()-1));
	}
	
}
