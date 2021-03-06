package Entity;

import java.awt.image.BufferedImage;

public abstract class Entity {
    // sprite
    protected BufferedImage sprite;
    protected BufferedImage proj_sprite;

    // collision
    protected CollisionBox cb;

    // positioning and speed
    protected double x;
    protected double y;
    protected double room_x;
    protected double room_y;
    protected double dx;
    protected double dy;
    protected int width;
    protected int height;

    protected boolean left;
    protected boolean right;
    protected boolean up;
    protected boolean down;

    public void setPosition(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setRoomPosition(double x, double y) {
        this.room_x = x;
        this.room_y = y;
    }

    public CollisionBox getCB() { return cb; }

    public int x_pos() { return (int)x; }
    public int y_pos() { return (int)y; }
    public int x_r_pos() { return (int)room_x; }
    public int y_r_pos() { return (int)room_y; }
    public int getWidth() { return width; }
    public int getHeight() { return height; }

    public void setLeft(boolean b) { left = b; }
    public void setRight(boolean b) { right = b; }
    public void setUp(boolean b) { up = b; }
    public void setDown(boolean b) { down = b; }

    public boolean onScreen(int px, int py){
        return (Math.abs(px - room_x) < 512) && (Math.abs(py - room_y) < 384);
    }

    // for static objects that don't move on screen
    public void draw(java.awt.Graphics2D g){ g.drawImage(sprite, (int)(x - width/2), (int)(y - height/2), null); }

    // dynamic objects moving across map
    public void draw(java.awt.Graphics2D g, int px, int py, int x, int y) {
        if(onScreen(px, py)) g.drawImage(sprite,512-px+(x - width/2),384-py+(y - height/2), null);
    }
}