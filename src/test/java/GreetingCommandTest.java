import org.junit.Test;
import rx.Observable;

import java.util.concurrent.Future;

import static org.junit.Assert.assertTrue;

/**
 * Created by Matthias Riedl (ianmcderp) on 02.04.2017.
 */
public class GreetingCommandTest {
    @Test
    public void testSynchronously() {
        // Given
        GreetingCommand greetingCommand = new GreetingCommand("Alice");

        // When
        String greeting = greetingCommand.execute();

        // Then
        assertTrue(greeting.contains("Alice"));
    }

    @Test
    public void testAsynchronously() throws Exception {
        // Given
        GreetingCommand greetingCommand = new GreetingCommand("Alice");

        // When
        Future<String> greetingFuture = greetingCommand.queue();

        // Then
        assertTrue(greetingFuture.get().contains("Alice"));
    }

    @Test
    public void testObserve() throws Exception {
        // Given
        GreetingCommand greetingCommand = new GreetingCommand("Alice");

        // When
        Observable greetingCommandObservable = greetingCommand.observe();

        // Then
        greetingCommandObservable.subscribe(
                onNext -> System.out.println("onNext: " + onNext),
                onError -> System.err.println("onError"),
                () -> System.out.println("onCompleted")
        );
    }
}
