package Oop.Video3.Encapsulation;

public class Main {

    private int num;

    public Main(){
        this(10);
    }

    public Main(int num){
        this.num=num;
    }

    public int getNum(){
        return this.num;
    }

    public void setNum(int num){
        this.num=num;
    }

    public static void main(String[] args) {

        Main main = new Main();
        System.out.println(main.getNum());
        main.setNum(50);
        System.out.println(main.getNum());

    }

}
