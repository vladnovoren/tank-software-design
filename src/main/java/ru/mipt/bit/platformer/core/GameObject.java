package ru.mipt.bit.platformer.core;

import com.badlogic.gdx.math.Vector2;

public abstract class GameObject {
    public GameObject() {
        transform = new Transform();
    }

    public GameObject(Transform transform) {
        this.transform = new Transform(transform);
    }

    public GameObject(Vector2 position, float rotation) {
        this.transform = new Transform(position, rotation);
    }

    public abstract void tick(float dt);

    public Transform getTransform() {
        return new Transform(transform);
    }

    protected void setTransform(Transform transform) {
        this.transform.copy(transform);
    }

    protected void setPosition(Vector2 position) {
        this.transform.position.set(position);
    }

    protected void setRotation(float rotation) {
        this.transform.rotation = rotation;
    }

    private Transform transform;
}
