package alifanov.m.model.printers;

public class PrinterA2 extends Printer {
    @Override
    public void print() {
        try {
                    Thread.sleep(2000);
                    System.out.println("A2 has finished");
        } catch (InterruptedException e) {
            System.out.println("A2 was interrupted");
            return;
        }
    }
}
