package parts.instruction;

import parts.MachineState;

import java.util.List;

public interface Instruction {
    void execute_command(MachineState state);
    int get_cycles();
    String get_label();
    String toDisplayString();
    List<String> getVariables();

}