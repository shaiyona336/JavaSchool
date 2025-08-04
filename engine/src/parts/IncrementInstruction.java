package parts;

public class IncrementInstruction implements Instruction{
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
}
