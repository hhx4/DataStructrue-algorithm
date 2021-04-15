package algorithm.sorts;

/**
 * @description 选择排序
 **/
public class SelectionSort {
    public int[] selectSort(int[] nums){
        //记录最小值的下标
        int min;

        for (int i = 0; i < nums.length-1; i++) {
            min = i;
            //一轮循环找出最小值下标并与前面的互换
            for (int j = i+1; j < nums.length; j++) {
                if(nums[j]<nums[min]){
                    min = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[min];
            nums[min] = temp;
        }
        return nums;
    }
}