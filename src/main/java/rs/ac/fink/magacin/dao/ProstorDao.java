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
import rs.ac.fink.magacin.data.Prostor;
import rs.ac.fink.magacin.data.Radnik;

public class ProstorDao {

    private static final ProstorDao instance = new ProstorDao();

    private ProstorDao() {
    }

    public static ProstorDao getInstance() {
        return instance;
    }

    
    public Prostor find(int idProstor, Connection con) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Prostor prostor = null;
        try {
            ps = con.prepareStatement("SELECT * FROM prostor WHERE prostorId=?");
            ps.setInt(1, idProstor);
            rs = ps.executeQuery();
            if (rs.next()) {
                Radnik radnik = RadnikDao.getInstance().find(rs.getInt("fk_radnik"), con); 
                prostor = new Prostor(rs.getString("imeMagacina"), radnik);
                prostor.setProstorId(rs.getInt("prostorId"));
                prostor.setImeMagacina(rs.getString("imeMagacina"));
                prostor.setRadnik(radnik);
            }
        } finally {
            ResourcesManager.closeResources(rs, ps);
        }
        return prostor;
    }

    
    public int insert(Prostor prostor, Connection con) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        int id = -1;
        try {
            ps = con.prepareStatement("INSERT INTO prostor(imeMagacina, fk_radnik) VALUES(?, ?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, prostor.getImeMagacina());
            ps.setInt(2, prostor.getRadnik().getId());  
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            }
        } finally {
            ResourcesManager.closeResources(rs, ps);
        }
        return id;
    }

    
    public void update(Prostor prostor, Connection con) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("UPDATE prostor SET imeMagacina=?, fk_radnik=? WHERE prostorId=?");
            ps.setString(1, prostor.getImeMagacina());
            ps.setInt(2, prostor.getRadnik().getId());
            ps.setInt(3, prostor.getProstorId());
            ps.executeUpdate();
        } finally {
            ResourcesManager.closeResources(null, ps);
        }
    }

    
    public void delete(int idProstor, Connection con) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("DELETE FROM prostor WHERE prostorId=?");
            ps.setInt(1, idProstor);
            ps.executeUpdate();
        } finally {
            ResourcesManager.closeResources(null, ps);
        }
    }
}