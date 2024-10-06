package ru.mipt.bit.platformer.systems;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import ru.mipt.bit.platformer.core.Map;

import static com.badlogic.gdx.graphics.GL20.GL_COLOR_BUFFER_BIT;

public class RenderSystem {
    public RenderSystem() {
        batch = new SpriteBatch();
    }

    public void registerGameObjectsManager(GameObjectsManager gameObjectsManager) {
        this.gameObjectsManager = gameObjectsManager;
    }

    public void registerMap(Map map) {
        this.map = map;
    }

    public void render() {
        clear();
        map.render();
        batch.begin();
        for (var drawable : gameObjectsManager.getDrawables()) {
            drawable.draw(batch);
        }
        batch.end();
    }

    public Batch getBatch() {
        return batch;
    }

    private void clear() {
        Gdx.gl.glClearColor(0f, 0f, 0.2f, 1f);
        Gdx.gl.glClear(GL_COLOR_BUFFER_BIT);
    }

    private GameObjectsManager gameObjectsManager;
    private Map map;
    private final Batch batch;
}
