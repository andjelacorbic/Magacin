/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.fink.magacin.service;

/**
 *
 * @author andje
 */

import java.sql.Connection;
import java.sql.SQLException;
import rs.ac.fink.magacin.dao.ProizvodDao;
import rs.ac.fink.magacin.dao.ResourcesManager;
import rs.ac.fink.magacin.data.Proizvod;
import rs.ac.fink.magacin.exception.MagacinException;

public class ProizvodService {

    private static final ProizvodService instance = new ProizvodService();

    private ProizvodService() {
    }

    public static ProizvodService getInstance() {
        return instance;
    }

    public void addNewProizvod(Proizvod proizvod) throws MagacinException {
        Connection con = null;
        try {
            con = ResourcesManager.getConnection();
            con.setAutoCommit(false);

            ProizvodDao.getInstance().insert(proizvod, con);

            con.commit();
        } catch (SQLException ex) {
            ResourcesManager.rollbackTransactions(con);
            throw new MagacinException("Neuspesno dodavanje novog proizvoda " + proizvod, ex);
        } finally {
            ResourcesManager.closeConnection(con);
        }
    }

    public Proizvod findProizvod(int proizvodId) throws MagacinException {
        Connection con = null;
        try {
            con = ResourcesManager.getConnection();

            return ProizvodDao.getInstance().find(proizvodId, con);
        } catch (SQLException ex) {
            throw new MagacinException("Proizvod ne postoji " + proizvodId, ex);
        } finally {
            ResourcesManager.closeConnection(con);
        }
    }

    public void deleteProizvod(int proizvodId) throws MagacinException {
        Connection con = null;
        try {
            con = ResourcesManager.getConnection();
            con.setAutoCommit(false);

            Proizvod proizvod = ProizvodDao.getInstance().find(proizvodId, con);
            if (proizvod != null) {
                ProizvodDao.getInstance().delete(proizvodId, con);
            }

            con.commit();
        } catch (SQLException ex) {
            ResourcesManager.rollbackTransactions(con);
            throw new MagacinException("Nije moguce obrisati proizvod " + proizvodId, ex);
        } finally {
            ResourcesManager.closeConnection(con);
        }
    }

    public void updateProizvod(Proizvod proizvod) throws MagacinException {
        Connection con = null;
        try {
            con = ResourcesManager.getConnection();
            con.setAutoCommit(false);

            ProizvodDao.getInstance().update(proizvod, con);

            con.commit();
        } catch (SQLException ex) {
            ResourcesManager.rollbackTransactions(con);
            throw new MagacinException("Izmena proizvoda nije moguca " + proizvod, ex);
        } finally {
            ResourcesManager.closeConnection(con);
        }
    }
}

