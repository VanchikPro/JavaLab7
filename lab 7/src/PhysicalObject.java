abstract class PhysicalObject implements Measurable{
    protected double mass;
    protected double speed;

    public PhysicalObject(double mass, double speed) {
        this.mass = mass;
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "PhysicalObject{mass=" + mass + ", speed=" + speed + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        PhysicalObject other = (PhysicalObject) obj;
        return Double.compare(other.mass, mass) == 0 && Double.compare(other.speed, speed) == 0;
    }
}