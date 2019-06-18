import java.awt.*;

public class SnakeBody extends GameObject {

    GameObject next, prev;
    SnakeBody(int xCoor, int yCoor, int height, int width) {
        super(xCoor, yCoor, height, width);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillRect(getxCoor()*getWidth(),getyCoor()*getHeight(), getWidth(), getHeight());
    }
}
