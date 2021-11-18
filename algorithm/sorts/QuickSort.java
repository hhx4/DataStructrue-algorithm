package algorithm.sorts;

import java.util.Random;

/**
 * @description 快速排序
 **/
public class QuickSort {
    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] nums = {5,1,6,2,5};
        for (int i:quickSort.quickSort(nums,0,nums.length-1)) {
            System.out.println(i);
        }
    }
    //转变参数
    public int[] quickSort(int[] nums,int left,int right) {
        // 0个或1个元素的子数组
        if(right<=left){
            return nums;
        }
        //找到基准值移到子数组最左边；
        int pivot= new Random().nextInt(right-left+1)+left;
        swap(nums,left,pivot);

        //新一次的切分点
        int n = partition(nums,left,right);
        // 对第一部分进行递归操作
        quickSort(nums, left, n -1);
        // 对第二部分进行递归操作　　　
        quickSort(nums, n+1,right);
        return nums;
    }
    //基础快排，用于找到每次分组的切割点
    private int partition(int[] nums,int left,int right) {
        int pivot = nums[left];
        int i = left+1;
        for(int j = left+1;j<=right;j++){
            if(nums[j]<pivot){
                swap(nums,i,j);
                i++;
            }
        }
        swap(nums,left,i-1);
        return i-1;
    }

    //用于交换数据
    private  void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}