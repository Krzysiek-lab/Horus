import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class WallTest {
    CompositeBlock brickRock = new Brick("white", "rock");
    CompositeBlock brickPlastic = new Brick("black", "plastic");
    CompositeBlock brickGlass = new Brick("blue", "glass");
    CompositeBlock brickWood = new Brick("brown", "wood");

    @Test
    public void givenWallWithSingleBrick_WhenGettingBrickCount_ThenOneIsReturned() {
        Wall wall = new Wall(Collections.singletonList(brickRock));

        Assert.assertEquals(1, wall.count());
    }

    @Test
    public void givenWallWithBricksPanel_WhenGettingBrickCount_ThenCountIsCorrect() {
        CompositeBlock compositeBlock = new BricksPanel(List.of(brickRock, brickPlastic, brickGlass));
        CompositeBlock compositeBlock2 = new BricksPanel(List.of(brickWood));
        Wall wall = new Wall(List.of(compositeBlock, compositeBlock2));

        Assert.assertEquals(4, wall.count());
    }

    @Test
    public void givenWallWithBricksPanelAndBrick_WhenGettingBrickCount_ThenCountIsCorrect() {
        CompositeBlock compositeBlock = new BricksPanel(List.of(brickRock, brickPlastic, brickGlass));
        Wall wall = new Wall(List.of(compositeBlock, brickWood));

        Assert.assertEquals(4, wall.count());
    }

    @Test
    public void givenWallWithBricks_WhenFindingBrickByColor_ThenBlockIsReturned() {
        CompositeBlock compositeBlock = new BricksPanel(List.of(brickPlastic));
        Wall wall = new Wall(List.of(compositeBlock, brickRock));

        var brick = wall.findBlockByColor("white");

        Assert.assertEquals(brick, Optional.of(brickRock));
    }

    @Test
    public void givenWallWithBricks_WhenFindingBrickByColor_ThenNullIsReturned() {
        CompositeBlock compositeBlock = new BricksPanel(List.of(brickPlastic));
        Wall wall = new Wall(List.of(compositeBlock, brickRock));

        var brick = wall.findBlockByColor("noneExistingColor");

        Assert.assertEquals(brick, Optional.empty());
    }

    @Test
    public void givenWallWithBricks_WhenFindingBricksByMaterial_ThenCorrectBricksAreReturned() {
        CompositeBlock compositeBlock = new BricksPanel(List.of(brickPlastic));
        Wall wall = new Wall(List.of(compositeBlock, brickRock));

        var bricks = wall.findBlocksByMaterial("rock");

        Assert.assertEquals(bricks.get(0), brickRock);
    }

    @Test
    public void givenWallWithBricks_WhenFindingBricksByMaterial_ThenEmptyCollectionIsReturned() {
        CompositeBlock compositeBlock = new BricksPanel(List.of(brickPlastic));
        Wall wall = new Wall(List.of(compositeBlock, brickRock));

        var bricks = wall.findBlocksByMaterial("noneExistingMaterial");

        Assert.assertEquals(bricks, Collections.EMPTY_LIST);
    }
}