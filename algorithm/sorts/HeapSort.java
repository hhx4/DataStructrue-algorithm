package algorithm.sorts;

import java.util.Arrays;

/**
 *
 **/
public class HeapSort {
    public static void main(String[] args) {
        int[] nums = new int[]{1,4,2,5,2,5,2,3,1};
        heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static int[] heapSort(int[] arr){
        int len = arr.length;
        //初始化堆，构造一个最大堆,用于进行后续工作，如果堆小了效率较低；
        for(int i = (len/2 - 1);i >= 0;i--){
            heapAdjust(arr,i,len);
        }
        //将堆顶的元素和后面的元素交换，并重新调整堆，即移除一个堆顶元素尝试对新进的元素进行排序；
        for(int i = len - 1;i > 0;i--){
            swap(arr, i,0);
            heapAdjust(arr,0,i);
        }
        return arr;
    }

    public static void heapAdjust(int[] arr,int index,int length){
        int max = index;
        //完全二叉树的左子节点等于父节点下标*2，右子节点等于父节点下标*2+1
        int leftChild = 2*index;
        int rightChild = 2*index + 1;
        //与左右子树比较，尝试向二叉树下方下沉，或者说向数组后面移动；
        if(length > leftChild && arr[max] < arr[leftChild]){
            max = leftChild;
        }
        if(length > rightChild && arr[max] < arr[rightChild]){
            max = rightChild;
        }
        if(max != index){
            swap(arr,index,max);
            heapAdjust(arr,max,length);
        }

    }
    private static void swap(int[] arr, int index,int j) {
        int temp = arr[index];
        arr[index] = arr[j];
        arr[j] = temp;
    }
    /*    public static int[] heapSort(int[] arr, int n) {
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = arr[i];
        }
        //初始化小根堆；
        for (int i = n; i > 0; i--) {
            heapAdjust(num, i, n);
        }

    }

    public static void heapAdjust(int[] arr, int index, int len) {

    }*/
}
