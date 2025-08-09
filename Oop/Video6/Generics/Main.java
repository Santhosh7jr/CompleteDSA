package Oop.Video6.Generics;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        /*Product<Integer> product1=new Product<>();
        product1.setItem(20);
        System.out.println(product1.getItem()+"\n");

        Product<String> product2 = new Product<>();
        product2.setItem("Apple");
        System.out.println(product2.getItem()+"\n");

        Product<Integer>[] products = new Product[10];

        for (int i=0;i<10;i++){
            products[i]=new Product<>();
            products[i].setItem(i*i);
            System.out.print(products[i].getItem()+" ");
        }*/

        Student<String,Double> student = new Student<>();
        student.setStudInfo("kunal",99.9);

        System.out.println("name: "+student.getStudentInfo1()+" Percentage: "+student.getStudentInfo2());
    }

}
