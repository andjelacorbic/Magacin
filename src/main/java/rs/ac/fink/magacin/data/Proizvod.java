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
    private int kolicina;
    private String napomena;
    private Prostor prostor; 

   
    public Proizvod(int proizvodId, String naziv, String tip, String tezina, int kolicina, String napomena, Prostor prostor) {
        this.proizvodId = proizvodId;
        this.naziv = naziv;
        this.tip = tip;
        this.tezina = tezina;
        this.kolicina = kolicina;
        this.napomena = napomena;
        this.prostor = prostor;
    }
    
    
    public Proizvod(String naziv, String tip, String tezina, int kolicina, String napomena, Prostor prostor) {
        this.naziv = naziv;
        this.tip = tip;
        this.tezina = tezina;
        this.kolicina = kolicina;
        this.napomena = napomena;
        this.prostor = prostor;
    }

    
    public int getProizvodId() {
        return proizvodId;
    }

    public void setProizvodId(int proizvodId) {
        this.proizvodId = proizvodId;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getTezina() {
        return tezina;
    }

    public void setTezina(String tezina) {
        this.tezina = tezina;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    public Prostor getProstor() {
        return prostor;
    }

    public void setProstor(Prostor prostor) {
        this.prostor = prostor;
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
          .append(", prostor=").append(prostor != null ? prostor.getProstorId() : "null") 
          .append('}');
        return sb.toString();
    }
}

