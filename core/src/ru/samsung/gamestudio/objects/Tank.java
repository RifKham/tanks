package ru.samsung.gamestudio.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Tank {
    int x, y;
    int width, height;
    Texture[] framesArray;
    int speed;

    int hp;
    int direction;
    Texture texture;
    Tank tank;

    public Tank(int x, int y, int width, int height, int speed, int hp) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.hp = hp;
        framesArray = new Texture[]{ // спрайты танка, повернутые под разным углом
                new Texture("textures/tank/tank_right.jpeg"),   //заменить спрайты на нормальные потом в формате png
                new Texture("textures/tank/tank_left.jpeg"),
                new Texture("textures/tank/tank_up.jpeg"),
                new Texture("textures/tank/tank_down.jpeg")};
        texture = framesArray[2];
    }


    //эту функцию нужно будет вызывать в handleInput, где направление будет зависить от нажатой кнопки
    public void move(int dir){
        direction = dir;
        switch (dir){
            case 1: // право // почему то при движении вправо, танк одновременно движется влево
                x += speed;
                texture = framesArray[dir - 1];
                //break; //если поставить break, то работает, хотя я уверен что есть другое решение
            case 2: // лево
                x -= speed;
                texture = framesArray[dir - 1];
            case 3: // вверх // почему то при движении вверх, танк одновременно движется вниз
                y += speed;
                texture = framesArray[dir - 1];
                //break;
            case 4: // вниз
                y -= speed;
                texture = framesArray[dir - 1];
        }
    }

    public void needToShoot() { // реализовать потом. есть ли способ поварачивать спрайты, без необходимости использовать одни и те же повернутые картинки?
        switch (direction){
            case 1:
                x += speed;
            case 2:
                x -= speed;
            case 3:
                y += speed;
            case 4:
                y -= speed;
        }
    }

    public int getDirection() {
        return direction;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public void draw(SpriteBatch batch) {
        batch.draw(texture, x - (width / 2f), y - (height / 2f), width, height);
    }
}
