package alifanov.m.model.printers;

public class PrinterA4 extends Printer {
    @Override
    public void print() {
        try {
            Thread.sleep(2000);
            System.out.println("A4 has finished");
        } catch (InterruptedException e) {
            System.out.println("A4 was interrupted");
            return;
        }
    }
}
