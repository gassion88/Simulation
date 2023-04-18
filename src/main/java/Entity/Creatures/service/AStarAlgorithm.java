package Entity.Creatures.service;

import Entity.Entity;
import Map.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class AStarAlgorithm {
    private static final int PATH_COST_DIAGONAL = 14;
    private static final int PATH_COST_DIRECT = 10;
    private final Coordinates start;
    private final Coordinates target;
    private Map map;
    private List<Node> openList = new ArrayList<>();
    private List<Node> closedList = new ArrayList<>();
    private Node currentNode;
    private List<Node> path = new ArrayList<>();

    public AStarAlgorithm(Coordinates start, Coordinates target, Map map) {
        this.start = start;
        this.target = target;
        this.map = map;
        this.currentNode = new Node(null, null, start, 0, 0);
        this.openList.add(currentNode);
    }

    public List<Node> getPath(){
        while (!openList.isEmpty()) {
            openList.addAll(getNearestNods());

            if (isTargetFound(openList)) {
                path = getPathByTargetNode();
                return path;
            }

            selectSmallestNodeCost();
        }

        return path;
    }

    private List<Node> getPathByTargetNode() {
        Node targetNode = null;
        List<Node> path = new ArrayList<>();

        for (Node node : openList) {
            if (node.getCoordinates().equals(target)) {
                targetNode = node;
                break;
            }
        }

        if (targetNode == null) {
            return path;
        }

        while (!targetNode.getCoordinates().equals(start)) {
            path.add(0, targetNode);
            targetNode = targetNode.from;
        }

        return  path;
    }

    private boolean isTargetFound(List<Node> openList) {
        return !getPathByTargetNode().isEmpty();

    }

    private void selectSmallestNodeCost() {
        openList.remove(currentNode);
        closedList.add(currentNode);

        if (openList.isEmpty()) {
            return;
        }
        currentNode = getSmallestNode(openList);
    }

    private Node getSmallestNode(List<Node> openList) {
        Node min = openList.get(0);

        for(Node node : openList) {
            if (node.getCoordinates().equals(start)) {
                continue;
            }
            if (node.getCost() < min.getCost()) {
                min = node;
            }
        }

        return min;
    }

    private List<Node> getNearestNods() {
        List<Node> nearestNods = new ArrayList<>();

        for (int x = -1; x <=1; x++) {
            for (int y = -1; y <= 1; y++) {
                if (x == 0 && y == 0) {
                    continue;
                }

                Coordinates coordinates = new Coordinates(currentNode.getCoordinates().x + x, currentNode.getCoordinates().y + y);

                if (isNodeClosed(coordinates)) {
                    continue;
                }

                if (isNodeMarked(coordinates)) {
                    Node markedNode = getMarkedNode(coordinates);
                    int markedNodeNewCost = currentNode.getLengthToStart() + getHeuristics(coordinates, target);

                    if (markedNode.getCost() > markedNodeNewCost) {
                        markedNode.setCost(markedNodeNewCost);
                        markedNode.setLengthToStart(getNodeLengthToStart(markedNode.getCoordinates()));
                    }

                    continue;
                }

                if (map.isSquareExist(coordinates) && isSquareTargetOrEmpty(coordinates)) {
                    int newNodeLenStart = getNodeLengthToStart(coordinates);
                    int newNodeCost = newNodeLenStart + getHeuristics(coordinates, target);
                    Node newNode = new Node(currentNode, null, coordinates, newNodeCost, newNodeLenStart);

                    nearestNods.add(newNode);
                }
            }
        }

        return nearestNods;
    }

    private boolean isSquareTargetOrEmpty(Coordinates coordinates) {
        return map.isSquareEmpty(coordinates) || coordinates.equals(target);
    }

    private int getNodeLengthToStart(Coordinates coordinates) {
        int lenToStart = currentNode.getLengthToStart();

        if (coordinates.x == currentNode.getCoordinates().x || coordinates.y == currentNode.getCoordinates().y) {
            lenToStart += PATH_COST_DIRECT;
        }else {
            lenToStart += PATH_COST_DIAGONAL;
        }

        return lenToStart;
    }

    private boolean isNodeClosed(Coordinates coordinates) {
        for (Node node : closedList) {
            if (node.getCoordinates().equals(coordinates)) {
                return true;
            }
        }

        return false;
    }

    private Node getMarkedNode(Coordinates coordinates) {
        for (Node node : openList) {
            if (node.getCoordinates().equals(coordinates)) {
                return node;
            }
        }

        return null;
    }

    private boolean isNodeMarked(Coordinates coordinates) {
        return getMarkedNode(coordinates) != null;

    }

    private int getHeuristics(Coordinates newNodeCoordinates, Coordinates targetNodeCoordinates) {
        return (Math.abs(newNodeCoordinates.x - targetNodeCoordinates.x) +
                Math.abs(newNodeCoordinates.y - targetNodeCoordinates.y)) * 10;
    }

    public static void main(String[] args) {
        Map map = new Map(10,10);

        AStarAlgorithm aStarAlgorithm = new AStarAlgorithm(new Coordinates(2, 2), new Coordinates(5, 2), map);
        List<Node> nodes = aStarAlgorithm.getPath();

        System.out.println("123");
    }
}
