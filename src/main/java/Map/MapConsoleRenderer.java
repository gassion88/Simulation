package Map;

import Entity.Entity;

public class MapConsoleRenderer {
    public void render(Map map) {
        for (int rowIndex = 1; rowIndex <= map.height; rowIndex++) {
            String rowView = "";
            for (int columnIndex = 1; columnIndex <= map.weight; columnIndex++) {
                Coordinates square = new Coordinates(rowIndex, columnIndex);

                if (map.isSquareEmpty(square)) {
                    rowView += getEmptySquareSprite();
                } else {
                    Entity entity = map.getEntity(square);
                    rowView += getEntitySpriteForEntity(entity);
                }
            }

            System.out.println(rowView);
        }
        System.out.println("");
    }

    private String getEntitySpriteForEntity(Entity entity) {
        return entity.sprite + "  ";
    }

    private String getEmptySquareSprite() {
        return "..  ";
    }

    public static void main(String[] args) {
        Map map = new Map(7, 7);
        new MapConsoleRenderer().render(map);
        // map.setEntity(new Coordinates(1,1), );

    }
}
