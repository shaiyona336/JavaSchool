package parts;
import java.util.List;


public interface SyntheticInstruction extends Instruction  {

    List<BasicInstruction> expand();

}
