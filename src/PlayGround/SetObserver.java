package PlayGround;

@FunctionalInterface
public interface SetObserver<E> {
    //call this function when ObservableSet added element
    void added(ObservableSet<E> set, E element);
}
