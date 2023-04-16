package Entity.Factory;

import Entity.Entity;
import Map.Map;

public interface EntityFactory {
    Entity create(Map map);
}
