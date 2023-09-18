package Actions.InitActions;

import Entity.Factory.DeerFactory;
import Entity.Factory.EntityFactory;
import Entity.Factory.GrassFactory;
import Entity.Factory.WolfFactory;
import Map.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class SpawnEntityActionTest {

    static Map map;
    SpawnEntityAction spawnEntityAction;

    @BeforeEach
    void preparedDate() {
        map = new Map(10,10);
    }

    @Test
    void checkExistenceEntity() {
        HashMap<EntityFactory, Integer> entityAndHerProbabilitySpawn = new HashMap<>();
        entityAndHerProbabilitySpawn.put(new WolfFactory(), 3);
        entityAndHerProbabilitySpawn.put(new DeerFactory(), 3);
        entityAndHerProbabilitySpawn.put(new GrassFactory(), 3);

        spawnEntityAction = new SpawnEntityAction(entityAndHerProbabilitySpawn, map);
        spawnEntityAction.init();

        assertEquals(map.getAllEntity().size(), 9);
    }

    @Test
    void checkEmptyMapCreation() {
        HashMap<EntityFactory, Integer> entityAndHerProbabilitySpawn = new HashMap<>();
        entityAndHerProbabilitySpawn.put(new WolfFactory(), 0);
        entityAndHerProbabilitySpawn.put(new DeerFactory(), 0);
        entityAndHerProbabilitySpawn.put(new GrassFactory(), 0);

        spawnEntityAction = new SpawnEntityAction(entityAndHerProbabilitySpawn, map);
        spawnEntityAction.init();

        assertEquals(map.getAllEntity().size(), 0);
    }
}