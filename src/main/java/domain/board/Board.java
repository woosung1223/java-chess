package domain.board;

import domain.piece.move.Coordinate;
import domain.piece.pawn.BlackInitPawn;
import domain.piece.pawn.WhiteInitPawn;
import domain.square.Color;
import domain.square.Square;

import java.util.HashMap;
import java.util.Map;

public final class Board {

    private static final int KING_COUNT = 2;

    private static final int RANK_SIZE = 8;
    private static final int FILE_SIZE = 8;

    private final Map<Coordinate, Square> squareLocations;

    public Board() {
        this.squareLocations = fillBoard();
    }

    private Map<Coordinate, Square> fillBoard() {
        Map<Coordinate, Square> board = new HashMap<>();
        for (int rank = 0; rank < RANK_SIZE; rank++) {
            board.putAll(fillSquaresForOneRank(rank));
        }
        return board;
    }

    private Map<Coordinate, Square> fillSquaresForOneRank(final int rankNumber) {
        Map<Coordinate, Square> rank = new HashMap<>();
        for (int fileNumber = 0; fileNumber < FILE_SIZE; fileNumber++) {
            rank.put(
                    new Coordinate(rankNumber, fileNumber),
                    BoardInitialImage.getSquareByCoordinate(rankNumber, fileNumber)
            );
        }
        return rank;
    }

    public Square findSquare(final Coordinate target) {
        return squareLocations.get(target);
    }

    public void replaceSquare(final Coordinate target, final Square square) {
        if (square.getPiece().isPawn()) {
            replaceSquareIfIsPawn(target, square);
        }
        squareLocations.put(target, square);
    }

    private void replaceSquareIfIsPawn(final Coordinate target, final Square square) {
        if (square.getColor() == Color.BLACK) {
            squareLocations.put(target, new Square(new WhiteInitPawn(), Color.WHITE));
            return;
        }
        squareLocations.put(target, new Square(new BlackInitPawn(), Color.BLACK));
    }

    public void replaceWithEmptySquare(final Coordinate target) {
        squareLocations.put(target, Square.ofEmptyPiece());
    }

    public boolean isMovable(final Coordinate start, final Coordinate end) {
        validateOverBoardSize(start, end);
        return squareLocations.get(start).isPieceMovable(start, end);
    }

    private void validateOverBoardSize(final Coordinate start, final Coordinate end) {
        if (squareLocations.containsKey(start) && squareLocations.containsKey(end)) {
            return;
        }
        throw new IllegalArgumentException("[ERROR] 보드 좌표 범위를 벗어났습니다.");
    }

    public boolean isSquareEmptyAt(final Coordinate target) {
        return squareLocations.get(target)
                .getColor() == Color.NEUTRAL;
    }

    public Map<Coordinate, Square> getSquareLocations() {
        return squareLocations;
    }

    public boolean isSameColor(final Coordinate start, final Coordinate end) {
        Square startSquare = findSquare(start);
        Square endSquare = findSquare(end);

        return startSquare.hasPieceNotSameColorWith(endSquare);
    }

    public boolean allKingAlive() {
        return squareLocations.values().stream()
                .filter(Square::hasKing)
                .count() == KING_COUNT;
    }
}
