package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import org.w3c.dom.Text;

import javax.swing.text.View;

public class MyGdxGame extends ApplicationAdapter {
	private Stage stage;
	private Label outputLabel;
	private OrthographicCamera camera;


	@Override
	public void create (){
		camera=new OrthographicCamera();
		stage = new Stage(new FillViewport(1280,604));
		camera.setToOrtho(false,1280,604);
		Texture texture = new Texture(Gdx.files.local("LOGO.jpg"));
		Image image1 = new Image(texture);
		image1.setPosition(0,0);
		stage.addActor(image1);
		Gdx.input.setInputProcessor(stage);

		int Help_Guides = 12;
		int row_height = Gdx.graphics.getWidth() / 12;
		int col_width = Gdx.graphics.getWidth() / 12;

		Skin mySkin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));


		Button button1=new TextButton("Resume Game",mySkin,"small");
		button1.setSize(col_width*4,row_height);
		button1.setPosition(800,200);
		button1.addListener(new InputListener(){
		@Override
		public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
			outputLabel.setText("Press a Button");
		}
		@Override
		public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
			outputLabel.setText("Pressed Text Button");
			return true;
		}
	});
		stage.addActor(button1);

		Button button3=new TextButton("Exit",mySkin,"small");
		button3.setSize(col_width*4,row_height);
		button3.setPosition(800,100);
		button3.addListener(new InputListener(){
			@Override
			public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
				outputLabel.setText("Press a Button");
			}
			@Override
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				outputLabel.setText("Pressed Text Button");
				return true;
			}
		});
		stage.addActor(button3);

		// Text Button
		Button button2 = new TextButton("New Game",mySkin,"small");
		button2.setSize(col_width*4,row_height);
		button2.setPosition(800,300);
		button2.addListener(new InputListener(){
			@Override
			public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
				outputLabel.setText("Press a Button");
			}
			@Override
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				outputLabel.setText("Pressed Text Button");
				return true;
			}
		});
		stage.addActor(button2);

		outputLabel = new Label("Press a Button",mySkin,"black");
		outputLabel.setSize(Gdx.graphics.getWidth(),row_height);
		outputLabel.setPosition(0,row_height);
		outputLabel.setAlignment(Align.center);
		stage.addActor(outputLabel);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act();
		stage.draw();
	}
}