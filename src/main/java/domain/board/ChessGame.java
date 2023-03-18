package domain.board;

import domain.square.Square;
import domain.piece.Coordinate;

public class ChessGame {

    public static final int FILE_SIZE = 8;

    private final Board board;

    public ChessGame() {
        this.board = new Board(FILE_SIZE);
    }

    public void move(final Coordinate start, final Coordinate end) {
        if (!isMovable(start, end)) {
            throw new IllegalArgumentException("[ERROR] 해당 위치로 가는 경로에 기물이 이미 존재합니다.");
        }
        Square findSquare = board.findSquare(start);
        board.replaceWithEmptySquare(start);
        board.replaceSquare(end, findSquare);
    }

    private boolean isMovable(final Coordinate start, final Coordinate end) {
        return isMovableByRule(start, end) &&
                isEmptySquareAt(end) &&
                isNotBlocked(start, end);
    }

    private boolean isMovableByRule(final Coordinate start, final Coordinate end) {
        return board.isMovable(start, end);
    }

    private boolean isEmptySquareAt(final Coordinate target) {
        return board.isSquareEmptyAt(target);
    }

    private boolean isNotBlocked(final Coordinate start, final Coordinate end) {
        Square square = board.findSquare(start);
        if (square.canReap()) {
            return true;
        }
        return isNotBlockedWhenCantReap(start, end);
    }

    private boolean isNotBlockedWhenCantReap(final Coordinate start, final Coordinate end) {
        Coordinate directionVector = DirectionVector.calculate(start, end);
        Coordinate indexCoordinate = start.add(directionVector);

        while (board.isSquareEmptyAt(indexCoordinate) &&
                !indexCoordinate.equals(end)) {
            indexCoordinate = indexCoordinate.add(directionVector);
        }
        return indexCoordinate.equals(end);
    }

    public Board getBoard() {
        return board;
    }
}
