package ru.mipt.bit.platformer.creatures;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import ru.mipt.bit.platformer.core.Transform;

import static ru.mipt.bit.platformer.util.GdxGameUtils.createBoundingRectangle;
import static ru.mipt.bit.platformer.util.GdxGameUtils.drawTextureRegionUnscaled;

public class TreeSkin {
    public TreeSkin(String texturePath) {
        texture = new Texture(texturePath);
        textureRegion = new TextureRegion(texture);
    }

    public Rectangle getDefaultBoundingRectangle() {
        return createBoundingRectangle(textureRegion);
    }

    public void draw(Batch batch, Transform transform, Rectangle treeBounds) {
        drawTextureRegionUnscaled(batch, textureRegion, treeBounds, transform.rotation);
    }

    private final Texture texture;
    private final TextureRegion textureRegion;
}
