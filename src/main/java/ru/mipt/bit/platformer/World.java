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
        gameObjectsManager.addTree(new GridPoint2(3, 4), "images/greenTree.png", map.getTileMovement());

        renderSystem.registerGameObjectsManager(gameObjectsManager);


        collisionSystem = new CollisionSystem();
    }

    void tick(float dt) {
        renderSystem.render();
        gameObjectsManager.tick(dt);
        collisionSystem.processMovingGameObjects(gameObjectsManager.getMovingObjects(), gameObjectsManager.getStaticObstacles());
    }

    private final RenderSystem renderSystem;

    private final Map map;

    private final GameObjectsManager gameObjectsManager;
    private final CollisionSystem collisionSystem;

}
