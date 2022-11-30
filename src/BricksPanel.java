import java.util.Collection;
import java.util.List;

public class BricksPanel implements CompositeBlock {
    private final Collection<CompositeBlock> blocks;

    public BricksPanel(Collection<CompositeBlock> blocks) {
        this.blocks = blocks;
    }

    @Override
    public String getColor() {
        return null;
    }

    @Override
    public String getMaterial() {
        return null;
    }

    @Override
    public List<CompositeBlock> getBlocks() {
        return blocks.stream().flatMap(x -> x.getBlocks().stream()).toList();
    }
}
