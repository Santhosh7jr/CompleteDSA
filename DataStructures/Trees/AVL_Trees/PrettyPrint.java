package DataStructures.Trees.AVL_Trees;
import java.util.*;

public class PrettyPrint<T> {

    public void prettyPrint(List<List<T>> list) {

        int num = list.size()-1;
        int size=num+1;

        for(int i=0;i<size;i++){

            for(int j=0;j<Math.pow(2,num)-1;j++){

                System.out.print("   ");

            }

            for(int j=0;j<list.get(i).size();j++){

                if(j==list.get(i).size()-1) {

                    if (list.get(i).get(j) == null) System.out.print(" X ");
                    else System.out.print(" "+list.get(i).get(j)+" ");
                    break;

                }

                if (list.get(i).get(j) == null) System.out.print(" X ");
                else System.out.print(" "+list.get(i).get(j)+" ");

                for(int k=0;k<Math.pow(2,num+1)-1;k++){

                    System.out.print("   ");

                }

            }

            System.out.println("\n\n");
            num--;

        }

    }
}