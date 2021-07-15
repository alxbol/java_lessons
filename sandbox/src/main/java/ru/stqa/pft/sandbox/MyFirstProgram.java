package ru.stqa.pft.sandbox;

class MyFirstProgram {
    public static void main(String[] args) {
        Point p1 = new Point();
        p1.x = 300;
        p1.y = 300;
        Point p2 = new Point();
        p2.x = 400;
        p2.y = 400;
        System.out.println(p1.distance(p1, p2));
    }
}