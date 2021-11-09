package algorithm.swordToOffer.numbers;

/**
 * 不使用除号完成除法
 * Divide without the division sign
 *
 **/
public class Integer_division {
        public int divide(int a, int b) {
            if(a == Integer.MIN_VALUE&& b == -1){
                return Integer.MAX_VALUE;
            }
            boolean flag = false;
            if ((a<0 && b<0) || (a>0 && b>0)) {
                flag = true;
            }

            long dividend = Math.abs((long) a);
            long divisor = Math.abs((long) b);
            if (dividend < divisor) {
                return 0;
            }
            int result = 0;
            int shift = 31;
            while (dividend >= divisor) {
                while (dividend < divisor << shift) {
                    shift--;
                }
                dividend -= divisor << shift;
                result += 1 << shift;
            }

            return flag ? result : -result;
        }
}