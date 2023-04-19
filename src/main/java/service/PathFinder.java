package service;

import Map.*;

import java.util.List;

public class PathFinder extends AStarAlgorithm{

    public static List<Node> getPath(Coordinates start, Coordinates target, Map map) {
        return AStarAlgorithm.getPath(start, target, map);
    }
}
