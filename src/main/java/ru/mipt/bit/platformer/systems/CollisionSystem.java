package ru.mipt.bit.platformer.systems;

import ru.mipt.bit.platformer.core.Pawn;
import ru.mipt.bit.platformer.creatures.MovingGameObject;

import java.util.ArrayList;
import java.util.List;

public class CollisionSystem {
    public void processMovingGameObjects(List<? extends MovingGameObject> movingGameObjects, List<? extends Pawn> staticObstacles) {
        for (var gameObject : movingGameObjects) {
            processMovingGameObject(gameObject, staticObstacles);
        }
    }

    private void processMovingGameObject(MovingGameObject movingGameObject, List<? extends Pawn> staticObstacles) {
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
}
