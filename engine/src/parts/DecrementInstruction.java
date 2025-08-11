package parts;

import java.util.List;

public class DecrementInstruction extends AbstractInstruction {
    private final String variable;

    public DecrementInstruction(String label, String variable) {
        super(label);
        this.variable = variable;
    }

    public DecrementInstruction(String variable) {
        this.variable = variable;
    }


    @Override
    public void execute_command(MachineState state) {
        //int variable;
        //variable = get_current_variable(state);
        //sub_one(variable)
        //state.advance_program_counter()
    }
    @Override
    public int get_cycles() {
        return 1;
    }

    @Override
    public String toDisplayString() {
        return String.format("%s <- %s - 1", variable, variable);
    }

    @Override
    public List<String> getVariables() {
        return List.of(variable);
    }

}
