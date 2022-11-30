import java.util.List;

public interface CompositeBlock extends Block {
    List<CompositeBlock> getBlocks();
}
