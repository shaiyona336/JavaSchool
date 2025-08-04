package parts;

public class ConditionalGotoInstruction implements Instruction {
    @Override
    public void execute_command(MachineState state) {
//        int variable;
//        variable = get_current_variable(state);
//        if (variable == 0){
//            state.jump_to_label(l);
//        }
//        else {
//            state.advance_program_counter();
//        }
    }

    @Override
    public int get_cycles() {
        return 2;
    }
}
