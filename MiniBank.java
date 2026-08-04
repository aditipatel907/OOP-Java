import java.util.Scanner;

record BankInfo(String name, String branch) {}

enum MenuOption {
    OPEN_ACCOUNT,
    DEPOSIT,
    WITHDRAW,
    TRANSFER,
    EXIT
}

public class MiniBank {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BankInfo bank = new BankInfo("MiniBank", "Vadodara");

        System.out.println("==================================");
        System.out.println("Welcome to " + bank.name());
        System.out.println("Branch : " + bank.branch());
        System.out.println("==================================");

        int choice = 0;

        while (choice != 5) {

            System.out.println("\nMENU");
            System.out.println("1. Open Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1 -> {
                    MenuOption option = MenuOption.OPEN_ACCOUNT;
                    System.out.println(option + " - To be implemented in a later lab.");
                }

                case 2 -> {
                    MenuOption option = MenuOption.DEPOSIT;
                    System.out.println(option + " - To be implemented in a later lab.");
                }

                case 3 -> {
                    MenuOption option = MenuOption.WITHDRAW;
                    System.out.println(option + " - To be implemented in a later lab.");
                }

                case 4 -> {
                    MenuOption option = MenuOption.TRANSFER;
                    System.out.println(option + " - To be implemented in a later lab.");
                }

                case 5 -> {
                    MenuOption option = MenuOption.EXIT;
                    System.out.println("Thank you for using " + bank.name() + "!");
                }

                default -> {
                    System.out.println("Invalid choice! Please try again.");
                }
            }
        }

        sc.close();
    }
}