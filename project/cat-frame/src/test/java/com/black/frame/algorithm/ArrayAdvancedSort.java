package com.black.frame.algorithm;

import java.util.Random;

import org.junit.Test;

public class ArrayAdvancedSort {
	
	public static int partition(int[] nums, int left, int right, long pivot) {
		
		int leftPtr = left - 1;
		int rightPtr = right + 1;
		
		while(true) {
			while(leftPtr < right && nums[++leftPtr] < pivot) {
				
			}
			while(rightPtr > left && nums[--rightPtr] > pivot) {
				
			}
			if(leftPtr >= rightPtr) {
				break;			
			} else {
				swap(nums, leftPtr, rightPtr);				
			}
		}
		
		return leftPtr;
	}
	
	public static void swap(int[] nums, int leftPtr, int rightPtr) {
		int tmp = nums[leftPtr];
		nums[leftPtr] = nums[rightPtr];
		nums[rightPtr] = tmp;
	}
	
	@Test
	public void testPartition() {
		int[] nums = {5,6,7,8,9,1,2,3,4};
		System.out.println(partition(nums, 0, nums.length-1, 5));
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
	
	public static void quickSort(int[] nums, int left, int right) {
		if(left >= right) {
			return;
		} else {
			long pivot = nums[right];
			int partition = partitionIt(nums, left, right, pivot);
			quickSort(nums,left,partition-1);
			quickSort(nums,partition+1,right);
		}
	}
	
	//
	private static int partitionIt(int[] nums, int left, int right, long pivot) {
		
		int leftPtr = left - 1;
		int rightPtr = right;            //从倒数第二位开始向左移动，将最后一位作为pivot
		
		while(true) {
			while(nums[++leftPtr] < pivot) { //由于pivot总是最后一个值，因此不会越界
				
			}
			while(rightPtr > 0 && nums[--rightPtr] > pivot) { //
				
			}
			if(leftPtr >= rightPtr) {
				break;			
			} else {
				swap(nums, leftPtr, rightPtr);				
			}
		}		
		swap(nums,leftPtr,right); //次数leftPtr停止在pivot应该处于的位置，因此交换两边数据
		return leftPtr;
	}
	
	public void qkshort(int[] nums) {
		
	}
	@Test
	public void testQuickSort() {
		int[] nums = {5,6,7,8,9,1,2,3,4};
		quickSort(nums,0,nums.length-1);
		print(nums);
		
	}
	@Test
	public void testPartitionIt() {
		int[] nums = {5,6,7,8,9,1,2,3,4};
		quickSort(nums,0,nums.length-1);
		print(nums);
		
	}
	
	
	@Test
	public void test11() {
		System.out.println(5/2);
	}
	protected class ProtectClass {
		
	}
}

