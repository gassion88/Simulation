package Entity.Inanimates;

import Map.Coordinates;
import Map.Map;

public class Grass extends Inanimate implements IEatable{
    private final int hpAmount;

    public Grass(Coordinates coordinates, String sprite, Map map, int hpAmount) {
        super(coordinates, sprite, map);
        this.hpAmount = hpAmount;
    }

    @Override
    public int getHpAmount() {
        map.removeEntity(coordinates);
        return hpAmount;
    }
}
