package lol.redScarf.yjdf.openapi.infrastructure.web;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.servlet.http.HttpServletResponse;

@Getter
@AllArgsConstructor
public enum ResultCode {
    SUCCESS(HttpServletResponse.SC_OK, "Operation is Successful"),

    FAILURE(HttpServletResponse.SC_BAD_REQUEST, "Biz Exception"),

    UN_AUTHORIZED(HttpServletResponse.SC_UNAUTHORIZED, "Request Unauthorized"),

    NOT_FOUND(HttpServletResponse.SC_NOT_FOUND, "404 Not Found"),

    MSG_NOT_READABLE(HttpServletResponse.SC_BAD_REQUEST, "Message Can't be Read"),

    METHOD_NOT_SUPPORTED(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "Method Not Supported"),

    MEDIA_TYPE_NOT_SUPPORTED(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE, "Media Type Not Supported"),

    REQ_REJECT(HttpServletResponse.SC_FORBIDDEN, "Request Rejected"),

    INTERNAL_SERVER_ERROR(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Internal Server Error"),

    PARAM_MISS(HttpServletResponse.SC_BAD_REQUEST, "Missing Required Parameter"),

    PARAM_TYPE_ERROR(HttpServletResponse.SC_BAD_REQUEST, "Parameter Type Mismatch"),

    PARAM_BIND_ERROR(HttpServletResponse.SC_BAD_REQUEST, "Parameter Binding Error"),

    PARAM_VALID_ERROR(HttpServletResponse.SC_BAD_REQUEST, "Parameter Validation Error"),

    //40000 参数校验异常
    PARAMENT_ERROR(40000, "参数错误，请开发者对照文档进行接口开发。"),
    PAGE_INDEX_PARAM_MIN_ERROR(40001, "Page index太小啦，请开发者对照开放文档检查参数的正确性。"),
    PAGE_INDEX_PARAM_MAX_ERROR(40002, "Page index太大啦，请开发者对照开放文档检查参数的正确性。"),
    PAGE_SIZE_PARAM_MIN_ERROR(40003, "Page size太小啦，请开发者对照开放文档检查参数的正确性。"),
    PAGE_SIZE_PARAM_MAX_ERROR(40004, "Page size太大啦，请开发者对照开放文档检查参数的正确性。"),
    SIGN_PARAM_NULL_ERROR(40005, "校验签名不能为空！"),
    SIGN_PARAM_VALID_ERROR(40006, "签名校验失败，请开发者对照开放文档检查签名的正确性或联系平台管理员处理！"),
    TIMESTAMP_PARAM_NULL_ERROR(40007, "请求时间戳不能为空！"),
    TIMESTAMP_PARAM_FORMAT_ERROR(40008, "请求时间格式错误，请开发者传入毫秒级的时间戳！"),
    DATA_PARAM_NULL_ERROR(40009, "业务请求参数不能为空！"),
    SIGN_PARAM_EXPIRE_ERROR(400010, "校验签名已经过期了！"),
    UPDATE_START_TIMESTAMP_PARAM_NULL_ERROR(40011, "更新开始时间戳不能为空！"),
    UPDATE_END_TIMESTAMP_PARAM_NULL_ERROR(40012, "更新结束时间戳不能为空！"),
    //41000 应用通行证
    CUSTOMER_ID_PARAM_NULL_ERROR(41001, "客户ID不能为空！"),
    APP_KEY_PARAM_NULL_ERROR(41002, "AppKey不能为空！"),
    APP_SECRET_PARAM_NULL_ERROR(41003, "AppSecret不能为空！"),
    APP_NAME_PARAM_NULL_ERROR(41004, "AppName不能为空！"),
    ACCESS_ID_PARAM_NULL_ERROR(41005, "通行证ID不能为空！"),
    CALL_TYPE_PARAM_NULL_ERROR(41006, "回调接口类型不能为空！"),
    CALL_URL_PARAM_NULL_ERROR(41007, "回调接口类型不能为空！"),
    APP_LIMIT_ID_PARAM_NULL_ERROR(41008, "应用接口限流ID不能为空！"),
    APP_LIMIT_MINUTES_PARAM_VALID_ERROR(41009, "应用接口每分钟限流量不能为空或小于0！"),
    APP_LIMIT_HOURS_PARAM_VALID_ERROR(41010, "应用接口每小时限流量不能为空或小于0！"),
    //42000 订单
    PLAT_ORDER_SN_PARAM_NULL_ERROR(42001, "平台订单号不能为空！"),
    DELI_NAME_PARAM_NULL_ERROR(42002, "收货人姓名不能为空！"),
    DELI_MOBILE_PARAM_NULL_ERROR(42003, "收货人手机不能为空！"),
    DELI_PROVINCE_PARAM_NULL_ERROR(42004, "收货地址-省不能为空！"),
    DELI_CITY_PARAM_NULL_ERROR(42005, "收货地址-市不能为空！"),
    DELI_DISTRICT_PARAM_NULL_ERROR(42006, "收货地址-区不能为空！"),
    DELI_ADDRESS_PARAM_NULL_ERROR(42007, "收货地址-详细不能为空！"),
    ORDER_TIME_PARAM_NULL_ERROR(42008, "下单时间（毫秒级时间戳）不能为空！"),
    ORDER_TIME_PARAM_FORMAT_ERROR(42009, "下单时间格式错误，请开发者传入毫秒级的时间戳！"),
    SPU_ID_PARAM_NULL_ERROR(42010, "商品SPUID不能为空！"),
    SKU_ID_PARAM_NULL_ERROR(42011, "商品SKUID不能为空！"),
    CUSTOMER_BAR_CODE_PARAM_NULL_ERROR(42012, "平台商品编码不能为空！"),
    ORDER_ITEM_NUM_PARAM_NULL_ERROR(42013, "订单明细商品数量不能为空！"),
    ORDER_SN_PARAM_NULL_ERROR(42014, "一件代发平台订单号不能为空！"),
    ORDER_STATUS_PARAM_NULL_ERROR(42015, "订单状态为空或订单状态不在枚举范围内！"),
    ORDER_ITEMS_PARAM_EMPTY_ERROR(42016, "订单明细不能为空！"),
    ORDER_CANCEL_REASON_PARAM_NULL_ERROR(42017, "订单取消原因不能为空！"),
    ORDER_PACKAGES_PARAM_EMPTY_ERROR(42018, "订单包裹不能为空！"),
    LOGISTICS_SN_PARAM_NULL_ERROR(42019, "一件代发平台订单号不能为空！"),
    LOGISTICS_COMPANY_NAME_PARAM_NULL_ERROR(42020, "一件代发平台订单号不能为空！"),
    PACKAGE_QUANTITY_PARAM_NULL_ERROR(42021, "一件代发平台订单号不能为空！"),
    DELIVERY_TIMESTAMP_PARAM_EMPTY_ERROR(42022, "一件代发平台订单号不能为空！"),
    ORDER_CANCELLED_PARAM_NULL_ERROR(42023, "订单取消结果不能为空！"),

    //43000 商品
    SPU_LIST_PARAM_EMPTY_ERROR(43001, "商品列表不能为空！"),

    //60000 业务数据校验异常
    DATA_VALID_ERROR(60000, "业务数据校验异常，请开发者检查业务数据的准确性或联系平台管理员处理。"),
    //61000 应用通行证
    ACCESS_EXISTS_VALID_ERROR(61001, "该客户已经创建过通行证了！"),
    ACCESS_NOT_EXISTS_VALID_ERROR(61002, "该应用通行证不存在！"),
    APP_KEY_VALID_ERROR(61003, "不合法的 AppKey，请开发者检查 AppKey 的正确性，避免异常字符，注意大小写！"),
    APP_SECRET_VALID_ERROR(61004, "AppSecret 错误，请开发者确认 AppSecret 的正确性！"),
    APP_ENABLED_VALID_ERROR(61005, "App已被禁用，请开发者联系平台管理员！"),
    APP_LIMIT_EXISTS_VALID_ERROR(61006, "该应用流量限制不存在！"),
    CUSTOMER_ENABLE_VALID_ERROR(61007, "客户关系未启用，请联系平台管理员处理！"),
    APP_CALL_NOT_EXISTS_VALID_ERROR(61008, "该回调类型不存在！"),
    //62000 订单
    GOODS_STOCK_EMPTY_ERROR(62001, "商品库存不足！"),
    GOODS_OUT_SALES_ERROR(62002, "商品已下架！"),

    //80000 网络异常
    NETWORK_ERROR(80000, "系统繁忙，此时请开发者稍候再试"),
    REPEAT_SUBMITION_ERROR(80001, "访问太快了，此时请开发者稍候再试"),
    APP_MINUTES_LIMIT_ERROR(80002, "一分钟内访问次数已达上限！请开发者对照开发者文档的接口访问次数调整访问频率！或联系平台管理员调整访问频率！"),
    APP_HOURS_LIMIT_ERROR(80003, "一小时内访问次数已达上限！请开发者对照开发者文档的接口访问次数调整访问频率！或联系平台管理员调整访问频率！"),

    //90000 未知异常
    UNKOWN_LIMIT_TYPE_ERROR(90001, "出现未知限流类型异常。"),
    UNKOWN_ERROR(99999, "发生未知错误，如有需要请联系平台管理员处理。");

    final int code;

    final String msg;
}
