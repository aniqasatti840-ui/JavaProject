package game;

public class Wife extends Suspect {
    public Wife() {
        super("Eleanor", "Wife");
    }

    @Override
    public String interrogate() {
        if (isKiller()) {
            return "He was going to cut me out of his will! I couldn't let him ruin our family status and leave me with nothing!";
        }
        return "I was reading a novel in the lounge. My husband was acting extremely stressed lately about his financial matters.";
    }

    @Override
    public Clue giveClue() {
        return new Clue("Torn Will Document", "A ripped piece of paper showing a sudden change in the inheritance distribution.");
    }
}