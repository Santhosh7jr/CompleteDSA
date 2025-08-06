package Recursion.Video8;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        /*boolean maze[][]={
                {true,true,true,true,true},
                {true,true,false,true,true},
                {true,false,false,false,true},
                {true,true,false,true,true},
                {true,true,true,true,true},
        };

        char path[][]=new char[maze.length][maze[0].length];

        for (int i=0;i<path.length;i++){
            for (int j=0;j<path[i].length;j++){
                if(!maze[i][j]) path[i][j]='#';
                else path[i][j]=' ';
            }
        }

        restrictedMaze(maze,path,0,0);*/

        printAllPaths(
                new boolean[][] {
                        {true,true,true},
                        {true,true,true},
                        {true,true,true}
                },
                "",0,0
        );

    }

    //Q1: finding number of paths from source to destination in a maze
    // we can only travel to the right and to the down
    public static long pathCount(int row,int col){

        if(row==1 || col==1) return 1;

        return pathCount(row-1,col)+pathCount(row,col-1);

    }

    // printing Q1 paths V --> Vertical, H --> Horizontal
    public static void printPaths(String path,int row,int col){

        if(row==1 && col==1){
            System.out.print(path+' ');
            return;
        }

        if (row>1) printPaths(path+'H',row-1,col);

        if(col>1) printPaths(path+'V',row,col-1);

    }

    //Q1 with ArrayList<>() return type
    public static ArrayList<String> returnPaths(ArrayList<String> list,String path,int row,int col){

        if(row==1 && col==1){
            list.add(path);
            return list;
        }

        if (row>1) returnPaths(list,path+'H',row-1,col);

        if(col>1) returnPaths(list,path+'V',row,col-1);

        return list;
    }

    //printing all the paths in array form if . --> path doesn't exist. if x --> path does exist.
    public static void printAllPaths(char path[][],int row,int col){

        if(row==0 && col==0){

            path[row][col]='*';

            for (char[] chars : path) {
                System.out.print("[");
                for (char ch : chars){
                    if(ch!=' '){
                        System.out.print(" x ");
                    }else {
                        System.out.print(" . ");
                    }
                }
                System.out.println("]");
            }

            System.out.println("\n");
            return;
        }

        if (row>0) {
            path[row][col]='*';
            printAllPaths(path,row-1,col);
            path[row][col]=' ';
        }

        if(col>0) {
            path[row][col]='*';
            printAllPaths(path,row,col-1);
            path[row][col]=' ';
        }

    }

    //maze with obstacles. if . --> path doesn't exist, if x --> path does exist and # --> represent obstacle.
    public static void restrictedMaze(boolean maze[][],char path[][],int row,int col){

        if(!maze[row][col]) return;

        if(row==maze.length-1 && col==maze[0].length-1){

            path[row][col]='*';

            for (char[] chars : path) {
                System.out.print("[");
                for (char ch : chars){
                    if(ch=='#'){
                        System.out.print(" # ");
                    }else if(ch!=' '){
                        System.out.print(" x ");
                    }else {
                        System.out.print(" . ");
                    }
                }
                System.out.println("]");
            }

            System.out.println("\n");
            return;
        }

        path[row][col]='*';

        if (row<maze.length-1) {
            restrictedMaze(maze,path,row+1,col);
        }

        if(col<maze[0].length-1) {
            restrictedMaze(maze,path,row,col+1);
        }

        path[row][col]=' ';

    }

    //maze with diagonal option. H --> Horizontal, V --> Vertical and D --> Diagonal.
    public static ArrayList<String> diagonalMaze(ArrayList<String> list,String path,int row,int col){

        if(row==1 && col==1){
            list.add(path);
            return list;
        }

        if (row>1 && col>1) diagonalMaze(list,path+'D',row-1,col-1);

        if (row>1) diagonalMaze(list,path+'H',row-1,col);

        if(col>1) diagonalMaze(list,path+'V',row,col-1);

        return list;
    }

    //maze with all direction movement
    // R --> Right, B --> Bottom, L --> Left and T--> Top
    public static void printAllPaths(boolean maze[][],String path,int row,int col){

        if(!maze[row][col]) return;

        if (row==maze.length-1 && col==maze[0].length-1){

            maze[row][col]=false;

            char arr[][]=new char[maze.length][maze[0].length];
            int idx1=0;
            int idx2=0;

            char ch=path.charAt(0);

            if(ch=='R') arr[0][0]='⇢';
            else arr[0][0]='⇣';

            for(int i=0;i<path.length();i++){

                if(path.charAt(i)=='R'){
                    idx2++;
                    arr[idx1][idx2]='⇢';
                }else if(path.charAt(i)=='B'){
                    idx1++;
                    arr[idx1][idx2]='⇣';
                } else if (path.charAt(i)=='L') {
                    idx2--;
                    arr[idx1][idx2]='⇠';
                }else {
                    idx1--;
                    arr[idx1][idx2]='⇡';
                }

            }

            int x=1;
            System.out.println("Path >> "+path);
            for(char i[] : arr){
                System.out.print("[");
                for (char j : i){

                    if (j!='\u0000'){
                        System.out.print(" "+j+" ");
                    }else {
                        System.out.print(" . ");
                    }

                }
                System.out.println("]");
            }
            System.out.print("\n");

            maze[row][col]=true;

            return;
        }

        maze[row][col]=false;

        if (col<maze[0].length-1){
            printAllPaths(maze,path+'R',row,col+1);
        }

        if (row<maze.length-1){
            printAllPaths(maze,path+'B',row+1,col);
        }

        if (col>0){
            printAllPaths(maze,path+'L',row,col-1);
        }

        if (row>0){
            printAllPaths(maze,path+'T',row-1,col);
        }

        maze[row][col]=true;

    }


}
