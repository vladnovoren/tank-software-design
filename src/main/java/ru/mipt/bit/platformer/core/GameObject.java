package ru.mipt.bit.platformer.core;

import com.badlogic.gdx.math.GridPoint2;

public abstract class GameObject {
    public GameObject() {
        transform = new Transform();
    }

    public GameObject(Transform transform) {
        this.transform = new Transform(transform);
    }

    public GameObject(GridPoint2 position, float rotation) {
        transform = new Transform(position, rotation);
    }

    public void tick(float dt) {}

    public Transform getTransform() {
        return new Transform(transform);
    }

    protected void setTransform(Transform transform) {
        this.transform.copy(transform);
    }

    protected void setPosition(GridPoint2 position) {
        transform.position.set(position);
    }

    protected void setRotation(float rotation) {
        transform.rotation = rotation;
    }

    protected Transform transform;
}
