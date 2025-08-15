package parts.instruction;

import parts.MachineState;
import parts.label.Label;
import parts.variable.Variable;
import java.util.List;

public class IncrementInstruction extends AbstractInstruction {

    public IncrementInstruction(Variable variable) {
        super(InstructionData.INCREASE, variable);
    }

    public IncrementInstruction(Variable variable, Label label) {
        super(InstructionData.INCREASE, variable, label);
    }

    @Override
    public void execute_command(MachineState state) {
        // execute logic will go here
    }

    @Override
    public String toDisplayString() {
        return String.format("%s <- %s + 1", variable.getRepresentation(), variable.getRepresentation());
    }

}