package Player.Items;

import GameState.GameStateManager;
import Images.ImageLoader;
import Player.Inventory;
import Player.Item;

import java.util.ArrayList;

public class Portal extends Item {

    private GameStateManager gsm;

    public Portal(int room_x, int room_y, GameStateManager gsm) {
        super("portal", room_x, room_y, false);

        sprite = ImageLoader.getImage("portal.png");

        this.width = 100;
        this.height = 100;

        this.gsm = gsm;
    }

    public void pickUp(Inventory inv, ArrayList<Item> items) {
        gsm.setState(GameStateManager.LEVEL);
    }
}
