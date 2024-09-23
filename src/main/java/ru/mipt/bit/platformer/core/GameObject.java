package ru.mipt.bit.platformer.core;

import ru.mipt.bit.platformer.util.Vector2D;

public abstract class GameObject {
    public GameObject(Transform transform) {
        this.transform = new Transform(transform);
    }

    public GameObject(Vector2D position, float rotation) {
        this.transform = new Transform(position, rotation);
    }

    public abstract void Tick(float dt);

    public Transform getTransform() {
        return new Transform(transform);
    }

    public Vector2D getPosition() {
        return transform.position;
    }

    protected Transform transform;
}
