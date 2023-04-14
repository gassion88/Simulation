package Map;

public class MapConsoleRenderer {
    public void renderer(Map map) {

        for (int rowIndex = 1; rowIndex <= map.height; rowIndex++) {
            String rowView = "";
            for (int columnIndex = 1; columnIndex <= map.weight; columnIndex++) {
                Coordinates square = new Coordinates(rowIndex, columnIndex);

                if (map.isSquareEmpty(square)) {
                    rowView += getEmptySquareSprite();
                } else {
                    rowView += getEntitySprite();
                }
            }

            System.out.println(rowView);
        }
    }

    private String getEntitySprite() {
        return "*";
    }

    private String getEmptySquareSprite() {
        return "..  ";
    }

    public static void main(String[] args) {
        Map map = new Map(7, 7);
        new MapConsoleRenderer().renderer(map);
       // map.setEntity(new Coordinates(1,1), );

    }
}
