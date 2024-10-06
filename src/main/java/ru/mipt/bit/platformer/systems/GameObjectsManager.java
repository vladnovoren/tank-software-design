package ru.mipt.bit.platformer.systems;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.GridPoint2;
import com.badlogic.gdx.math.Rectangle;
import ru.mipt.bit.platformer.core.Drawable;
import ru.mipt.bit.platformer.core.GameObject;
import ru.mipt.bit.platformer.creatures.DrawableTank;
import ru.mipt.bit.platformer.creatures.MovingGameObject;
import ru.mipt.bit.platformer.creatures.Tank;
import ru.mipt.bit.platformer.creatures.TankSkin;
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

    public void addTank(GridPoint2 position, float speed, String texturePath, TileMovement tileMovement) {
        var tankSkin = new TankSkin(texturePath);
        var tank = new Tank(new GridPoint2(position), speed, tankSkin.getDefaultBoundingRectangle(), tileMovement);
        var drawableTank = new DrawableTank(tank, tankSkin);

        drawables.add(drawableTank);
        movingObjects.add(tank);
        allGameObjects.add(tank);
    }

    public List<Drawable> getDrawables() {
        return Collections.unmodifiableList(drawables);
    }

    public List<MovingGameObject> getMovingObjects() {
        return Collections.unmodifiableList(movingObjects);
    }

    private final ArrayList<Drawable> drawables = new ArrayList<>();
    private final ArrayList<MovingGameObject> movingObjects = new ArrayList<>();
    private final ArrayList<GameObject> allGameObjects = new ArrayList<>();
}
