package Oop.Video6.Generics;

public class Product<T> {

    T item;

    public void setItem(T item){
        this.item=item;
    }

    public T getItem(){
        return this.item;
    }

}
