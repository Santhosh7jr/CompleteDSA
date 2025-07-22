package DataStructures.Arrays;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(reverseArr(new int[] {1,2,34,4,6,7,8,9,0})));

    }

    //store 5 roll numbers
    public static int[] storeRollNumbers(){

        Scanner scanner=new Scanner(System.in);

        int rollNos[]=new int[5];

        for(int i=0;i<rollNos.length;i++){
            rollNos[i]=scanner.nextInt();
        }

        return rollNos;

    }

    //for-each loop ( traverse the entire array )
    public static void traverseArr(int arr[]){
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println(" ");
    }

    //toString method to print the array
    public static String printArr(int arr[]){
        return Arrays.toString(arr);
    }

    //Array of objects
    public static String[] objectArray(){
        String arr[]=new String[5];
        Scanner scanner=new Scanner(System.in);

        for(int i=0;i<arr.length;i++){
            arr[i]=scanner.next();
        }

        return arr;
    }

    //multi-dimensional Arrays
    public static int[][] multDimArr(){
        int arr[][]=new int[5][5];
        Scanner scanner=new Scanner(System.in);

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                arr[i][j]=scanner.nextInt();
            }
        }

        return arr;

    }

    //Dynamic Arrays
    public static ArrayList<Integer> dynamicArrays(){
        ArrayList<Integer> arr=new ArrayList<>();
        Scanner scanner=new Scanner(System.in);

        for(int i=0;i<5;i++){
            arr.add(scanner.nextInt());
        }

        return arr;
    }

    //swapping numbers
    public static int[] swap(int arr[],int idx1,int idx2){
        int temp=arr[idx1];
        arr[idx1]=arr[idx2];
        arr[idx2]=temp;

        return arr;
    }

    //maximum value in an array
    public static int findMax(int arr[]){
        if(arr.length==0) return -1;

        int max=arr[0];

        for(int i=1;i<arr.length;i++){
            if(arr[i]>max) max=arr[i];
        }

        return max;

    }

    //reversing an array
    public static int[] reverseArr(int arr[]){
        for(int i=0,j=arr.length-1;i<j;i++,j--){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
        }

        return arr;
    }

}
