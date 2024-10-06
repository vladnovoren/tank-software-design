package ru.mipt.bit.platformer.systems;

import com.badlogic.gdx.maps.MapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import ru.mipt.bit.platformer.util.TileMovement;

public class Map {
    public Map() {
    }

    private TiledMap level;
    private MapRenderer levelRenderer;
    private TileMovement tileMovement;
}
