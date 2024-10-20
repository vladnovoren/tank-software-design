package ru.mipt.bit.platformer.core;

import ru.mipt.bit.platformer.systems.InputHandler;

public abstract class Action {
    public abstract void execute(InputHandler inputHandler);
}
