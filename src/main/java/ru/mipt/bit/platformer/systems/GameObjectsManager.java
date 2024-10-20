package ru.mipt.bit.platformer.systems;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.GridPoint2;
import com.badlogic.gdx.math.Rectangle;
import ru.mipt.bit.platformer.core.Drawable;
import ru.mipt.bit.platformer.core.GameObject;
import ru.mipt.bit.platformer.core.Pawn;
import ru.mipt.bit.platformer.creatures.*;
import ru.mipt.bit.platformer.util.TileMovement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameObjectsManager {
    public void tick(float dt) {
        for (var gameObject : allGameObjects) {
            gameObject.tick(dt);
        }
    }

    public Tank addTank(GridPoint2 position, float speed, String texturePath, TileMovement tileMovement) {
        var tankSkin = new TankSkin(texturePath);
        var tank = new Tank(new GridPoint2(position), speed, tankSkin.getDefaultBoundingRectangle(), tileMovement);
        var drawableTank = new DrawableTank(tank, tankSkin);

        allGameObjects.add(tank);
        drawables.add(drawableTank);
        movingObjects.add(tank);

        return tank;
    }

    public void addTree(GridPoint2 position, String texturePath, TileMovement tileMovement) {
        var treeSkin = new TreeSkin(texturePath);
        var tree = new Tree(position, treeSkin.getDefaultBoundingRectangle(), tileMovement);
        var drawableTree = new DrawableTree(tree, treeSkin);

        allGameObjects.add(tree);
        drawables.add(drawableTree);
        staticObstacles.add(tree);
    }

    public List<Drawable> getDrawables() {
        return Collections.unmodifiableList(drawables);
    }

    public List<MovingGameObject> getMovingObjects() {
        return Collections.unmodifiableList(movingObjects);
    }

    public List<Pawn> getStaticObstacles() {
        return Collections.unmodifiableList(staticObstacles);
    }

    private final ArrayList<Drawable> drawables = new ArrayList<>();
    private final ArrayList<Pawn> staticObstacles = new ArrayList<>();
    private final ArrayList<MovingGameObject> movingObjects = new ArrayList<>();
    private final ArrayList<GameObject> allGameObjects = new ArrayList<>();
}
