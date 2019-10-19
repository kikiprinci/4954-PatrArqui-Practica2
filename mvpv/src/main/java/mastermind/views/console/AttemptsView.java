package mastermind.views.console;

import mastermind.utils.WithConsoleView;
import mastermind.views.MessageView;

public class AttemptsView extends WithConsoleView {

	public AttemptsView() {
	}

	public void writeln(int attempts) {
		this.console.writeln(MessageView.ATTEMPTS.getMessage().replaceFirst("#attempts",
		"" + attempts));
	}
}
