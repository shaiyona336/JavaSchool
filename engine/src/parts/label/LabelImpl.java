package parts.label;

public class LabelImpl implements Label {

    private final String label;

    // FIX: Constructor now accepts a String.
    public LabelImpl(String label) {
        this.label = label;
    }

    public String getLabelRepresentation() {
        return label;
    }
}