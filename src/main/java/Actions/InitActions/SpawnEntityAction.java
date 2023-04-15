package Actions.InitActions;

import Entity.Creatures.Herbivores.Deer;
import Entity.Creatures.Predators.Wolf;
import Entity.Entity;
import Entity.Inanimates.Tree;
import Map.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class SpawnEntityAction extends InitAction {
    Set<EntityFactory> possibleEntity = Collections.emptySet();

    public SpawnEntityAction(Set<EntityFactory> possibleEntity) {
        this.possibleEntity = possibleEntity;
    }

    @Override
    public void init(Map map) {



    }

    private void spawnSelectPossibleEntity(HashMap<Integer, Entity> entity, Map map) {
        for(Entity entityHashMap : entity.values()) {

        }
    }

}
