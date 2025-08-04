package parts;

import java.util.Map;

public class MachineState {
    private Program program; //potentially change to final
    private Map<String, Integer> variables; //potentially change <string,integar> to a class
    private int programCounter;
    private int totalCycles;

    public void advance_program_counter() {
        programCounter++;
    }

    public void add_one(String variableName) {
        //add one to variableName in variables
    }

    public void sub_one(String variableName) {
        //sub one to variableName in variables, cant be less than 0
    }

    public String get_current_variable() {
        //with programCounter, get variable for the current instruction
        return null;
    }
}
