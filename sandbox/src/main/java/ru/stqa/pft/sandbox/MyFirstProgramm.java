package ru.stqa.pft.sandbox;

public class MyFirstProgramm
{
    public static void main(String[] args)
    {
        hello("Mir");
        hello("Mur");

        Square s = new Square();
        s.l = 5.0;
        System.out.println("Площадь квадрата со стороной "+s.l+" = "+area(s));

        Rectangle r = new Rectangle();
        r.a = 4.0;
        r.b = 3.0;
        System.out.println("Площадь прямоугольного треугольника со сторонами "+r.a+" и "+r.b+" = "+area(r));
    }

    public static void hello(String word)
    {
        System.out.println("Hello, " + word);
    }
    public static double area(Square s)
    {
        return s.l*s.l;
    }
    public static double area(Rectangle r)
    {
        return (r.a*r.b)/2;
    }
}