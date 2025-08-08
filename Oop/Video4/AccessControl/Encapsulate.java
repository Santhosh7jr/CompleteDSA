package Oop.Video4.AccessControl;

public class Encapsulate {

    private int[] arr;
    private int size;

    public Encapsulate(){
        this(10);
    }

    public Encapsulate(int size){
        this.size=size;
        this.arr=new int[size];
    }

    public void setSize(int size){
        this.size=size;
    }

    public int getSize(){
        return size;
    }

}
