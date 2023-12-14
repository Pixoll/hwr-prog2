package kanban.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class AppTexture extends Texture {
    public final String filePath;
    public final Bounds bounds;

    public AppTexture(String filePath) {
        super(Gdx.files.internal(filePath));

        this.filePath = filePath;
        this.bounds = new Bounds(this.getWidth(), this.getHeight());
    }

    @Override
    public AppTexture clone() {
        final AppTexture texture = new AppTexture(this.filePath);
        texture.bounds.set(this.bounds);
        return texture;
    }
}
