package parts;

import java.util.*;

public class Program {
    private final String name;
    private final List<Instruction> instructions;

    public Program(List<Instruction> instructions, String name) {
        this.name = name;
        this.instructions = instructions;
    }

    public Instruction get_instruction(int programCounter) {
        assert instructions != null : "program is not set";
        assert programCounter >= 0 && programCounter < instructions.size() : "programCounter out of bounds";

        return instructions.get(programCounter);
    }

    public String getName() {
        return name;
    }
    //TODO
    public List<String> getInputVariables() {
        Set<String> inputs = new TreeSet<>(Comparator.comparingInt(s -> Integer.parseInt(s.substring(1))));
        for (Instruction instruction : instructions) {
            for (String var : instruction.getVariables()) {
                if (var != null && var.startsWith("x")) {
                    inputs.add(var);
                }
            }
        }
        return new ArrayList<>(inputs);
    }
    //TODO
    public List<String> getLabels() {
        Set<String> labels = new TreeSet<>();
        List<String> sortedLabels = new ArrayList<>(labels);
        boolean hasExit = false;
        for (Instruction instruction : instructions) {
            if (instruction.get_label() != null) {
                labels.add(instruction.get_label());
            }
            if (instruction instanceof ConditionalGotoInstruction) {
                String targetLabel = ((ConditionalGotoInstruction) instruction).getTargetLabel();
                if ("EXIT".equalsIgnoreCase(targetLabel)) {
                    hasExit = true;
                }

            }
        }
        if (hasExit) {
            sortedLabels.add("EXIT");
        }

        return sortedLabels;
    }

    public List<Instruction> getInstructions() {
        return instructions;
    }
}


