import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * Created by Matthias Riedl (ianmcderp) on 02.04.2017.
 */
public class GreetingCommand extends HystrixCommand<String> {
    private final String name;

    public GreetingCommand(String name) {
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
        this.name = name;
    }

    @Override
    protected String run() throws Exception {
        return "Hello " + name + "!";
    }
}
