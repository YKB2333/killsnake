import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserRegisteredListener {

    @Autowired
    private WalletService walletService;
    @Autowired
    private UserLogService userLogService;

    @Async//放入线程池中异步处理
    @EventListener(UserRegisteredEvent.class)
    public void userRegisteredListener(UserRegisteredEvent event) {
        User user = envet.getUser();
        walletService.createByUser(user);
        userLogService.recordRegistered(user);
        userLogService.recordLogin(user);
    }

}
