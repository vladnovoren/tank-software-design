package ru.mipt.bit.platformer;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.GridPoint2;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.Rectangle;
import ru.mipt.bit.platformer.util.TileMovement;

import static com.badlogic.gdx.Input.Keys.*;
import static com.badlogic.gdx.graphics.GL20.GL_COLOR_BUFFER_BIT;
import static com.badlogic.gdx.math.MathUtils.isEqual;
import static ru.mipt.bit.platformer.util.GdxGameUtils.*;

public class GameDesktopLauncher implements ApplicationListener {

//    private static final float MOVEMENT_SPEED = 0.4f;
//
//    private Batch batch;
//
//    private TiledMap level;
//    private MapRenderer levelRenderer;
//    private TileMovement tileMovement;
//
//    private Texture blueTankTexture;
//    private TextureRegion playerGraphics;
//    private Rectangle playerRectangle;
//    // player current position coordinates on level 10x8 grid (e.g. x=0, y=1)
//    private GridPoint2 playerCoordinates;
//    // which tile the player want to go next
//    private GridPoint2 playerDestinationCoordinates;
//    private float playerMovementProgress = 1f;
//    private float playerRotation;
//
//    private Texture greenTreeTexture;
//    private TextureRegion treeObstacleGraphics;
//    private GridPoint2 treeObstacleCoordinates = new GridPoint2();
//    private Rectangle treeObstacleRectangle = new Rectangle();

    private World world;

    @Override
    public void create() {
        world = new World();
    }

    @Override
    public void render() {
//        world.tick(0.0f);
    }

    @Override
    public void resize(int width, int height) {
        // do not react to window resizing
    }

    @Override
    public void pause() {
        // game doesn't get paused
    }

    @Override
    public void resume() {
        // game doesn't get paused
    }

    @Override
    public void dispose() {
        // dispose of all the native resources (classes which implement com.badlogic.gdx.utils.Disposable)
//        greenTreeTexture.dispose();
//        blueTankTexture.dispose();
//        level.dispose();
//        batch.dispose();
    }

    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        // level width: 10 tiles x 128px, height: 8 tiles x 128px
        config.setWindowedMode(1280, 1024);
        new Lwjgl3Application(new GameDesktopLauncher(), config);
    }
}
