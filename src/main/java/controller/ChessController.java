package controller;

import controller.adapter.inward.Command;
import controller.adapter.inward.CoordinateAdapter;
import controller.adapter.outward.RenderingAdapter;
import domain.board.ChessGame;
import domain.piece.move.Coordinate;
import view.InputView;
import view.OutputView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public class ChessController {

    public static final int START_COORDINATE_INDEX = 1;
    public static final int END_COORDINATE_INDEX = 2;

    private final InputView inputView;
    private final OutputView outputView;

    private final Map<Command, BiConsumer<ChessGame, List<String>>> commander;

    public ChessController(
            final InputView inputView,
            final OutputView outputView
    ) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.commander = new HashMap<>();
        initializeCommander();
    }

    private void initializeCommander() {
        commander.put(Command.START, this::start);
        commander.put(Command.END, this::end);
        commander.put(Command.MOVE, this::move);
        commander.put(Command.STATUS, this::status);
    }

    public void run() {
        ChessGame chessGame = new ChessGame();
        outputView.printGameStartMessage();
        repeat(() -> interact(chessGame));
    }

    private void repeat(Runnable target) {
        try {
            target.run();
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e.getMessage());
            repeat(target);
        }
    }

    private void interact(final ChessGame chessGame) {
        Command command;
        do {
            List<String> arguments = inputView.readCommand();
            command = Command.of(arguments);
            commander.get(command).accept(chessGame, arguments);
        } while (command.isNotEnd() && chessGame.isGameNotOver());
    }

    private void start(final ChessGame chessGame, final List<String> ignored) {
        printBoard(chessGame);
    }

    private void end(final ChessGame chessGame, final List<String> ignored) {
        String gameResultMessage = RenderingAdapter.unpackGameResult(chessGame.collectPoint());
        outputView.printGameEndMessage();
        outputView.printGameResult(gameResultMessage);
    }

    private void move(final ChessGame chessGame, final List<String> coordinates) {
        Coordinate startCoordinate = CoordinateAdapter.convert(coordinates.get(START_COORDINATE_INDEX));
        Coordinate endCoordinate = CoordinateAdapter.convert(coordinates.get(END_COORDINATE_INDEX));
        chessGame.move(startCoordinate, endCoordinate);
        printBoard(chessGame);
    }

    private void status(final ChessGame chessGame, final List<String> ignored) {
        outputView.printGameResult(RenderingAdapter.unpackGameResult(chessGame.collectPoint()));
    }

    private void printBoard(final ChessGame chessGame) {
        String boardMessage = RenderingAdapter.unpackBoard(chessGame.getBoard());
        outputView.printBoard(boardMessage);
    }
}
