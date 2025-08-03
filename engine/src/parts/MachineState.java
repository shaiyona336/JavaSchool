package parts;

import java.util.Map;

public class MachineState {
    private Program program; //potentially change to final
    private Map<String, Integer> variables; //potentially change <string,integar> to a class
    private int programCounter;
    private int totalCycles;
}
