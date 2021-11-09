package algorithm.swordToOffer.numbers;

/**
 * 二进制数中1的个数；
 * Given a non-negative integer n,
 * count the number of 1s in the binary representation of each number between 0 and n and output an array.
 **/
public class BitCount {
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        for(int i=0;i<=n;i++){
            //对于一个二进制数来说，每次扩大二倍时1的数量1是不变的； 1-》10-》100-》1000  1，2，4，8，16；
            res[i]=res[i>>1] + (i%2);
        }
        return res;
    }
}