import parts.Instruction;
import parts.Program;
import parts.SyntheticInstruction;

import java.util.List;
import java.util.ArrayList;

public class SEmuEngineImpl implements SEngine {
    private Program currentProgram;
//    private List<RunHistoryDTO> runHistory;

    public SEmuEngineImpl() {
        this.currentProgram = null;
//        this.runHistory = new ArrayList<>();
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
        details.append("Instructions: ");
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
