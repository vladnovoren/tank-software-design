package ru.mipt.bit.platformer.creatures;

import com.badlogic.gdx.graphics.g2d.Batch;
import ru.mipt.bit.platformer.core.Drawable;

public class DrawableTree implements Drawable {
    public DrawableTree(Tree tree, TreeSkin skin) {
        this.tree = tree;
        this.skin = skin;
    }

    public void draw(Batch batch) {
        skin.draw(batch, tree.getTransform(), tree.getBounds());
    }

    private final Tree tree;
    private final TreeSkin skin;
}
