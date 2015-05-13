package de.htwg.se.mastermind.persistence.hibernate;
import com.db4o.ObjectContainer;
import com.db4o.Db4oEmbedded;
import com.db4o.query.Predicate;
import com.db4o.query.Query;
import de.htwg.se.mastermind.model.Grid;
import de.htwg.se.mastermind.model.IGrid;
import de.htwg.se.mastermind.persistence.IGridDAO;

import java.util.List;

public class GridHibernateDAO implements IGridDAO {
    private ObjectContainer db;

    public GridHibernateDAO() {
        db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "grid.data");
    }

    public void closeDb() {
        db.close();
    }

    @Override
    public void saveGrid(IGrid grid) {
        db.store(grid);
    }

    @Override
    public List<IGrid> getAllGrids() {
        Query query = db.query();
        query.constrain(Grid.class);
        query.descend("actualRow").orderAscending();
        query.descend("date").orderAscending();

        List<IGrid> grids = query.execute();
        return grids;
    }

    @Override
    public void removeAllGrids() {
        List<IGrid> allGrids = this.getAllGrids();

        for (IGrid grid : allGrids) {
            db.delete(grid);
        }
    }

    @Override
    public void removeGridById(final String removeId) {
        List<IGrid> gridId = db.query(new Predicate<IGrid>() {
            public boolean match(IGrid grid) {
                return grid.getId().equals(removeId);
            }
        });

        for (IGrid grid : gridId) {
            db.delete(grid);
        }
    }
}
