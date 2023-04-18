package Entity.Creatures.service;

import Map.Coordinates;

import java.util.Objects;

public class Node {
    public Node from;
    public Node to;
    private Coordinates coordinates;
    private int cost;

    public Node(Node from, Node to, Coordinates coordinates, int cost) {
        this.from = from;
        this.to = to;
        this.coordinates = coordinates;
        this.cost = cost;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        if (cost != node.cost) return false;
        if (!Objects.equals(from, node.from)) return false;
        if (!Objects.equals(to, node.to)) return false;
        return Objects.equals(coordinates, node.coordinates);
    }

    @Override
    public int hashCode() {
        int result = from != null ? from.hashCode() : 0;
        result = 31 * result + (to != null ? to.hashCode() : 0);
        result = 31 * result + (coordinates != null ? coordinates.hashCode() : 0);
        result = 31 * result + cost;
        return result;
    }
}
