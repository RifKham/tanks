package ru.samsung.gamestudio.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.ScreenUtils;

import ru.samsung.gamestudio.GameResources;
import ru.samsung.gamestudio.MyGdxGame;
import ru.samsung.gamestudio.objects.Tank;

public class GameScreen extends ScreenAdapter {

    MyGdxGame myGdxGame;
    Tank tank;

    public GameScreen(MyGdxGame myGdxGame) {

        this.myGdxGame = myGdxGame;
        this.tank = new Tank(720, 720, 200, 160, 10, 3);
    }

    @Override
    public void render(float delta){
        handleInput();
        draw();
    }

    private void handleInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.UP))  {
            tank.move(3);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN))  {
            tank.move(4);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))  {
            tank.move(1);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT))  {
            tank.move(2);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.ENTER)) {}
    }

    private void draw() {

        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);
        ScreenUtils.clear(Color.CLEAR);

        myGdxGame.batch.begin();
        tank.draw(myGdxGame.batch);
        myGdxGame.batch.end();
    }

}