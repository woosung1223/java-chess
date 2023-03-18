package domain.board;

import domain.piece.Bishop;
import domain.piece.King;
import domain.piece.Knight;
import domain.piece.Pawn;
import domain.piece.Queen;
import domain.piece.Rook;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ChessGameInitialImageTest {

    @ParameterizedTest(name = "{0}행 {1}열의 록을 가져온다")
    @CsvSource(value = {"0,0", "7,0", "0,7", "7,7"})
    void getPieceByCoordinateWhenRook(int row, int col) {
        assertThat(BoardInitialImage.getPieceByCoordinate(row, col).getPieceType())
                .isInstanceOf(Rook.class);
    }

    @ParameterizedTest(name = "{0}행 {1}열의 폰을 가져온다")
    @CsvSource(value = {"1,0", "1,1", "1,2", "1,3", "1,4", "1,5", "1,6", "1,7",
            "6,0", "6,1", "6,2", "6,3", "6,4", "6,5", "6,6", "6,7"})
    void getPieceByCoordinateWhenPawn(int row, int col) {
        assertThat(BoardInitialImage.getPieceByCoordinate(row, col).getPieceType())
                .isInstanceOf(Pawn.class);
    }

    @ParameterizedTest(name = "{0}행 {1}열의 나이트를 가져온다")
    @CsvSource(value = {"0,1", "0,6", "7,1", "7,6"})
    void getPieceByCoordinateWhenKnight(int row, int col) {
        assertThat(BoardInitialImage.getPieceByCoordinate(row, col).getPieceType())
                .isInstanceOf(Knight.class);
    }

    @ParameterizedTest(name = "{0}행 {1}열의 비숍을 가져온다")
    @CsvSource(value = {"0,2", "0,5", "7,2", "7,5"})
    void getPieceByCoordinateWhenBishop(int row, int col) {
        assertThat(BoardInitialImage.getPieceByCoordinate(row, col).getPieceType())
                .isInstanceOf(Bishop.class);
    }

    @ParameterizedTest(name = "{0}행 {1}열의 퀸을 가져온다")
    @CsvSource(value = {"0,3", "7,3"})
    void getPieceByCoordinateWhenQueen(int row, int col) {
        assertThat(BoardInitialImage.getPieceByCoordinate(row, col).getPieceType())
                .isInstanceOf(Queen.class);
    }

    @ParameterizedTest(name = "{0}행 {1}열의 킹을 가져온다")
    @CsvSource(value = {"0,4", "7,4"})
    void getPieceByCoordinateWhenKing(int row, int col) {
        assertThat(BoardInitialImage.getPieceByCoordinate(row, col).getPieceType())
                .isInstanceOf(King.class);
    }

    @ParameterizedTest(name = "{0}행 {1}열의 말이 없다")
    @CsvSource(value = {"2,0", "2,7", "5,0", "5,7"})
    void getPieceByCoordinateWhenNull(int row, int col) {
        assertThat(BoardInitialImage.getPieceByCoordinate(row,col).getPieceType())
                .isNull();
    }
}
