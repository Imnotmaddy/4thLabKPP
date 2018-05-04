package alifanov.m;

import alifanov.m.model.Client;
import alifanov.m.services.PrintService;

class Main {
    public static void main(String[] args) {

        Client client = new Client();
        PrintService printService = new PrintService();
        printService.executeOrder(client.getOrder());

    }
}