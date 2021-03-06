package GameState;

import java.util.ArrayList;

public class GameStateManager {
    // arraylist to hold all gamestates
    private ArrayList<GameState> gameStates;
    private int currentState;

    public static final int MENU = 0;
    public static final int ABOUT = 1;
    public static final int CONTROL = 2;
    public static final int LEADERBOARD = 3;
    public static final int LEVEL = 4;
    public static final int LOST = 5;
    public static final int WON = 6;

    public GameStateManager() {
        gameStates = new ArrayList<GameState>();

        currentState = MENU;

        gameStates.add(new MenuState(this));
        gameStates.add(new AboutState(this));
        gameStates.add(new ControlsState(this));
        gameStates.add(new LeaderboardState(this));
        gameStates.add(new LevelState(this));
        gameStates.add(new LostState(this));
        gameStates.add(new VictoryState(this));
    }

    public void setState(int state) {
        currentState = state;
        gameStates.get(currentState).init();
    }

    public void setState(int state, int score) {
        currentState = state;
        gameStates.get(currentState).init(score);
    }

    public void update() {
        gameStates.get(currentState).update();
    }

    public void draw(java.awt.Graphics2D g) {
        gameStates.get(currentState).draw(g);
    }
}
