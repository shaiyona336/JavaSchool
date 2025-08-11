package parts;

import java.util.List;

public class ConditionalGotoInstruction extends AbstractInstruction {
    private final String variable;
    private final String targetLabel;

    public ConditionalGotoInstruction(String label, String variable, String targetLabel) {
        super(label);
        this.variable = variable;
        this.targetLabel = targetLabel;
    }

    public ConditionalGotoInstruction(String variable, String targetLabel) {
        this.variable = variable;
        this.targetLabel = targetLabel;
    }


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

    @Override
    public String toDisplayString() {
        return String.format("IF %s != 0 GOTO %s", variable, targetLabel);
    }

    @Override
    public List<String> getVariables() {
        return List.of(variable);
    }

    public String getTargetLabel() {
        return targetLabel;
    }

}
