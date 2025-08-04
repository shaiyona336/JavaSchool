package parts;

public class DecrementInstruction extends AbstractInstruction {

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

}
