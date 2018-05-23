package alifanov.m.model.printers;

public abstract class Printer extends Thread {

    protected boolean isAvailable;

    public Printer() {
        isAvailable = true;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public abstract void print();

    @Override
    public void run() {
        this.print();
    }

}
