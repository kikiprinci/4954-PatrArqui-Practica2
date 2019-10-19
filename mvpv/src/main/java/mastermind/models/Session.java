package mastermind.models;

import java.util.List;

import mastermind.types.Color;

public class Session {

    private Game game;

    private State state;

    public Session() {
        this.game = new Game();
        this.state = new State();
    }

    public void resume() {
        this.game.clear();
        this.state.reset();
    }

    public void next() {
        this.state.next();
    }

    public StateValue getValueState() {
        return this.state.getValueState();
    }

    public int getWidth() {
        return this.game.getWidth();
    }

    public void addProposedCombination(List<Color> colors) {
        this.game.addProposedCombination(colors);

        if (this.game.isWinner() || this.game.isLooser()) {
            this.next();
        }
    }

    public boolean isLooser() {
        return this.game.isLooser();
    }

    public boolean isWinner() {
        return this.game.isWinner();
    }

    public int getAttempts() {
        return this.game.getAttempts();
    }

    public List<Color> getColors(int position) {
        return this.game.getColors(position);
    }

    public int getBlacks(int position) {
        return this.game.getBlacks(position);
    }

    public int getWhites(int position) {
        return this.game.getWhites(position);
    }

    public void clear() {
        this.game.clear();
    }

    public List<ProposedCombination> getProposedCombinations() {
        return this.game.getProposedCombinations();
    }

    public List<Result> getResults() {
        return this.game.getResults();
    }
}