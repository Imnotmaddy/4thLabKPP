package alifanov.m.model.printers;

public abstract class Printer extends Thread {


    public abstract void print();

    @Override
    public void run() {
        this.print();
    }

}
