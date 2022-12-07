package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.assets.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.Menu;
import com.badlogic.gdx.utils.viewport.FillViewport;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

public class TankSelect implements Screen{
    private final MyGdxGame game;
    SpriteBatch spriteBatch;
    private Stage stage;
    private OrthographicCamera camera;
    private Texture background,backbutton4,texture;
    private TextureRegion backgroundTexture,bbt,bbt1,bbt2,bbt3,bbt4,bbt5,bbt6,bbt7,bbt8,bbt9,bbt10;
    private TextureRegionDrawable bbtt,bbtt1,bbtt2,bbtt3,bbtt4,bbtt6,bbtt5,bbtt7,bbtt8,bbtt9,bbtt10;
    private ImageButton bt,bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9,bt10;
    Animation<TextureRegion> animation;
    SpriteBatch batch;
    private Skin skin;
    float elapsed;
    private int i,j;
    private Boolean a=true,b=true;



    public TankSelect(final MyGdxGame game) {
        this.game = game;
        this.skin=new Skin();
        this.skin.addRegions();
        ImageButton backbutton=new ImageButton(skin);
        ImageButton backbutton2=new ImageButton(skin);
        ImageButton backbutton3=new ImageButton(skin);
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        stage = new Stage(new FillViewport(1120.0F, 620.0F));
        this.background = new Texture(Gdx.files.internal("background1/bfts.png"));
        this.backgroundTexture = new TextureRegion(this.background, 0, 0, background.getWidth(), background.getHeight());
        this.camera.setToOrtho(false, background.getWidth(), background.getHeight());
        Gdx.input.setInputProcessor(stage);
        backbutton.setSize(35,35);
        backbutton.getStyle().imageUp = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("background1/backbutton.png"))));
        backbutton.setPosition(10,580);
        backbutton2.setSize(35,35);
        backbutton2.getStyle().imageUp = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("background1/backbutton.png"))));
        backbutton2.setPosition(80,200);
        backbutton3.setSize(35,35);
        backbutton3.getStyle().imageUp = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("background1/forwardbutton.png"))));
        backbutton3.setPosition(370,200);

        backbutton.addListener(new ClickListener() { //time gap is bit large
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new Menu(game));
            }
        });
        stage.addActor(backbutton);
        i++;
        stage.addActor(backbutton2);

        stage.addActor(backbutton3);


        final Dictionary<Integer, String> dict = new Hashtable<Integer, String>();
        dict.put(0, "tank/Abrams.png");
        dict.put(1, "tank/Frost.png");
        dict.put(2, "tank/Buratino.png");
        dict.put(3, "tank/Coalition.png");
        dict.put(4, "tank/Dubstep_edited_29.png");
        dict.put(5, "tank/Atomic.png");
        dict.put(6, "tank/Mark_I.png");
        dict.put(7, "tank/Pinky_edited.png");
        System.out.println(dict.get(i));
        this.i=0;
        this.texture = new Texture(Gdx.files.internal("tank/Mark_I.png"));
        backbutton2.addListener(new InputListener() {
            final int max =0;
            final int min=7;
            public int value(int i){
//                waitTime(300);
                final int p=(int) (Math.random() * (min - max + 1) + min);
                System.out.println(p);
                return p;
            }
//            @Override
//            public boolean handle(Event event) {
//                i++;
//                int v =value(i);
//                waitTime(500);
//                texture = new Texture(Gdx.files.internal(dict.get(v)));
//                waitTime(500);
////                System.out.println(v);
//                return false;
//            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return super.touchDown(event, x, y, pointer, button);
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                i++;
                int v =value(i);
                waitTime(500);
                texture = new Texture(Gdx.files.internal(dict.get(v)));
                super.touchUp(event, x, y, pointer, button);
            }

            private void waitTime(int MS) {
                try
                {
                    TimeUnit.MILLISECONDS.sleep(MS);
                }
                catch(InterruptedException ex)
                {
                    Thread.currentThread().interrupt();
                }
            }
        });
        backbutton3.addListener(new EventListener() {
            final int p=i;
            @Override
            public boolean handle(Event event) {
                texture = new Texture(Gdx.files.internal(dict.get(i)));
                return false;
            }
        });

    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        elapsed += Gdx.graphics.getDeltaTime();
        ScreenUtils.clear(0.0F, 0.0F, 0.0F, 0.0F);
        this.camera.update();
        this.game.batch.setProjectionMatrix(this.camera.combined);
        this.game.batch.begin();
        this.game.batch.draw(this.backgroundTexture, 0.0F, 0.0F, background.getWidth(), background.getHeight());
        this.game.batch.draw(this.texture, 60,140,180,200);
        this.game.batch.end();
        stage.act();
        stage.draw();
//        spriteBatch.begin();
//        spriteBatch.draw(this.texture,60,150,400,200);
//        spriteBatch.end();

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
    public void dispose() {batch.dispose();stage.dispose();}

}
