package ru.mipt.bit.platformer.core;

import com.badlogic.gdx.math.GridPoint2;

public class Transform {
    public Transform() {
        this.position = new GridPoint2();
    }

    public Transform(GridPoint2 position, float rotation) {
        this.position = new GridPoint2(position);
        this.rotation = rotation;
    }

    public Transform(Transform other) {
        this(other.position, other.rotation);
    }

    void copy(Transform other) {
        this.position.set(other.position);
        this.rotation = other.rotation;
    }

    public GridPoint2 position;
    public float rotation;
}
