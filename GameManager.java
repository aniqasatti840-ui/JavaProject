package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameManager {
    private Detective detective;
    private List<Suspect> suspects;
    private Suspect killer;

    public GameManager(String detectiveName) {
        detective = new Detective(detectiveName);
        suspects = new ArrayList<>();
        
      
        suspects.add(new Butler());
        suspects.add(new Wife());
        suspects.add(new Friend());
        suspects.add(new BusinessPartner());

      
        Random random = new Random();
        killer = suspects.get(random.nextInt(suspects.size()));
        killer.setKiller(true);
    }

    public Detective getDetective() { return detective; }
    public List<Suspect> getSuspects() { return suspects; }
    public Suspect getKiller() { return killer; }

    public boolean checkAccusation(String suspectName) {
        return killer.getName().equalsIgnoreCase(suspectName);
    }
}