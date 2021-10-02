import deskclass.Desk;
import java.io.FileWriter; // Import the File class
import java.io.IOException; // Import the IOException class to handle errors
import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// import deskquote.DeskQuote;
import deskquote.DeskQuote;

class Main {

    public static int OptionMenu() {
        InputStreamReader inStream = new InputStreamReader(System.in);
        BufferedReader stdin = new BufferedReader(inStream);
        int num = 0;
        String str[] = new String[1];
        System.out.println("Press 1 to Create a Desk Quote:: ");
        System.out.println("Press 2 to View a Desk Quote::");
        try {
            str[0] = stdin.readLine();
            num = Integer.parseInt(str[0]);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return num;
    }

    public static void main(String[] args) {

        // Constants
        int BASE_DESK = 200;
        int DRAWERS = 50;

        int BASE_SURFACE_AREA = 1000;
        int surfaceAreaCost = 0;
        int total = 0;
        int shippingPrice = 0;

        DeskQuote deskQuote = new DeskQuote();

        Desk desk = new Desk();

        deskQuote.DisplayScreen();

        int opt1 = OptionMenu();

        if (opt1 == 1) {
            desk.AskForInput();

            int area = desk.getWidth() * desk.getHeight();
            int drawer = DRAWERS * desk.getDrawers();

            if (area > 1000) {
                surfaceAreaCost = (area - BASE_SURFACE_AREA) * 1;
            }

            int materialPrice = desk.fetchMaterial(desk.getMaterialChoice());

            int shoppingChoice = desk.getShippingOption();

            switch (shoppingChoice) {
            case 3:
                if (area <= 1000) {
                    shippingPrice = deskQuote.getPriceFromMatrix(0, 0);
                } else if (area >= 1000 && area <= 2000) {
                    shippingPrice = deskQuote.getPriceFromMatrix(0, 1);
                } else {
                    shippingPrice = deskQuote.getPriceFromMatrix(0, 2);
                }
                break;
            case 5:
                if (area <= 1000) {
                    shippingPrice = deskQuote.getPriceFromMatrix(1, 0);
                } else if (area >= 1000 && area <= 2000) {
                    shippingPrice = deskQuote.getPriceFromMatrix(1, 1);
                } else {
                    shippingPrice = deskQuote.getPriceFromMatrix(1, 2);
                }
                break;
            case 7:
                if (area <= 1000) {
                    shippingPrice = deskQuote.getPriceFromMatrix(2, 0);
                } else if (area >= 1000 && area <= 2000) {
                    shippingPrice = deskQuote.getPriceFromMatrix(2, 1);
                } else {
                    shippingPrice = deskQuote.getPriceFromMatrix(2, 2);
                }
                break;
            default:
                shippingPrice = deskQuote.getPriceFromMatrix(2, 1);
            }

            total = surfaceAreaCost + drawer + shippingPrice + materialPrice + BASE_DESK;

            try {
                FileWriter myWriter = new FileWriter("filename.txt");
                myWriter.write(desk.getName() + total);
                System.out.println("Your total DeskQuote is $: " + total);
                System.out.println("Data Saved Successfully");
                myWriter.close();

            } catch (Exception e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }

        else {
            deskQuote.readSavedFile();
        }

    }

}
