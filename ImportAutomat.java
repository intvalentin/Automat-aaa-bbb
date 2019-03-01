/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author valen
 */
public class ImportAutomat {

    public ImportAutomat() {
    }

    public Tranzitie[] listaTranzitii() {
        String[] stare_finala;
        Tranzitie[] tranzitii = new Tranzitie[11];
        Tranzitie aux;
        try {
            int i = 1;
            BufferedReader bf = new BufferedReader(new FileReader("automat.txt"));
            String line = new String();
            String[] v_line;
            stare_finala = line.split(" ");
            line = bf.readLine();

            tranzitii[0] = new Tranzitie(line);
            line = bf.readLine();

            while (line != null) {

                v_line = line.split("-");

                if (v_line.length == 5) {
                    aux = new Tranzitie(v_line[0], v_line[1], v_line[2].charAt(0), v_line[3], v_line[4]);
                } else {
                    aux = new Tranzitie(v_line[0], v_line[1], v_line[2], v_line[3]);
                }

                //System.out.println(v_line[2]);
                tranzitii[i] = aux;
                i++;
                line = bf.readLine();

            }

        } catch (Exception e) {
            System.out.println("Fisierul cu tranzitii nu este valid!");
        }
        return tranzitii;
    }
}
