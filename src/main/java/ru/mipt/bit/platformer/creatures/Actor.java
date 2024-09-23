package ru.mipt.bit.platformer.creatures;

import com.badlogic.gdx.math.GridPoint2;
import com.badlogic.gdx.math.Rectangle;
import ru.mipt.bit.platformer.core.GameObject;
import ru.mipt.bit.platformer.util.TileMovement;

import static com.badlogic.gdx.math.MathUtils.isEqual;
import static ru.mipt.bit.platformer.util.GdxGameUtils.continueProgress;

public abstract class Actor extends GameObject {
    public Actor(GridPoint2 position, float rotation, float speed) {
        super(position, rotation);
        setSpeed(speed);
    }

    public void move(float dt, TileMovement tileMovement) {
        interpolateMovement(tileMovement);
        movementProgress = continueProgress(movementProgress, dt, speed);
        if (isEqual(movementProgress, 1f)) {
            position.set(destination);
        }
    }

    public GridPoint2 getDestination() {
        return destination;
    }

    public float getSpeed() {
        return speed;
    }

    public void setDestination(GridPoint2 destination) {
        this.destination = destination;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    protected void interpolateMovement(TileMovement tileMovement) {
        tileMovement.moveRectangleBetweenTileCenters(bounds, position, destination, movementProgress);
    }

    protected GridPoint2 destination;
    protected float speed;
    protected float movementProgress;

    protected Rectangle bounds;
}
