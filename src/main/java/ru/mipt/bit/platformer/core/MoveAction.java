package ru.mipt.bit.platformer.core;

import ru.mipt.bit.platformer.systems.InputHandler;

public class MoveAction extends Action {
    public MoveAction(Direction direction) {
        this.direction = direction;
    }

    @Override
    public void execute(InputHandler inputHandler) {
        inputHandler.handle(this);
    }

    public Direction getDirection() {
        return direction;
    }

    private final Direction direction;
}
