package algorithm.sorts;

/**
 * @description 插入排序
 **/
public class InsertionSort {
    public static void main(String[] args) {
        int[] nums = {1,3,5,2,4};
        for (int i : insertionSort(nums)) {
            System.out.println(i);
        }

    }
    public static int[] insertionSort(int[] nums){
        for (int i = 1; i < nums.length; i++) {
            // 选择要插入的元素
            int key = nums[i];
            int j = i - 1;
            //将插入的元素向左移到自己在有序队列中的位置
            while (j >= 0 && key<nums[j]) {
                nums[j + 1] = nums[j];
                j--;
            }
            // 将待插入的元素插入
            nums[j + 1] = key;
        }
        return nums;
    }
}