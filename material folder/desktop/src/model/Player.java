package model;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Player {

    Texture texture;

    public Player(){

        this.texture = new Texture(Gdx.files.internal("C:\\Users\\Max4u_000\\Documents\\Projekt\\source code\\AfterLife\\material folder\\images\\image0.png"));

    }

    public Texture getTexture() {
        return texture;
    }

}
