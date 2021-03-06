package Player;

import World.LayoutLoader;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class HUD {

    private Player player;
    private BufferedImage ws;
    private BufferedImage as;
    private BufferedImage asr;

    public HUD(Player p) {
        player = p;
        try {
            ws =  ImageIO.read(LayoutLoader.class.getResourceAsStream("/Assets/weaponslot.png"));
            as =  ImageIO.read(LayoutLoader.class.getResourceAsStream("/Assets/abilityslot.png"));
            asr = ImageIO.read(LayoutLoader.class.getResourceAsStream("/Assets/abilityslotready.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g, boolean ready) {
        // health bar
        g.setColor(new Color(170, 27, 27));
        g.fillRect(25, 720, 350, 30); // red
        g.setColor(new Color(0, 169, 0));
        g.fillRect(25, 720, (int)(350 * (player.health()/player.maxHealth())), 30); // green

        // weapon & ability slot
        g.drawImage(ws, 810, 675, null);
        if (ready) g.drawImage(asr, 920, 675, null);
        else g.drawImage(as, 920, 675, null);
    }
}
