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
import rs.ac.fink.magacin.dao.ProstorDao;
import rs.ac.fink.magacin.dao.ResourcesManager;
import rs.ac.fink.magacin.data.Prostor;
import rs.ac.fink.magacin.exception.MagacinException;

public class ProstorService {

    private static final ProstorService instance = new ProstorService();

    private ProstorService() {
    }

    public static ProstorService getInstance() {
        return instance;
    }

    public void addNewProstor(Prostor prostor) throws MagacinException {
        Connection con = null;
        try {
            con = ResourcesManager.getConnection();
            con.setAutoCommit(false);

            ProstorDao.getInstance().insert(prostor, con);

            con.commit();
        } catch (SQLException ex) {
            ResourcesManager.rollbackTransactions(con);
            throw new MagacinException("Nije moguce dodati novi prostor " + prostor, ex);
        } finally {
            ResourcesManager.closeConnection(con);
        }
    }

    public Prostor findProstor(int prostorId) throws MagacinException {
        Connection con = null;
        try {
            con = ResourcesManager.getConnection();

            return ProstorDao.getInstance().find(prostorId, con);
        } catch (SQLException ex) {
            throw new MagacinException("Nije moguce pronaci prostor koji zelite. " + prostorId, ex);
        } finally {
            ResourcesManager.closeConnection(con);
        }
    }

    public void deleteProstor(int prostorId) throws MagacinException {
        Connection con = null;
        try {
            con = ResourcesManager.getConnection();
            con.setAutoCommit(false);

            Prostor prostor = ProstorDao.getInstance().find(prostorId, con);
            if (prostor != null) {
                ProstorDao.getInstance().delete(prostorId, con);
            }

            con.commit();
        } catch (SQLException ex) {
            ResourcesManager.rollbackTransactions(con);
            throw new MagacinException("Nije moguce obrisati prostor " + prostorId, ex);
        } finally {
            ResourcesManager.closeConnection(con);
        }
    }

    public void updateProstor(Prostor prostor) throws MagacinException {
        Connection con = null;
        try {
            con = ResourcesManager.getConnection();
            con.setAutoCommit(false);

            ProstorDao.getInstance().update(prostor, con);

            con.commit();
        } catch (SQLException ex) {
            ResourcesManager.rollbackTransactions(con);
            throw new MagacinException("Neuspecna izmena. " + prostor, ex);
        } finally {
            ResourcesManager.closeConnection(con);
        }
    }
}

