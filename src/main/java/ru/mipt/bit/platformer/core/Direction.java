package ru.mipt.bit.platformer.core;

import com.badlogic.gdx.math.GridPoint2;

public enum Direction {
    RIGHT(0.0f),
    LEFT(180.0f),
    UP(90.0f),
    DOWN(-90.0f);

    private final float angle;

    Direction(float angle) {
        this.angle = angle;
    }

    public float getAngle() {
        return angle;
    }

    public GridPoint2 getVector() {
        switch (this) {
            case UP:
                return new GridPoint2(0, 1);
            case DOWN:
                return new GridPoint2(0, -1);
            case LEFT:
                return new GridPoint2(-1, 0);
            case RIGHT:
                return new GridPoint2(1, 0);
            default:
                return new GridPoint2(0, 0);
        }
    }
}
