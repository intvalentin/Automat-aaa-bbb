/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author valen
 */
public class Automat {

    public Automat() {

    }

    public void verificaCuvant(String cuvant, Tranzitie[] tranzitii) {
        StringBuilder cuv = new StringBuilder(cuvant);
        int pozitie = 0;
        char pozitie_in_cuvant = cuv.charAt(pozitie);
        // pozitie++;
        String tranzitie_simbol = tranzitii[1].getTr_start(), stare_initiala = tranzitii[1].getTr_start(), stare_finala = tranzitii[1].getTr_start(), pozitie_tranzitie;
        Tranzitie tranzitie_f = null;

        while (stare_finala != tranzitii[0].getTr_start()) {
            System.out.println("CUVANT: " + cuv);

            if (find_tranzitie(tranzitii, pozitie_in_cuvant, stare_finala) == null) {
                //System.out.println("Cuvantul NU apartine!!" +pozitie_in_cuvant+ " || "+stare_initiala);
                break;
            } else {
                //System.out.println(pozitie_in_cuvant+" || "+stare_finala);
                tranzitie_f = find_tranzitie(tranzitii, pozitie_in_cuvant, stare_finala);
                System.out.println("tranzitie_f= " + tranzitie_f.getTr_start() + " || " + tranzitie_f.getTr_final() + "|| directie: " + tranzitie_f.getDirectie() + "|| rescrie: " + tranzitie_f.getRescrie());

                if (tranzitie_f.getTr_final() == null) {
                    break;
                }

                //System.out.println(tranzitie_f.getDirectie()+" || ");
                if (!Character.toString(tranzitie_f.getRescrie()).equals("v")) {

                    cuv.setCharAt(pozitie, tranzitie_f.getRescrie());

                    if (tranzitie_f.getDirectie().equals("l")) {
                        pozitie -= 1;
                        pozitie_in_cuvant = cuv.charAt(pozitie);
                        System.out.println("pozitie: " + pozitie_in_cuvant);
                    } else {
                        pozitie += 1;
                        pozitie_in_cuvant = cuv.charAt(pozitie);
                        System.out.println("pozitie: " + pozitie_in_cuvant);
                    }

                } else {
                    if (tranzitie_f.getDirectie().equals("l")) {
                        while (Character.toString(pozitie_in_cuvant).equals(tranzitie_f.getSimbol())) {
                            pozitie -= 1;
                            pozitie_in_cuvant = cuv.charAt(pozitie);
                            System.out.println("pozitie: " + pozitie_in_cuvant);
                        }
                    } else {
                        while (Character.toString(pozitie_in_cuvant).equals(tranzitie_f.getSimbol())) {
                            pozitie += 1;
                            pozitie_in_cuvant = cuv.charAt(pozitie);
                            System.out.println("pozitie: " + pozitie_in_cuvant);
                        }
                    }
                }

            }
            if (tranzitie_f.getTr_final() != null) {
                stare_finala = tranzitie_f.getTr_final();
            } else {
                stare_finala = tranzitie_f.getTr_start();
            }

        }

        //System.out.println(""+ tranzitie_f.getTr_final()+" || "+tranzitii[0].getTr_start());
        if (tranzitie_f.getTr_final().equals(tranzitii[0].getTr_start())) {
            System.out.println("Cuvantul apartine! " + tranzitie_f.getTr_final() + " || " + tranzitii[0].getTr_start());
        } else {
            System.out.println("Cuvantul nu apartine!");
        }
    }

    private Tranzitie find_tranzitie(Tranzitie[] tranzitii, char simbol, String tranzitie_start) {

        for (int i = 0; i < tranzitii.length; i++) {
            //System.out.println(tranzitii[i].getTr_start()+" || "+tranzitii[i].getSimbol());
            if (tranzitie_start.equals(tranzitii[i].getTr_start()) && tranzitii[i].getSimbol().equals(Character.toString(simbol))) {
                // System.out.println(tranzitii[i].getTr_final());
                return tranzitii[i];
            }
        }
        return null;
    }
}
