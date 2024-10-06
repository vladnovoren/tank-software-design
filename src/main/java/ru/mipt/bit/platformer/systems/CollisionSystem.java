package ru.mipt.bit.platformer.systems;

import ru.mipt.bit.platformer.core.Pawn;
import ru.mipt.bit.platformer.creatures.MovingGameObject;

import java.util.ArrayList;
import java.util.List;

public class CollisionSystem {
    public void registerObstacle(Pawn obstacle) {
        staticObstacles.add(obstacle);
    }

    public void processMovingGameObjects(List<? extends MovingGameObject> movingGameObjects) {
        for (var gameObject : movingGameObjects) {
            processMovingGameObject(gameObject);
        }
    }

    private void processMovingGameObject(MovingGameObject movingGameObject) {
        boolean commit = true;
        for (var obstacle : staticObstacles) {
            if (movingGameObject.getRequestedDestination().equals(obstacle.getTransform().position)) {
                commit = false;
                break;
            }
        }
        if (commit) {
            movingGameObject.commitRequestedDestination();
        }
    }

    private final ArrayList<Pawn> staticObstacles = new ArrayList<>();
}
