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
import rs.ac.fink.magacin.data.Proizvod;
import rs.ac.fink.magacin.data.Prostor;

public class ProizvodDao {

    private static final ProizvodDao instance = new ProizvodDao();

    private ProizvodDao() {
    }

    public static ProizvodDao getInstance() {
        return instance;
    }

    
    public Proizvod find(int proizvodId, Connection con) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Proizvod proizvod = null;
        try {
            ps = con.prepareStatement("SELECT * FROM proizvod WHERE proizvod_id = ?");
            ps.setInt(1, proizvodId);
            rs = ps.executeQuery();
            if (rs.next()) {
                Prostor prostor = ProstorDao.getInstance().find(rs.getInt("prostor_id"), con); 
                proizvod = new Proizvod(
                    proizvodId,
                    rs.getString("naziv"),
                    rs.getString("tip"),
                    rs.getString("tezina"),
                    rs.getString("kolicina"),
                    rs.getString("napomena"),
                    prostor
                );
            }
        } finally {
            ResourcesManager.closeResources(rs, ps);
        }
        return proizvod;
    }

    
    public int insert(Proizvod proizvod, Connection con) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        int id = -1;
        try {
            ps = con.prepareStatement("INSERT INTO proizvod (prostor_id, naziv, tip, tezina, kolicina, napomena) VALUES (?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, proizvod.getProstorId().getProstorId());
            ps.setString(2, proizvod.getNaziv());
            ps.setString(3, proizvod.getTip());
            ps.setString(4, proizvod.getTezina());
            ps.setString(5, proizvod.getKolicina());
            ps.setString(6, proizvod.getNapomena());
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

    
    public void update(Proizvod proizvod, Connection con) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("UPDATE proizvod SET prostor_id = ?, naziv = ?, tip = ?, tezina = ?, kolicina = ?, napomena = ? WHERE proizvod_id = ?");
            ps.setInt(1, proizvod.getProstorId().getProstorId()); 
            ps.setString(2, proizvod.getNaziv());
            ps.setString(3, proizvod.getTip());
            ps.setString(4, proizvod.getTezina());
            ps.setString(5, proizvod.getKolicina());
            ps.setString(6, proizvod.getNapomena());
            ps.setInt(7, proizvod.getProizvodId());
            ps.executeUpdate();
        } finally {
            ResourcesManager.closeResources(null, ps);
        }
    }

   
    public void delete(int proizvodId, Connection con) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("DELETE FROM proizvod WHERE proizvod_id = ?");
            ps.setInt(1, proizvodId);
            ps.executeUpdate();
        } finally {
            ResourcesManager.closeResources(null, ps);
        }
    }
}