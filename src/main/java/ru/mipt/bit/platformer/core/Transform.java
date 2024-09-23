package ru.mipt.bit.platformer.core;

import ru.mipt.bit.platformer.util.Vector2D;

public class Transform {
    public Transform() {
        this.position = new Vector2D();
    }

    public Transform(Vector2D position, float rotation) {
        this.position = new Vector2D(position.x, position.y);
        this.rotation = rotation;
    }

    public Transform(Transform other) {
        this(other.position, other.rotation);
    }

    void copy(Transform other) {
        this.position.setLocation(other.position);
        this.rotation = other.rotation;
    }

    public Vector2D position;
    public float rotation;
}
