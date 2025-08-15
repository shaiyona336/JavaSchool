package parts.instruction;

import parts.MachineState;
import parts.label.Label;
import parts.variable.Variable;
import java.util.List;

public interface Instruction {
    void execute_command(MachineState state);
    int get_cycles();
    Label getLabel();
    String getName();
    String toDisplayString();
    List<Variable> getVariables(); // This is the only method for getting variables
}