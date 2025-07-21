package Basics.Math.M2;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println(findLCM(5,6));

    }

    //Question1: checking whether the number is prime or not.
    public static boolean isPrime(int n){
        for(int i=2;i*i<=n;i++){
            if(n%i==0) return false;
        }
        return true;
    }

    //Question2: find all the prime numbers comes between 1 and n.
    public static List<Integer> findAllPrimes(int n){

        int arr[]=new int[n+1];

        for(int i=0;i<=n;i++) arr[i]=i;

        for(int i=2;i*i<=n;i++){

            for(int j=i*i;j<=n;j+=i){
                if(arr[j]!=0) arr[j]=0;
            }

        }

        List<Integer> list=new ArrayList<>();

        for(int i=2;i<=n;i++){
            if(arr[i]!=0) list.add(arr[i]);
        }
        return list;
    }

    //Question3: finding Square-Root of a number.
    public static double findSquareRoot(double n){
        double start=1;
        double end=n;
        double mid=0;

        while(mid*mid!=n){

            if(countDigits(mid)>10) return mid;

            mid=(start+end)/2;
            if(mid*mid>n) end=mid-1;
            else start=mid+1;
        }
        return mid;
    }

    //counting decimal digits
    public static int countDigits(double d){
        String text=Double.toString(d);

        if(text.contains(".")) return text.length()-text.indexOf('.')-1;
        return 0;
    }

    //Question4: divisors of a number.
    public static List<Integer> allDivisorsOfn(int n){

        List<Integer> list=new ArrayList<>();

        for(int i=1;i<=(n/2);i++){
            if(n%i==0) list.add(i);
        }

        list.add(n);

        return list;

    }

    //Question4: divisors of a number (Optimal solution).
    public static List<Integer> allDivisorsOfn2(int n){

        List<Integer> list=new ArrayList<>();

        for(int i=1;i<=Math.sqrt(n);i++){
            if(n%i==0) {
                list.add(i);
                list.add(n/i);
            }
        }

        Collections.sort(list);

        return list;

    }

    //finding all the prime factors
    public static List<Integer> findAllPrimeFactorsOfn(int n){
        List<Integer> list=new ArrayList<>();

        int factor=2;

        while(factor<=n){
            if(n%factor==0){
                list.add(factor);
                n/=factor;
            }else {
                factor++;
            }
        }

        return list;

    }

    //Question5: finding GCD of two numbers (a and b)
    public static int findGCD(int a,int b){
        while (a!=0){
            int rem=b%a;
            b=a;
            a=rem;
        }
        return b;
    }

    //Question6: finding LCM of two numbers
    public static int findLCM(int a,int b){
        return (a*b)/findGCD(a,b);
    }

}
