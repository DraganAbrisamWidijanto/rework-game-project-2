package GameLogic;

import Entity.PlayerSprite;
import World.TileSetter;
import Object.MovingObstacles;

import javax.swing.*;
import java.awt.*;

public class GameScreen extends JPanel implements Runnable
{
    public static final int DEFAULT_TILE_SIZE = 16; // 16x16 tile, standard for most 2d games
    static final int SCALING = 3;
    public static final int TILE_SIZE = DEFAULT_TILE_SIZE * SCALING;

    // world is 16 * 12, or 4 : 3 ratio
    public static final int MAX_SCREEN_COLUMNS = 16;
    public static final int MAX_SCREEN_ROWS = 12;
    public static final int SCREEN_WIDTH = TILE_SIZE * MAX_SCREEN_COLUMNS;
    public static final int SCREEN_HEIGHT = TILE_SIZE * MAX_SCREEN_ROWS;

    // game mechanics
    final int FPS = 60;
    Thread gameThread;
    InputHandler inputHandler = new InputHandler();
    TileSetter tileSetter = new TileSetter(this);
    public CheckCollision checkCollision = new CheckCollision(this);
    public ObjectSetter objectSetter = new ObjectSetter(this);

    public MovingObstacles obj[] = new MovingObstacles[20];

    // player default location
    public PlayerSprite playerSprite = new PlayerSprite(this, inputHandler);

    // world
    public static final int MAX_WORLD_COL = 20;
    public static final int MAX_WORLD_ROW = 20;
    public final int worldWidth = TILE_SIZE * MAX_WORLD_COL;
    public final int worldHeight = TILE_SIZE * MAX_WORLD_ROW;




    public GameScreen()
    {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.black);
        // used to improve game's rendering performance, apparently
        this.setDoubleBuffered(true);

        // listening key inputs from this object
        this.addKeyListener(inputHandler);
        this.setFocusable(true);
    }
    public void setGame()
    {
        objectSetter.setObject();
    }
    /*
    when instantiate gameThread and starting it,
    it will call run() until stop method called.
     */
    public void startThread()
    {
        gameThread = new Thread(this);
        gameThread.start();

    }
    @Override
    public void run()
    {
        double drawInterval = 1000000000/FPS; //
        double nextInterval = System.nanoTime() + drawInterval;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;


        while(gameThread != null)
        {
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if(delta >= 1)
            {
                playerSprite.update();
                repaint();
                delta--;
                drawCount++;

            }
            if(timer >= 1000000000)
            {
                drawCount = 0;
                timer = 0;
            }
        }
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        tileSetter.draw(g2d);


        for(int i = 0; i < obj.length; i++)
        {
            if(obj[i] != null)
            {
                obj[i].moveObj(obj, i);
                obj[i].draw(g2d,this);
            }
        }

        playerSprite.draw(g2d);

        g2d.dispose();
    }
}
