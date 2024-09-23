package ru.mipt.bit.platformer.creatures;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.GridPoint2;
import com.badlogic.gdx.math.Rectangle;
import ru.mipt.bit.platformer.util.TileMovement;

import static com.badlogic.gdx.math.MathUtils.isEqual;
import static ru.mipt.bit.platformer.util.GdxGameUtils.*;

public class Tank {
    public Tank(String texturePath, float speed) {
        texture = new Texture(texturePath);
        textureRegion = new TextureRegion(texture);
        bounds = createBoundingRectangle(textureRegion);
        this.speed = speed;
    }

    public GridPoint2 getPosition() {
        return position;
    }

    public GridPoint2 getDestination() {
        return destination;
    }

    public void setPosition(GridPoint2 position) {
        this.position = position;
    }

    public void setDestination(GridPoint2 destination) {
        this.destination = destination;
    }

    public void move(float dt, TileMovement tileMovement) {
        interpolateMovement(tileMovement);
        movementProgress = continueProgress(movementProgress, dt, speed);
        if (isEqual(movementProgress, 1f)) {
            position.set(destination);
        }
    }

    public void draw(Batch batch) {
        drawTextureRegionUnscaled(batch, textureRegion, bounds, rotation);
    }

    private void interpolateMovement(TileMovement tileMovement) {
        tileMovement.moveRectangleBetweenTileCenters(bounds, position, destination, movementProgress);
    }

    private GridPoint2 position;
    private GridPoint2 destination;

    private float speed;
    private float movementProgress = 1.f;
    private float rotation;

    private Texture texture;
    private TextureRegion textureRegion;
    private Rectangle bounds;
}
