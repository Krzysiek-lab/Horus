import java.util.List;
import java.util.Optional;

public class Wall implements Structure {
    private final List<CompositeBlock> blocks;

    public Wall(List<CompositeBlock> blocks) {
        this.blocks = blocks;
    }

    @Override
    public Optional<CompositeBlock> findBlockByColor(String color) {
        return blocks.stream().flatMap(x -> x.getBlocks().stream())
                .filter(x -> x.getColor().equals(color))
                .findAny();
    }

    @Override
    public List<CompositeBlock> findBlocksByMaterial(String material) {
        return blocks.stream().flatMap(x -> x.getBlocks().stream())
                .filter(x -> x.getMaterial().equals(material))
                .toList();
    }

    @Override
    public int count() {
        return (int) blocks.stream().mapToLong(x -> x.getBlocks().size()).sum();
    }
}







