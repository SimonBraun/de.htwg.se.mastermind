package de.htwg.se.mastermind.persistence.couchdb;

import de.htwg.se.mastermind.model.IGrid;
import de.htwg.se.mastermind.persistence.IGridDAO;
import org.ektorp.CouchDbConnector;
import org.ektorp.CouchDbInstance;
import org.ektorp.http.HttpClient;
import org.ektorp.http.StdHttpClient;
import org.ektorp.impl.StdCouchDbInstance;

import java.net.MalformedURLException;
import java.util.List;

public class GridCouchdbDAO implements IGridDAO {

    private CouchDbConnector db = null;

    public GridCouchdbDAO() {
        HttpClient client = null;
        try {
            client = new StdHttpClient.Builder().url(
                    "http://lenny2.in.htwg-konstanz.de:5984").build();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        CouchDbInstance dbInstance = new StdCouchDbInstance(client);
        db = dbInstance.createConnector("mastermind_db", true);
    }

    @Override
    public void saveGrid(IGrid grid) {

    }

    @Override
    public List<IGrid> getAllGrids() {
        return null;
    }

    @Override
    public void removeAllGrids() {

    }

    @Override
    public void removeGridById(String id) {

    }
}
