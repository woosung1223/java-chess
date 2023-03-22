package domain.piece;

import domain.piece.move.Situation;
import domain.piece.move.Coordinate;

public abstract class Piece {

    private final Color color;

    public Piece(final Color color) {
        this.color = color;
    }


    public static Piece ofEmpty() {
        return new EmptyPiece();
    }

    public boolean isMovable(
            final Coordinate start,
            final Coordinate end,
            final Situation situation
    ) {
        validateIsNotSameColor(situation);
        return isMovableWhenMovingNotVariates(start, end);
    }

    private void validateIsNotSameColor(final Situation situation) {
        if (situation.meetColleague()) {
            throw new IllegalArgumentException("[ERROR] 같은 팀이 존재하는 곳으로 이동할 수 없습니다.");
        }
    }

    protected abstract boolean isMovableWhenMovingNotVariates(
            final Coordinate start,
            final Coordinate end
    );

    public boolean canJump() {
        return false;
    }

    public boolean isPawn() {
        return false;
    }

    public boolean isKing() {
        return false;
    }

    public boolean hasSameColorWith(final Color otherColor) {
        return color == otherColor;
    }

    public boolean hasSameColorWith(final Piece otherPiece) {
        return color == otherPiece.color;
    }

    public double getPoint() {
        return 0;
    }
}
