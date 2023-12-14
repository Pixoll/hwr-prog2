package kanban.util;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class AppSpriteBatch extends SpriteBatch {
    public void draw(Texture texture, Rectangle bounds) {
        super.draw(texture, bounds.x, bounds.y, bounds.width, bounds.height);
    }

    public void draw(AppTexture texture) {
        this.draw(texture, texture.bounds);
    }
}
