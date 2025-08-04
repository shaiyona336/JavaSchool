package parts;

public abstract class AbstractInstruction implements Instruction {

    protected final String label;

    protected AbstractInstruction(String label) {
        this.label = label;
    }
    protected AbstractInstruction() {

        this.label = null;
    }

    @Override
    public String get_label() {
        return this.label;
    }

}
