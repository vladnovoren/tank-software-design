package ru.mipt.bit.platformer.systems;

import ru.mipt.bit.platformer.core.MoveAction;
import ru.mipt.bit.platformer.creatures.Tank;

public class InputHandler {
    public InputHandler(Tank playerTank) {
        this.playerTank = playerTank;
    }

    public void handle(MoveAction action) {
        System.out.println("action");
        playerTank.requestMovement(action.getDirection());
    }

    private final Tank playerTank;
}
