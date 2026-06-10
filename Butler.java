package game;

public class Butler extends Suspect {
    public Butler() {
        super("James", "Butler");
    }

    @Override
    public String interrogate() {
        if (isKiller()) {
            return "I-I was in the kitchen all night, sir! Though... I might have misplaced the study room master key.";
        }
        return "I was polishing the silver in the dining room. I heard a loud argument upstairs around 10:00 PM.";
    }

    @Override
    public Clue giveClue() {
        return new Clue("Master Key", "A golden key found near the back door. It fits the study room lock.");
    }
}