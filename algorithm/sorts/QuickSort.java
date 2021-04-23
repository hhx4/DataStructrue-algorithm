package algorithm.sorts;

/**
 * @description 快速排序
 **/
public class QuickSort {
    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] nums = {5,1,6,2,5};
        for (int i:quickSort.quickSort(nums)) {
            System.out.println(i);
        }
    }
    //转变参数
    public int[] quickSort(int[] nums) {
        //调用快排方法进行，选择左右两个指针进行操作
        quickSortUtil(nums,0,nums.length-1);
        return nums;
    }
    //实现递归调用
    private void quickSortUtil(int[] nums,int left,int right){
       //找到切割点并递归调用
        if(left<right){
            int pivot = partition(nums, left, right);
            quickSortUtil(nums,left,pivot-1);
            quickSortUtil(nums, pivot, right);
        }
    }
    //基础快排，用于找到每次分组的切割点
    private int partition(int[] nums,int left,int right) {
        //定义分组的中间轴作为基准值
        int mid = (left+right) >>>1;
        int pivot = nums[mid];
        /*
           定义双指针用于交换前后数据并分组，从 i 这边开始向右移动，如果遇到大于基准值的值则与右边 j 位置交换，
           此时从 j 开始向左移动，当遇到比基准值小的与左边 i 位置交换，直到两个指针相遇代表遍历结束
         */
        while (left<=right){
            while(nums[left]<pivot){
                left++;
            }
            while (nums[right]>pivot){
                right--;
            }
            if(left<=right){
                swap(nums,left,right);
                left++;
                right--;
            }
        }
        return left;
    }

    //用于交换数据
    private  void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}