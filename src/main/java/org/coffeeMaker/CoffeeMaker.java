package org.coffeeMaker;

import java.util.Scanner;

public class CoffeeMaker {
    static int currentPrice = 400;
    static int cupsAmount = 50;
    static int waterAmount = 800;
    static int milkAmount = 600;
    static int beansAmount = 150;
    static CoffeeCondition coffeeCondition;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("Write action (buy, fill, take, remaining, exit): ");
        while (coffeeCondition != CoffeeCondition.EXIT) {
            run(scanner.nextLine());
        }
    }

    public static void run(String condition) {
        switch (condition) {
            case "buy" -> coffeeCondition = CoffeeCondition.BUY;
            case "fill" -> coffeeCondition = CoffeeCondition.FILL;
            case "take" -> coffeeCondition = CoffeeCondition.TAKE;
            case "remaining" -> coffeeCondition = CoffeeCondition.REMAINING;
            case "back" -> coffeeCondition = CoffeeCondition.ACTION;
            case  "exit" -> coffeeCondition = CoffeeCondition.EXIT;
            case "1" -> coffeeCondition = CoffeeCondition.CAPPUCCINO;
            case "2" -> coffeeCondition = CoffeeCondition.AMERICANO;
            case "3" -> coffeeCondition = CoffeeCondition.ESPRESSO;
            case "4" -> coffeeCondition = CoffeeCondition.LATTE;
        }
        switch (coffeeCondition) {
            case BUY:
                System.out.println("Hey. What would you like to drink? 1 - cappuccino, 2 - americano, 3 - espresso, 4 - latte, back - to main menu");
                break;
            case FILL:
                coffeeCondition = CoffeeCondition.FILL;
                break;
            case ADD_WATER:
                System.out.println("Write how many ml of water do you want to add: ");
                waterAmount += Integer.parseInt(condition);
                coffeeCondition = CoffeeCondition.ADD_WATER;
                break;
            case ADD_MILK:
                System.out.println("Write how many ml of milk do you want to add: ");
                milkAmount += Integer.parseInt(condition);
                coffeeCondition = CoffeeCondition.ADD_MILK;
                break;
            case ADD_BEANS:
                System.out.println("Write how many grams of coffee beans do you want to add: ");
                beansAmount += Integer.parseInt(condition);
                coffeeCondition = CoffeeCondition.ADD_BEANS;
                break;
            case ADD_CUP:
                System.out.println("Write how many cups of coffee do you want to add: ");
                cupsAmount += Integer.parseInt(condition);
                coffeeCondition = CoffeeCondition.ADD_CUP;
                break;
            case TAKE:
                System.out.println("I gave you $ " + currentPrice);
                currentPrice -= currentPrice;
                coffeeCondition = CoffeeCondition.ACTION;
            case REMAINING:
                System.out.println();
                System.out.println("The coffee machine has: ");
                System.out.println(currentPrice + " of money");
                System.out.println(waterAmount + " of water");
                System.out.println(milkAmount + " of milk");
                System.out.println(cupsAmount + " of cups");
                System.out.println(beansAmount + " of coffee beans");
                coffeeCondition = CoffeeCondition.ACTION;
                break;
            case EXIT:
                break;
            case CAPPUCCINO:
                if (waterAmount - 200 < 0) {
                    System.out.println("Sorry, not enough water!");
                } else if (beansAmount - 12 < 0) {
                    System.out.println("Sorry, not enough beans!");
                } else if (cupsAmount - 1 < 0) {
                    System.out.println("Sorry, not enough cups!");
                } else if (milkAmount - 100 < 0) {
                    System.out.println("Sorry, not enough milk!");
                } else {
                    waterAmount -= 200;
                    beansAmount -= 12;
                    cupsAmount -= 1;
                    milkAmount -= 100;
                    currentPrice += 6;
                    System.out.println("I have enough resources, making you a coffee!");
                }
                coffeeCondition = CoffeeCondition.ACTION;
                break;
            case ESPRESSO:
                if (waterAmount - 150 < 0) {
                    System.out.println("Sorry, not enough water!");
                } else if (beansAmount - 18 < 0) {
                    System.out.println("Sorry, not enough beans!");
                } else if (cupsAmount - 1 < 0) {
                    System.out.println("Sorry, not enough cups!");
                } else if (milkAmount < 0) {
                    System.out.println("Sorry, not enough milk!");
                } else {
                    waterAmount -= 150;
                    milkAmount -= 0;
                    cupsAmount -= 1;
                    beansAmount -= 18;
                    currentPrice += 4;
                    System.out.println("I have enough resources, making you a coffee!");
                }
                coffeeCondition = CoffeeCondition.ACTION;
                break;
            case AMERICANO:
                if (waterAmount - 250 < 0) {
                    System.out.println("Sorry, not enough water!");
                } else if (beansAmount - 14 < 0) {
                    System.out.println("Sorry, not enough beans!");
                } else if (cupsAmount - 1 < 0) {
                    System.out.println("Sorry, not enough cups!");
                } else if (milkAmount < 0) {
                    System.out.println("Sorry, not enough milk!");
                } else {
                    waterAmount -= 250;
                    milkAmount -= 0;
                    cupsAmount -= 1;
                    beansAmount -= 14;
                    currentPrice += 4;
                    System.out.println("I have enough resources, making you a coffee!");
                }
                coffeeCondition = CoffeeCondition.ACTION;
                break;
            case LATTE:
                if (waterAmount - 350 < 0) {
                    System.out.println("Sorry, not enough water!");
                } else if (beansAmount - 20 < 0) {
                    System.out.println("Sorry, not enough beans!");
                } else if (cupsAmount - 1 < 0) {
                    System.out.println("Sorry, not enough cups!");
                } else if (milkAmount - 75 < 0){
                    System.out.println("Sorry, not enough milk!");
                } else {
                    waterAmount -= 350;
                    beansAmount -= 20;
                    cupsAmount -= 1;
                    milkAmount -= 75;
                    currentPrice += 7;
                    System.out.println("I have enough resources, making you a coffee!");
                }
                coffeeCondition = CoffeeCondition.ACTION;
                break;
        }
        if (coffeeCondition == CoffeeCondition.ACTION) {
            System.out.println("Write action (buy, fill, take, ramaining, exit): ");
        }
    }
}
