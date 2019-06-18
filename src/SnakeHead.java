import java.awt.*;

public class SnakeHead extends GameObject {


    SnakeHead(int xCoor, int yCoor, int height, int width, GameObject next) {
        super(xCoor, yCoor, height, width, next);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(getxCoor()*getWidth(),getyCoor()*getHeight(), getWidth(), getHeight());
    }
}
