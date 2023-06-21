package GameLogic;
import Object.*;
public class ObjectSetter
{
    GameScreen gameScreen;

    public ObjectSetter(GameScreen gameScreen)
    {
        this.gameScreen = gameScreen;
    }

    public void setObject()
    {
        int row = 0;
        int col = 0;

        //membuat lawan
        gameScreen.obj[1] = new MovingObstacles(9);
        gameScreen.obj[1].worldX = 8 * GameScreen.TILE_SIZE;
        gameScreen.obj[1].worldY = 1 * GameScreen.TILE_SIZE;

        gameScreen.obj[2] = new MovingObstacles(9);
        gameScreen.obj[2].worldX = 12 * GameScreen.TILE_SIZE;
        gameScreen.obj[2].worldY = 5 * GameScreen.TILE_SIZE;

        gameScreen.obj[3]=new MovingObstacles(9);
        gameScreen.obj[3].worldX = 5 * GameScreen.TILE_SIZE;
        gameScreen.obj[3].worldY = 18 * GameScreen.TILE_SIZE;

        gameScreen.obj[4]=new MovingObstacles(9);
        gameScreen.obj[4].worldX = 4 * GameScreen.TILE_SIZE;
        gameScreen.obj[4].worldY = 7 * GameScreen.TILE_SIZE;

        gameScreen.obj[5]=new MovingObstacles(9);
        gameScreen.obj[5].worldY = 3 * GameScreen.TILE_SIZE;
        gameScreen.obj[5].worldX = 16 * GameScreen.TILE_SIZE;

        gameScreen.obj[6]=new MovingObstacles(9);
        gameScreen.obj[6].worldY = 7 * GameScreen.TILE_SIZE;
        gameScreen.obj[6].worldX = 16 * GameScreen.TILE_SIZE;

        gameScreen.obj[7]=new MovingObstacles(9);
        gameScreen.obj[7].worldY = 6 * GameScreen.TILE_SIZE;
        gameScreen.obj[7].worldX = 18 * GameScreen.TILE_SIZE;

        gameScreen.obj[8]=new MovingObstacles(9);
        gameScreen.obj[8].worldY = 10 * GameScreen.TILE_SIZE;
        gameScreen.obj[8].worldX = 18 * GameScreen.TILE_SIZE;
    }
}
