package service;

import Map.*;

import java.util.ArrayList;
import java.util.List;

public class AStarAlgorithm {
    private static final int PATH_COST_DIAGONAL = 14;
    private static final int PATH_COST_DIRECT = 10;

    public static List<Node> getPath(Coordinates start, Coordinates target, Map map){
        Node currentNode = new Node(null, null, start, 0, 0);
        List<Node> openList = new ArrayList<>();
        List<Node> closedList = new ArrayList<>();
        List<Node> path = new ArrayList<>();

        openList.add(currentNode);

        while (!openList.isEmpty()) {
            openList.addAll(getNearestNods(currentNode, closedList, openList, target, map));

            if (isTargetFound(start, target, openList)) {
                path = getPathByTargetNode(start, target, openList);
                return path;
            }

            currentNode = selectSmallestNodeCost(openList, closedList, currentNode);
        }

        return path;
    }

    private static List<Node> getPathByTargetNode(Coordinates start, Coordinates target, List<Node> openList) {
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

    private static boolean isTargetFound(Coordinates start, Coordinates target, List<Node> openList) {
        return !getPathByTargetNode(start, target, openList).isEmpty();

    }

    private static Node selectSmallestNodeCost(List<Node> openList, List<Node> closedList, Node currentNode) {
        openList.remove(currentNode);
        closedList.add(currentNode);

        if (openList.isEmpty()) {
            return null;
        }
        return currentNode = getSmallestNode(openList);
    }

    private static Node getSmallestNode(List<Node> openList) {
        Node min = openList.get(0);

        for(Node node : openList) {
            if (node.getCost() == 0) {
                continue;
            }
            if (node.getCost() < min.getCost()) {
                min = node;
            }
        }

        return min;
    }

    private static List<Node> getNearestNods(Node currentNode, List<Node> closedList, List<Node> openList, Coordinates target, Map map) {
        List<Node> nearestNods = new ArrayList<>();

        for (int x = -1; x <=1; x++) {
            for (int y = -1; y <= 1; y++) {
                if (x == 0 && y == 0) {
                    continue;
                }

                Coordinates coordinates = new Coordinates(currentNode.getCoordinates().x + x, currentNode.getCoordinates().y + y);

                if (isNodeClosed(coordinates, closedList)) {
                    continue;
                }

                if (isNodeMarked(coordinates, openList)) {
                    Node markedNode = getMarkedNode(coordinates, openList);
                    int markedNodeNewCost = currentNode.getLengthToStart() + getHeuristics(coordinates, target);

                    if (markedNode.getCost() > markedNodeNewCost) {
                        markedNode.setCost(markedNodeNewCost);
                        markedNode.setLengthToStart(getNodeLengthToStart(markedNode.getCoordinates(), currentNode));
                    }

                    continue;
                }

                if (map.isSquareExist(coordinates) && isSquareTargetOrEmpty(coordinates, target, map)) {
                    int newNodeLenStart = getNodeLengthToStart(coordinates, currentNode);
                    int newNodeCost = newNodeLenStart + getHeuristics(coordinates, target);
                    Node newNode = new Node(currentNode, null, coordinates, newNodeCost, newNodeLenStart);

                    nearestNods.add(newNode);
                }
            }
        }

        return nearestNods;
    }

    private static boolean isSquareTargetOrEmpty(Coordinates coordinates, Coordinates target, Map map) {
        return map.isSquareEmpty(coordinates) || coordinates.equals(target);
    }

    private static int getNodeLengthToStart(Coordinates coordinates, Node currentNode) {
        int lenToStart = currentNode.getLengthToStart();

        if (coordinates.x == currentNode.getCoordinates().x || coordinates.y == currentNode.getCoordinates().y) {
            lenToStart += PATH_COST_DIRECT;
        }else {
            lenToStart += PATH_COST_DIAGONAL;
        }

        return lenToStart;
    }

    private static boolean isNodeClosed(Coordinates coordinates, List<Node> closedList) {
        for (Node node : closedList) {
            if (node.getCoordinates().equals(coordinates)) {
                return true;
            }
        }

        return false;
    }

    private static Node getMarkedNode(Coordinates coordinates, List<Node> openList) {
        for (Node node : openList) {
            if (node.getCoordinates().equals(coordinates)) {
                return node;
            }
        }

        return null;
    }

    private static boolean isNodeMarked(Coordinates coordinates, List<Node> openList) {
        return getMarkedNode(coordinates, openList) != null;

    }

    private static int getHeuristics(Coordinates newNodeCoordinates, Coordinates targetNodeCoordinates) {
        return (Math.abs(newNodeCoordinates.x - targetNodeCoordinates.x) +
                Math.abs(newNodeCoordinates.y - targetNodeCoordinates.y)) * 10;
    }
}
