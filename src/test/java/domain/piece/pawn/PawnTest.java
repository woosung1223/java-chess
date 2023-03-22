package domain.piece.pawn;

import domain.piece.Piece;
import domain.piece.move.Situation;
import domain.piece.move.Coordinate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PawnTest {

    @Test
    @DisplayName("폰은 기본 상태를 가진다")
    void propertyTest() {
        Piece whitePawn = new WhitePawn();
        Piece blackPawn = new BlackPawn();

        assertThat(whitePawn.canJump()).isFalse();
        assertThat(whitePawn.isPawn()).isTrue();

        assertThat(blackPawn.canJump()).isFalse();
        assertThat(blackPawn.isPawn()).isTrue();
    }

    @Test
    @DisplayName("화이트 폰은 위로 한 칸 이동할 수 있다")
    void isReachableByRuleUp() {
        Coordinate startCoordinate = new Coordinate(1, 0);
        Coordinate endCoordinate = new Coordinate(2, 0);
        Pawn pawn = new WhitePawn();

        assertThat(pawn.isReachableByRule(startCoordinate, endCoordinate, Situation.NEUTRAL)).isTrue();
    }

    @Test
    @DisplayName("화이트 폰은 위로 두 칸 이동할 수 있다")
    void isReachableByRuleUpTwo() {
        Coordinate startCoordinate = new Coordinate(1, 0);
        Coordinate endCoordinate = new Coordinate(3, 0);
        Pawn pawn = new WhiteInitPawn();

        assertThat(pawn.isReachableByRule(startCoordinate, endCoordinate, Situation.NEUTRAL)).isTrue();
    }

    @Test
    @DisplayName("화이트 폰은 위로 세 칸 이동할 수 없다")
    void isReachableByRuleUpThree() {
        Coordinate startCoordinate = new Coordinate(1, 0);
        Coordinate endCoordinate = new Coordinate(4, 0);
        Pawn pawn = new WhitePawn();

        assertThat(pawn.isReachableByRule(startCoordinate, endCoordinate, Situation.NEUTRAL)).isFalse();
        assertThat(pawn.isReachableByRule(startCoordinate, endCoordinate, Situation.NEUTRAL)).isFalse();

    }

    @Test
    @DisplayName("화이트 폰은 아래로 한 칸 이동할 수 없다")
    void isReachableByRuleCantDown() {
        Coordinate startCoordinate = new Coordinate(2, 0);
        Coordinate endCoordinate = new Coordinate(1, 0);
        Pawn pawn = new WhitePawn();

        assertThat(pawn.isReachableByRule(startCoordinate, endCoordinate, Situation.NEUTRAL)).isFalse();
    }

    @Test
    @DisplayName("블랙 폰은 아래로 한 칸 이동할 수 있다")
    void isReachableByRuleDown() {
        Coordinate startCoordinate = new Coordinate(6, 0);
        Coordinate endCoordinate = new Coordinate(5, 0);
        Pawn pawn = new BlackPawn();

        assertThat(pawn.isReachableByRule(startCoordinate, endCoordinate, Situation.NEUTRAL)).isTrue();
    }

    @Test
    @DisplayName("블랙 폰은 아래로 두 칸 이동할 수 있다")
    void isReachableByRuleDownTwo() {
        Coordinate startCoordinate = new Coordinate(6, 0);
        Coordinate endCoordinate = new Coordinate(4, 0);
        Pawn pawn = new BlackInitPawn();

        assertThat(pawn.isReachableByRule(startCoordinate, endCoordinate, Situation.NEUTRAL)).isTrue();
    }

    @Test
    @DisplayName("블랙 폰은 아래로 세 칸 이동할 수 없다")
    void isReachableByRuleDownThree() {
        Coordinate startCoordinate = new Coordinate(6, 0);
        Coordinate endCoordinate = new Coordinate(3, 0);
        Pawn pawn = new BlackPawn();

        assertThat(pawn.isReachableByRule(startCoordinate, endCoordinate, Situation.NEUTRAL)).isFalse();
        assertThat(pawn.isReachableByRule(startCoordinate, endCoordinate, Situation.NEUTRAL)).isFalse();
    }

    @Test
    @DisplayName("블랙 폰은 위로 한 칸 이동할 수 없다")
    void isReachableByRuleCantUp() {
        Coordinate startCoordinate = new Coordinate(6, 0);
        Coordinate endCoordinate = new Coordinate(7, 0);
        Pawn pawn = new BlackPawn();

        assertThat(pawn.isReachableByRule(startCoordinate, endCoordinate, Situation.NEUTRAL)).isFalse();
    }

    @Test
    @DisplayName("블랙 폰은 가로로 이동할 수 없다")
    void isReachableByRuleCantStraight() {
        Coordinate startCoordinate = new Coordinate(6, 0);
        Coordinate endCoordinate = new Coordinate(6, 1);
        Pawn blackPawn = new BlackPawn();
        Pawn whitePawn = new WhitePawn();

        assertThat(blackPawn.isReachableByRule(startCoordinate, endCoordinate, Situation.NEUTRAL)).isFalse();
        assertThat(whitePawn.isReachableByRule(startCoordinate, endCoordinate, Situation.NEUTRAL)).isFalse();
    }
}
