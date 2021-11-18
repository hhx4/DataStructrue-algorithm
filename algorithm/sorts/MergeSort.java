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
        int i = left;
        int j = mid+1;
        int len = right-left+1;
        int[] temp = new int[len];
        int k = 0;
        //合并数组
        while (i <= mid && j <= right) {
            if (nums[i]<nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        //如果左右子数组没有合并完成
        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        while (j <= right) {
            temp[k++] = nums[j++];
        }

        System.arraycopy(temp, 0, nums, left, len);

    }
}