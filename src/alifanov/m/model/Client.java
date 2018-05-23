package alifanov.m.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Client {
    private List<String> order;
    private static final Random random = new Random();

    public Client() {
        this.order = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            this.order.add(selectPageFormat(
                    random.nextInt(3)
            ));
        }
    }

    /**
     * creates an element for Client order
     * @param choice number of the element
     * @return randomly selected Page format
     */
    private String selectPageFormat(int choice) {
        if (choice == 0) return "A2";
        if (choice == 1) return "A3";
        if (choice == 2) return "A4";
        return null;
    }

    public List<String> getOrder() {
        return order;
    }
}
