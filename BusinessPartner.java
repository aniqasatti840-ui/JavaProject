package game;

public class BusinessPartner extends Suspect {
    public BusinessPartner() {
        super("Mr. Davis", "Business Partner");
    }

    @Override
    public String interrogate() {
        if (isKiller()) {
            return "The entire company was mine! He was making reckless decisions and destroying everything we built!";
        }
        return "I left the estate at 9:00 PM right after our meeting. Our joint business venture is doing perfectly fine.";
    }

    @Override
    public Clue giveClue() {
        return new Clue("Unusual Bank Statement", "A financial record showing millions of dollars transferred to an anonymous offshore account.");
    }
}