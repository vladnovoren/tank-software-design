package ru.mipt.bit.platformer.systems;

import com.badlogic.gdx.math.GridPoint2;
import ru.mipt.bit.platformer.core.Drawable;
import ru.mipt.bit.platformer.creatures.DrawableTank;
import ru.mipt.bit.platformer.creatures.MovingGameObject;
import ru.mipt.bit.platformer.creatures.Tank;
import ru.mipt.bit.platformer.creatures.TankSkin;
import ru.mipt.bit.platformer.util.TileMovement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameObjectsManager {
    public void addTank(GridPoint2 position, float speed, String texturePath, TileMovement tileMovement) {
        drawables = new ArrayList<>();
        movingObjects = new ArrayList<>();

        var tank = new Tank(new GridPoint2(position), speed, tileMovement);
        var tankSkin = new TankSkin(texturePath);
        var drawableTank = new DrawableTank(tank, tankSkin);

        drawables.add(drawableTank);
        movingObjects.add(tank);
    }

    public List<Drawable> getDrawables() {
        return Collections.unmodifiableList(drawables);
    }

    public List<MovingGameObject> getMovingObjects() {
        return Collections.unmodifiableList(movingObjects);
    }

    private ArrayList<Drawable> drawables;
    private ArrayList<MovingGameObject> movingObjects;
}
