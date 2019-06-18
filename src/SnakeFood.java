import java.awt.*;

public class SnakeFood extends GameObject {

    SnakeFood(int xCoor, int yCoor, int height, int width) {
        super(xCoor, yCoor, height, width);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(getxCoor()*getWidth(),getyCoor()*getHeight(), getWidth(), getHeight());
    }
}
