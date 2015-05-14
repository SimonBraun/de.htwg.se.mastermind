package de.htwg.se.mastermind.persistence.hibernate;

import de.htwg.se.mastermind.model.Grid;
import de.htwg.se.mastermind.model.IGrid;
import de.htwg.se.mastermind.persistence.IGridDAO;

import java.util.List;

public class GridHibernateDAO implements IGridDAO {

    public GridHibernateDAO() {
        HttpClient client = null;
        try {
            client = new StdHttpClient.Builder().url("http://lenny2.in.htwg-konstanz.de:5984").build();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        CouchDbInstance dbInstance = new StdCouchDbInstance(client);
        db = dbInstance.createConnector("mastermind_db", true);
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
        db.create(grid.getId(), copyGrid(grid));
    }

    @Override
    public IGrid getGridById(String id) {
        PersistentGrid g = db.find(PersistentGrid.class, id);
        if (g == null) {
            return null;
        }
        return copyGrid(g);
    }

    @Override
    public List<IGrid> getAllGrids() {
        List<IGrid> lst = new ArrayList<IGrid>();
        ViewQuery query = new ViewQuery().allDocs();
        ViewResult vr = db.queryView(query);
        for (Row r : vr.getRows()) {
            lst.add(getGridById(r.getId()));
        }

        Collections.sort(lst);

        return lst;
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
        PersistentGrid g = db.find(PersistentGrid.class, id);
        db.delete(g);
    }
}
