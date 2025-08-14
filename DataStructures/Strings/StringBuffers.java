package DataStructures.Strings;
import java.util.*;

public class StringBuffers {

    public static void main(String[] args) {

        /*StringBuffer sb = new StringBuffer();
        sb.append("hello world!");

        String str = sb.toString();

        System.out.println(sb);
        System.out.println(str);*/


        /*StringBuffer sb2 = new StringBuffer("This is string buffer");
        System.out.println(sb2);

        sb2.append(" class");
        System.out.println(sb2);

        sb2.insert(1,"tttt");
        System.out.println(sb2);

        sb2.replace(1,5,"");
        System.out.println(sb2);*/


//        System.out.println(generateRandomStr());


        /*String sentence ="    h   e   l  l  o    !";

        System.out.println(sentence);
        System.out.println(sentence.replaceAll("\\s",""));*/


        String arr = "this is an array";
        System.out.println(Arrays.toString(arr.split(" ")));

    }

    public static String generateRandomStr(){

        StringBuffer sb = new StringBuffer();
        Random random = new Random();

        for(int i=0;i<5;i++){
            int num=65+(int) (26*random.nextFloat());
            sb.append((char) (num));
        }

        return sb.toString();

    }

}


