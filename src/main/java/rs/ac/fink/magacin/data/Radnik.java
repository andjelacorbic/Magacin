/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.fink.magacin.data;
/**
 *
 * @author andje
 */
public class Radnik {
   
    private int id;

    private String ime;
    private String prezime;
    private String username;
    private String telefon;

    public Radnik(int id, String ime, String prezime, String username, String telefon) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.username = username;
        this.telefon = telefon;
    }

    public Radnik() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Radnik{")
          .append("id=").append(id)
          .append(", ime='").append(ime).append('\'')
          .append(", prezime='").append(prezime).append('\'')
          .append(", username='").append(username).append('\'')
          .append(", telefon='").append(telefon).append('\'')
          .append("}");
    return sb.toString();
}


}