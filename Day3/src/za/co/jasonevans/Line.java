package za.co.jasonevans;

public class Line {
    Coordinate point1;
    Coordinate point2;

    public Line(Coordinate point1, Coordinate point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    public Coordinate getPoint1() {
        return point1;
    }

    public void setPoint1(Coordinate point1) {
        this.point1 = point1;
    }

    public Coordinate getPoint2() {
        return point2;
    }

    public void setPoint2(Coordinate point2) {
        this.point2 = point2;
    }

    public Integer getLength() {
        return (int) Math.sqrt((Math.pow(point2.getX() - point1.getX(), 2) + Math.pow(point2.getY() - point1.getY(), 2)));
    }
}
