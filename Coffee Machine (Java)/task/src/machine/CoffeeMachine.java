package machine;


import java.util.Scanner;

public class CoffeeMachine {
    private static int waterInMachine = 400;
    private static int milkInMachine = 540;
    private static int coffeeBeansInMachine = 120;

    private static int espressoWaterAmount = 250;
    private static int espressoMilkAmount = 0;
    private static int espressoCoffeeBeansAmount = 16;
    private static int espressoPrice = 4;

    private static int latteWaterAmount = 350;
    private static int latteMilkAmount = 75;
    private static int latteCoffeeBeansAmount = 20;
    private static int lattePrice = 7;


    private static int cappuccinoWaterAmount = 200;
    private static int cappuccinoMilkAmount = 100;
    private static int cappuccinoCoffeeBeansAmount = 12;
    private static int cappuccinoPrice = 6;

    private static boolean isPossible = false;

    private static int cupsDisposable = 9;
    private static int moneyAmount = 550;

    private static String coffeeChoice;

    // gives the user a choice of action
    public static void requestAction(Scanner scan) {
        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            String actionSelected = scan.nextLine();

            if (actionSelected.equals("buy")) {
                buyCoffee(scan);
            } else if (actionSelected.equals("fill")) {
                fillMachine(scan);
            } else if (actionSelected.equals("take")) {
                takeMoney();
            } else if (actionSelected.equals("remaining")) {
                stateStatus();
            } else if (actionSelected.equals("exit")) {
                System.exit(0);
            }
        }
    }

    // method to buy a coffee after user selects "buy"
    public static void buyCoffee(Scanner scan) {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        coffeeChoice = scan.nextLine();
        CalculateIfPossible(scan);
    }

    // deduct ingredients from resources in the machine to make this type of coffee
    public static void makeEspresso(
    ) {
        if (    waterInMachine >= espressoWaterAmount
                && milkInMachine >= espressoMilkAmount
                && coffeeBeansInMachine >= espressoCoffeeBeansAmount
                && cupsDisposable > 0) {
            isPossible = true;
            System.out.println("I have enough resources, making you a coffee!");
            waterInMachine -= espressoWaterAmount;
            milkInMachine -= espressoMilkAmount;
            coffeeBeansInMachine -= espressoCoffeeBeansAmount;
            moneyAmount += espressoPrice;
            cupsDisposable --;
        } else if (waterInMachine < espressoWaterAmount) {
            System.out.println("You need more water");
        } else if (milkInMachine < espressoMilkAmount) {
            System.out.println("You need more milk");
        } else if (coffeeBeansInMachine < espressoCoffeeBeansAmount) {
            System.out.println("You need more coffee beans");
        } else if (cupsDisposable < 0) {
            System.out.println("You need more cups");
        }
    }

    // deduct ingredients from resources in the machine to make this type of coffee
    public static void makeLatte() {
        if (    waterInMachine >= latteWaterAmount
                && milkInMachine >= latteMilkAmount
                && coffeeBeansInMachine >= latteCoffeeBeansAmount
                && cupsDisposable > 0){
            isPossible = true;
            System.out.println("I have enough resources, making you a coffee!");
            waterInMachine -= latteWaterAmount;
            milkInMachine -= latteMilkAmount;
            coffeeBeansInMachine -= latteCoffeeBeansAmount;
            moneyAmount += lattePrice;
            cupsDisposable --;
        } else if (waterInMachine < latteWaterAmount) {
            System.out.println("You need more water");
        } else if (milkInMachine < latteMilkAmount) {
            System.out.println("You need more milk");
        } else if (coffeeBeansInMachine < latteCoffeeBeansAmount) {
            System.out.println("You need more coffee beans");
        } else if (cupsDisposable < 0) {
            System.out.println("You need more cups");
        }
    }

    // deduct ingredients from resources in the machine to make this type of coffee
    public static void makeCappuccino() {
        if (    waterInMachine >= cappuccinoWaterAmount
                && milkInMachine >= cappuccinoMilkAmount
                && coffeeBeansInMachine >= cappuccinoCoffeeBeansAmount
                && cupsDisposable > 0) {
            isPossible = true;
            System.out.println("I have enough resources, making you a coffee!");
            waterInMachine -= cappuccinoWaterAmount;
            milkInMachine -= cappuccinoMilkAmount;
            coffeeBeansInMachine -= cappuccinoCoffeeBeansAmount;
            moneyAmount += cappuccinoPrice;
            cupsDisposable--;

        } else if (waterInMachine < cappuccinoWaterAmount) {
            System.out.println("You need more water");
        } else if (milkInMachine < cappuccinoMilkAmount) {
            System.out.println("You need more milk");
        } else if (coffeeBeansInMachine < cappuccinoCoffeeBeansAmount) {
            System.out.println("You need more coffee beans");
        } else if (cupsDisposable < 0) {
            System.out.println("You need more cups");
        }
    }

    // calculate if the chosen coffee type is possible to make
    public static void CalculateIfPossible(Scanner scan) {
        if (coffeeChoice.equals("1")){
            makeEspresso();
        } else if (coffeeChoice.equals("2")) {
            makeLatte();
        } else if (coffeeChoice.equals("3")) {
            makeCappuccino();
        } else if (coffeeChoice.equals("back")) {
            requestAction(scan);
        }
    }

    //method to fill the machine with resources
    public static void fillMachine(Scanner scan){
        int extraWater;
        int extraMilk;
        int extraCoffeeBeans;
        int extraDisposableCups;
        System.out.println("How much ml of water do you want to add?");
        extraWater = scan.nextInt();
        waterInMachine += extraWater;

        System.out.println("How much ml of milk do you want to add?");
        extraMilk = scan.nextInt();
        milkInMachine += extraMilk;

        System.out.println("How much  of coffee beans do you want to add?");
        extraCoffeeBeans = scan.nextInt();
        coffeeBeansInMachine += extraCoffeeBeans;

        System.out.println("How many disposable cups do you want to add?");
        extraDisposableCups = scan.nextInt();
        cupsDisposable += extraDisposableCups;
    }

    // method to take money out of the cash register
    public static void takeMoney() {
        int moneyEarned = moneyAmount - (espressoPrice + lattePrice + cappuccinoPrice);
        System.out.println("I gave you $" + moneyEarned);
        moneyAmount = 0;
    }

    // State a list of the resources in the machine
    public static void stateStatus() {
        System.out.println("The coffee machine has:");
        System.out.println(waterInMachine + " ml of water");
        System.out.println(milkInMachine + " ml of milk");
        System.out.println(coffeeBeansInMachine + " g of coffee beans");
        System.out.println(cupsDisposable + " of disposable cups");
        System.out.println("$" + moneyAmount + " of money");
    }

}
