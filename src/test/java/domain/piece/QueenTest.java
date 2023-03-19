package domain.piece;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class QueenTest {

    @ParameterizedTest(name = "우측 상단으로 {0}칸 이동할 수 있다")
    @ValueSource(ints = {1, 3, 7})
    void isReachableByRuleRightUp(int distance) {
        Coordinate startCoordinate = new Coordinate(0, 0);
        Coordinate endCoordinate = new Coordinate(distance, distance);
        Queen queen = new Queen();

        assertThat(queen.isReachableByRule(startCoordinate, endCoordinate)).isTrue();
    }

    @ParameterizedTest(name = "좌측 상단으로 {0}칸 이동할 수 있다")
    @ValueSource(ints = {1, 3, 7})
    void isReachableByRuleLeftUp(int distance) {
        Coordinate startCoordinate = new Coordinate(7, 0);
        Coordinate endCoordinate = new Coordinate(7 - distance, distance);
        Queen queen = new Queen();

        assertThat(queen.isReachableByRule(startCoordinate, endCoordinate)).isTrue();
    }

    @ParameterizedTest(name = "좌측 하단으로 {0}칸 이동할 수 있다")
    @ValueSource(ints = {1, 3, 7})
    void isReachableByRuleLeftBottom(int distance) {
        Coordinate startCoordinate = new Coordinate(7, 7);
        Coordinate endCoordinate = new Coordinate(7 - distance, 7 - distance);
        Queen queen = new Queen();

        assertThat(queen.isReachableByRule(startCoordinate, endCoordinate)).isTrue();
    }

    @ParameterizedTest(name = "우측 하단으로 {0}칸 이동할 수 있다")
    @ValueSource(ints = {1, 3, 7})
    void isReachableByRuleRightBottom(int distance) {
        Coordinate startCoordinate = new Coordinate(7, 0);
        Coordinate endCoordinate = new Coordinate(7 - distance, distance);
        Queen queen = new Queen();

        assertThat(queen.isReachableByRule(startCoordinate, endCoordinate)).isTrue();
    }

    @ParameterizedTest(name = "룩은 왼쪽으로 {0}칸 이동할 수 있다")
    @ValueSource(ints = {1, 3, 7})
    void isReachableByRuleLeft(int distance) {
        Coordinate startCoordinate = new Coordinate(0, 7);
        Coordinate endCoordinate = new Coordinate(0, 7 - distance);
        Queen queen = new Queen();

        assertThat(queen.isReachableByRule(startCoordinate, endCoordinate)).isTrue();
    }

    @ParameterizedTest(name = "룩은 오른쪽으로 {0}칸 이동할 수 있다")
    @ValueSource(ints = {1, 3, 7})
    void isReachableByRuleRight(int distance) {
        Coordinate startCoordinate = new Coordinate(0, 0);
        Coordinate endCoordinate = new Coordinate(0, distance);
        Queen queen = new Queen();

        assertThat(queen.isReachableByRule(startCoordinate, endCoordinate)).isTrue();
    }

    @ParameterizedTest(name = "위쪽으로 {0}칸 이동할 수 있다")
    @ValueSource(ints = {1, 3, 7})
    void isReachableByRuleUp(int distance) {
        Coordinate startCoordinate = new Coordinate(0, 0);
        Coordinate endCoordinate = new Coordinate(distance, 0);
        Queen queen = new Queen();

        assertThat(queen.isReachableByRule(startCoordinate, endCoordinate)).isTrue();
    }

    @ParameterizedTest(name = "아래쪽으로 {0}칸 이동할 수 있다")
    @ValueSource(ints = {1, 3, 7})
    void isReachableByRuleDown(int distance) {
        Coordinate startCoordinate = new Coordinate(7, 0);
        Coordinate endCoordinate = new Coordinate(7 - distance, 0);
        Queen queen = new Queen();

        assertThat(queen.isReachableByRule(startCoordinate, endCoordinate)).isTrue();
    }
}
