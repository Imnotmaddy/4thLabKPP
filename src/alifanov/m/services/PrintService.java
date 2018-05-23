package alifanov.m.services;

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
        printersA4 = new PrinterA4[]{new PrinterA4(), new PrinterA4(), new PrinterA4()};
    }

    /**
     *
     * @param pages List of pages containing page format for printing
     */
    public void executeOrder(List<String> pages) {

        for (int i = 0; i < 3; i++) {
            String page = pages.get(i);
            if (page.equals("A2")) {
                PrinterA2 temp = new PrinterA2();
                try {
                    if (printerA2.isAlive()) {
                        printerA2.join();
                    }
                    printerA2 = temp;
                    printerA2.start();
                    continue;

                } catch (InterruptedException e) {
                }
            }
            if (page.equals("A3")) {
                checkA3().start();
            } else if (page.equals("A4")) {
                checkA4().start();
            }
        }
    }

    /**
     * Checks current avalaible printers format A3
     * @return first available printer or the first one
     */
    private PrinterA3 checkA3() {
        for (int i = 0 ; i < printersA3.length ;i++)
        {
            if (!printersA3[i].isAlive()){
                printersA3[i] = new PrinterA3();
                return printersA3[i];
            }
        }
        try {
            printersA3[0].join();
        } catch (InterruptedException e) {
        }
        printersA3[0] = new PrinterA3();
        return printersA3[0];
    }

    /**
     * Checks current avalaible printers format A4
     * @return first available printer or the first one
     */
    private PrinterA4 checkA4() {
        for (int i = 0 ; i < printersA4.length ;i++)
        {
            if (!printersA4[i].isAlive()){
                printersA4[i] = new PrinterA4();
                return printersA4[i];
            }
        }
        try {
            printersA4[0].join();
        } catch (InterruptedException e) {
        }
        printersA4[0] = new PrinterA4();
        return printersA4[0];
    }
}
