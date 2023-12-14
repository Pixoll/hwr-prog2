package kanban.core;

import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;

import java.util.Date;

public class Card implements Json.Serializable {
    public enum Type {
        TODO("To Do"),
        DOING("Doing"),
        DONE("Done");

        public final String name;

        Type(String name) {
            this.name = name;
        }
    }

    public String name;
    public String description;
    public Type type;
    public Date createdAt;

    public Card(String name, Type type) {
        this.name = name;
        this.type = type;
        this.createdAt = new Date();
    }

    public Card(String name) {
        this(name, Type.TODO);
    }

    public Card() {
        this(null, Type.TODO);
    }

    @Override
    public void write(Json json) {
        json.writeValue("name", this.name, String.class);
        json.writeValue("description", this.description, String.class);
        json.writeValue("type", this.type.toString(), String.class);
        json.writeValue("created_at", this.createdAt.getTime(), long.class);
    }

    @Override
    public void read(Json json, JsonValue jsonData) {
        this.name = jsonData.get("name").asString();
        this.description = jsonData.get("description").asString();
        this.type = Type.valueOf(jsonData.get("type").asString());
        this.createdAt = new Date(jsonData.get("created_at").asLong());
    }
}
