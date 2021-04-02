package lol.redScarf.yjdf.openapi.facade.api.app;


import com.baomidou.mybatisplus.core.metadata.IPage;
import lol.redScarf.yjdf.openapi.biz.api.app.AppApiBiz;
import lol.redScarf.yjdf.openapi.domain.app.model.AppAccess;
import lol.redScarf.yjdf.openapi.dto.api.app.create.AppAccessApiDto;
import lol.redScarf.yjdf.openapi.dto.api.app.create.AppLimitApiDto;
import lol.redScarf.yjdf.openapi.dto.api.app.query.AppAccessApiQo;
import lol.redScarf.yjdf.openapi.dto.api.app.query.AppAccessApiVo;
import lol.redScarf.yjdf.openapi.infrastructure.web.PageResponse;
import lol.redScarf.yjdf.openapi.infrastructure.web.RestResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 一件代发通行证关系表 前端控制器
 * </p>
 *
 * @author zhongshang
 * @since 2020-07-10
 */
@RestController
@RequestMapping("/api/app")
public class AppApiController {

    @Autowired
    private AppApiBiz appApiBiz;

    @PostMapping("/register")
    public RestResponseBody<AppAccess> registerAppAccess(@RequestBody AppAccessApiDto dto) throws UnsupportedEncodingException {
        AppAccess entity = appApiBiz.registerAppAccess(dto);
        return RestResponseBody.builder().result(entity).build();
    }

    @PatchMapping("/refresh/{id}")
    public RestResponseBody<AppAccess> refreshAppSecret(@PathVariable Long id) throws UnsupportedEncodingException {
        AppAccess entity = appApiBiz.refreshAppSecret(id);
        return RestResponseBody.builder().result(entity).build();
    }

    @PatchMapping("/enable/{id}")
    public RestResponseBody<String> enable(@PathVariable Long id) {
        appApiBiz.enable(id);
        return RestResponseBody.builder().build();
    }

    @PatchMapping("/disable/{id}")
    public RestResponseBody<String> disable(@PathVariable Long id) {
        appApiBiz.disable(id);
        return RestResponseBody.builder().build();
    }

    @PostMapping("/page")
    public RestResponseBody<PageResponse<AppAccessApiVo>> appPage(@RequestBody AppAccessApiQo qo) {
        IPage<AppAccess> ipage = appApiBiz.page(qo);

        PageResponse page = PageResponse.fromIPage(ipage)
                .convert(entity -> AppAccessApiVo.fromEntity(entity));
        return RestResponseBody.builder().result(page).build();
    }

    @GetMapping("/details/{id}")
    public RestResponseBody<AppAccessApiVo> appDetails(@PathVariable Long id) {
        AppAccess entity = appApiBiz.details(id);
        AppAccessApiVo vo = AppAccessApiVo.fromEntity(entity);
        return RestResponseBody.builder().result(vo).build();
    }

    @GetMapping("/details/customer/{customerId}")
    public RestResponseBody<List<AppAccessApiVo>> appDetailsByCustomer(@PathVariable Long customerId) {
        List<AppAccess> list = appApiBiz.detailsByCustomer(customerId);
        List<AppAccessApiVo> vos = list.stream().map(entity -> AppAccessApiVo.fromEntity(entity)).collect(Collectors.toList());
        return RestResponseBody.builder().result(vos).build();
    }

    @PostMapping("/limit/save")
    public RestResponseBody saveAppLimit(@RequestBody AppLimitApiDto dto) {
        appApiBiz.saveAppLimit(dto);
        return RestResponseBody.builder().build();
    }
}
