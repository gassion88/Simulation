public class Grass extends Inanimate implements IEatable{
    private final int hpAmount;

    public Grass(Coordinates coordinates, int hpAmount) {
        super(coordinates);
        this.hpAmount = hpAmount;
    }

    @Override
    public int getHpAmount() {
        return hpAmount;
    }
}
