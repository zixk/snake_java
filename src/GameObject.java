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

    boolean selfCollision(GameObject obj){
        if(obj == null) {
            return false;
        }else{
            if(xCoor == obj.xCoor && yCoor == obj.yCoor){
                System.out.println("Game Over");
                return true;
            }
            return this.selfCollision(obj.next);
        }
    }


    boolean wallCollision(){
        if(xCoor < 0 || xCoor > 29 || yCoor < 0 || yCoor > 19){
            System.out.println("Game Over");
            return true;
        }
        return false;
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

    public abstract void draw(Graphics g);
}
