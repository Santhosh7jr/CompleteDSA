package Oop.Video3.Inheritance;

public class SingleInheritance extends ConstructorOverloading {

    int weight;

    public SingleInheritance(){
        this.weight=-1;
    }

    public SingleInheritance(int weight){
        this.weight=weight;
    }

    public SingleInheritance(int length,int width,int height,int weight){
        super(length,width,height);
        this.weight=weight;
//        super(length,width,height); <-- ERROR: have to initialize before initializing thw child class variables
        System.out.println(this.weight+" "+super.weight);
    }

}
