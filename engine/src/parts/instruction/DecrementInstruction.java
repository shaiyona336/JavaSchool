package parts.instruction;

import parts.MachineState;
import parts.label.Label;
import parts.variable.Variable;
import java.util.List;

public class DecrementInstruction extends AbstractInstruction {

    public DecrementInstruction(Variable variable) {
        super(InstructionData.DECREASE, variable);
    }

    public DecrementInstruction(Variable variable, Label label) {
        super(InstructionData.DECREASE, variable, label);
    }

    @Override
    public void execute_command(MachineState state) {
        // execute logic will go here
    }

    @Override
    public String toDisplayString() {
        return String.format("%s <- %s - 1", variable.getRepresentation(), variable.getRepresentation());
    }

}