package Object;

import GameLogic.GameScreen;

import javax.swing.*;

public class MovingObstacles extends GameObject
{
    boolean reverse = true;
    int destination;
    public MovingObstacles(int num)
    {
        name = "puzzle piece";
        String path = "./assets/objects/0";
        image = new ImageIcon(path + num + ".png").getImage();
        collision = true;
    }

    //lawan bergerak logic
//    public void moveObj(GameObject objs[], int i)
//    {
//        if(i == 1 || i == 2)
//        {
//            destination = 14 * GameScreen.TILE_SIZE;
//        }
//
//        if(reverse)
//        {
//            if(objs[i].worldY <= destination - (GameScreen.TILE_SIZE * 3))
//            {
//                reverse = false;
//            } else
//            {
//                objs[i].worldY -= 3;
//            }
//        }
//        else
//        {
//            if(objs[i].worldY >= destination)
//            {
//                reverse = true;
//            }
//            else
//            {
//                objs[i].worldY += 3;
//            }
//        }
//    }



    public void moveObj(GameObject objs[], int i) {
        // Tentukan posisi tujuan
        int destinationX = objs[i].worldX;
        int destinationY = objs[i].worldY;
        if(i == 1 || i == 2)
        {
            // Pengecekan arah pergerakan
            if (objs[i].worldX == destinationX && objs[i].worldY == destinationY) {
                // Musuh berada di posisi awal, tentukan tujuan berikutnya
                if (destinationX < 12 * GameScreen.TILE_SIZE && destinationY <= 1 * GameScreen.TILE_SIZE) {
                    // Bergerak ke kanan
                    destinationX += 4 * GameScreen.TILE_SIZE;
                } else if (destinationY < 5 * GameScreen.TILE_SIZE && destinationX >= 12 * GameScreen.TILE_SIZE) {
                    // Bergerak ke bawah
                    destinationY += 4 * GameScreen.TILE_SIZE;
                } else if (destinationX >= 8 * GameScreen.TILE_SIZE && destinationY <= 9 * GameScreen.TILE_SIZE) {
                    // Bergerak ke kiri
                    destinationX -= 4 * GameScreen.TILE_SIZE;
                } else if (destinationY >= 1 * GameScreen.TILE_SIZE && destinationX <= 8 * GameScreen.TILE_SIZE) {
                    // Bergerak ke atas
                    destinationY -= 4 * GameScreen.TILE_SIZE;
                }
            }
            // Gerakan musuh ke tujuan berikutnya
            if (objs[i].worldX < destinationX) {
                // Bergerak ke kanan
                if (destinationX - objs[i].worldX >= 4 * GameScreen.TILE_SIZE) {
                    objs[i].worldX += 3;
                } else {
                    objs[i].worldX = destinationX;
                }
            } else if (objs[i].worldY < destinationY) {
                // Bergerak ke bawah
                if (destinationY - objs[i].worldY >= 4 * GameScreen.TILE_SIZE) {
                    objs[i].worldY += 3;
                } else {
                    objs[i].worldY = destinationY;
                }
            } else if (objs[i].worldX > destinationX) {
                // Bergerak ke kiri
                if (objs[i].worldX - destinationX >= 4 * GameScreen.TILE_SIZE) {
                    objs[i].worldX -= 3;
                } else {
                    objs[i].worldX = destinationX;
                }
            } else {
                // Bergerak ke atas
                if (objs[i].worldY - destinationY >= 4 * GameScreen.TILE_SIZE) {
                    objs[i].worldY -= 3;
                } else {
                    objs[i].worldY = destinationY;
                }
            }
        }
        if (i == 3) {
            if (objs[i].worldX == destinationX && objs[i].worldY == destinationY) {
//                // Musuh berada di posisi awal, tentukan tujuan berikutnya
//                if (destinationY >= 18 * GameScreen.TILE_SIZE && reverse) {
//                    // Bergerak ke bawah
//                    destinationY -= 10 * GameScreen.TILE_SIZE;
//                } else if (destinationY < 8 * GameScreen.TILE_SIZE && !reverse) {
//                    // Bergerak ke atas
//                    destinationY += 10 * GameScreen.TILE_SIZE;
//                }
                if(i == 3)
                {
                    if (reverse) {
                        // Bergerak ke bawah
                        destinationY = 8 * GameScreen.TILE_SIZE;
                    } else if (!reverse) {
                        // Bergerak ke atas
                        destinationY = 18 * GameScreen.TILE_SIZE;
                    }
                }
            }

        }
        if(i == 4)
        {
            if (objs[i].worldX == destinationX && objs[i].worldY == destinationY) {

                if (reverse) {
                    // Bergerak ke bawah
                    destinationY = 11 * GameScreen.TILE_SIZE;
                } else if (!reverse) {
                    // Bergerak ke atas
                    destinationY = 7 * GameScreen.TILE_SIZE;
                }
                System.out.println(objs[i].worldY + " " + destinationY);

            }
        }

        if(i == 3 || i == 4)
        {
            if(objs[i].worldY < destinationY)
            {
                objs[i].worldY += 3;
            }
            else if(objs[i].worldY > destinationY)
            {
                objs[i].worldY -=3;
            }
            else if(objs[i].worldY == destinationY)
            {
                if(reverse)
                {
                    reverse = false;
                }
                else
                {
                    reverse = true;
                }
            }
    }
    }


}
