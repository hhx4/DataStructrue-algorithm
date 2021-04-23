package algorithm.serach;

/**
 * @description 插值查找
 **/
public class InsertValueSearch {
    public int find(int array[], int key) {
        int start = 0, end = (array.length - 1);

        while (start <= end && key >= array[start] && key <= array[end]) {
            //和二分查找相似，将mid值替换为pos如下的值
            int pos = start + (((end - start) / (array[end] - array[start])) * (key - array[start]));

            if (array[pos] == key) {
                return pos;
            }
            if (array[pos] < key) {
                start = pos + 1;
            } else {
                end = pos - 1;
            }
        }
        return -1;
    }
}