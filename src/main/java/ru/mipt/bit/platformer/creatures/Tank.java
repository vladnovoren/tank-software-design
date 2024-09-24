package ru.mipt.bit.platformer.creatures;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import ru.mipt.bit.platformer.core.GameObject;
import ru.mipt.bit.platformer.core.Renderable;
import ru.mipt.bit.platformer.util.TileMovement;

import static com.badlogic.gdx.math.MathUtils.isEqual;
import static ru.mipt.bit.platformer.util.GdxGameUtils.*;

public class Tank extends GameObject {
    public Tank(float speed) {
        this.speed = speed;
    }

    @Override
    public void tick(float dt) {

    }

//    public Vector2 getDestination() {
//        return destination;
//    }

    public void move(float dt, TileMovement tileMovement) {
        interpolateMovement(tileMovement);
        movementProgress = continueProgress(movementProgress, dt, speed);
        if (isEqual(movementProgress, 1f)) {
            setPosition(destination);
        }
    }

//    public void draw(Batch batch) {
//        drawTextureRegionUnscaled(batch, textureRegion, bounds, rotation);
//    }

    private void interpolateMovement(TileMovement tileMovement) {
        tileMovement.moveRectangleBetweenTileCenters(bounds, position, destination, movementProgress);
    }

    protected Vector2 destination;

    private float speed;
    private float movementProgress = 1.f;
    private float rotation;
}
