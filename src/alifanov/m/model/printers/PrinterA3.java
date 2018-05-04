package alifanov.m.model.printers;

public class PrinterA3 extends Printer {
    @Override
    public void print() {
        try {
            Thread.sleep(2000);
            System.out.println("A3 has finished");
        } catch (InterruptedException e) {
            System.out.println("A3 was interrupted");
            return;
        }
    }
}
