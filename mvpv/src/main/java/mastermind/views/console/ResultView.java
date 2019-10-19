package mastermind.views.console;

import mastermind.models.Result;
import mastermind.utils.WithConsoleView;
import mastermind.views.MessageView;

public class ResultView extends WithConsoleView {

	public ResultView() {
	}

	public void write(Result result) {
		this.console.writeln(MessageView.RESULT.getMessage().replaceFirst("#blacks", "" + result.getBlacks())
				.replaceFirst("#whites", "" + result.getWhites()));
	}

	public void write(String message) {
		this.console.writeln(message);
	}

}
