package de.htwg.se.mastermind.persistence.db4o;

import com.db4o.ObjectContainer;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectSet;
import com.db4o.query.Predicate;
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
    public List<IGrid> getAllGrids() {
        return db.query(IGrid.class);
    }

    @Override
    public void removeAllGrids() {
        List<IGrid> allGrids = this.getAllGrids();

        for (int i = 0; i < allGrids.size(); i++) {
            db.delete(allGrids.get(i));
        }
    }

    @Override
    public void removeGridById(final String removeId) {
        List<IGrid> gridId = db.query(new Predicate<IGrid>() {
            public boolean match(IGrid grid) {
                return grid.getId().equals(removeId);
            }
        });

        for (int i = 0; i < gridId.size(); i++) {
            db.delete(gridId.get(i));
        }
    }
}
