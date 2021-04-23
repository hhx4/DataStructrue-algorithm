package algorithm.sorts;

/**
 * @description 归并
 **/
public class MergeSort {
    public static void main(String[] args) {
        MergeSort mergeSort =new MergeSort();
        int[] nums = {1,2,2,4,2,4,2};
        int[] ints = mergeSort.mergeSort(nums);
        for (int i :
                ints) {
            System.out.println(i);
        }

    }
    public int[] mergeSort(int[] nums) {
        doSort(nums,0,nums.length - 1);
        return nums;
    }
    public void doSort(int[] nums, int left, int right) {
        if (left < right) {
        int mid = left+(right-left) / 2;
            doSort(nums,left,mid);
            doSort(nums,mid+1,right);
            merge(nums,left,mid,right);
        }
    }

    private void merge(int[] nums, int left, int mid, int right) {

    }
}