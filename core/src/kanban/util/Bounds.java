package kanban.util;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Bounds extends Rectangle {
    public Bounds(float width, float height) {
        super(0, 0, width, height);
    }

    public Bounds(float x, float y, float width, float height) {
        super(x, y, width, height);
    }

    @Override
    public Bounds set(Rectangle rect) {
        return (Bounds) super.set(rect);
    }

    @Override
    public Bounds setPosition(Vector2 position) {
        return (Bounds) super.setPosition(position);
    }

    public Vector2 getCenter() {
        return super.getCenter(new Vector2());
    }

    public Vector2 getPosition() {
        return super.getPosition(new Vector2());
    }

    public Bounds scaleBy(float factor, boolean scaleCoords) {
        this.width *= factor;
        this.height *= factor;
        if (scaleCoords) {
            this.x *= factor;
            this.y *= factor;
        }
        return this;
    }

    public Bounds scaleBy(float factor) {
        return this.scaleBy(factor, true);
    }

    public Bounds toSquare() {
        final float w = this.width;
        final float h = this.height;
        if (h > w) {
            this.height = w;
        } else {
            this.width = h;
        }
        return this;
    }

    @Override
    public Bounds clone() {
        return new Bounds(this.x, this.y, this.width, this.height);
    }
}
