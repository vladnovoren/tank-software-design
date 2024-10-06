package ru.mipt.bit.platformer.core;

import com.badlogic.gdx.math.GridPoint2;

public abstract class Pawn extends GameObject {
    public Pawn(Transform transform) {
        super(transform);
    }

    public Pawn(GridPoint2 position, float rotation) {
        super(position, rotation);
    }

    @Override
    public void setTransform(Transform transform) {
        super.setTransform(transform);
    }

    @Override
    public void setPosition(GridPoint2 position) {
        super.setPosition(position);
    }

    @Override
    public void setRotation(float rotation) {
        super.setRotation(rotation);
    }
}
