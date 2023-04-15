package Actions.InitActions;

import Entity.Entity;
import Entity.Factory.DeerFactory;
import Entity.Factory.GrassFactory;
import Entity.Factory.WolfFactory;
import Map.*;
import Map.Map;

import java.util.*;

public class SpawnEntityAction extends InitAction {
    HashMap<EntityFactory, Integer> possibleEntity;
    Random random = new Random();

    public SpawnEntityAction(HashMap<EntityFactory, Integer> possibleEntity) {
        this.possibleEntity = possibleEntity;
    }

    @Override
    public void init(Map map) {
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

        int i = 0;
        while (true){
            int coordinateX = random.nextInt(map.weight+1);
            int coordinateY = random.nextInt(map.height+1);
            Coordinates spawnCoordinate = new Coordinates(coordinateX, coordinateY);

            if (!map.isSquareEmpty(spawnCoordinate)) {
                continue;
            }

            Entity entity = entityFactory.create();
            map.setEntity(spawnCoordinate, entity);
            i++;

            if (i == entityNumber) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Map map = new Map(10,10);
        HashMap<EntityFactory, Integer> entity = new HashMap<>();

        entity.put(new WolfFactory(), 5);
        entity.put(new DeerFactory(), 10);
        entity.put(new GrassFactory(), 10);

        SpawnEntityAction spawnEntityAction = new SpawnEntityAction(entity);
        spawnEntityAction.init(map);
    }
}