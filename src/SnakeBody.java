import java.awt.*;

public class SnakeBody extends GameObject {


    SnakeBody(int xCoor, int yCoor, int height, int width, GameObject next) {
        super(xCoor, yCoor, height, width, next);
    }



    @Override
    public void draw(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillRect(getxCoor()*getWidth(),getyCoor()*getHeight(), getWidth(), getHeight());
    }
}
