package com.pract.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;
import jdk.nio.zipfs.ByteArrayChannel;

public class HomeMenu implements Screen{
    OrthographicCamera camera;
    private Texture backgroundImage;
    private TextureRegion backgroundTexture;

    public HomeMenu(final Tank_stars game){
        //this.game=game;
        camera=new OrthographicCamera();
        backgroundImage=new Texture(Gdx.files.internal("starting_page.jpeg"));
        backgroundTexture=new TextureRegion(backgroundImage,0,0,1920,1229);
        camera.setToOrtho(false,640,360);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}