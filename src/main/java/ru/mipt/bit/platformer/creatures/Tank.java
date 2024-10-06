package ru.mipt.bit.platformer.creatures;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.GridPoint2;
import com.badlogic.gdx.math.Rectangle;
import ru.mipt.bit.platformer.core.Direction;
import ru.mipt.bit.platformer.core.GameObject;
import ru.mipt.bit.platformer.util.TileMovement;

import static com.badlogic.gdx.Input.Keys.*;
import static com.badlogic.gdx.math.MathUtils.isEqual;
import static ru.mipt.bit.platformer.util.GdxGameUtils.*;

public class Tank extends GameObject implements MovingGameObject {
    public Tank(GridPoint2 position, float speed, Rectangle boundingRectangle, TileMovement tileMovement) {
        super(position, Direction.RIGHT.getAngle());
        requestedDestination = new GridPoint2(position);
        destination = new GridPoint2(position);
        this.tileMovement = tileMovement;
        setBounds(boundingRectangle);
        this.speed = speed;
    }

    @Override
    public void tick(float dt) {
        move(dt, tileMovement);
        processInput();
    }

    public void move(float dt, TileMovement tileMovement) {
        interpolateMovement(tileMovement);
        movementProgress = continueProgress(movementProgress, dt, speed);
        if (isEqual(movementProgress, 1f)) {
            setPosition(destination);
        }
    }

    private void interpolateMovement(TileMovement tileMovement) {
        tileMovement.moveRectangleBetweenTileCenters(bounds, transform.position, destination, movementProgress);
    }

    @Override
    public GridPoint2 getRequestedDestination() {
        return requestedDestination.cpy();
    }

    @Override
    public void commitRequestedDestination() {
        destination.set(requestedDestination);
    }

    public Rectangle getBounds() {
        return new Rectangle(bounds);
    }

    private void setBounds(Rectangle bounds) {
        this.bounds = new Rectangle(bounds);
        tileMovement.moveRectangleBetweenTileCenters(this.bounds, transform.position, transform.position, 1.0f);
    }

    private void processInput() {
        if (Gdx.input.isKeyPressed(UP) || Gdx.input.isKeyPressed(W)) {
            if (isEqual(movementProgress, 1f)) {
                requestedDestination = transform.position.cpy().add(Direction.UP.getVector());
                movementProgress = 0f;
                transform.rotation = Direction.UP.getAngle();
            }
        }
        if (Gdx.input.isKeyPressed(LEFT) || Gdx.input.isKeyPressed(A)) {
            if (isEqual(movementProgress, 1f)) {
                requestedDestination = transform.position.cpy().add(Direction.LEFT.getVector());
                movementProgress = 0f;
                transform.rotation = Direction.LEFT.getAngle();
            }
        }
        if (Gdx.input.isKeyPressed(DOWN) || Gdx.input.isKeyPressed(S)) {
            if (isEqual(movementProgress, 1f)) {
                requestedDestination = transform.position.cpy().add(Direction.DOWN.getVector());
                movementProgress = 0f;
                transform.rotation = Direction.DOWN.getAngle();
            }
        }
        if (Gdx.input.isKeyPressed(RIGHT) || Gdx.input.isKeyPressed(D)) {
            if (isEqual(movementProgress, 1f)) {
                requestedDestination = transform.position.cpy().add(Direction.RIGHT.getVector());
                movementProgress = 0f;
                transform.rotation = Direction.RIGHT.getAngle();
            }
        }
    }

    private GridPoint2 requestedDestination;
    private GridPoint2 destination;
    private Rectangle bounds;

    private float speed;
    private float movementProgress = 1.f;
    private float rotation;
    private TileMovement tileMovement;
}
