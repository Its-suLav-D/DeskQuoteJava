package deskquote;

import java.io.IOException; // Import the IOException class to handle errors
import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner;

import javax.swing.plaf.synth.SynthMenuBarUI;

import java.util.HashMap;

public class DeskQuote {

    private String name;

    private int shippingOption;

    int[][] arr = { { 60, 70, 80 }, { 40, 50, 60 }, { 30, 35, 40 } };

    /****************************************************************
     * Getters
     **************************************************************/

    public String getName() {
        return this.name;
    }

    public int getShippingOption() {
        return this.shippingOption;
    }

    /****************************************************************
     * Setters
     **************************************************************/

    public void setName(String name) {
        this.name = name;
    }

    public void setShippingOption(int shippingOption) {
        this.shippingOption = shippingOption;
    }

    // Methods
    public void askUserInfo() {
        Scanner input = new Scanner(System.in);
        System.out.print("Please Enter your Shipping Choice : 3 or 5 or 7 day !! Charges Applied :: ");
        this.shippingOption = input.nextInt();
        setShippingOption(this.shippingOption);
        input.close();

        // Name
        // System.out.print("Please Enter your Name: ");
        // this.name = input.nextLine();
        // setName(this.name);
        // input.close();
    }

    public int getPriceFromMatrix(int x, int y) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                return arr[x][y];
            }
        }
        return 0;

    }

    public void DisplayScreen() {
        System.out.println(" ");
        System.out.println("**********************************************************************");
        System.out.println("                 Welcome to the Desk Quote Application             ");
        System.out.println("**********************************************************************");
    }

    public void readSavedFile() {
        try {
            File myObj = new File("filename.txt");
            Scanner myReader = new Scanner(myObj);
            if (myReader != null) {
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    System.out.println("Name    Total");
                    System.out.println(data);
                }
            }

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
