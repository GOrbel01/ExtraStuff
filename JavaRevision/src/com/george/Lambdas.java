package com.george;

import java.util.Optional;
import java.util.function.Predicate;
import com.george.GenericPredOwn;

/**
 * Created by Cloud on 28/05/2015.
 */
public class Lambdas {
    public static void main(String[] args) {
        Predicate<String> predicate = (a) -> a.length() > 4;
        GenericPredOwn<Integer> numPred = (n) -> n < 3;
        PredOwn strPred = (a) -> a.length() > 4;
        String testa = "Testing";
        String testb = "Test";
        int testc = 2;
        System.out.println(predicate.test(testa));
        System.out.println(predicate.test(testb));
        System.out.println(strPred.StringTest(testa));
        System.out.println(numPred.test(testc));
    }
}
