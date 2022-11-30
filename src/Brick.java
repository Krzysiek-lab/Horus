import java.util.Collections;
import java.util.List;

public class Brick implements CompositeBlock {
    private final String color;
    private final String material;

    public Brick(String color, String material) {
        this.color = color;
        this.material = material;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public String getMaterial() {
        return this.material;
    }

    @Override
    public List<CompositeBlock> getBlocks() {
        return Collections.singletonList(this);
    }
}
