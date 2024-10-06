package ru.mipt.bit.platformer.creatures;

import com.badlogic.gdx.graphics.g2d.Batch;
import ru.mipt.bit.platformer.core.Drawable;

public class DrawableTank implements Drawable {
    public DrawableTank(Tank tank, TankSkin skin) {
        this.tank = tank;
        this.skin = skin;
    }

    public void draw(Batch batch) {
        skin.draw(batch, tank.getTransform(), tank.getBounds());
    }

    private final Tank tank;
    private final TankSkin skin;
}
