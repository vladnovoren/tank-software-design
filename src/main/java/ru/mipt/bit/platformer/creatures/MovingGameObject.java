package ru.mipt.bit.platformer.creatures;

import com.badlogic.gdx.math.GridPoint2;

public interface MovingGameObject {
    GridPoint2 getRequestedDestination();

    void commitRequestedDestination();
}
