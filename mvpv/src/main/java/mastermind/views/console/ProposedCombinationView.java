package mastermind.views.console;

import java.util.ArrayList;
import java.util.List;

import mastermind.models.Combination;
import mastermind.models.Session;
import mastermind.types.Color;
import mastermind.types.Error;
import mastermind.utils.WithConsoleView;
import mastermind.views.MessageView;

public class ProposedCombinationView extends WithConsoleView {

	public ProposedCombinationView() {
	}

	public void write(int position,Session session) {
		for (Color color : session.getColors(position)) {
			new ColorView(color).write();
		}
	}

	public List<Color> read() {
		List<Color> colors = new ArrayList<>();
		Error error;
		do {
			error = null;
			colors = readColors();
			if (colors.size() != Combination.getWidth()) {
				error = Error.WRONG_LENGTH;
			} else {
				for (int i = 0; i < colors.size(); i++) {
					if (colors.get(i) == null) {
						error = Error.WRONG_CHARACTERS;
					} else {
						for (int j = i + 1; j < colors.size(); j++) {
							if (colors.get(i) == colors.get(j)) {
								error = Error.DUPLICATED;
							}
						}
					}
				}
			}
			if (error != null) {
				new ErrorView(error).writeln();
				colors = new ArrayList<>();
			}
		} while (error != null);

		return colors;
	}

	private List<Color> readColors() {
		String characters = this.console.readString(MessageView.PROPOSED_COMBINATION.getMessage());
		List<Color> colors = new ArrayList<Color>();
		for (int i = 0; i < characters.length(); i++) {
			colors.add(ColorView.getInstance(characters.charAt(i)));
		}
		return colors;
	}
}
