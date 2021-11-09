package algorithm.swordToOffer.numbers;

/**
 * 二进制字符串的加法
 * Given two 01 strings A and B, compute their sum and output it as a binary string.
 * The input is a non-empty string containing only the digits 1 and 0.
 **/
public class BinaryAddition {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length()-1;
        int j = b.length()-1;
        int sum = 0;
        int carry = 0;
        while(i>=0||j>=0){
            //三数相加3,2则追加0且进位为1， 1，0则直接追加。
            int numA = i >= 0 ? a.charAt(i--) - '0' : 0;
            int numB = j >= 0 ? b.charAt(j--) - '0' : 0;
            sum=numA+numB+carry;
            if(sum>=2){
                sb.append(sum-2);
                carry=1;
            }else{
                sb.append(sum);
                carry=0;
            }
        }
        if(carry==1){
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}