package ru.geekbrains.lesson7;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GraphTest {
    private Graph graph;

    @Before
    public void init() {
        graph = new Graph(10);
        graph.addVertex("Москва");
        graph.addVertex("Тула");
        graph.addVertex("Рязань");
        graph.addVertex("Калуга");
        graph.addVertex("Тамбов");
        graph.addVertex("Липецк");
        graph.addVertex("Орел");
        graph.addVertex("Саратов");
        graph.addVertex("Курск");
        graph.addVertex("Воронеж");

        graph.addEdge("Москва","Тула");
        graph.addEdge("Москва","Калуга");
        graph.addEdge("Москва","Рязань");
        graph.addEdge("Тула","Липецк");
        graph.addEdge("Рязань","Тамбов");
        graph.addEdge("Калуга","Орел");
        graph.addEdge("Липецк","Воронеж");
        graph.addEdge("Тамбов","Саратов");
        graph.addEdge("Орел","Курск");
        graph.addEdge("Саратов","Воронеж");
        graph.addEdge("Курск","Воронеж");
    }

    @Test
    public void findShortPath() {
        Assert.assertEquals(
                "Москва -> Тула -> Липецк -> Воронеж",
                graph.findShortPath("Москва", "Воронеж"));

        Assert.assertNull(graph.findShortPath("Рязань", "Орел"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void findShortPathException() {
        graph.findShortPath("Бирабиджан", "Москва");
    }

}