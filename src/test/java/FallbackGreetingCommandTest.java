import org.junit.Test;
import rx.Observable;

import java.util.concurrent.Future;

import static org.junit.Assert.assertTrue;

/**
 * Created by Matthias Riedl (ianmcderp) on 02.04.2017.
 */
public class FallbackGreetingCommandTest {
    @Test
    public void testFallback() throws Exception {
        // Given
        FallbackGreetingCommand fallbackGreetingCommand = new FallbackGreetingCommand("Bob");

        // When
        Future<String> fallbackGreetingFuture = fallbackGreetingCommand.queue();

        // Then
        assertTrue(fallbackGreetingFuture.get().contains("failed"));
    }

    @Test
    public void testObserve() {
        // Given
        FallbackGreetingCommand fallbackGreetingCommand = new FallbackGreetingCommand("Alice");

        // When
        Observable fallbackGreetingCommandObservable = fallbackGreetingCommand.observe();

        // Then
        fallbackGreetingCommandObservable.subscribe(
                onNext -> System.out.println("onNext: " + onNext),
                onError -> System.err.println("onError"),
                () -> System.out.println("onCompleted")
        );
    }
}
