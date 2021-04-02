package com.gf.job.dto.report;

import com.gf.order.bo.orderdetails.OrderDetails;
import com.gf.order.bo.orderinfo.OrderInfo;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
public class ExampleVo implements Serializable {

    private static final long serialVersionUID = 1L;
    //订单主体
    private Date date;
    private Long orderId;
    private Long orderNo;
    private Integer orderType;
    private Integer status;
    private Integer payChannel;
    private Date payTime;
    private Date finishedTime;
    private Integer orderPayableTotal;
    private Integer orderAmtTotal;
    private Integer logisticsFee;
    private Integer useIntegral;
    private String consignee;
    private String mobile;
    private String country;
    private String province;
    private String city;
    private String district;
    private String address;
    //订单明细
    private String goodsName;
    private String barCode;
    private Integer quantity;
    private Integer price;
    private String actvityName;
    private Integer activityPrice;
    private Integer perUseIntegral;
    private Integer perDeductionAmount;
    //用户信息
    private Long userId;
    private String userName;

    //静态工厂
    public static ExampleVo fromEntity(Example entity) {
        if (entity == null) {
            return null;
        }
        ExampleVo vo = new ExampleVo();
        BeanUtils.copyProperties(entity, vo);
        return vo;
    }

    //Builder模式
    public static ExampleVo.Builder builder() {
        return new ExampleVo.Builder();
    }

    public static class Builder {
        @Getter
        private Long orderId;
        private ExampleVo vo;

        public Builder() {
            this.vo = new ExampleVo();
        }

        public Builder buildOrderInfo(OrderInfo orderInfo) {
            if (orderInfo != null) {
                this.orderId = orderInfo.getId();
                vo.setDate(orderInfo.getCreateTime());
                vo.setOrderId(orderInfo.getId());
                vo.setOrderNo(orderInfo.getOrderNo());
                vo.setOrderType(orderInfo.getOrderType());
                vo.setStatus(orderInfo.getStatus());
                vo.setPayChannel(orderInfo.getPayChannel());
                vo.setPayTime(orderInfo.getPayTime());
                vo.setFinishedTime(orderInfo.getFinishedTime());
                vo.setOrderPayableTotal(orderInfo.getOrderPayableTotal());
                vo.setOrderAmtTotal(orderInfo.getOrderAmtTotal());
                vo.setLogisticsFee(orderInfo.getLogisticsFee());
                vo.setUseIntegral(orderInfo.getUseIntegral());
                vo.setConsignee(orderInfo.getConsignee());
                vo.setMobile(orderInfo.getMobile());
                vo.setCountry(orderInfo.getCountry());
                vo.setProvince(orderInfo.getProvince());
                vo.setCity(orderInfo.getCity());
                vo.setDistrict(orderInfo.getDistrict());
                vo.setAddress(orderInfo.getAddress());
            }
            return this;
        }

        public Builder buildOrderDetails(OrderDetails orderDetails) {
            if (orderDetails != null) {
                vo.setGoodsName(orderDetails.getSkuName() + orderDetails.getOwnSpec());
                vo.setBarCode(orderDetails.getBarCode());
                vo.setQuantity(orderDetails.getQuantity());
                vo.setPrice(orderDetails.getPrice());
                vo.setActivityPrice(orderDetails.getActivityPrice());
                vo.setActvityName(orderDetails.getActvityName());
                vo.setPerUseIntegral(orderDetails.getPerUseIntegral());
                vo.setPerDeductionAmount(orderDetails.getPerDeductionAmount());
            }
            return this;
        }

        public Builder buildOrderDetails(User user) {
            if (user != null) {
                vo.setUserId(user.getId());
                vo.setUserName(user.getName());
            }
            return this;
        }

        public ExampleVo build() {
            return this.vo;
        }
    }
}
