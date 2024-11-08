package game.players;
import java.util.List;

public abstract class CPUPlayer extends Player {
    public CPUPlayer(String name) { super(name); }

    public abstract void cpuStrategy(List<Player> opponents);
}
