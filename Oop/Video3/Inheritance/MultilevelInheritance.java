package Oop.Video3.Inheritance;

public class MultilevelInheritance extends SingleInheritance {

    double price;

    public MultilevelInheritance(){
        this.price=1000;
    }

    public MultilevelInheritance(double price){
        this.price=price;
    }

    public MultilevelInheritance(double price,int weight){
        super(weight);
        this.price=price;
    }

    public MultilevelInheritance(int length,int width,int height,int weight,double price){
        super(length,width,height,weight);
    }

}
