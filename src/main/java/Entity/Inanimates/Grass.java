package Entity.Inanimates;

import Map.Coordinates;

public class Grass extends Inanimate implements IEatable{
    private final int hpAmount;

    public Grass(Coordinates coordinates, int hpAmount, String sprite) {
        super(coordinates, sprite);
        this.hpAmount = hpAmount;
    }

    @Override
    public int getHpAmount() {
        return hpAmount;
    }
}
