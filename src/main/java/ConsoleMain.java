import jdk.nashorn.internal.runtime.JSONFunctions;

import java.util.ArrayList;
import java.util.List;
import com.alibaba.fastjson.JSON;

/**
 * Created with IntelliJ IDEA.
 * User: Allen
 * Date: 2019/12/5 0005
 * Time: 14:24
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class ConsoleMain {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Long.MAX_VALUE);
        System.out.println(Math.sqrt(Long.MAX_VALUE));
        System.out.println(Long.MAX_VALUE);
        System.out.println(Math.sqrt(Long.MAX_VALUE));
        Long ii = 310000000L*310000000L;
        Long start = System.currentTimeMillis();
    //    calcNum(9223372036854775783L);
        PrimeNumberList.calcPrimeNumbers(310000000L);
        Long end = System.currentTimeMillis();
        System.out.println("time is " + (end - start) + " ms");
        System.out.println("maxNum "+PrimeNumberList.getMaxNumber());
        System.out.println("primeNum num "+PrimeNumberList.getPrimeNumbers().size());
        System.out.println("rate "+PrimeNumberList.getPrimeNumbers().size() / Double.valueOf(PrimeNumberList.getMaxNumber()));
        Integer size = PrimeNumberList.getPrimeNumbers().size();
        System.out.println("last "+PrimeNumberList.getPrimeNumbers().get(size-1) + " " + PrimeNumberList.getPrimeNumbers().get(size-2) );
       //System.out.println(JSON.toJSONString(PrimeNumberList.getPrimeNumbers()));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Long.MAX_VALUE);
        System.out.println(Math.sqrt(Long.MAX_VALUE));
        System.out.println(Long.MAX_VALUE);
        System.out.println(Math.sqrt(Long.MAX_VALUE));


    }

   public static  void calcNum(Long l){
        Long temp = l;
       Long num = 0L;
        List<Long> factors = new ArrayList<>();
        boolean endFlag = false;
        while(!endFlag) {
            endFlag = true;
            for (long i = 2; i < Math.sqrt(temp) + 1; i++) {
                num++;
                if (temp % i == 0) {
                    factors.add(i);
                    temp = temp / i;
                    endFlag = false;
                    break;
                }
            }
        }
       factors.add(temp);
       System.out.print(l+"=");
       for (Long f:
            factors) {
           System.out.print(f+"*");
       }
       System.out.println("1");
       System.out.println("Number is"+num);

   }
}
