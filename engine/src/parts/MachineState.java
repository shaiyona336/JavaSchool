package parts;

import java.util.Map;

public class MachineState {
    private Map<String, Integer> variables; //potentially change <string,integar> to a class
    private int programCounter;
    private int totalCycles;
}
