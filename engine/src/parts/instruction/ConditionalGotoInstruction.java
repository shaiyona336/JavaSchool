package parts.instruction;

import parts.MachineState;
import parts.label.Label;
import parts.variable.Variable;
import java.util.List;

public class ConditionalGotoInstruction extends AbstractInstruction {

    private final Label jumpTo;

    public ConditionalGotoInstruction(Variable variable, Label label, Label jumpTo) {
        super(InstructionData.JUMP_NOT_ZERO, variable, label);
        this.jumpTo = jumpTo;
    }

    @Override
    public void execute_command(MachineState state) {
        // execute logic will go here
    }

    public Label getTargetLabel() {
        return jumpTo;
    }

    @Override
    public String toDisplayString() {
        return String.format("IF %s != 0 GOTO %s", variable.getRepresentation(), jumpTo.getLabelRepresentation());
    }

}