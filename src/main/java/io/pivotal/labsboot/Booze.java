package io.pivotal.labsboot;

public class Booze {
    String name;
    Float price_in_cents;

    public Booze() {
    }

    public Booze(String name, Float price_in_cents) {
        this.name = name;
        this.price_in_cents = price_in_cents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice_in_cents() {
        return price_in_cents;

    }

    public void setPrice_in_cents(float price_in_cents) {
        this.price_in_cents = price_in_cents;
    }

    @Override
    public String toString() {
        return "Gettin' drunk on " + getName() + " for $" + getPrice_in_cents();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Booze booze = (Booze) o;

        if (name != null ? !name.equals(booze.name) : booze.name != null) return false;
        return !(price_in_cents != null ? !price_in_cents.equals(booze.price_in_cents) : booze.price_in_cents != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (price_in_cents != null ? price_in_cents.hashCode() : 0);
        return result;
    }
}
