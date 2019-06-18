import java.awt.*;

public class SnakeHead extends GameObject {

    GameObject next;
    SnakeHead(int xCoor, int yCoor, int height, int width) {
        super(xCoor, yCoor, height, width);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(getxCoor()*getWidth(),getyCoor()*getHeight(), getWidth(), getHeight());
    }
}
