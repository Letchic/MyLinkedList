package com.letchik.testClasses.shapes;

public class MyTriangle {
    private MyPoint v1;
    private MyPoint v2;
    private MyPoint v3;

    public MyTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
    }

    public MyTriangle(MyPoint v1, MyPoint v2, MyPoint v3) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }

    @Override
    public String toString() {
        return "MyTriangle[v1=" + v1 +", v2=" + v2 +", v3=" + v3 +"]";
    }

    public double getPerimetr (){
        return v1.distance(v2)+v2.distance(v3)+v3.distance(v1);
    }

    public String getType (){
        double dist1=v1.distance(v2);
        double dist2=v2.distance(v3);
        double dist3=v3.distance(v1);
        if (dist1==dist2&&dist2==dist3) return "Equilateral";
        if (dist1!=dist2&&dist2!=dist3&&dist3!=dist1) return "Scalene";
        return "Isosceles";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyTriangle that = (MyTriangle) o;

        if (v1 != null ? !v1.equals(that.v1) : that.v1 != null) return false;
        if (v2 != null ? !v2.equals(that.v2) : that.v2 != null) return false;
        return v3 != null ? v3.equals(that.v3) : that.v3 == null;
    }

    @Override
    public int hashCode() {
        int result = v1 != null ? v1.hashCode() : 0;
        result = 31 * result + (v2 != null ? v2.hashCode() : 0);
        result = 31 * result + (v3 != null ? v3.hashCode() : 0);
        return result;
    }
}
