package Map;

import Entity.Creatures.service.Node;
import Entity.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Map {
    public final int height;
    public final int weight;
    private HashMap<Coordinates, Entity> entity = new HashMap<>();

    public Map(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    public void setEntity(Coordinates coordinates, Entity entity) {
        entity.coordinates = coordinates;
        this.entity.put(coordinates, entity);
    }

    public Entity getEntity(Coordinates coordinates) {
        return this.entity.get(coordinates);
    }

    public void removeEntity(Coordinates coordinates) {
        entity.remove(coordinates);
    }

    public boolean isSquareEmpty(Coordinates square) {
        return !entity.containsKey(square);
    }

    public boolean isSquareExist(Coordinates coordinates) {
        int x = coordinates.x;
        int y = coordinates.y;

        if (x < 1 || x > weight) return false;
        if (y < 1 || y > height) return false;

        return true;
    }

    public List<Entity> getEntityByType(Class<?> entityType) {
        List<Entity> entities = new ArrayList<>();

        for (Entity entity : this.entity.values()) {
            if (entityType.isAssignableFrom(entity.getClass())) {
                entities.add(entity);
            }
        }

        return entities;
    }

    public void moveEntity(Coordinates startCoordinates, Coordinates targetCoordinates) {
        Entity entity = getEntity(startCoordinates);
        removeEntity(startCoordinates);

        setEntity(targetCoordinates, entity);
    }
}
