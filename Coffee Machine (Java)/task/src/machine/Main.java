package machine;

import java.util.Scanner;

public class Main extends CoffeeMachine{
    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        Scanner scan = new Scanner(System.in);
        requestAction(scan);
    }
}
