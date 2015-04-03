package de.htwg.se.mastermind;

import com.google.inject.AbstractModule;
import de.htwg.se.mastermind.controller.IController;
import de.htwg.se.mastermind.controller.Controller;

public class MastermindModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(IController.class).to(Controller.class);
    }
}
