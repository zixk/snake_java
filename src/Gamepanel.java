import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class Gamepanel extends JPanel implements Runnable, KeyListener {

    public static final int WIDTH = 500, HEIGHT = 500;
    private boolean right = true, left = false, up = false, down = false;
    private int xCoor = 10, yCoor = 10, size = 15;
    private int ticks = 0;
    private Thread thread;
    private boolean running;
    private SnakeHead head;
    private SnakeBody body;
    private SnakeFood food;
    private Random r;

    public Gamepanel() {

        setFocusable(true);
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
        addKeyListener(this);
        r = new Random();

        start();
    }

    public void start(){
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public void stop(){
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void tick() {
        if (head == null) {
            head = new SnakeHead(xCoor, yCoor, 10, 10, null);
        }
        ticks++;
        if (ticks > 700000) {
            if (right) xCoor++;
            if (left) xCoor--;
            if (up) yCoor--;
            if (down) yCoor++;

            ticks = 0;

            body = head.castFromHead(head);
            head = new SnakeHead(xCoor, yCoor, 10, 10, null);
            head.append(body);

            if(head.size() > size){
                head.removeLast();
            }

        }

        if(food == null){
            int xCoor = r.nextInt(49);
            int yCoor = r.nextInt(49);

            food = new SnakeFood(xCoor,yCoor,10,10, null);
        }

        if(xCoor == food.getxCoor() && yCoor == food.getyCoor()){
            size++;
            int xCoor = r.nextInt(49);
            int yCoor = r.nextInt(49);

            food = new SnakeFood(xCoor,yCoor,10,10, null);
        }

        if (head.wallCollision()) stop();
        if (head.selfCollision(head.next)) stop();

    }

    public void paint(Graphics g){
        g.clearRect(0,0,WIDTH,HEIGHT);

        g.setColor(Color.BLACK);
        g.fillRect(0,0,WIDTH,HEIGHT);
        //GRID DRAWING
        for(int i = 0; i < WIDTH/10;i++){
            g.drawLine(i*10,0,i*10,HEIGHT);
        }
        for(int i = 0; i < HEIGHT/10;i++) {
            g.drawLine(0, i * 10, WIDTH, i * 10);

        }
        GameObject snakePart = head;
        while(snakePart != null) {
            snakePart.draw(g);
            snakePart = snakePart.next;
        }
        food.draw(g);

    }

    @Override
    public void run() {
        while(running) {
            tick();
            repaint();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_RIGHT && !left){
            right = true;
            up = false;
            down = false;

        }
        if(key == KeyEvent.VK_LEFT && !right) {
            left = true;
            up = false;
            down = false;
        }
        if(key == KeyEvent.VK_UP && !down) {
            up = true;
            left = false;
            right = false;
        }
        if(key == KeyEvent.VK_DOWN && !up) {
            down = true;
            left = false;
            right = false;
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }
}
