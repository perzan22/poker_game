package org.perzan22.pokergame.ui.console;

import org.perzan22.pokergame.ui.UserInterface;

import java.util.Scanner;

public class ConsoleUI implements UserInterface {

    static Scanner scanner = new Scanner(System.in);

    @Override
    public int[] getUserDecision() {
        System.out.println("Choose your actionType:\n1. Call/Check\n2. Raise/Bet\n3. All in\n4. Fold\n");
        int choice = scanner.nextInt();
        int amount = 0;
        if (choice == 2) {
            System.out.println("Enter amount to raise/bet:");
            amount = scanner.nextInt();
        }
        return new int[]{choice, amount};
    }

}
