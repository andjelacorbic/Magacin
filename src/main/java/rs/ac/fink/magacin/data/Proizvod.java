/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.fink.magacin.data;

/**
 *
 * @author andje
 */

public class Proizvod {

    private int proizvodId;
    private String naziv;
    private String tip;
    private String tezina;
    private String kolicina;
    private String napomena;
    private Prostor prostorId; 

    public Proizvod() {
    }

    public Proizvod(int proizvodId, String naziv, String tip, String tezina, String kolicina, String napomena, Prostor prostorId) {
        this.proizvodId = proizvodId;
        this.naziv = naziv;
        this.tip = tip;
        this.tezina = tezina;
        this.kolicina = kolicina;
        this.napomena = napomena;
        this.prostorId = prostorId;
    }

    public String getKolicina() {
        return kolicina;
    }

    public void setKolicina(String kolicina) {
        this.kolicina = kolicina;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getProizvodId() {
        return proizvodId;
    }

    public void setProizvodId(int proizvodId) {
        this.proizvodId = proizvodId;
    }

    public Prostor getProstorId() {
        return prostorId;
    }

    public void setProstorId(Prostor prostorId) {
        this.prostorId = prostorId;
    }

    public String getTezina() {
        return tezina;
    }

    public void setTezina(String tezina) {
        this.tezina = tezina;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

   
  
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Proizvod{")
          .append("proizvodId=").append(proizvodId)
          .append(", naziv='").append(naziv).append('\'')
          .append(", tip='").append(tip).append('\'')
          .append(", tezina='").append(tezina).append('\'')
          .append(", kolicina=").append(kolicina)
          .append(", napomena='").append(napomena).append('\'')
          .append(", prostorId=").append(prostorId != null ? prostorId.getProstorId() : "null") 
          .append('}');
        return sb.toString();
    }
}