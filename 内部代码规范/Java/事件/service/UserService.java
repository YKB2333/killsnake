import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zhongshang
 * @since 2020-07-13
 */
@Service
public class UserService extends ServiceImpl<UserMapper, User> {

    @Autowired
    private ApplicationContext applicationContext;

    public User register(UserRegisterDto dto) {
        User user = new User();
        user.setName(dto.getName);
        user.setGender(dto.getGender);
        if (!save(user)) {
            return null;
        }
        applicationContext.publishEvent(new UserRegisteredEvent(this, user));
        return user;
    }

}
