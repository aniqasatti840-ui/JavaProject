package game;

import java.util.ArrayList;
import java.util.List;

public class Detective {
    private String name;
    private List<Clue> inventory;

    public Detective(String name) {
        this.name = name;
        this.inventory = new ArrayList<>();
    }

    public String getName() { return name; }
    public void addClue(Clue clue) { inventory.add(clue); }
    public List<Clue> getInventory() { return inventory; }
}