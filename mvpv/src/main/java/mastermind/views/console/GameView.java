package mastermind.views.console;

import mastermind.models.Session;
import mastermind.views.MessageView;

public class GameView {

    public GameView() {
    }

    public void write(Session session) {
        new AttemptsView().writeln(session.getAttempts());
        new SecretCombinationView().write(session.getWidth());

        for (int i = 0; i < session.getAttempts(); i++) {
            new ProposedCombinationView().write(i, session);
            new ResultView().write(session.getResults().get(i));
        }
    }

    public void checkResult(Session session) {

        if (session.isWinner()) {
            new ResultView().write(MessageView.WINNER.getMessage());
            session.next();
        } else if (session.isLooser()) {
            new ResultView().write(MessageView.LOOSER.getMessage());
            session.next();
        }
    }
}