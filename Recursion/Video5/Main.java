package Recursion.Video5;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println(printSubsequences2(new int[] {1,2,2}));

    }

    //Q1: remove all a's from the string
    public static String removeA(String str1,StringBuffer str2,int idx){

        if(idx==str1.length()) return str2.toString();

        if(str1.charAt(idx)!='a'){
            str2.append(str1.charAt(idx));
        }

        return removeA(str1,str2,idx+1);
    }

    //Q2: skip the particular word from a string
    public static String skipWord(String str,String word){

        if(str.isEmpty()) return "";

        if(str.startsWith(word)) return skipWord(str.substring(word.length()),word);

        return str.charAt(0)+skipWord(str.substring(1),word);
    }

    //Q3: print all subsequences of a string
    public static void printSubsequences(String str1,String str2,int idx){

        if(idx==str1.length()) {
            System.out.print(str2+" ");
            return;
        }

        printSubsequences(str1,str2+str1.charAt(idx),idx+1);
        printSubsequences(str1,str2,idx+1);

    }

    //Q3 with ArrayList<> return type
    public static ArrayList<String> printSubsequences(String str1,String str2,int idx,ArrayList<String> list){

        if(idx==str1.length()){
            list.add(str2);
            return list;
        }

        printSubsequences(str1,str2,idx+1,list);
        printSubsequences(str1,str2+str1.charAt(idx),idx+1,list);

        return list;
    }

    //Q4: print integer subSequences
    public static ArrayList<ArrayList<Integer>> printSubsequences(int arr[]){

        ArrayList<ArrayList<Integer>> list=new ArrayList<>();

        list.add(new ArrayList<>());

        for(int num : arr){

            int idx=list.size();

            for(int i=0;i<idx;i++){

                ArrayList<Integer> temp=new ArrayList<>(list.get(i));
                temp.add(num);

                list.add(temp);

            }

        }
        return list;
    }

    //Q4 handling duplicates
    public static ArrayList<ArrayList<Integer>> printSubsequences2(int arr[]){

        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();

        list.add(new ArrayList<>());

        int start=0;
        int end=0;

        for(int i=0;i<arr.length;i++){

            if(i>0 && arr[i]==arr[i-1]){

                start=end+1;

            }
            end=list.size()-1;
            int size=list.size();

            for(int j=start;j<size;j++){
                ArrayList<Integer> temp=new ArrayList<>(list.get(j));
                temp.add(arr[i]);

                list.add(temp);
            }
        }

        return list;
    }

}
