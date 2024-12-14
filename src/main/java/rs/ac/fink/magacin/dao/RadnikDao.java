/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.fink.magacin.dao;

/**
 *
 * @author andje
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import rs.ac.fink.magacin.data.Radnik;

public class RadnikDao {

    private static final RadnikDao instance = new RadnikDao();

    private RadnikDao() {
    }

    public static RadnikDao getInstance() {
        return instance;
    }

    
    public Radnik find(int idRadnik, Connection con) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Radnik radnik = null;
        try {
            ps = con.prepareStatement("SELECT * FROM radnik WHERE radnik_id=?");
            ps.setInt(1, idRadnik);
            rs = ps.executeQuery();
            if (rs.next()) {
                radnik = new Radnik();
                radnik.setId(rs.getInt("radnik_id"));
                radnik.setImePrezime(rs.getString("ime_i_prezime"));
                radnik.setUsername(rs.getString("username"));
                radnik.setPassword(rs.getString("password"));
                radnik.setTelefon(rs.getString("telefon"));
            }
        } finally {
            ResourcesManager.closeResources(rs, ps);
        }
        return radnik;
    }

    
    public int insert(Radnik radnik, Connection con) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        int radnik_id = -1;
        try {
            ps = con.prepareStatement("INSERT INTO radnik(ime_i_prezime, username, password, telefon) VALUES(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, radnik.getImePrezime());
            ps.setString(2, radnik.getUsername());
            ps.setString(3, radnik.getPassword());
            ps.setString(4, radnik.getTelefon());
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                radnik_id = rs.getInt(1);
            }
        } finally {
            ResourcesManager.closeResources(rs, ps);
        }
        return radnik_id;
    }

    
    public void update(Radnik radnik, Connection con) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("UPDATE radnik SET ime_i_prezime=?, username=?, password=?, telefon=? WHERE radnik_id=?");
            ps.setString(1, radnik.getImePrezime());
            ps.setString(2, radnik.getUsername());
            ps.setString(3, radnik.getPassword());
            ps.setString(4, radnik.getTelefon());
            ps.setInt(5, radnik.getId());
            ps.executeUpdate();
        } finally {
            ResourcesManager.closeResources(null, ps);
        }
    }

    
    public void delete(int idRadnik, Connection con) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("DELETE FROM radnik WHERE radnik_id=?");
            ps.setInt(1, idRadnik);
            ps.executeUpdate();
        } finally {
            ResourcesManager.closeResources(null, ps);
        }
    }
}

