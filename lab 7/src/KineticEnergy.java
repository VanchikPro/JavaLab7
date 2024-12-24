public class KineticEnergy extends PhysicalObject implements Comparable<KineticEnergy>, Cloneable{
    private final int id; // номер расчета

    public KineticEnergy(int id, double mass, double speed) {
        super(mass, speed);
        this.id = id;
    }

    @Override
    public double calculate() {
        return 0.5 * mass * Math.pow(speed, 2); // расчет кинетической энергии
    }

    @Override
    public String toString() {
        return "масса = " + mass + "м/с, скорость = " + speed + "км/ч, энергия = " + calculate() + "Дж.";
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        KineticEnergy that = (KineticEnergy) obj;
        return Double.compare(that.calculate(), this.calculate()) == 0;
    }
    // реализация метода compareTo
    @Override
    public int compareTo(KineticEnergy other) {
        double thisEnergy = this.calculate();
        double otherEnergy = other.calculate();

        if (Double.compare(thisEnergy, otherEnergy) == 0) {
            return 0; // энергии равны
        } else if (thisEnergy > otherEnergy) {
            return 1; // первая энергия больше
        } else {
            return -1; // вторая энергия больше
        }
    }
    @Override
    public KineticEnergy clone() {
        try {
            return (KineticEnergy) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
