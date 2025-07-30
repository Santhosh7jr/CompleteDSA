package DataStructures.Strings;
import java.util.*;

class Strings{
    //declaration
    String str;

    public Strings(String str){
        this.str=str;
    }

}

public class Main {

    public static void main(String[] args) {

//        Strings strings=new Strings("hello World!");
//        Strings strings2=new Strings("hello World!");
//
//        String string=new String("hello World!");
//
//        System.out.println(strings.str==strings2.str);
//
//        System.out.println(strings.str==string);
//        System.out.println(strings.str.equals(string));
//
//        String str="hello"+5;
//        System.out.println(str);
//
//        String str2="hello "+Integer.toString(45);
//        System.out.println(str2);
//
//        System.out.println('a'+'b');
//        System.out.println("a"+"b");
//        System.out.println('a'+"b");
//
//        System.out.println((char) ('a'+5));

//        printAtoZ();
//
//        System.out.println("\n"+stringBuilder());

//        stringMethods();


        System.out.println(palindromeString("helleh"));
    }

    public static void printAtoZ(){
        for(int i=0;i<26;i++){
            System.out.print((char) ('a'+i)+" ");
        }
    }

    public static String stringBuilder(){
        StringBuilder strBuilder=new StringBuilder("hello World");

        return strBuilder.toString();
    }

    public static void stringMethods(){

        String string="hello WORLD";
        System.out.println(Arrays.toString(string.toCharArray()));

        System.out.println(string.length());

        System.out.println(string.toLowerCase());

        System.out.println(string.toUpperCase());

        System.out.println(string.indexOf('e'));

        System.out.println(string.charAt(2));

        System.out.println(string.lastIndexOf('l'));

        System.out.println("   hello      ".strip());

        System.out.println(Arrays.toString(string.split(" ")));

    }

    public static boolean palindromeString(String str){

        for(int i=0,j=str.length()-1;i<j;i++,j--){
            if(str.charAt(i)!=str.charAt(j)) return false;
        }

        return true;

    }

}
