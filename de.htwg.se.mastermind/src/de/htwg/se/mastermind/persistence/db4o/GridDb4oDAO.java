package de.htwg.se.mastermind.persistence.db4o;

import com.db4o.ObjectContainer;
import com.db4o.Db4oEmbedded;

public class GridDb4oDAO {
    private ObjectContainer db;

    public GridDb4oDAO() {
        db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "grid.data");
    }

    public void closeDb() {
        db.close();
    }
}
