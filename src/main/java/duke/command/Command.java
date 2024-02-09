package duke.command;

import duke.exceptions.InputException;

/**
 * Enumeration of commands that can be executed in the Duke application.
 */
public enum Command {
    BYE {
        @Override
        public boolean isExit() {
            return true;
        }
    },
    TODO,
    DEADLINE,
    EVENT,
    LIST,
    MARK,
    UNMARK,
    FIND,
    DELETE;

    public boolean isExit() {
        return false;
    }

    /**
     * Parses and returns the appropriate command based on user input.
     *
     * @param input The user's input string.
     * @return The corresponding `Command` enum value.
     * @throws InputException If there is an issue processing the input or if the command is unrecognized.
     */
    public static Command processCommand(String input) throws InputException {
        try {
            String commandString = input.split(" ")[0];
            return Command.valueOf(commandString.toUpperCase());
        } catch (IndexOutOfBoundsException e) {
            String message = "Something went wrong when processing your command: \n"
                    + "Check your input again: " + input;
            throw new InputException(message, e);
        } catch (IllegalArgumentException e) {
            String message = "You inputted an unrecognizable command";
            throw new InputException(message);
        }
    }
}
