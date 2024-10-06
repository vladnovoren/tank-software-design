package ru.mipt.bit.platformer.creatures;

import com.badlogic.gdx.math.GridPoint2;
import com.badlogic.gdx.math.Rectangle;
import ru.mipt.bit.platformer.core.Direction;
import ru.mipt.bit.platformer.core.Pawn;
import ru.mipt.bit.platformer.util.TileMovement;

public class Tree extends Pawn {
    public Tree(GridPoint2 position, Rectangle boundingRectangle, TileMovement tileMovement) {
        super(position, Direction.UP.getAngle());
        this.tileMovement = tileMovement;
        setBounds(boundingRectangle);
    }

    public Rectangle getBounds() {
        return new Rectangle(bounds);
    }

    private void setBounds(Rectangle bounds) {
        this.bounds = new Rectangle(bounds);
        tileMovement.moveRectangleBetweenTileCenters(this.bounds, transform.position, transform.position, 1.0f);
    }

    private final TileMovement tileMovement;
    private Rectangle bounds;
}
