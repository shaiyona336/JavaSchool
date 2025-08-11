package parts;

public class IncrementInstruction extends AbstractInstruction {
    private final String variable;

    public IncrementInstruction(String label, String variable) {
        super(label);
        this.variable = variable;
    }

    public IncrementInstruction(String variable) {
        this.variable = variable;
    }

    @Override
    public void execute_command(MachineState state) {
        //int variable;
        //variable = get_current_variable(state);
        //add_one(variable)
        //state.advance_program_counter()
    }
    @Override
    public int get_cycles() {
        return 1;
    }

    @Override
    public String toDisplayString() {
        return String.format("%s <- %s + 1", variable, variable);
    }
}
