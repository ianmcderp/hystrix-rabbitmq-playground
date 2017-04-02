import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * Created by Matthias Riedl (ianmcderp) on 02.04.2017.
 */
public class FallbackGreetingCommand extends HystrixCommand<String> {
    private final String name;

    protected FallbackGreetingCommand(String name) {
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
        this.name = name;
    }

    @Override
    protected String run() throws Exception {
        throw new RuntimeException();
    }

    @Override
    protected String getFallback() {
        return "Hello failed " + name + "!";
    }
}
