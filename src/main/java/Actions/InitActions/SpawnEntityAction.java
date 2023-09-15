package Actions.InitActions;

import Entity.Entity;
import Entity.Factory.EntityFactory;
import Map.*;
import Map.Map;

import java.util.*;

public class SpawnEntityAction extends InitAction {
    private final HashMap<EntityFactory, Integer> possibleEntity;
    private final Map map;
    static final Random RANDOM = new Random();

    public SpawnEntityAction(HashMap<EntityFactory, Integer> possibleEntity, Map map) {
        this.possibleEntity = possibleEntity;
        this.map = map;
    }

    @Override
    public void init() {

        spawnPossibleEntity(map, possibleEntity);
    }

    private void spawnPossibleEntity(Map map, HashMap<EntityFactory, Integer> possibleEntity) {
        for (EntityFactory entityFactory : possibleEntity.keySet()) {
            int spawnProbability = possibleEntity.get(entityFactory);

            spawnEntityByProbability(map, spawnProbability, entityFactory);
        }
    }

    private void spawnEntityByProbability(Map map, int spawnProbability, EntityFactory entityFactory) {
        int entityNumber = (map.height * map.weight) / 100 * spawnProbability;

        for (int entityAmount = 0; entityAmount < entityNumber;){
            int coordinateX = RANDOM.nextInt(1, map.weight+1);
            int coordinateY = RANDOM.nextInt(1, map.height+1);
            Coordinates spawnCoordinate = new Coordinates(coordinateX, coordinateY);

            if (!map.isSquareEmpty(spawnCoordinate)) {
                continue;
            }

            Entity entity = entityFactory.create(map);
            map.setEntity(spawnCoordinate, entity);
            entityAmount++;
        }
    }
}