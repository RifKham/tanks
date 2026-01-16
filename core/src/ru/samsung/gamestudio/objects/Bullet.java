package ru.samsung.gamestudio.objects;

import com.badlogic.gdx.graphics.Texture;
import ru.samsung.gamestudio.objects.Tank;

public class Bullet {
    int x, y, width, height, speed, hp;
    Texture[] framesArray;

    public Bullet(int x, int y, int width, int height, int speed) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.hp = hp;
        framesArray = new Texture[]{ // спрайты пули, повернутые под разным углом
                new Texture("textures/tank/bullet_right.jpeg"),   //заменить спрайты на нормальные потом в формате png
                new Texture("textures/tank/bullet_left.jpeg"),
                new Texture("textures/tank/bullet_up.jpeg"),
                new Texture("textures/tank/bullet_down.jpeg")};
    }




}
