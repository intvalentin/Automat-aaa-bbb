/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import javafx.scene.shape.Line;
import java.lang.NullPointerException;

/**
 *
 * @author student
 */
public class Main {

    
    public static void main(String[] args){
        String cuvant;
        Scanner scan=new Scanner(System.in);
        ImportAutomat iautomat=new ImportAutomat();
        Automat automat=new Automat();
        Tranzitie[] tranzitii=iautomat.listaTranzitii();
        
        
        System.out.println("Cuvant: ");
        cuvant=" "+scan.nextLine()+" ";
        
        if(!cuvant.equals("  "))
            automat.verificaCuvant(cuvant, tranzitii);
        else
          System.out.println("Cuvantul nu este valid!");
            
            
        
        
    }
    
    
    
}
