package kanban.core;

import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonWriter.OutputType;

import java.util.ArrayList;

public class CardsSerializer {
    private final String jsonFilePath;
    private FileHandle jsonFile;
    private final Json jsonHandler;

    public CardsSerializer(String jsonFilePath) {
        this.jsonFilePath = jsonFilePath;
        this.jsonHandler = new Json(OutputType.json);
    }

    public void initialize() {
        this.jsonFile = Gdx.files.getFileHandle(this.jsonFilePath, FileType.Local);
    }

    public void save(ArrayList<CardList> cardLists) {
        this.jsonHandler.toJson(cardLists, ArrayList.class, CardList.class, this.jsonFile);
    }

    public void load(ArrayList<CardList> cardLists) {
        cardLists.clear();
        if (!this.jsonFile.exists()) return;

        final ArrayList<CardList> data = this.jsonHandler.fromJson(ArrayList.class, CardList.class, this.jsonFile);
        cardLists.addAll(data);
    }
}
