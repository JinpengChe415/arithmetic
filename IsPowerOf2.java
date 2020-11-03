package arithmetic;
/**
 * Create with Darcula IDEA
 * Description:
 *
 * @Author CJP
 * @Date 2020/11/3
 * @Time 17:26
 */
public class IsPowerOf2 {
    //时间复杂度为O（log n）
    public static boolean isPowerOf20(int num) {
        int temp = 1;
        while(temp <= num){
            if(temp == num) {
                return true;
            }
            temp = temp << 1 ;
        }
        return false;
    }
    //时间复杂度为O（1)!
    public static boolean isPowerOf2(int num) {
        return (num & (num - 1))== 0;
    }
}
