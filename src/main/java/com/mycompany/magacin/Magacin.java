/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.magacin;

/**
 *
 * @author andje
 */
import rs.ac.fink.magacin.data.Prostor;
import rs.ac.fink.magacin.data.Proizvod;
import rs.ac.fink.magacin.data.Radnik;
import rs.ac.fink.magacin.service.ProstorService;
import rs.ac.fink.magacin.service.ProizvodService;

public class Magacin {

    private static final ProstorService prostorService = ProstorService.getInstance();
    private static final ProizvodService proizvodService = ProizvodService.getInstance();

    public static void main(String[] args) {
        try {
            dodajTestProstore();
            dodajTestProizvode();

            
            Prostor prostor = prostorService.findProstor(1); 
            System.out.println("Pronađeni prostor: " + prostor);

            Proizvod proizvod = proizvodService.findProizvod(101); 
            System.out.println("Pronađeni proizvod: " + proizvod);

            
            obrisiTestProizvode();
            obrisiTestProstore();
        } catch (Exception e) {
            System.err.println("Greška: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void dodajTestProstore() throws Exception {
        Radnik radnik1 = new Radnik(1, "Petar", "Petrović", "petar.petrovic","0641234567");
        Radnik radnik2 = new Radnik(2, "Jovana", "Jovanović", "jovana.jovanovic","0639876543");

        Prostor prostor1 = new Prostor(1, "Magacin A", radnik1);
        Prostor prostor2 = new Prostor(2, "Magacin B", radnik2);

        prostorService.addNewProstor(prostor1);
        prostorService.addNewProstor(prostor2);
    }

    private static void dodajTestProizvode() throws Exception {
        Prostor prostor = prostorService.findProstor(1); 

        Proizvod proizvod1 = new Proizvod(101, "Televizor", "Elektronika", "5", 12, "LCD televizor", prostor);
        Proizvod proizvod2 = new Proizvod(102, "Frižider", "Bela tehnika", "3", 50, "No Frost tehnologija", prostor);

        proizvodService.addNewProizvod(proizvod1);
        proizvodService.addNewProizvod(proizvod2);
    }

    private static void obrisiTestProizvode() throws Exception {
        proizvodService.deleteProizvod(101); 
        proizvodService.deleteProizvod(102);
    }

    private static void obrisiTestProstore() throws Exception {
        prostorService.deleteProstor(1); 
        prostorService.deleteProstor(2);
    }
}
