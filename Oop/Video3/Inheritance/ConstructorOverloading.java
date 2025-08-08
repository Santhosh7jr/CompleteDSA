package Oop.Video3.Inheritance;

public class ConstructorOverloading {

    int length;
    int width;
    int height;
    int weight=20;

    public ConstructorOverloading(){
        this(-1,-1,-1);
    }

    public ConstructorOverloading(int side){
        this.length=side;
        this.width=side;
        this.height=side;
    }

    public ConstructorOverloading(int length,int width,int height){
        this.length=length;
        this.width=width;
        this.height=height;
    }

    public ConstructorOverloading(ConstructorOverloading object){
        this.height=object.height;
        this.width=object.width;
        this.length=object.length;
    }

}
