import java.util.Scanner;

public abstract class Location {
    private String name;
    protected Fighter fighter;
    protected Scanner input;
    protected Enemy enemy;

    public Location(Fighter fighter, Scanner input , Enemy enemy)
    {
        this.fighter = fighter;
        this.input = input;
        this.enemy = enemy;
    }

    public Location(Fighter fighter, Scanner input)
    {
        this(fighter, input, null);
    }

    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }

    public abstract boolean getLocation();
}
