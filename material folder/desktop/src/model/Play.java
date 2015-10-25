package model;

public class Play {

    private Map map;

    public Play() {
        this.map = new Map();
    }

    public void update(float dt) {
        map.getWorld().step(dt, 6, 2);
    }

    public Map getMap() {
        return map;
    }

}
