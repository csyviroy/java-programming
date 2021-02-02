package com.example.hackerrank_question;

import java.util.List;

public class Between_two_sets {

    public static int getTotalX(List<Integer> a, List<Integer> b) {
    // Write your code here
        int f = computeLCM(a);
        System.out.println("The LCM of " + a.toString() + " is " + f);
        int l = computeGCD(b);
        System.out.println("The GCM of " + b.toString() + " is " + l);
        int count = 0;
        for (int i = f, j=2; i<=l; i=f*j, j++){
            System.out.println("l is " + l);
            System.out.println("i is " + i);
            if (l%i == 0){
                System.out.println("count");
                count++;
            }
        }
        return count;
    }
    
    private static int GCD(int a, int b){
        if (a==0){
            return b;
        }
        return GCD(b%a, a);
    }
    
    private static int computeGCD(List<Integer> a){
        int gcdResult = a.get(0);
        for (int i = 1; i < a.size(); i++){
            gcdResult = GCD(gcdResult, a.get(i));
        }
        return gcdResult;
    }
    
    private static int LCM(int a, int b){
        System.out.println("a * b " + a*b);
        System.out.println("GCD(a,b) " + GCD(a,b));
        System.out.println("result: " + a*b/GCD(a,b));
        return a*b/GCD(a,b);
    }

    private static int computeLCM(List<Integer> b){
        int lcmResult = b.get(0);
        for (int i = 1; i < b.size(); i++){
            lcmResult = LCM(lcmResult, b.get(i));
        }
        return lcmResult;
    }
    
}
