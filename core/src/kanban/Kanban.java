package kanban;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import kanban.core.CardList;
import kanban.core.CardsSerializer;
import kanban.screens.MainScreen;
import kanban.util.AppShapeRenderer;
import kanban.util.AppSpriteBatch;
import kanban.util.Bounds;
import kanban.util.FontGenerator;

import java.util.ArrayList;

public class Kanban extends Game {
    public static final int WIDTH = 1960;
    public static final int HEIGHT = 1080;
    public final ArrayList<CardList> cardLists;
    public final CardsSerializer cardsSerializer;
    public AppSpriteBatch batch;
    public AppShapeRenderer shape;
    public FontGenerator fontGenerator;
    public OrthographicCamera camera;
    public Bounds bounds;

    public Kanban() {
        this.cardsSerializer = new CardsSerializer("../data/cards.json");
        this.cardLists = new ArrayList<>();
    }

    public void create() {
        this.cardsSerializer.initialize();
        this.cardsSerializer.load(this.cardLists);

        this.batch = new AppSpriteBatch();
        this.shape = new AppShapeRenderer();
        this.camera = new OrthographicCamera();
        this.camera.setToOrtho(true, WIDTH, HEIGHT);
        this.bounds = new Bounds(WIDTH, HEIGHT);
        this.fontGenerator = new FontGenerator(
                "fonts/HelveticaNeueMedium.ttf",
                "fonts/HelveticaNeueBold.ttf",
                "fonts/HelveticaNeueItalic.ttf",
                "fonts/HelveticaNeueLight.ttf"
        );

        this.setScreen(new MainScreen(this));
    }

    @Override
    public void dispose() {
        this.batch.dispose();
        this.shape.dispose();
        this.fontGenerator.dispose();
    }
}
