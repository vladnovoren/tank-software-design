package ru.mipt.bit.platformer;

import com.badlogic.gdx.math.GridPoint2;
import ru.mipt.bit.platformer.core.Map;
import ru.mipt.bit.platformer.systems.CollisionSystem;
import ru.mipt.bit.platformer.systems.GameObjectsManager;
import ru.mipt.bit.platformer.systems.RenderSystem;

public class World {
    public World() {
        renderSystem = new RenderSystem();
        map = new Map("level.tmx", renderSystem.getBatch());
        renderSystem.registerMap(map);
        gameObjectsManager = new GameObjectsManager();
        gameObjectsManager.addTank(new GridPoint2(1, 1), 0.4f, "images/tank_blue.png", map.getTileMovement());
        renderSystem.registerGameObjectsManager(gameObjectsManager);
        collisionSystem = new CollisionSystem();
    }

    void tick(float dt) {
        renderSystem.render();
    }

    private RenderSystem renderSystem;

    private Map map;

    private GameObjectsManager gameObjectsManager;
    private CollisionSystem collisionSystem;

}
