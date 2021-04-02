package lol.redScarf.yjdf.openapi.dto.api.app.query;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import lombok.Data;

import java.math.BigDecimal;

@Data
@TableName(autoResultMap = true)//开启查询时的关系映射
public class Order {
    private Long id;
    private BigDecimal goodsAmount;
    private BigDecimal logistcsAmount;
    private BigDecimal totalAmount;
    //收货地址值对象
    @TableField(typeHandler = JacksonTypeHandler.class)
    private Address address;
    //收货地址值对象
    @TableField(exist = false)
    private List<OrderDetails> detials;
    //收货地址值对象
    @TableField(exist = false)
    private List<Logistics> logistics;
}
