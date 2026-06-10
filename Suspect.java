package game;

public abstract class Suspect {
    private String name;
    private String role;
    private boolean isKiller;

    public Suspect(String name, String role) {
        this.name = name;
        this.role = role;
        this.isKiller = false;
    }

    public String getName() { return name; }
    public String getRole() { return role; }
    public boolean isKiller() { return isKiller; }
    public void setKiller(boolean killer) { this.isKiller = killer; }

    public abstract String interrogate();
    public abstract Clue giveClue();
}