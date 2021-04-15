package DataStructrues.sparseArray;

/**
 * @author hw
 * @program mine learn
 * @description 稀疏数组
 * @create 2021-04-06 15:39
 **/
public class SparseArray {
    public static int[][] sparseArr(int[][] start){
        //先遍历二维数组
        int sum = 0;
        for (int[] ints : start) {
            for (int anInt : ints) {
                if (anInt != 0) {
                    sum++;
                }
            }
        }
        //创建稀疏数组
        int[][] sparseArr =new int[sum+1][3];
        //赋予第一行的基准值
        sparseArr[0][0] = start.length;
        sparseArr[0][1] = start[0].length;
        sparseArr[0][3] = sum;
//        再次遍历二维数组，存储非0值
        int count = 0;
        for (int i = 0; i < start.length; i++) {
            for (int j = 0; j < start[i].length; j++) {
                if (start[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = start[i][j];
                }
            }
        }
        return sparseArr;
    }
    public static int[][] unSparseArray(int[][] sparseArray){
        //先读取第一行数据并新建二维数组
        int[][] before = new int[sparseArray[0][0]][sparseArray[0][1]];
        //读取后几行的数据并赋值
        for (int[] ints : sparseArray) {
            before[ints[0]][ints[1]] = ints[2];
        }
        return before;
    }
}