package deskclass;

import java.util.Scanner;
import java.util.HashMap;

public class Desk {

    private int width;
    private int height;
    private int drawers;
    private String name;
    private int shippingOption;

    private int materialChoice;
    private int option;

    HashMap<String, Integer> Material = new HashMap<String, Integer>();

    /****************************************************************
     * Getters
     **************************************************************/
    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public int getDrawers() {
        return this.drawers;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getShippingOption() {
        return this.shippingOption;
    }

    public int getMaterialChoice() {
        return this.materialChoice;
    }

    public int getOption() {
        return this.option;
    }

    /****************************************************************
     * Setters
     **************************************************************/

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setDrawers(int drawers) {
        this.drawers = drawers;
    }

    public void setShippingOption(int shippingOption) {
        this.shippingOption = shippingOption;
    }

    public void setMaterialChoice(int materialChoice) {
        this.materialChoice = materialChoice;
    }

    public void setOption(int option) {
        this.option = option;
    }

    // Main Method

    public Desk() {
        Material.put("Oak", 200);
        Material.put("Lamiate", 100);
        Material.put("Pine", 50);
        Material.put("Rosewood", 300);
        Material.put("Veneer", 125);
    }
    // Methods

    public void AskForInput() {
        Scanner userInput = new Scanner(System.in);

        System.out.print("Please Enter your Name: ");
        this.name = userInput.nextLine();
        setName(this.name);
        System.out.println(" ");

        // Width
        System.out.print("Enter Width of the Desk: ");
        this.width = userInput.nextInt();
        setWidth(this.width);
        System.out.println(" ");

        // Height
        System.out.print("Enter Height of the Desk: ");
        this.height = userInput.nextInt();
        setHeight(this.height);
        System.out.println(" ");
        // Drawers

        System.out.print("Please Enter numbers of Drawer from 1 to 7: ");
        this.drawers = userInput.nextInt();
        setDrawers(this.drawers);
        System.out.println(" ");

        // Material
        System.out.print("Please type a number to choose a material: ");
        System.out.println("");
        this.PrintMaterialDetail();
        System.out.println(" ");

        this.materialChoice = userInput.nextInt();
        setMaterialChoice(this.materialChoice);
        System.out.println(" ");

        // Shipping
        System.out.print("Please Enter your Shipping Choice:: 3 or 5 or 7 day !! Charges Applied ::  ");
        this.shippingOption = userInput.nextInt();
        setShippingOption(this.shippingOption);
        userInput.close();

    }

    public void PrintMaterialDetail() {
        int count = 1;
        for (String material : Material.keySet()) {
            System.out.println(count + ". " + material + ": $" + Material.get(material));
            count++;
        }
    }

    public int fetchMaterial(int number) {
        int count = 1;
        int price = 0;
        for (String material : Material.keySet()) {
            if (count == number) {
                price = Material.get(material);
            }
            count++;
        }
        return price;
    }

    public static void Desk() {
        Desk feed = new Desk();
        feed.Desk();
    }
}
