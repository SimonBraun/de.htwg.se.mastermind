package de.htwg.se.mastermind;

import com.google.inject.AbstractModule;
import de.htwg.se.mastermind.controller.Controller;
import de.htwg.se.mastermind.controller.IController;
import de.htwg.se.mastermind.persistence.IGridDAO;
import de.htwg.se.mastermind.util.*;

public class MastermindModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(IController.class).to(Controller.class);
        bind(IGridDAO.class).to(de.htwg.se.mastermind.persistence.db4o.GridDb4oDAO.class);
        //bind(IGridDAO.class).to(de.htwg.se.mastermind.persistence.couchdb.GridCouchdbDAO.class);
        //bind(IGridDAO.class).to(de.htwg.se.mastermind.persistence.hibernate.GridHibernateDAO.class);
        bind(Plugin.class).to(de.htwg.se.mastermind.util.ColorPlugin.class);
    }
}
