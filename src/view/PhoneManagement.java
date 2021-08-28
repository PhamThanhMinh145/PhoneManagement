package view;

import controller.Menu;
import controller.PhoneControl;
import model.Phone;

public class PhoneManagement {

    public static void main(String[] args) {
        Menu menu = new Menu("HKT Store - @ 2021 by SE140310 - Pham Thanh Minh ");
        menu.addOption("Select the options below:");
        menu.addOption("1.Add a phone");
        menu.addOption("2.Search a phone by model");
        menu.addOption("3.Search phones");
        menu.addOption("4.Remove the phone by model");
        menu.addOption("5.Print the phone list in the descending order of Model");
        menu.addOption("6.Save to file");
        menu.addOption("7.Exit");

//        PhoneController
        PhoneControl phone = new PhoneControl();

        int choice;
        do {
            menu.showMenu();
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    phone.addNewPhone();
                    break;
                case 2:
                    phone.searchPhoneByModel();
                    break;
                case 3:
                    phone.findPhone();
                    break;
                case 4:
                    phone.removePhoneByModel();
                    break;
                case 5:
                    phone.printPhoneListDescendingByModel();
                    break;
                case 6:
                    phone.saveToFile("phone.txt");

                    break;
                case 7:
                    System.out.println("Thank you. See you again!!!!");
                    break;

            }
        } while (choice != 6);

    }
}
