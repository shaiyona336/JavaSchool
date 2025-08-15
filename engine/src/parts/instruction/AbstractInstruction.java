package parts.instruction;

import parts.label.FixedLabel;
import parts.label.Label;
import parts.variable.Variable;
import java.util.List;

public abstract class AbstractInstruction implements Instruction {

    private final InstructionData instructionData;
    private final Label label;
    protected final Variable variable;

    public AbstractInstruction(InstructionData instructionData, Variable variable) {
        this(instructionData, variable, FixedLabel.EMPTY);
    }

    public AbstractInstruction(InstructionData instructionData, Variable variable, Label label) {
        this.instructionData = instructionData;
        this.label = label;
        this.variable = variable;
    }

    @Override
    public Label getLabel() {
        return label;
    }

    @Override
    public int get_cycles() {
        return instructionData.getCycles();
    }

    @Override
    public String getName() {
        return instructionData.getName();
    }

    @Override
    public List<Variable> getVariables() {
        return List.of(variable);
    }
}