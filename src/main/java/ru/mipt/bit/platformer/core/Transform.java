package ru.mipt.bit.platformer.core;

import com.badlogic.gdx.math.Vector2;

public class Transform {
    public Transform() {
        this.position = new Vector2();
    }

    public Transform(Vector2 position, float rotation) {
        this.position = new Vector2(position);
        this.rotation = rotation;
    }

    public Transform(Transform other) {
        this(other.position, other.rotation);
    }

    void copy(Transform other) {
        this.position.set(other.position);
        this.rotation = other.rotation;
    }

    public Vector2 position;
    public float rotation;
}
