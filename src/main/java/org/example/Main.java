package org.example;

public class Main {
    public static void main(String[] args) {

        // create square
        Square square = new Square(10);
        Rectangle rectangle = new SquareToRectangleAdapter(square);

        System.out.println("Square's area: " + square.getArea());
        System.out.println("Rectangle's area: " + rectangle.getArea());
    }
}

class Square
{
    public int side;

    public Square(int side)
    {
        this.side = side;
    }

    public int getArea()
    {
        return side * side;
    }
}

interface Rectangle
{
    int getWidth();
    int getHeight();

    default int getArea()
    {
        return getWidth() * getHeight();
    }
}

class SquareToRectangleAdapter implements Rectangle
{
    private int width;
    private int height;

    public SquareToRectangleAdapter(Square square)
    {
        width = square.side;
        height = square.side;
    }

    public Rectangle getRectangle()
    {
        return this;
    }


    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }
}