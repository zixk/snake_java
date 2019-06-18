import java.awt.*;

public class SnakeFood extends GameObject {


    SnakeFood(int xCoor, int yCoor, int height, int width, GameObject next) {
        super(xCoor, yCoor, height, width, next);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(getxCoor()*getWidth(),getyCoor()*getHeight(), getWidth(), getHeight());
    }
}
