package domain.piece.nonsliding;

import domain.piece.move.Coordinate;
import domain.piece.move.Direction;
import domain.piece.move.Inclination;
import domain.piece.Color;
import domain.piece.Piece;

import java.util.List;

public final class Knight extends Piece {

    private static final Direction DIRECTION = new Direction(List.of(
            Inclination.ZERO_POINT_FIVE, Inclination.MINUS_ZERO_POINT_FIVE,
            Inclination.TWO, Inclination.MINUS_TWO
    ));

    private static final List<Coordinate> availableCoordinateDifferences = List.of(
            new Coordinate(1, 2),
            new Coordinate(2, 1)
    );

    private static final double POINT = 2.5;

    public Knight(final Color color) {
        super(color);
    }

    @Override
    public boolean isMovableWhenMovingNotVariates(
            final Coordinate start,
            final Coordinate end
    ) {
        Inclination inclination = Inclination.of(start.getInclination(end));
        Coordinate coordinateDifference = start.minusWithAbsoluteValue(end);

        return DIRECTION.canBeDirectionOf(inclination) &&
                availableCoordinateDifferences.contains(coordinateDifference);
    }

    @Override
    public boolean canJump() {
        return true;
    }

    @Override
    public double getPoint() {
        return POINT;
    }
}
