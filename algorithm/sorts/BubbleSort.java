package algorithm.sorts;

/**
 * @description 冒泡排序的基本实现
 **/
public class BubbleSort {
    public int[] bubbleSort(int[] nums){
        //记录交换临时值
        int temp;
        //记录交换状态
        boolean flag = false;
        //循环n-1轮，每一轮得出一个最大的值
        for (int i = 0; i < nums.length; i++) {
            flag = false;
            for (int j = 0; j < nums.length-1-i; j++) {
                if(nums[j] > nums[j+1]){
                    temp = nums[j+1];
                    nums[j+1] = nums[j];
                    nums[j] = temp;
                    flag = true;
                }
            }
            //如果未发生交换则跳出循环
            if (!flag){
                break;
            }
        }
        return nums;
    }
}