package lol.redScarf.yjdf.openapi.biz.api.app;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class OrderApiBiz {

    @Autowired
    private OrderService orderService;
    @Autowired
    private LogisticsService logisticsService;

    @Transactional
    public IPage<Order> page() {
        IPage<Order> page = orderService.page();
        return page;
    }

    public Order getById(Long id) {
        Order order = orderService.getDetailsById(id);
        if (entity == null) {
            return null;
        }
        List<Logistics> logistics = logisticsService.list(new LambdaQueryWrraper<Logistics>().eq(Logistics::getOrderId, order.getId()));
        entity.setLogistics(logistics);
        return entity;
    }

}
