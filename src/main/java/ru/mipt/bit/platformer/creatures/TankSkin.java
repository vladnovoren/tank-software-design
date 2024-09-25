package ru.mipt.bit.platformer.creatures;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import ru.mipt.bit.platformer.core.Transform;

import static ru.mipt.bit.platformer.util.GdxGameUtils.createBoundingRectangle;
import static ru.mipt.bit.platformer.util.GdxGameUtils.drawTextureRegionUnscaled;

public class TankSkin {
    public TankSkin(String texturePath) {
        texture = new Texture(texturePath);
        textureRegion = new TextureRegion(texture);
        bounds = createBoundingRectangle(textureRegion);
    }

    public void render(Batch batch, Transform transform) {
        drawTextureRegionUnscaled(batch, textureRegion, bounds, transform.rotation);
    }

    public void setBounds(Rectangle bounds) {
        this.bounds = new Rectangle(bounds);
    }

    public Rectangle getBounds() {
        return new Rectangle(bounds);
    }

    private Texture texture;
    // this TextureRegion is skin position in global coordinates
    private TextureRegion textureRegion;
    private Rectangle bounds;
}
