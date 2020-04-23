package by.it.tolstik.jd01.jd01_08;

abstract class Var implements Operation{
    @Override
    public Var add(Var other) {
        System.out.println("Операция сложения " + this + " + " + other + " не возможна.");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Операция вычитания " + this + " + " + other + " не возможна.");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Операция умножения " + this + " + " + other + " не возможна.");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Операция деления " + this + " + " + other + " не возможна.");
        return null;
    }

    @Override
    public String toString() {
        return "You must override toString in child class!";
    }
}
