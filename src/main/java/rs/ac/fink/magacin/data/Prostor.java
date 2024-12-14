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
    private Radnik radnikId; 

    public Prostor() {
    }

    public Prostor(int prostorId, String imeMagacina, Radnik radnikId) {
        this.prostorId = prostorId;
        this.imeMagacina = imeMagacina;
        this.radnikId = radnikId;
    }

    public Prostor(String imeMagacina, Radnik radnikId) {
        this.imeMagacina = imeMagacina;
        this.radnikId = radnikId;
    }
    
    

    public String getImeMagacina() {
        return imeMagacina;
    }

    public void setImeMagacina(String imeMagacina) {
        this.imeMagacina = imeMagacina;
    }

    public int getProstorId() {
        return prostorId;
    }

    public void setProstorId(int prostorId) {
        this.prostorId = prostorId;
    }

    public Radnik getRadnikId() {
        return radnikId;
    }

    public void setRadnikId(Radnik radnikId) {
        this.radnikId = radnikId;
    }
    
   
 
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Prostor{")
          .append("prostorId=").append(prostorId)
          .append(", imeMagacina='").append(imeMagacina).append('\'')
          .append(", radnikId=").append(radnikId != null ? radnikId.getId() : "null") 
          .append('}');
        return sb.toString();
    }
}