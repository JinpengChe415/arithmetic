package arithmetic;
/**
 * Create with Darcula IDEA
 * Description:
 *  求两个数的最大公因数
 * @Author CJP
 * @Date 2020/11/3
 * @Time 15:52
 */
public class GetGreatestCommonDivisorV {
    public static int gcd(int a, int b) {
        if(a == b) {
            return a;
        }
        if((a & 1) == 0 && (b & 1) == 0) {    //a,b均为偶数
            return gcd(a >> 1,b >> 1) << 1;
        }else if((a & 1) == 0 && (b & 1) != 0) {    //a为偶数，b为奇数
            return gcd(a >> 1,b);
        }else if((a & 1) != 0 && (b & 1) == 0) {    //a为奇数，b为偶数
            return gcd(a,b>>1);
        }else {     //a,b均为奇数
            int big = a > b ? a : b;
            int small = a < b ? a : b;
            return gcd(small, big - small);
        }
    }

    public static void main(String[] args) {
        System.out.println(gcd(25,5));
        System.out.println(gcd(10,46));
        System.out.println(gcd(7,14));
        System.out.println(gcd(14,7));
    }
}
