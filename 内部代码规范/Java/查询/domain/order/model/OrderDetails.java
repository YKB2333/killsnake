package lol.redScarf.yjdf.openapi.dto.api.app.query;

import java.math.BigDecimal;

public class OrderDetails {
    private Long id;
    private Long orderId;
    private Long goodsId;
    private String goodsName;
    private Integer number;
    private BigDecimal price;
    private BigDecimal amount;
}
