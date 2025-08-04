package parts;

import java.util.List;

public class Program {
    private final List<Instruction> instructions;

    public Program(List<Instruction> instructions) {
        this.instructions = instructions;
    }

    public Instruction get_instruction(int programCounter) {
        assert instructions != null : "program is not set";
        assert programCounter >= 0 && programCounter < instructions.size() : "programCounter out of bounds";

        return instructions.get(programCounter);
    }

}
