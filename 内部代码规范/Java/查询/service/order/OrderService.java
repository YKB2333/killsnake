package lol.redScarf.yjdf.openapi.service.app;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lol.redScarf.yjdf.openapi.domain.app.model.AppAccess;
import lol.redScarf.yjdf.openapi.infrastructure.exception.NetworkException;
import lol.redScarf.yjdf.openapi.infrastructure.util.encrypt.Base64ConvertUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

/**
 * <p>
 * 一件代发通行证关系表 服务实现类
 * </p>
 *
 * @author zhongshang
 * @since 2020-07-10
 */
@Service
@Slf4j
public class OrderService extends ServiceImpl<OrderMapper, Order> {

    @Autowride
    private OrderDetailsMapper orderDetailsMapper;

    public Order getDetailsById(Long id) {
        Order entity = super.getById(id);
        if (entity == null) {
            return null;
        }
        List<OrderDetails> details = orderDetailsMapper.list(new LambdaQueryWrraper<OrderDetails>().eq(OrderDetails::getOrderId, entity.getId()));
        entity.setDetails(details);
        return entity;
    }

}
