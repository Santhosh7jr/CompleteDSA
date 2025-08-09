package Oop.Video5.Interface;

public class Car implements Engine,Media,Brake{
    @Override
    public void brake() {
        System.out.println("break has been applied!");
    }

    @Override
    public void start() {
        System.out.println("starting the car.");
    }

    @Override
    public void stop() {
        System.out.println("stopping the car.");
    }

    @Override
    public void accelerate() {
        System.out.println("applying acceleration!");
    }
}
