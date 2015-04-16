package de.htwg.se.mastermind.persistence;

import de.htwg.se.mastermind.model.IGrid;

import java.util.List;

public interface IGridDAO {

    void saveGrid(IGrid grid);

    List<IGrid> getAllGrids();

    void removeAllGrids();

    void removeGridById(String id);
}
