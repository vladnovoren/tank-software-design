package ru.mipt.bit.platformer.systems;

import ru.mipt.bit.platformer.core.Pawn;
import ru.mipt.bit.platformer.creatures.MovingGameObject;

import java.util.ArrayList;

public class CollisionSystem {
    public void registerObstacle(Pawn obstacle) {
        staticObstacles.add(obstacle);
    }

    public void processMovingGameObjects(ArrayList<? extends MovingGameObject> movingGameObjects) {
        for (var gameObject : movingGameObjects) {
            processMovingGameObject(gameObject);
        }
    }

    private void processMovingGameObject(MovingGameObject movingGameObject) {
        for (var obstacle : staticObstacles) {
            if (!movingGameObject.getRequestedDestination().equals(obstacle.getTransform().position)) {
                movingGameObject.commitRequestedDestination();
            }
        }
    }

    private ArrayList<Pawn> staticObstacles;
}
