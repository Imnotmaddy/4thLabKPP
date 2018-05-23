package alifanov.m.model.printers;

public class PrinterA3 extends Printer {

    /**
     * makes printer work
     */
    @Override
    public void print() {
        try {
            setAvailable(false);
            Thread.sleep(500);
            System.out.println("A3 has finished");
            setAvailable(true);
        } catch (InterruptedException e) {
            System.out.println("A3 was interrupted");
            setAvailable(true);
            return;
        }
    }
}
