package ru.mipt.bit.platformer.core;

import com.badlogic.gdx.Gdx;

import java.util.HashMap;

public class InputActionMap {
    public static void mapAction(int key, Action action) {
        actionsMap.put(key, action);
    }

    public static void cacheActualAction() {
        cachedAction = nativeGetAction();
        cached = true;
    }

    public static void invalidateCachedAction() {
        cachedAction = new NoneAction();
        cached = false;
    }

    public static Action getAction() {
        if (cached) {
            return cachedAction;
        }
        return nativeGetAction();
    }

    private static Action nativeGetAction() {
        for (var mapEntry : actionsMap.entrySet()) {
            if (Gdx.input.isKeyPressed(mapEntry.getKey())) {
                return mapEntry.getValue();
            }
        }
        return new NoneAction();
    }


    private static final HashMap<Integer, Action> actionsMap = new HashMap<>();

    private static boolean cached = false;
    private static Action cachedAction = new NoneAction();
}
