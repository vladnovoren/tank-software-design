package ru.mipt.bit.platformer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.GridPoint2;
import ru.mipt.bit.platformer.core.Direction;
import ru.mipt.bit.platformer.core.InputActionMap;
import ru.mipt.bit.platformer.core.Map;
import ru.mipt.bit.platformer.core.MoveAction;
import ru.mipt.bit.platformer.systems.CollisionSystem;
import ru.mipt.bit.platformer.systems.GameObjectsManager;
import ru.mipt.bit.platformer.systems.InputHandler;
import ru.mipt.bit.platformer.systems.RenderSystem;

public class World {
    public World() {
        renderSystem = new RenderSystem();

        map = new Map("level.tmx", renderSystem.getBatch());


        renderSystem.registerMap(map);

        gameObjectsManager = new GameObjectsManager();
        var playerTank = gameObjectsManager.addTank(new GridPoint2(1, 1), 0.4f, "images/tank_blue.png", map.getTileMovement());
        gameObjectsManager.addTree(new GridPoint2(3, 4), "images/greenTree.png", map.getTileMovement());

        renderSystem.registerGameObjectsManager(gameObjectsManager);


        collisionSystem = new CollisionSystem();

        InputActionMap.mapAction(Input.Keys.UP, new MoveAction(Direction.UP));
        InputActionMap.mapAction(Input.Keys.DOWN, new MoveAction(Direction.DOWN));
        InputActionMap.mapAction(Input.Keys.LEFT, new MoveAction(Direction.LEFT));
        InputActionMap.mapAction(Input.Keys.RIGHT, new MoveAction(Direction.RIGHT));

        InputActionMap.mapAction(Input.Keys.W, new MoveAction(Direction.UP));
        InputActionMap.mapAction(Input.Keys.A, new MoveAction(Direction.LEFT));
        InputActionMap.mapAction(Input.Keys.S, new MoveAction(Direction.DOWN));
        InputActionMap.mapAction(Input.Keys.D, new MoveAction(Direction.RIGHT));

        inputHandler = new InputHandler(playerTank);
    }

    void tick(float dt) {
        InputActionMap.cacheActualAction();
        InputActionMap.getAction().execute(inputHandler);
        gameObjectsManager.tick(dt);
        collisionSystem.processMovingGameObjects(gameObjectsManager.getMovingObjects(), gameObjectsManager.getStaticObstacles());
        renderSystem.render();
        InputActionMap.invalidateCachedAction();
    }

    private final RenderSystem renderSystem;

    private final Map map;

    private final GameObjectsManager gameObjectsManager;
    private final CollisionSystem collisionSystem;

    private final InputHandler inputHandler;

}
