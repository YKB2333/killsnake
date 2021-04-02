package lol.redScarf.yjdf.openapi.facade.openapi.order;


import lol.redScarf.yjdf.openapi.dto.openapi.order.query.OrderQo;
import lol.redScarf.yjdf.openapi.dto.openapi.order.query.OrderVo;
import lol.redScarf.yjdf.openapi.infrastructure.web.PageResponse;
import lol.redScarf.yjdf.openapi.infrastructure.web.RestResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 一件代发通行证关系表 前端控制器
 * </p>
 *
 * @author zhongshang
 * @since 2020-07-10
 */
@RestController
@RequestMapping("/api/order")
public class OrderApiController {

    @Autowired
    OrderBiz orderBiz;

    @PostMapping("/page")
    public RestResponseBody<PageResponse<OrderVo>> page(@RequestBody OrderQo qo) {
        IPage<Order> ipage = orderBiz.page(qo);
        PageResponse<OrderVo> page =
                PageResponse.fromIPage(ipage)
                        .convert(entity -> OrderVo.fromEntity(entity));
        return RestResponseBody.builder().result(page).build();
    }

    @GetMapping("/details/{id}")
    public RestResponseBody<OrderVo> details(@PathVariable Long id) {
        Order entity = orderBiz.getById(id);
        OrderVo vo = OrderVo.fromEntity(entity);
        return RestResponseBody.builder().result(vo).build();
    }

}
