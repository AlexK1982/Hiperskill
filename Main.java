import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoffeeMachine.water = 400;
        CoffeeMachine.milk = 540;
        CoffeeMachine.beans = 120;
        CoffeeMachine.money = 550;
        CoffeeMachine.cups = 9;
        CoffeeMachine.cont = true;
        CoffeeMachine.currentState = CoffeeMachine.State.CHOOSE_ACTION;

        while (CoffeeMachine.cont) {
            if (CoffeeMachine.currentState == CoffeeMachine.State.CHOOSE_ACTION) {
                System.out.println("Write action (buy, fill, take, remaining, exit):");
            } else if (CoffeeMachine.currentState == CoffeeMachine.State.CHOOSE_TYPE) {
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
            } else if (CoffeeMachine.currentState == CoffeeMachine.State.FILL) {
                System.out.println("Write how many ml of water you want to add:");
                int addWater = scanner.nextInt();
                CoffeeMachine.water += addWater;
                System.out.println("Write how many ml of milk you want to add:");
                int addMilk = scanner.nextInt();
                CoffeeMachine.milk += addMilk;
                System.out.println("Write how many grams of coffee you want to add:");
                int addBeans = scanner.nextInt();
                CoffeeMachine.beans += addBeans;
                System.out.println("Write how many disposable cups of coffee you want to add:");
                int addCups = scanner.nextInt();
                CoffeeMachine.cups += addCups;
                CoffeeMachine.currentState = CoffeeMachine.State.CHOOSE_ACTION;
                System.out.println("Write action (buy, fill, take, remaining, exit):");
            } else {
                System.out.println("State error, reload machine");
            }

            String action = scanner.next();
            CoffeeMachine.actionDo(action);
        }
    }
}

class CoffeeMachine {
    public enum State {
        CHOOSE_ACTION, CHOOSE_TYPE, FILL
    }
    static State currentState;
    static int water;
    static int milk;
    static int beans;
    static int money;
    static int cups;
    static boolean cont; //this is used for infinite loop

    public static void actionDo(String action) {
        if (currentState == State.CHOOSE_ACTION) {
            switch (action) {
                case "exit":
                    cont = false;
                    break;
                case "buy":
                    currentState = State.CHOOSE_TYPE;
                    break;
                case "fill":
                    currentState = State.FILL;
                    break;
                case "take":
                    System.out.println("I gave you $" + money);
                    money = 0;
                    break;
                case "remaining":
                    System.out.println("The coffee machine has:");
                    System.out.println(water + " ml of water");
                    System.out.println(milk + " ml of milk");
                    System.out.println(beans + " g of coffee beans");
                    System.out.println(cups + " disposable cups");
                    System.out.println("$" + money + " of money");
                    break;
                default:
                    System.out.println("wrong choice");
                    break;
            }
        } else if (currentState == State.CHOOSE_TYPE) {
            switch (action) {
                case "1":
                    if (water < 250) {
                        System.out.println("Sorry, not enough water!");
                        break;
                    } else if (beans < 16) {
                        System.out.println("Sorry, not enough beans");
                        break;
                    } else if (cups < 1) {
                        System.out.println("Sorry, not enough cups");
                        break;
                    } else {
                        System.out.println("I have enough resources, making you a coffee!");
                    }
                    water -= 250;
                    beans -= 16;
                    money += 4;
                    cups--;
                    break;
                case "2":
                    if (water < 350) {
                        System.out.println("Sorry, not enough water!");
                        break;
                    } else if (milk < 75) {
                        System.out.println("Sorry, not enough milk");
                        break;
                    } else if (beans < 20) {
                        System.out.println("Sorry, not enough beans");
                        break;
                    } else if (cups < 1) {
                        System.out.println("Sorry, not enough cups");
                        break;
                    } else {
                        System.out.println("I have enough resources, making you a coffee!");
                    }
                    water -= 350;
                    milk -= 75;
                    beans -= 20;
                    money += 7;
                    cups--;
                    break;
                case "3":
                    if (water < 200) {
                        System.out.println("Sorry, not enough water!");
                        break;
                    } else if (milk < 100) {
                        System.out.println("Sorry, not enough milk");
                        break;
                    } else if (beans < 12) {
                        System.out.println("Sorry, not enough beans");
                        break;
                    } else if (cups < 1) {
                        System.out.println("Sorry, not enough cups");
                        break;
                    } else {
                        System.out.println("I have enough resources, making you a coffee!");
                    }
                    water -= 200;
                    milk -= 100;
                    beans -= 12;
                    money += 6;
                    cups--;
                    break;
                case "back":
                    currentState = State.CHOOSE_ACTION;
                    break;
                default:
                    System.out.println("wrong choice");
                    break;
            }
        }
    }
}