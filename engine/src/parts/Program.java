package parts;

import parts.instruction.ConditionalGotoInstruction;
import parts.instruction.Instruction;
import parts.label.FixedLabel;
import parts.label.Label;
import parts.variable.Variable;
import parts.variable.VariableType;

import java.util.*;

public class Program {
    private final String name;
    private final List<Instruction> instructions;

    public Program(List<Instruction> instructions, String name) {
        this.name = name;
        this.instructions = instructions;
    }

    public String getName() {
        return name;
    }

    public List<Variable> getInputVariables() {
        Set<Variable> inputs = new TreeSet<>(Comparator.comparingInt(v ->
                Integer.parseInt(v.getRepresentation().substring(1))
        ));
        for (Instruction instruction : instructions) {
            for (Variable var : instruction.getVariables()) {
                if (var != null && var.getType() == VariableType.INPUT) {
                    inputs.add(var);
                }
            }
        }
        return new ArrayList<>(inputs);
    }

    public List<Label> getLabels() {
        // FIX: Provide a Comparator to tell the TreeSet how to sort Labels.
        Set<Label> labels = new TreeSet<>(Comparator.comparing(Label::getLabelRepresentation));
        boolean hasExit = false;

        for (Instruction instruction : instructions) {
            if (instruction.getLabel() != null && !instruction.getLabel().getLabelRepresentation().isEmpty()) {
                labels.add(instruction.getLabel());
            }
            if (instruction instanceof ConditionalGotoInstruction) {
                Label targetLabel = ((ConditionalGotoInstruction) instruction).getTargetLabel();
                if ("EXIT".equalsIgnoreCase(targetLabel.getLabelRepresentation())) {
                    hasExit = true;
                }
            }
        }

        List<Label> sortedLabels = new ArrayList<>(labels);

        if (hasExit) {
            sortedLabels.add(FixedLabel.EXIT);
        }

        return sortedLabels;
    }

    public List<Instruction> getInstructions() {
        return instructions;
    }
}