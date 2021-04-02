package lol.redScarf.yjdf.domain.model.account;

import lol.redScarf.yjdf.domain.enums.TransactionStatus;
import lol.redScarf.yjdf.domain.enums.TransactionType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * <p>
 *
 * </p>
 *
 * @author zhongshang
 * @since 2020-08-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TransactionVo implements Serializable {

    private String transactionSn;

    private Long customerId;

    private Long walletId;

    private TransactionType type;

    //添加枚举状态说明
    public String getTypeText() {
        return type.getText();
    }

    private TransactionStatus status;

    //添加枚举状态说明
    public String getStatusText() {
        return status.getText();
    }

    private BigDecimal beforeAmount;

    private BigDecimal changeAmount;

    private BigDecimal afterAmount;
}
