package ru.mipt.bit.platformer.systems;

import com.badlogic.gdx.math.GridPoint2;
import ru.mipt.bit.platformer.creatures.Tank;
import ru.mipt.bit.platformer.creatures.TankSkin;
import ru.mipt.bit.platformer.util.TileMovement;

public class GameObjectsManager {
    public GameObjectsManager(TileMovement tileMovement) {
        var tank = new Tank(new GridPoint2(1, 1), 0.4f, tileMovement);
        var tankSkin = new TankSkin("images/tank_blue.png");
        var renderable_tank = new
    }
}
