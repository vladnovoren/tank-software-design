package ru.mipt.bit.platformer.core;

import ru.mipt.bit.platformer.util.Vector2D;

public abstract class Pawn extends GameObject {
    public Pawn(Transform transform) {
        super(transform);
    }

    public Pawn(Vector2D position, float rotation) {
        super(position, rotation);
    }

    public void setTransform(Transform transform) {
        this.transform = transform;
    }

    public void setPosition(Vector2D position) {
        this.transform.position.setLocation(position);
    }

    public void setRotation(float rotation) {
        this.transform.rotation = rotation;
    }
}
