import org.junit.Test;
import rx.Observable;

/**
 * Created by Matthias Riedl (ianmcderp) on 02.04.2017.
 */
public class ErroneousGreetingCommandTest {
    @Test
    public void testObserve() {
        // Given
        ErroneousGreetingCommand erroneousGreetingCommand = new ErroneousGreetingCommand("Alice");

        // When
        Observable erroneousGreetingCommandObservable = erroneousGreetingCommand.observe();

        // Then
        erroneousGreetingCommandObservable.subscribe(
                onNext -> System.out.println("onNext: " + onNext),
                onError -> System.err.println("onError: " + ((Exception) onError).getMessage()),
                () -> System.out.println("onCompleted")
        );
    }
}
