package controller;

import model.Phone;
import validation.CheckValidation;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PhoneControl {

   private ArrayList<Phone> phoneList = new ArrayList<>();
   private Scanner sc = new Scanner(System.in);

    {
        phoneList.add(new Phone("IP2111", "Apple A14 Bionic", "6 GB", "12 MP", 6.7, 1.320,"Xanh duong", "iPhone 12 Pro Max 128GB"));
        phoneList.add(new Phone("IP1111", "Apple A13 Bionic", "4 GB", "12 MP", 6.1, 614,"Tim", "iPhone 11 64GB"));
        phoneList.add(new Phone("SS3122", "Exynos 2100", "12 GB", "108 MP", 6.8, 1.000,"Den tuyen", "Samsung Galaxy S21 Ultra 5G 128GB"));
        phoneList.add(new Phone("SS1405", "Snapdragon 865+", "12 GB", "12 MP", 7.59, 2.200,"Den tuyen", "Samsung Galaxy Z Fold2 5G"));

    }


   public int checkDuplicationPhoneByID(String phoneID)
   {
      int pos;
      if(phoneList.isEmpty())
          return -1;
      for(int i = 0; i <phoneList.size(); i++)
          if(phoneList.get(i).getModel().equalsIgnoreCase(phoneID))
              return i;
      return -1;
   }
   public void addNewPhone()
   {
       String model, CPU,RAM,primaryCamera,color,brand;
       String s = null;
       double price, screeenSize;
       int pos;
       do{
        do{
           model= CheckValidation.getString("Input model(SSxxxx): ", "Model is required. The format of model is SSxxxx (S is a word,x stands for a digit)", "^[A-Z|a-z]{2}\\d{4}$");
           pos = checkDuplicationPhoneByID(model);
           if(pos >= 0)
               System.out.println("The model already exists. Please enter new model");

        }while (pos !=-1);
        CPU = CheckValidation.getStringNoFormat("Input CPU: ", "The CPU is required");
        RAM = CheckValidation.getString("Input RAM: ", "The Ram is required. The format of RAM includes of number and 'GB/gb'.",
                                        "^[0-9]+[ GB|gb]{3}$");
        primaryCamera = CheckValidation.getString("Input primary camera: ", "The format of primary camera includes of number and 'MP/mp' .The primary camera is required",
                                                "^\\d+[ MP|mp]{3}$");
        screeenSize = CheckValidation.getDoubleInAnInterval("Input screen-size: ", "The screen- size is required. The screen-size is from 0' to 12' ",
                                                            0, 12);
        price = CheckValidation.getDoubleInAnInterval("Input price: ", "The price is from 0 to 100000$",
                                                        0, 100000);
        color = CheckValidation.getStringNoFormat("Input color: ", "Color is required");
        brand = CheckValidation.getStringNoFormat("Input brand: ", "The brand is required");
       phoneList.add(new Phone(model,CPU,RAM,primaryCamera,screeenSize, price, color, brand));
       System.out.println("A phone is added sucessfully");
            s =CheckValidation.getString("Do you wanna continue adding phone (Y/N)","Input is required", "[Y-y|N-n]{1}");
        }while (s.equalsIgnoreCase("Y"));

   }

   public Phone searchPhoneObject(String model)
   {
       if(phoneList.isEmpty())
           return null;
       for (Phone x: phoneList)
           if(x.getModel().equalsIgnoreCase(model))
               return x;

       return null;
   }
   public void searchPhoneByModel(){
       String phoneModel;
       Phone p;
       String s = null;
       do {
           phoneModel = CheckValidation.getString("Input model to searching: ", "Model is required", "^[A-Z|a-z]{2}\\d{4}$");
           p = searchPhoneObject(phoneModel);
           System.out.println("-------*******--------");
           if (p == null)
               System.out.println("This phone Model does not exist.Please, check again");
           else {
               System.out.println("Had found. This is the phone information you need to find");
               String msg = String.format("|%-15s|%-30s|%-6s|%-15s|%-10s|%-8s|%-15s|%-35s|",
                       "Model", "CPU", "RAM", "Primary camera", "Screen-size", "Price", "Color", "Brand");
               System.out.println(msg);
               p.printPhones();
           }
           s = CheckValidation.getString("Do you wanna continue searching phone (Y/N)", "Input is required", "[Y-y|N-n]{1}");
       }while (s.equalsIgnoreCase("Y"));

   }
   
   
   public void findPhone(){
       String phoneModel;
       
       String s = null;
       do {
           phoneModel = CheckValidation.getStringNoFormat("Input model to searching: ", "Model is required");
          
           System.out.println("-------*******--------");
            if(phoneList.isEmpty())
                   System.out.println("Not Found");
            for (Phone x: phoneList){
                if(x.getModel().contains(phoneModel))
                     x.printPhones();
            }  
            System.out.println("Not found");
             
           
           s = CheckValidation.getString("Do you wanna continue searching phone (Y/N)", "Input is required", "[Y-y|N-n]{1}");
       }while (s.equalsIgnoreCase("Y"));
   }

   public void removePhoneByModel(){
       String model, s= null, d = null;
       Phone p;
       do {
        model = CheckValidation.getString("Input model to delete: ", "Model is required", "^[A-Z|a-z]{2}\\d{4}$");

           p = searchPhoneObject(model);
        System.out.println("----------*******----------");
            if (p == null)
               System.out.println("Not found!!!");
           else {
                String msg = String.format("|%-15s|%-30s|%-6s|%-15s|%-10s|%-8s|%-15s|%-35s|",
                        "Model", "CPU", "RAM", "Primary camera", "Screen-size", "Price", "Color", "Brand");
                System.out.println(msg);
                p.printPhones();
                d = CheckValidation.getString("Do you wanna remove this phone (Y/N)", "Input is required", "[Y-y|N-n]{1}");
                if (d.equalsIgnoreCase("Y")) {
                    phoneList.remove(p);
                    System.out.println("The selected phone is removed successfully!");
                }


           }
           s = CheckValidation.getString("Do you wanna continue removing (Y/N)", "Input is required", "[Y-y|N-n]{1}");
       }while (s.equalsIgnoreCase("Y"));

   }

   public void printPhoneListDescendingByModel(){
       if(phoneList.isEmpty()){
           System.out.println("The phone list is empty. Nothing to print");
           return;
       }
       Collections.sort(phoneList, Collections.reverseOrder());// được sử dụng để đảo ngược thứ tự của đối tượng tập hợp dựa trên thứ tự mặc định
       System.out.println("----------*******----------");
       System.out.println("----------List of detailed information of the phones----------");
       String msg = String.format("|%-15s|%-30s|%-6s|%-15s|%-10s|%-8s|%-15s|%-35s|",
               "Model", "CPU", "RAM", "Primary camera", "Screen-size", "Price", "Color", "Brand");
       System.out.println(msg);
       for (int i = 0; i< phoneList.size(); i++)
           phoneList.get(i).printPhones();

   }

   public void saveToFile(String filename){
       if(phoneList.isEmpty()) {
           System.out.println("The list phones is empty");
           return;
       }
       try {
           File f= new File(filename);
           FileWriter fw = new FileWriter(f); // write()
           PrintWriter pw = new PrintWriter(fw); // println()
           String msg, msg1;
            msg1 = String.format("|%-15s|%-30s|%-6s|%-15s|%-10s|%-8s|%-15s|%-35s|",
                   "Model", "CPU", "RAM", "Primary camera", "Screen-size", "Price", "Color", "Brand");
           pw.println(msg1);
           for (Phone p: phoneList) {
               msg = String.format("|%-15s|%-30s|%-6s|%-15s|%-11.2f|%-7.3f$|%-15s|%-35s|",
                       p.getModel(), p.getCPU(), p.getRAM(), p.getPrimaryCamera(),p.getScreeenSize(), p.getPrice(), p.getColor(), p.getBrand());
               pw.println(msg);
           }
           pw.close();
           fw.close();
           System.out.println("Save to file sucessfull");
       }catch (Exception e){
           System.out.println("file loi");
       }


   }

}
