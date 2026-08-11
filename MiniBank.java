import java.util.Scanner;

record BankInfo(String name, String branch) {}

enum MenuOption {
    OPEN_ACCOUNT,
    DEPOSIT,
    WITHDRAW,
    TRANSFER,
    EXIT
}

class Customer {

    private String name;
    private String email;
    private String mobile;
    private final String customerId;
    private Address address;
    private static long customerCounter = 101;

    private static String generateCustomerId() {
        return "CUST" + customerCounter++;
    }

    public Customer(String name, String email, String mobile) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.customerId = generateCustomerId();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void Cloneable(){
        Customer clonedCust = new Customer(this.name, this.email, this.mobile);
    }
    
    public static class Address{
        String line;
        String city;
        String pincode;

        String getLine() {
            return line;
        }

        String getCity() {
            return city;
        }

        String getPincode() {
            return pincode;
        }
    }
    public String getAddress() {
        if (address != null) {
            return address.getLine() + ", " + address.getCity() + " - " + address.getPincode();
        }
        return "Address not set";
    }
}

class Account {

    private final String accNum;
    private String owner;
    private long balance;
    private boolean active;

    private static int accCount = 1;

    private static String generateAccountNumber() {
        return String.format("AC%04d", accCount++);
    }

    public Account(String ownerName, long openingBalance) {
        this.accNum = generateAccountNumber();
        this.owner = ownerName;
        this.balance = openingBalance;
        this.active = true;
    }

    public Account(String ownerName) {
        this(ownerName, 0);
    }

    public void deposit(long amount) {
        balance += amount;
    }

    public boolean withdraw(long amount) {

        if (balance >= amount) {
            balance -= amount;
            return true;
        }

        return false;
    }

    public String getAccountNumber() {
        return accNum;
    }

    public String getOwnerName() {
        return owner;
    }

    public long getBalance() {
        return balance;
    }

    public boolean isActive() {
        return active;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accNum + '\'' +
                ", ownerName='" + owner  + '\'' +
                ", balance=" + balance +
                ", active=" + active +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Account account = (Account) obj;

        return accNum.equals(account.accNum);
    }

    @Override
    public int hashCode() {
        return accNum.hashCode();
    }
}

public class MiniBank {

    public static void main(String[] args) {

    Scanner input = new Scanner(System.in);

    BankInfo bank = new BankInfo("MiniBank", "Vadodara");

    System.out.println("==================================");
    System.out.println("Welcome to " + bank.name());
    System.out.println("Branch : " + bank.branch());
    System.out.println("==================================");

    Customer c1 = new Customer("Aditi", "aditi@gmail.com", "9876543210");
    Customer c2 = new Customer("Rahul", "rahul@gmail.com", "9876501234");
    Customer c3 = new Customer("Priya", "priya@gmail.com", "9123456780");

    Account[] accounts = new Account[3];

    accounts[0] = new Account(c1.getName(), 5000);
    accounts[1] = new Account(c2.getName());
    accounts[2] = new Account(c3.getName(), 10000);

    accounts[0].deposit(1000);
    accounts[1].deposit(2000);

    accounts[0].withdraw(1500);
    accounts[2].withdraw(3000);

    System.out.println("\nAccount Details");

    for (Account acc : accounts) {
        System.out.println("---------------------------");
        System.out.println(acc.toString());
    }

    System.out.println("\nComparing Accounts");

    System.out.println("Account 1 equals Account 2: "
            + accounts[0].equals(accounts[1]));

    System.out.println("Account 1 equals Account 1: "
            + accounts[0].equals(accounts[0]));

    // Using instanceof
    System.out.println("\nType Checking");

    if (accounts[0] instanceof Account) {
        System.out.println("accounts[0] is an Account object.");
    }

    if (c1 instanceof Customer) {
        System.out.println("c1 is a Customer object.");
    } else {
        System.out.println("c1 is not a Customer object.");
    }

    // Menu
    int choice = 0;

    while (choice != 5) {

        System.out.println("\nMENU");
        System.out.println("1. Open Account");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Transfer");
        System.out.println("5. Exit");

        System.out.print("Enter your choice: ");
        choice = input.nextInt();

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
                System.out.println("Thank you for using " + bank.name() + "!");
            }

            default -> {
                System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    input.close();
}
}