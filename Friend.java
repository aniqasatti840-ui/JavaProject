package game;

public class Friend extends Suspect {
    public Friend() {
        super("Arthur", "Old Friend");
    }

    @Override
    public String interrogate() {
        if (isKiller()) {
            return "He betrayed me years ago back in college and stole my business idea! He finally got what he deserved!";
        }
        return "We had a drink together earlier in the evening. He mentioned that someone was constantly blackmailing him.";
    }

    @Override
    public Clue giveClue() {
        return new Clue("Threatening Letter", "A confidential note warning the victim to 'pay back the debt or face dire consequences'.");
    }
}