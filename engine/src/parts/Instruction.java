package parts;

public interface Instruction {
    void execute_command(MachineState state);
    int get_cycles();
    String get_label();
}