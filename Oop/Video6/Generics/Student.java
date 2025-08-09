package Oop.Video6.Generics;

public class Student<T,U> {

    T studInfo1;
    U studInfo2;

    public void setStudInfo(T studInfo1,U studInfo2){
        this.studInfo1=studInfo1;
        this.studInfo2=studInfo2;
    }

    public T getStudentInfo1(){
        return this.studInfo1;
    }

    public U getStudentInfo2(){
        return this.studInfo2;
    }

}
