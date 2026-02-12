/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package datastructureandalgorithmsproject;

import java.util.Scanner;

/**
 *
 * @author evrim
 */
public class DataStructureAndAlgorithmsProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {  
      
      List l1 = new List();
      
      Methods m1 = new Methods();
      
      l1.add("1", "Veri Yapıları ve Algoritmalar");
      l1.add("1.1", "Veri Yapısı Nedir");
      l1.add("1.2", "Algoritma Nedir");
      l1.add("1.2.1", "Kaba kod");
      l1.add("1.2.2", "Akıs Semasi");
      l1.add("1.2.3", "Alogirtma Analizi");
      l1.add("1.2.3.1", "En iyi durum Analizi");
      l1.add("1.2.3.2", "Ortalama Durum");
      l1.add("1.2.3.3", "En kötü Durum Analizi");
      l1.add("2", "Sıralama");
      l1.add("2.1", "Siralama Nedir");
      l1.add("2.2", "Siralama Algoritmalari");
      l1.add("2.2.1", "Araya Sokma Siralamasi");
      l1.add("2.2.1.1", "Kaba Kodu");
      l1.add("2.2.1.1.1", "C Kodu");
      l1.add("2.2.1.1.2", "Java Kodu");
      l1.add("2.2.1.1.2.1", "Ekleme");
      l1.add("2.2.1.1.2.2", "Silme");
      l1.add("2.2.1.1.2.2", "Gezinme");
      l1.add("2.2.1.2", "Ornekler");
      l1.add("2.2.1.2.1", "Ornek 1");
      l1.add("2.2.1.2.2", "Ornek 2");
      l1.add("2.2.1.3", "Algoritma Analizi");
      l1.add("2.2.2", "Secmeli Sıralama");
      l1.add("2.2.3", "Kabarcik Siralama");
      l1.add("3", "Arama");
      l1.add("4", "Agaclar");
      l1.add("4.1", "Agac Nedir");
      
      l1.print(); 
      
      Scanner sn = new Scanner(System.in);
      
      System.out.println("Type Command: ");
      
      System.out.println("Type -Print- to see the whole list");
      
      System.out.println("To add items to the list use this format : Add, path, name");
      
      boolean condition = true;
      
      while(condition){
          
          System.out.println("Enter Command: ");
          
          String command = sn.nextLine();
          
          switch(m1.parse(command, 1)){
              
              case "Print":
                  l1.print();
                  break;
                  
              case "print":
                  l1.print();
                  break;
                  
              case "Add":
                  
                  String path = m1.parse(command, 2);
                  
                  String heading = m1.parse(command, 3);
                  
                  l1.add(path, heading);
                  
                  break;
                  
              case "Exit":
                  
                  System.out.println("Program Terminated");
                  condition = false;
                  break;
                  
              default: System.out.println("False statement");
          }
          System.out.println();
      }
      
    }
    
}
