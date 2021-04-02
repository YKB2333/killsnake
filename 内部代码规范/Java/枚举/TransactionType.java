package lol.redScarf.yjdf.domain.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TransactionType implements IEnum<Integer> {
    /**
     * 接口层入参为枚举类型时，接收参数为 枚举名称：RECHARGE_INNER 或者 枚举索引：0（这里的索引是指枚举的顺序,不是value的值）
     * <p>
     * 当顺序发生变化是索引也会变化
     * <p>
     * 例如：当枚举内容为以下顺序是，SALES_OUT的索引为：0，RECHARGE_INNER的索引为：1
     * SALES_OUT(1, "销售出账"),
     * RECHARGE_INNER(0, "充值入账"),
     */
    RECHARGE_INNER(0, "充值入账"),
    SALES_OUT(1, "销售出账"),
    ;
    private Integer value;
    private String text;
}
