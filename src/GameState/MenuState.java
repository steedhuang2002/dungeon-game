package GameState;

import Handler.Keys;
import Images.Background;
import java.awt.*;

public class MenuState extends GameState {

    private Background bg;
    private int currentChoice = 0;
    private String[] buttons = {"Play", "Controls", "Leaderboard", "About", "Quit"};

    private Color titleColor;
    private Font titleFont;
    private Font font;

    public MenuState(GameStateManager gsm) {
        this.gsm = gsm;
        try{
            bg = new Background("/Assets/menubg.jpg", 0);
            bg.setVector(0, 0);
            titleColor = new Color(206, 209, 233);
            titleFont = new Font("Century Gothic", Font.BOLD, 70);

            font = new Font("Century Gothic", Font.PLAIN, 45);

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void init() {}
    public void init(int score) {}

    public void update() {
        bg.update();
        handleInput();
    }

    public void draw(Graphics2D g) {
        // bg and title
        bg.draw(g);
        g.setColor(titleColor);
        g.setFont(titleFont);
        g.drawString("Dungeon Game", 230, 260); // make function that centers string

        // menu options
        g.setFont(font);
        for (int i = 0; i < buttons.length; i++){
            if (i == currentChoice) {
                g.setColor(Color.WHITE);
            } else {
                g.setColor(Color.RED);
            }
            g.drawString(buttons[i],270,340+i*60);
        }
    }

    private void select() {
        if (currentChoice == 0) gsm.setState(GameStateManager.LEVEL); // play
        else if (currentChoice == 1) gsm.setState(GameStateManager.CONTROL); // controls
        else if (currentChoice == 2) gsm.setState(GameStateManager.LEADERBOARD);  // leader board
        else if (currentChoice == 3) gsm.setState(GameStateManager.ABOUT); // about
        else if (currentChoice == 4) System.exit(0); // quit
    }

    public void handleInput() {
        if (Keys.isPressed(Keys.ENTER)) {
            select();
        }
        if (Keys.isPressed(Keys.W)) {
            currentChoice--;
            if (currentChoice == -1){
                currentChoice = buttons.length-1;
            }
        }
        if (Keys.isPressed(Keys.S)) {
            currentChoice++;
            if (currentChoice == buttons.length){
                currentChoice = 0;
            }
        }
    }
}
