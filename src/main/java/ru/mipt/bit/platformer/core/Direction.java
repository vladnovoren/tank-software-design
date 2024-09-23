package ru.mipt.bit.platformer.core;

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
}
