package alifanov.m.services;

import alifanov.m.model.printers.Printer;
import alifanov.m.model.printers.PrinterA2;
import alifanov.m.model.printers.PrinterA3;
import alifanov.m.model.printers.PrinterA4;

import java.util.List;

public class PrintService {

    private PrinterA2 printerA2;
    private PrinterA3[] printersA3;
    private PrinterA4[] printersA4;

    public PrintService() {
        printerA2 = new PrinterA2();
        printersA3 = new PrinterA3[]{new PrinterA3(), new PrinterA3()};
        printersA4 = new PrinterA4[]{new PrinterA4(), new PrinterA4(), new PrinterA4(), new PrinterA4()};
    }

    public void executeOrder(List<String> pages) {

        for (int i = 0; i < 3; i++) {
            String page = pages.get(i);
            if (page.equals("A2")) {
                if (printerA2.getState().equals(Thread.State.NEW)) {
                    printerA2.start();
                } else {
                    printerA2.run();
                }

            }
            if (page.equals("A3")) {
                PrinterA3 printerA3 = checkA3();
                if (printerA3.getState().equals(Thread.State.NEW)) {
                    printerA3.start();
                } else {
                    printerA3.run();
                }
            }
            if (page.equals("A4")) {
                PrinterA4 printerA4 = checkA4();
                if (printerA4.getState().equals(Thread.State.NEW)) {
                    printerA4.start();
                } else {
                    printerA4.run();
                }
            }
        }
    }

    private PrinterA3 checkA3() {
        for (PrinterA3 printerA3 : printersA3) {
            if (printerA3.getState().equals(Thread.State.NEW)) {
                return printerA3;
            }
        }
        return printersA3[0];
    }

    private PrinterA4 checkA4() {
        for (PrinterA4 printerA4 : printersA4) {
            if (printerA4.getState().equals(Thread.State.NEW)) {
                return printerA4;
            }
        }
        return checkA4();
    }

}
