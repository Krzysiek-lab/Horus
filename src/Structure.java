import java.util.List;
import java.util.Optional;

public interface Structure {
    Optional<CompositeBlock> findBlockByColor(String color);

    List<CompositeBlock> findBlocksByMaterial(String material);

    int count();
}
