/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.fink.magacin.data;

/**
 *
 * @author andje
 */

public class Prostor {

    private int prostorId;
    private String imeMagacina;
    private Radnik radnik; 

    public Prostor(int prostorId, String imeMagacina, Radnik radnik) {
        this.prostorId = prostorId;
        this.imeMagacina = imeMagacina;
        this.radnik = radnik;
    }

    public Prostor(String imeMagacina, Radnik radnik) {
        this.imeMagacina = imeMagacina;
        this.radnik = radnik;
    }

    
    public int getProstorId() {
        return prostorId;
    }

    public void setProstorId(int prostorId) {
        this.prostorId = prostorId;
    }

    public String getImeMagacina() {
        return imeMagacina;
    }

    public void setImeMagacina(String imeMagacina) {
        this.imeMagacina = imeMagacina;
    }

    public Radnik getRadnik() {
        return radnik;
    }

    public void setRadnik(Radnik radnik) {
        this.radnik = radnik;
    }

    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Prostor{")
          .append("prostorId=").append(prostorId)
          .append(", imeMagacina='").append(imeMagacina).append('\'')
          .append(", radnik=").append(radnik != null ? radnik.getId() : "null") // Prikaz ID-a radnika ako postoji
          .append('}');
        return sb.toString();
    }
}

