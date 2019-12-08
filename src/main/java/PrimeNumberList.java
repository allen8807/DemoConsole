import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Allen
 * Date: 2019/12/5 0005
 * Time: 14:27
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class PrimeNumberList {
    private static Long mMaxNumber = 2L;//该质数列表为该数字以下的质数
    private static List<Long> mPrimeNumbers = new ArrayList<>();

    static {
        mPrimeNumbers.add(2L);
    }

    //为防止并发，这里加同步锁
    public synchronized static List<Long> calcPrimeNumbers(Long maxNumber) {
        List<Long> primeNumbers = new ArrayList<>();
        //如果小于已经计算的值
        if (maxNumber <= mMaxNumber) {
            for (Long p :
                    mPrimeNumbers) {
                if (p < maxNumber) {
                    primeNumbers.add(p);
                }
            }
            return primeNumbers;
        }
        //如果不小于则计算，从已经有的数字开始计算
        for (Long i = mMaxNumber; i <= maxNumber; i++) {
            boolean res = checkPrimeNumberWhenCalc(i);
            if (res) {
                mPrimeNumbers.add(i);
//                System.out.print(i);
//                System.out.println(" the " + mPrimeNumbers.size()+"th");
            }
        }
        //更新静态变量
        mMaxNumber = maxNumber;
        return primeNumbers;
    }

    private static boolean checkPrimeNumberWhenCalc(Long num) {
        boolean res = true;
        for (Long p :
                mPrimeNumbers) {
            if (p > (Math.sqrt(num) + 1)) {
                break;
            }
            if (num % p == 0) {
                res = false;
                break;
            }
        }
        return res;
    }

    public static Long getMaxNumber() {
        Long maxNumber = mMaxNumber;
        return maxNumber;
    }

    public static List<Long> getPrimeNumbers() {
        List<Long> primeNumbers = new ArrayList<>();
        primeNumbers.addAll(mPrimeNumbers);
        return primeNumbers;
    }
}
