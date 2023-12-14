package kanban.util;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class AppShapeRenderer extends ShapeRenderer {
    @Override
    public void begin() {
        super.begin(ShapeType.Filled);
    }

    public void rect(Rectangle bounds) {
        super.rect(bounds.x, bounds.y, bounds.width, bounds.height);
    }

    public void rect(Rectangle bounds, float lineWidth) {
        final float y1 = bounds.y + bounds.height - lineWidth / 2;
        super.rectLine(bounds.x, y1, bounds.x + bounds.width, y1, lineWidth);
        final float y2 = bounds.y + lineWidth / 2;
        super.rectLine(bounds.x, y2, bounds.x + bounds.width, y2, lineWidth);
        final float x1 = bounds.x + lineWidth / 2;
        super.rectLine(x1, bounds.y + bounds.height, x1, bounds.y, lineWidth);
        final float x2 = bounds.x + bounds.width - lineWidth / 2;
        super.rectLine(x2, bounds.y + bounds.height, x2, bounds.y, lineWidth);
    }
}
