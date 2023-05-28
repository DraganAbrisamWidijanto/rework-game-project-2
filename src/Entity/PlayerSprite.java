package Entity;


import GameLogic.GameScreen;
import GameLogic.InputHandler;
import Utilities.Util;

import java.awt.*;
import java.util.ArrayList;
import java.util.Map;

public class PlayerSprite extends Sprite
{
    GameScreen gameScreen;
    InputHandler inputHandler;

    public PlayerSprite(GameScreen gameScreen, InputHandler inputHandler)
    {
        this.gameScreen = gameScreen;
        this.inputHandler = inputHandler;

        setDefaultValues();
    }

    public void setDefaultValues()
    {
        x = 100;
        y = 100;
        speed = 4;
        spriteFiles = Util.loadFileToHashMap();
        direction = "down";
    }

    public void update()
    {
        if(inputHandler.isUp || inputHandler.isDown || inputHandler.isLeft || inputHandler.isRight)
        {
            if(inputHandler.isUp)
            {
                direction = "up";
                y -= speed;
            }
            else if(inputHandler.isDown)
            {
                direction = "down";
                y += speed;
            }
            else if(inputHandler.isRight)
            {
                direction = "right";
                x += speed;
            }
            else if(inputHandler.isLeft)
            {
                direction = "left";
                x -= speed;
            }
            spriteCounter++;

            if(spriteCounter > 20) // for every 20 frames
            {
                if(spriteNum == 0)
                {
                    spriteNum = 1;
                }
                else if(spriteNum == 1)
                {
                    spriteNum = 2;
                }
                else if (spriteNum == 2)
                {
                    spriteNum = 3;
                }
                else if (spriteNum == 3)
                {
                    spriteNum = 4;
                }
                else if (spriteNum == 4)
                {
                    spriteNum = 5;
                }
                else if (spriteNum == 5)
                {
                    spriteNum = 0;
                }
                spriteCounter = 0;
            }
        }
        else
        {
            direction = "idle";
            spriteCounter++;
            if(spriteCounter > 20) // for every 20 frames
            {
                if(spriteNum == 0)
                {
                    spriteNum = 1;
                }
                else if(spriteNum == 1)
                {
                    spriteNum = 2;
                }
                else if (spriteNum == 2)
                {
                    spriteNum = 3;
                }
                else if (spriteNum == 3)
                {
                    spriteNum = 0;
                }

                spriteCounter = 0;
            }
        }
    }

    public void draw(Graphics2D g2d)
    {
        Image image = null;
        ArrayList<Image> temp = getSpritesFromDirections(Util.loadFileToHashMap(),direction);
        System.out.println(direction);
        if(direction == "idle" && spriteNum > 3)
        {
            spriteNum = 0;
            g2d.drawImage(temp.get(spriteNum),x,y,GameScreen.TILE_SIZE,GameScreen.TILE_SIZE,null);
        }
        else
        {
            g2d.drawImage(temp.get(spriteNum),x,y,GameScreen.TILE_SIZE,GameScreen.TILE_SIZE,null);
        }
    }

    private ArrayList<Image> getSpritesFromDirections(Map<String, ArrayList<Image>> spriteFiles, String direction)
    {
        switch (direction)
        {
            case "up":
                return spriteFiles.get("WalkUp");
            case "down":
                return spriteFiles.get("Walk");
            case "right":
                return spriteFiles.get("WalkRight");
            case "left":
                return spriteFiles.get("WalkLeft");
            case "idle":
                return spriteFiles.get("Idle");
        }
        return null;
    }
}