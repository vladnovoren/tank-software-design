package ru.mipt.bit.platformer.creatures;

import com.badlogic.gdx.graphics.g2d.Batch;
import ru.mipt.bit.platformer.core.Drawable;

import static ru.mipt.bit.platformer.util.GdxGameUtils.drawTextureRegionUnscaled;

public class RenderableTank implements Drawable {
    public RenderableTank(Tank tank, TankSkin skin) {
        this.tank = tank;
        this.skin = skin;
    }

    public void draw(Batch batch) {
        skin.render(batch, tank.getTransform());
    }

    private Tank tank;
    private TankSkin skin;
}
