package lecture_9_10_graphs;

import java.awt.*;
import java.util.Map;

public class Vertex {
    int value;
    int weight;
    String color;

    public Vertex(int value, int weight) {
        this.value = value;
        this.weight = weight;

    }

    public Vertex(int value, int weight, String color) {
        this.value = value;
        this.weight = weight;
        this.color = color;
    }

}