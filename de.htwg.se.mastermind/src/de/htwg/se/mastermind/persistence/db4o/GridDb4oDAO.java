package de.htwg.se.mastermind.persistence.db4o;
import com.db4o.ObjectContainer;
import com.db4o.Db4oEmbedded;
import com.db4o.query.Predicate;
import com.db4o.query.Query;
import de.htwg.se.mastermind.model.Grid;
import de.htwg.se.mastermind.model.IGrid;
import de.htwg.se.mastermind.persistence.IGridDAO;

import java.util.List;

public class GridDb4oDAO implements IGridDAO {
    private ObjectContainer db;

    public GridDb4oDAO() {
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
    public IGrid getGridById(final String id) {
        List<IGrid> grids = db.query(new Predicate<IGrid>() {

            private static final long serialVersionUID = 1L;

            public boolean match(IGrid grid) {
                return (id.equals(grid.getId()));
            }
        });

        if (grids.size() > 0) {
            return grids.get(0);
        }
        return null;
    }

    @Override
    public List<IGrid> getAllGrids() {
        Query query = db.query();
        query.constrain(Grid.class);
        query.descend("actualRow").orderAscending();
        query.descend("date").orderAscending();

        return query.execute();
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
