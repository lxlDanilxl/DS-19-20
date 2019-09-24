package e3;

import java.util.Objects;

// Represents a rectangle
public class Rectangle {

    private int base;
    private int height;
// Initializes a new rectangle with the values passed by parameter .
// Throws IllegalArgumentException if a a negative value is passed to any of
// the dimensions .

    public Rectangle(int base, int height) throws IllegalArgumentException {
        this.base = base;
        this.height = height;

        if (base * height < 0) {
            throw new IllegalArgumentException();
        }
    }
// Copy constructor

    public Rectangle(Rectangle r) {
        this.base = r.getBase();
        this.height = r.getHeight();
    }
// Getters

    public int getBase() {
        return this.base;
    }

    public int getHeight() {
        return this.height;
    }
// Setters . Throw IllegalArgumentException if the parameters are negative .

    public void setBase(int base) {
        this.base = base;
    }

    public void setHeight(int height) {
        this.height = height;
    }
// Return true if the rectangle is a square

    public boolean isSquare() {
        return this.base == this.height;
    }
// Calculate the area of the rectangle .

    public int area() {
        return this.base * this.height;
    }
// Calculate the perimeter of the rectangle .

    public int perimeter() {
        return (this.base + this.height) * 2;
    }
// Calculate the length of the diagonal

    public double diagonal() {
        double diag;
        diag = Math.abs(Math.sqrt(Math.pow(base, 2) + Math.pow(height, 2)));
        return diag;
    }
// Turn this rectangle 90 degrees ( changing base by height ).

    public void turn() {
        int aux = this.base;
        this.base = this.height;
        this.height = aux;
    }
// Ensure that this rectangle is oriented horizontally ( the base is greater
// or equal than the height ).

    public void putHorizontal() {
        if (this.base < this.height) {
            this.turn();
        }
    }
// Ensure that this rectangle is oriented vertically ( the height is greater
// or equal than the base ).

    public void putVertical() {
        if (this.base > this.height) {
            this.turn();
        }
    }
// Two rectangles are equal if the base and the height are the same .
// It does not take into account if the rectangle is rotated .

    @Override
    public boolean equals(Object obj) {
        if (obj==null)
            return false;
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        Rectangle rect = (Rectangle) obj;
        if (this.base == rect.getBase() && this.height == rect.getHeight()) {
            return true;
        } else if (this.base == rect.getHeight() && this.height == rect.getBase()) {
            return true;
        }
        return false;
    }
// It complies with the hashCode contract and is consistent with the equals .

    @Override
    public int hashCode() {
        int total = base + height;
        return Objects.hash(total);
    }
}
