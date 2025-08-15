import parts.instruction.Instruction;
import parts.Program;
import parts.instruction.SyntheticInstruction;
import java.util.List;
import java.util.ArrayList;
import parts.instruction.IncrementInstruction;
import parts.instruction.DecrementInstruction;
import parts.instruction.ConditionalGotoInstruction;
import parts.label.Label;
import parts.label.LabelImpl;
import parts.variable.Variable;
import parts.variable.VariableImpl;
import parts.variable.VariableType;

public class SEmuEngineImpl implements SEngine {
    private Program currentProgram;

    public SEmuEngineImpl() {
        this.currentProgram = null;
    }

    public void load_program() {
        Variable x1 = new VariableImpl(VariableType.INPUT, 1);
        Variable y = new VariableImpl(VariableType.RESULT, 0);
        Variable z1 = new VariableImpl(VariableType.WORK, 1);
        Label l1 = new LabelImpl("L1");

        List<Instruction> instructions = new ArrayList<>();

        instructions.add(new DecrementInstruction(x1, l1));
        instructions.add(new IncrementInstruction(y));

        instructions.add(new ConditionalGotoInstruction(x1, null, l1));
        instructions.add(new IncrementInstruction(z1));

        this.currentProgram = new Program(instructions, "Debug Program");
        System.out.println("DEBUG: A sample program has been loaded.");
    }

    public String get_program_details() {
        if (currentProgram == null) {
            return "no loaded program";
        }

        StringBuilder details = new StringBuilder();
        details.append("Program name: ").append(currentProgram.getName()).append("\n");

        List<String> inputVarStrings = new ArrayList<>();
        for (Variable var : currentProgram.getInputVariables()) {
            inputVarStrings.add(var.getRepresentation());
        }
        details.append("Input variables: ").append(String.join(", ", inputVarStrings)).append("\n");

        List<String> labelStrings = new ArrayList<>();
        for(Label label : currentProgram.getLabels()){
            if(label != null && !label.getLabelRepresentation().isEmpty()){
                labelStrings.add(label.getLabelRepresentation());
            }
        }
        details.append("Labels: ").append(String.join(", ", labelStrings)).append("\n\n");

        details.append("Instructions: \n");
        List<Instruction> instructions = currentProgram.getInstructions();
        for (int i = 0; i < instructions.size(); i++) {
            Instruction instruction = instructions.get(i);
            String type = (instruction instanceof SyntheticInstruction) ? "S" : "B";
            String labelStr = instruction.getLabel() != null ? instruction.getLabel().getLabelRepresentation() : "";
            String formattedLabel = String.format("[ %-5s]", labelStr);

            String line = String.format("#%-4d (%s) %s %-30s (%d)",
                    i + 1,
                    type,
                    formattedLabel,
                    instruction.toDisplayString(),
                    instruction.get_cycles());
            details.append(line).append("\n");
        }
        return details.toString();
    }

    public boolean isProgramLoaded() {
        return currentProgram != null;
    }
}