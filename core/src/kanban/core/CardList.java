package kanban.core;

import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.JsonWriter.OutputType;

import java.util.ArrayList;
import java.util.Comparator;

public class CardList implements Json.Serializable {
    public String name;
    public Card.Type type;
    private final ArrayList<Card> cards;

    public CardList(String name, Card.Type type) {
        this.name = name;
        this.type = type;
        this.cards = new ArrayList<>();
    }

    public CardList() {
        this(null, null);
    }

    public void add(Card card) {
        if (card.type != this.type) return;
        this.cards.add(card);
    }

    public Card get(int index) {
        if (this.cards.isEmpty() || index < 0 || index >= this.cards.size()) return null;
        return this.cards.get(index);
    }

    public void sortByName() {
        this.cards.sort(Comparator.comparing(c -> c.name));
    }

    public void sortByDate() {
        this.cards.sort(Comparator.comparing(c -> c.createdAt));
    }

    @Override
    public void write(Json json) {
        json.writeValue("name", this.name, String.class);
        json.writeValue("type", this.type.toString(), String.class);
        json.writeValue("cards", this.cards, ArrayList.class, Card.class);
    }

    @Override
    public void read(Json json, JsonValue jsonData) {
        this.name = jsonData.get("name").asString();
        this.type = Card.Type.valueOf(jsonData.get("type").asString());

        final JsonValue cards = jsonData.get("cards");
        for (int i = 0; i < cards.size; i++) {
            final Card card = json.fromJson(Card.class, cards.get(i).toJson(OutputType.json));
            this.cards.add(card);
        }
    }
}
