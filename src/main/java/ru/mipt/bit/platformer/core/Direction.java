package ru.mipt.bit.platformer.core;

import com.badlogic.gdx.math.GridPoint2;

public enum Direction {
    RIGHT(0.0f, new GridPoint2(1, 0)),
    LEFT(180.0f, new GridPoint2(-1, 0)),
    UP(90.0f, new GridPoint2(0, 1)),
    DOWN(-90.0f, new GridPoint2(0, -1));

    private final float angle;
    private final GridPoint2 vector;

    Direction(float angle, GridPoint2 vector) {
        this.angle = angle;
        this.vector = vector;
    }

    public float getAngle() {
        return angle;
    }

    public GridPoint2 getVector() {
        return vector;
    }
}
