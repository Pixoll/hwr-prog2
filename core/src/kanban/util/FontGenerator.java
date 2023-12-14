package kanban.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.utils.Disposable;

public class FontGenerator implements Disposable {
    private final FreeTypeFontGenerator regular;
    private final FreeTypeFontGenerator bold;
    private final FreeTypeFontGenerator italic;
    private final FreeTypeFontGenerator light;

    public enum Type {
        REGULAR,
        BOLD,
        ITALIC,
        LIGHT,
    }

    public FontGenerator(String regularFilePath, String boldFilePath, String italicFilePath, String lightFilePath) {
        this.regular = new FreeTypeFontGenerator(Gdx.files.internal(regularFilePath));
        this.bold = new FreeTypeFontGenerator(Gdx.files.internal(boldFilePath));
        this.italic = new FreeTypeFontGenerator(Gdx.files.internal(italicFilePath));
        this.light = new FreeTypeFontGenerator(Gdx.files.internal(lightFilePath));
    }

    public BitmapFont generate(Type type, int size, String borderColor, float borderWidth) {
        FreeTypeFontParameter config = new FreeTypeFontParameter();
        config.size = size;
        if (borderColor != null && borderWidth != 0) {
            config.borderColor = Util.color(borderColor);
            config.borderWidth = borderWidth;
        }

        FreeTypeFontGenerator generator = null;
        switch (type) {
            case REGULAR -> generator = this.regular;
            case BOLD -> generator = this.bold;
            case ITALIC -> generator = this.italic;
            case LIGHT -> generator = this.light;
        }

        return generator.generateFont(config);
    }

    public BitmapFont generate(Type type, int size) {
        return this.generate(type, size, null, 0);
    }

    @Override
    public void dispose() {
        this.regular.dispose();
        this.bold.dispose();
        this.italic.dispose();
    }
}
