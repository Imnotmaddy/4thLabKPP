package alifanov.m.model.printers;

public class PrinterA4 extends Printer {

    /**
     * makes printer work
     */
    @Override
    public void print() {
        try {
            setAvailable(false);
            Thread.sleep(500);
            System.out.println("A4 has finished");
            setAvailable(true);
        } catch (InterruptedException e) {
            System.out.println("A4 was interrupted");
            return;
        }
    }
}
