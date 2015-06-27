package de.htwg.se.mastermind.persistence.hibernate;

import de.htwg.se.mastermind.model.Grid;
import de.htwg.se.mastermind.model.IGrid;
import de.htwg.se.mastermind.persistence.IGridDAO;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class GridHibernateDAO implements IGridDAO {

    private Session session;

    public GridHibernateDAO() {
        this.session = HibernateUtil.getInstance().openSession();
    }

    private IGrid copyGrid(PersistentGrid pgrid) {
        if (pgrid == null) {
            return null;
        }

        IGrid grid = new Grid(pgrid.getRowsAmount(), pgrid.getColumnsAmount());
        grid.setId(pgrid.getId());
        grid.setUsername(pgrid.getName());
        grid.setActualRow(pgrid.getActualRow());
        grid.setDate(pgrid.getDate());

        return grid;
    }

    private PersistentGrid copyGrid(IGrid grid) {
        if (grid == null) {
            return null;
        }

        PersistentGrid pgrid = new PersistentGrid();
        pgrid.setId(grid.getId());
        pgrid.setName(grid.getUsername());
        pgrid.setRowsAmount(grid.getRowsAmount());
        pgrid.setColumnsAmount(grid.getColumnsAmount());
        pgrid.setActualRow(grid.getActualRow());
        pgrid.setDate(grid.getDate());

        return  pgrid;
    }

    @Override
    public void saveGrid(IGrid grid) {
        Transaction tx = null;
        Session session = null;

        try {
            session = HibernateUtil.getInstance().getCurrentSession();
            tx = session.beginTransaction();

            PersistentGrid pgrid = copyGrid(grid);

            session.saveOrUpdate(pgrid);

            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
        }
    }

    @Override
    public IGrid getGridById(String id) {
        Session session = HibernateUtil.getInstance().getCurrentSession();
        session.beginTransaction();

        return copyGrid((PersistentGrid) session.get(PersistentGrid.class, id));
    }

    @Override
    public List<IGrid> getAllGrids() {
        Session session = HibernateUtil.getInstance().getCurrentSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(PersistentGrid.class);

        @SuppressWarnings("unchecked")
        List<PersistentGrid> results = criteria.list();

        List<IGrid> grids = new ArrayList<IGrid>();
        for (PersistentGrid pgrid : results) {
            IGrid grid = copyGrid(pgrid);
            grids.add(grid);
        }
        return grids;
    }

    @Override
    public void removeAllGrids() {
        List<IGrid> lst = getAllGrids();

        for (IGrid grid : lst) {
            removeGridById(grid.getId());
        }
    }

    @Override
    public void removeGridById(String id) {
        Transaction tx = null;
        Session session = null;

        try {
            session = HibernateUtil.getInstance().getCurrentSession();
            tx = session.beginTransaction();

            PersistentGrid pgrid = (PersistentGrid) session.get(PersistentGrid.class, id);

            session.delete(pgrid);

            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
        }
    }
}
