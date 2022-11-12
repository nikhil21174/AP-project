package com.pract.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;

public class HomeMenu implements Screen{
    OrthographicCamera camera;

    public HomeMenu(final practice game){
        this.game=game;
        camera=new OrthographicCamera();
        camera.setToOrtho(false,1850,950);
    }
}