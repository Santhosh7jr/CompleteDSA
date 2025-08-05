package Recursion.Video6;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        permutation("abc","");

    }

    //Q: print permutations of a string
    public static void permutation(String src,String dest){

        if(src.isEmpty()){
            System.out.print(dest+" ");
            return;
        }

        char ch=src.charAt(0);

        for (int i=0;i<=dest.length();i++){

            permutation(src.substring(1),dest.substring(0,i)+ch+dest.substring(i));

        }

    }

    //Q: permutations with ArrayList<>() return type
    public static ArrayList<String> permutation(String src,String dest,ArrayList<String> list){

        if(src.isEmpty()){
            list.add(dest);
            return list;
        }

        char ch=src.charAt(0);

        for (int i=0;i<=dest.length();i++){

            permutation(src.substring(1),dest.substring(0,i)+ch+dest.substring(i),list);

        }
        return list;
    }

    public static int permutationCount(String src,String dest){

        if(src.isEmpty()){
            return 1;
        }

        int count=0;
        char ch=src.charAt(0);

        for (int i=0;i<=dest.length();i++){

            count+=permutationCount(src.substring(1),dest.substring(0,i)+ch+dest.substring(i));

        }

        return count;
    }

}
