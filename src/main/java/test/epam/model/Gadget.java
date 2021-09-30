package test.epam.model;

public abstract class Gadget {
    protected String name;
    protected double cost;
    protected double weight;


    protected Gadget(String name, double cost, double weight) {
        this.name = name;
        this.cost = cost;
        this.weight = weight;
    }


    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public double getWeight() {
        return weight;
    }
}
