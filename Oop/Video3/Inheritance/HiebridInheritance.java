package Oop.Video3.Inheritance;

public class HiebridInheritance{

    public static class HeibridInheritance1 extends MultilevelInheritance {

        int num;

        public HeibridInheritance1(){
            this.num=10;
        }

        public HeibridInheritance1(int num,double price){
            super(price);
            this.num=num;
        }

    }

    public static class HeibridInheritance2 extends MultilevelInheritance{

        int num;

        public HeibridInheritance2(){
            this.num=10;
        }

        public HeibridInheritance2(int num,double price){
            super(price);
            this.num=num;
        }

    }

}
