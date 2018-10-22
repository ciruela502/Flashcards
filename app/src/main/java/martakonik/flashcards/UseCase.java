package martakonik.flashcards;

public interface UseCase<TParam, TResult> {
    TResult execute(TParam arg);
}
