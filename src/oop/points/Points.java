package oop.points;

import fileworks.DataImport;

import java.util.ArrayList;

public class Points {
    public static void main(String[] args) {
        DataImport di = new DataImport("data/points.txt");
        ArrayList<Point> points = new ArrayList<>();
        String[] cutLine;

        while (di.hasNext()){
            cutLine = di.readLine().split(",");
            switch (cutLine.length){
                case 2: points.add(new Point(Double.parseDouble(cutLine[0]), Double.parseDouble(cutLine[1])));
                    break;
                case 3: points.add(new Point(cutLine[0], Double.parseDouble(cutLine[1]), Double.parseDouble(cutLine[2])));
                    break;
                case 4: points.add(new Point(cutLine[0], Double.parseDouble(cutLine[1]), Double.parseDouble(cutLine[2]), Double.parseDouble(cutLine[3])));
                    break;

            }

        }
        for (Point p : points){
            System.out.println(p.toString());
        }







        di.finishImport();
    }
}


class Point {
    protected String name;
    protected double x, y, z;
    protected final double DEFAULT_Z = 0;
    protected static int pointsCreated = 1;


    public Point(String name, double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.name = name;
    }
    public Point(String name, double x, double y) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.z = DEFAULT_Z;
    }
    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
        z = DEFAULT_Z;
        name = "Point#"+pointsCreated;
        pointsCreated++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getX() {
        return x;
    }

    public static int getPointsCreated() {
        return pointsCreated;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return "Point{" +
                "z=" + z +
                ", y=" + y +
                ", x=" + x +
                ", name='" + name + '\'' +
                '}';
    }
}