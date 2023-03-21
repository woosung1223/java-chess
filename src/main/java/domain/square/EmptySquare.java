package domain.square;

import domain.piece.Coordinate;
import domain.piece.Piece;

public final class EmptySquare extends Square implements Cloneable {

    @Override
    public boolean canReap() {
        return false;
    }

    @Override
    public boolean isNotSameCampWith(final Square other) {
        return false;
    }

    @Override
    public boolean isMovable(final Coordinate startCoordinate, final Coordinate endCoordinate) {
        return false;
    }

    @Override
    public boolean isExist() {
        return false;
    }

    @Override
    public Piece getPieceType() {
        return null;
    }

    @Override
    public Camp getCamp() {
        return null;
    }

    @Override
    public Object clone() {
        return super.clone();
    }
}
