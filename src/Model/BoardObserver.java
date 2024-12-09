package Model;

public interface BoardObserver {
    void updatePushRow(int index, Direction direction);
    void updatePushColumn(int index, Direction direction);
}
