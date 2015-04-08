package de.htwg.se.mastermind.persistence.db4o;

import com.db4o.ObjectContainer;
import com.db4o.Db4oEmbedded;
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
    public IGrid getGrid() {
        return null;
    }

    @Override
    public List<IGrid> getAllGrids() {
        return null;
    }
}
