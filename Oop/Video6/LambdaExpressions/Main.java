package Oop.Video6.LambdaExpressions;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5));

        list.forEach((item) -> System.out.println(item*2)); //<- lambda function

    }
}
