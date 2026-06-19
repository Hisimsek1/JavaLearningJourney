import java.util.Scanner;

public class Hospital extends Location {
    public Hospital(Fighter fighter, Scanner input)
    {
        super(fighter, input);
    }

    @Override
    public boolean getLocation()
    {
        this.fighter.setHealth(this.fighter.getMaxHealth());
        System.out.println("Hastanedesiniz. Caniniz tamamen yenilendi.");
        return true;
    }
}
