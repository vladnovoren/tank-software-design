package ru.mipt.bit.platformer.creatures;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.GridPoint2;
import com.badlogic.gdx.math.Rectangle;

import static com.badlogic.gdx.math.MathUtils.isEqual;
import static ru.mipt.bit.platformer.util.GdxGameUtils.continueProgress;
import static ru.mipt.bit.platformer.util.GdxGameUtils.createBoundingRectangle;

public class Tank {
    public Tank(String texturePath) {
        texture = new Texture(texturePath);
        textureRegion = new TextureRegion(texture);
        bounds = createBoundingRectangle(textureRegion);
    }

    GridPoint2 getPosition() {
        return position;
    }

    GridPoint2 getDestination() {
        return destination;
    }

    void setPosition(GridPoint2 position) {
        this.position = position;
    }

    void setDestination(GridPoint2 destination) {
        this.destination = destination;
    }

    void move(float dt) {
        movementProgress = continueProgress(movementProgress, dt, speed);
        if (isEqual(movementProgress, 1f)) {
            position.set(destination);
        }
    }

    private GridPoint2 position;
    private GridPoint2 destination;

    private float speed;
    private float movementProgress = 0.f;
    private float rotation;

    private Texture texture;
    private TextureRegion textureRegion;
    private Rectangle bounds;
}
