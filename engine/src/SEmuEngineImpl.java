import parts.instruction.Instruction;
import parts.Program;
import parts.instruction.SyntheticInstruction;

import java.util.List;
import java.util.ArrayList;
//
import parts.instruction.IncrementInstruction;
import parts.instruction.DecrementInstruction;
import parts.instruction.ConditionalGotoInstruction;
//
public class SEmuEngineImpl implements SEngine {
    private Program currentProgram;
//    private List<RunHistoryDTO> runHistory;

    public SEmuEngineImpl() {
        this.currentProgram = null;
//        this.runHistory = new ArrayList<>();
    }

    public void load_program() {
        List<Instruction> instructions = new ArrayList<>();

        instructions.add(new DecrementInstruction("L1", "x1"));
        instructions.add(new IncrementInstruction("y"));
        instructions.add(new ConditionalGotoInstruction(null, "x1", "L1"));
        // Add one more instruction for display variety
        instructions.add(new IncrementInstruction("z1"));


        this.currentProgram = new Program(instructions,"Debug Program");
        System.out.println("DEBUG: A sample program has been loaded.");
    }


    //TODO
    public String get_program_details() {
        StringBuilder details = new StringBuilder();

        if (currentProgram == null) {
            return "no loaded program";
        }

        details.append("Program name: ").append(currentProgram.getName()).append("\n");
        details.append("Input variables: ").append(String.join(", ", currentProgram.getInputVariables())).append("\n");
        details.append("Labels: ").append(String.join(", ", currentProgram.getLabels())).append("\n\n");
        details.append("Instructions: \n");
        //instructions
        List<Instruction> instructions = currentProgram.getInstructions();
        for (int i = 0; i < instructions.size(); i++) {
            Instruction instruction = instructions.get(i);

            // קביעת סוג ההוראה (בסיסית או סינטטית)
            String type = (instruction instanceof SyntheticInstruction) ? "S" : "B";

            // פורמט התווית
            String label = instruction.get_label() != null ? instruction.get_label() : "";
            String formattedLabel = String.format("[ %-5s]", label);

            // הרכבת השורה המלאה
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
