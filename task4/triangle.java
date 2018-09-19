package task4;

public class triangle {
    point a, b, c;
    public triangle(point a_, point b_, point c_){
        this.a = a_;
        this.b = b_;
        this.c = c_;
    }
    public void moveRight(float distance){
        a.x += distance;
        b.x += distance;
        c.x += distance;
    }
    public void moveLeft(float distance){
        a.x -= distance;
        b.x -= distance;
        c.x -= distance;
    }
    public void moveUp(float distance){
        a.y += distance;
        b.y += distance;
        c.y += distance;
    }
    public void moveDown(float distance){
        a.y -= distance;
        b.y -= distance;
        c.y -= distance;
    }
    public void resize(point a_, point b_, point c_){
        this.a = a_;
        this.b = b_;
        this.c = c_;
    }
    private float getDistance(point a_, point b_){
        return (float)(Math.sqrt(Math.pow((a_.x - b_.x), 2) + Math.pow((a_.y - b_.y), 2)));
    }
    public void rotate(float degree){
        point t = new point((a.x+b.x+c.x)/3,(a.y+b.y+c.y)/3);
        a.x = (float)(t.x + getDistance(t, a) * Math.cos(degree));
        a.y = (float)(t.y - getDistance(t, a) * Math.sin(degree));
        b.x = (float)(t.x + getDistance(t, b) * Math.cos(degree));
        b.y = (float)(t.y - getDistance(t, b) * Math.sin(degree));
        c.x = (float)(t.x + getDistance(t, c) * Math.cos(degree));
        c.y = (float)(t.y - getDistance(t, c) * Math.sin(degree));
    }
    public void print(){
        System.out.println("point: a{x;y} = " + a.x + ";" + a.y + "| b{x;y} = " + b.x + ";" + b.y + "| c{x;y} = " + c.x + ";" + c.y + "|");
    }

    //d = sqrt(a.x - b.x)^2 + (a.y - b.y)^2)) - формула вычисления расстояния между 2-умя точками в прямоугольной системе координат
    //(x1+x2+x3)/3
}
