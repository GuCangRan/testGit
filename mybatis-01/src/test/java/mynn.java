

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by GuaiWenWo on 2021/2/7 13:36
 */
public class mynn {

    public static void main(String[] args) {
//        int dd= 100_000;
//        System.out.println(dd);
//
//        List<String> strYmd = Arrays.asList("ddd", "ddwww");
//        strYmd.forEach(System.out::println);
        System.out.println(System.currentTimeMillis());
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int i = Runtime.getRuntime().availableProcessors();
        System.out.println(i);
        System.out.println(System.currentTimeMillis());
    }
}
