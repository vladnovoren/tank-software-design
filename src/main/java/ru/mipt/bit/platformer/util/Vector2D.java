package ru.mipt.bit.platformer.util;

import java.awt.geom.Point2D;

public class Vector2D extends Point2D.Float {
    public Vector2D() {}

    public Vector2D(float x, float y) {
        super(x, y);
    }

    public Vector2D(Vector2D other) {
        this(other.x, other.y);
    }

    Vector2D add(Vector2D other) {
        x += other.x;
        y += other.y;
        return this;
    }

    Vector2D sub(Vector2D other) {
        x -= other.x;
        y -= other.y;
        return this;
    }
}
