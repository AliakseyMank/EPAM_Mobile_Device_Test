package test.epam.util;

import test.epam.model.*;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    public static List<Result> getResults(List<Gadget> gadgetList) {
        Calculator.calculate(gadgetList);
        return results;
    }


    public static void calculate(List<Gadget> gadgetList){
        sumTotalCost(gadgetList);
        calcWeight(gadgetList);
    }

    private static List<Result> results = new ArrayList<>();

    private static void sumTotalCost(List<Gadget> gadgetList){
        double totalCost = 0;
        for (Gadget gadget : gadgetList) {
            totalCost += gadget.getCost();
        }
        results.add(new Result("Total cost",totalCost));
    }

    private static void calcWeight(List<Gadget> gadgetList){
        double weightOfNotebooks = 0;
        double weightOfDesktopComputers = 0;
        double weightOfSmartphones = 0;
        double weightOfReaders = 0;
        for (Gadget gadget : gadgetList) {
            if (gadget instanceof Notebook) weightOfNotebooks+=gadget.getWeight();
            if (gadget instanceof DesktopComputer) weightOfDesktopComputers+=gadget.getWeight();
            if (gadget instanceof Smartphone) weightOfSmartphones+=gadget.getWeight();
            if (gadget instanceof Reader) weightOfReaders+=gadget.getWeight();
        }

        results.add(new Result("Weight of notebooks",weightOfNotebooks));
        results.add(new Result("Weight of smartphones",weightOfSmartphones));
        results.add(new Result("Weight of readers",weightOfReaders));
        results.add(new Result("Weight of desktop computers",weightOfDesktopComputers));
    }

    public static class Result {

        private String nameOfResult;
        private double value;

        public Result(String nameOfResult, double value) {
            this.nameOfResult = nameOfResult;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "nameOfResult='" + nameOfResult + '\'' +
                    ", value=" + value +
                    '}';
        }

        public String getNameOfResult() {
            return nameOfResult;
        }


        public double getValue() {
            return value;
        }

    }
}
