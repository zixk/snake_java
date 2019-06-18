import java.awt.*;

abstract class GameObject {
    private int xCoor, yCoor, height, width;
    GameObject next, prev = null;

    GameObject(int xCoor, int yCoor, int height, int width, GameObject next){
        this.xCoor = xCoor;
        this.yCoor = yCoor;
        this.height = 10;
        this.width = 10;
        this.next = next;
        if (next != null) next.prev = this;
    }

    int size(){
        if(next != null) return next.size() + 1;
        return 1;
    }

    void append(GameObject obj){
        if(next == null){
            next = obj;
            obj.prev = this;
        } else next.append(obj);
    }

    void removeLast(){
        if(next!= null){
            next.removeLast();
        }else{
            prev.next = null;
        }

    }
    public int getxCoor() {
        return xCoor;
    }

    public int getyCoor() {
        return yCoor;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void setxCoor(int xCoor) {
        this.xCoor = xCoor;
    }

    public void setyCoor(int yCoor) {
        this.yCoor = yCoor;
    }

    public abstract void draw(Graphics g);
}
