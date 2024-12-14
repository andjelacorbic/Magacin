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

    private String imePrezime;
    private String username;
    private String password;
    private String telefon;
    
    public Radnik() {
    }

    public Radnik(int id, String imePrezime, String username, String password, String telefon) {
        this.id = id;
        this.imePrezime = imePrezime;
        this.username = username;
        this.password = password;
        this.telefon = telefon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

  
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Radnik{")
          .append("id=").append(id)
          .append(", imePrezime='").append(imePrezime).append('\'')
          .append(", username='").append(username).append('\'')
          .append(", password='").append(password).append('\'')
          .append(", telefon='").append(telefon).append('\'')
          .append("}");
    return sb.toString();
}


}