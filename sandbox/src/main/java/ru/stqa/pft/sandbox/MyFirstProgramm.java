package ru.stqa.pft.sandbox;

public class MyFirstProgramm
{
    public static void main(String[] args)
    {
        hello("Mir");
        hello("Mur");

        Square s = new Square(5);
        System.out.println("Площадь квадрата со стороной "+s.l+" = "+s.area());

        Rectangle r = new Rectangle(4,3);
        System.out.println("Площадь прямоугольного треугольника со сторонами "+r.a+" и "+r.b+" = "+r.area());
    }
    public static void hello(String word)
    {
        System.out.println("Hello, " + word);
    }
}