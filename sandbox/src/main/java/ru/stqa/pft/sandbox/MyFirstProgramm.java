package ru.stqa.pft.sandbox;

public class MyFirstProgramm
{
    public static void main(String[] args)
    {
        hello("Mir");
        hello("Mur");

        double i = 4.0;
        double l = 3.0;
        System.out.println("Площадь прямоугольного треугольника со сторонами "+i+" и "+l+" = "+area(i,l));
    }

    public static void hello(String word)
    {
        System.out.println("Hello, " + word);
    }

    public static double area(double m, double n)
    {
        return (m*n)/2;
    }
}