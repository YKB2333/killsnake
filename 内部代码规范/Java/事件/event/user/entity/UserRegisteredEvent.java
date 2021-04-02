import lombok.Getter;
import org.springframework.context.ApplicationEvent;

public class UserRegisteredEvent extends ApplicationEvent {

    @Getter
    private User user;

    /**
     * Create a new ApplicationEvent.
     */

    public UserRegisteredEvent(Object source, User user) {
        super(source);
    }
}
