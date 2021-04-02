package lol.redScarf.yjdf.openapi.biz.api.app;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lol.redScarf.yjdf.openapi.domain.app.model.AppAccess;
import lol.redScarf.yjdf.openapi.domain.app.model.AppCall;
import lol.redScarf.yjdf.openapi.domain.app.model.AppLimit;
import lol.redScarf.yjdf.openapi.dto.api.app.create.AppAccessApiDto;
import lol.redScarf.yjdf.openapi.dto.api.app.create.AppLimitApiDto;
import lol.redScarf.yjdf.openapi.dto.api.app.query.AppAccessApiQo;
import lol.redScarf.yjdf.openapi.infrastructure.exception.ValidationException;
import lol.redScarf.yjdf.openapi.infrastructure.web.ResultCode;
import lol.redScarf.yjdf.openapi.service.app.AppAccessService;
import lol.redScarf.yjdf.openapi.service.app.AppCallService;
import lol.redScarf.yjdf.openapi.service.app.AppLimitService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.util.List;

@Service
@Slf4j
public class AppApiBiz {

    @Autowired
    private AppAccessService appAccessService;
    @Autowired
    private AppCallService appCallService;
    @Autowired
    private AppLimitService appLimitService;

    @Transactional
    public AppAccess registerAppAccess(AppAccessApiDto dto) throws UnsupportedEncodingException {
        boolean exists = appAccessService.count(new LambdaQueryWrapper<AppAccess>().eq(AppAccess::getCustomerId, dto.getCustomerId())) > 0;
        if (exists) {
            throw new ValidationException(ResultCode.ACCESS_EXISTS_VALID_ERROR);
        }
        AppAccess entity = appAccessService.rigister(dto.getCustomerId(), dto.getAppName());
        appLimitService.initialization(entity);
        return entity;
    }

    public AppAccess refreshAppSecret(Long id) throws UnsupportedEncodingException {
        AppAccess entity = appAccessService.getById(id);
        if (entity == null) {
            throw new ValidationException(ResultCode.ACCESS_NOT_EXISTS_VALID_ERROR);
        }
        appAccessService.refreshAppSecret(entity);
        return entity;
    }

    public void enable(Long id) {
        AppAccess entity = appAccessService.getById(id);
        if (entity == null) {
            throw new ValidationException(ResultCode.ACCESS_NOT_EXISTS_VALID_ERROR);
        }
        appAccessService.enable(entity);
    }

    public void disable(Long id) {
        AppAccess entity = appAccessService.getById(id);
        if (entity == null) {
            throw new ValidationException(ResultCode.ACCESS_NOT_EXISTS_VALID_ERROR);
        }
        appAccessService.disable(entity);
    }

    public IPage<AppAccess> page(AppAccessApiQo qo) {
        LambdaQueryWrapper qw = new LambdaQueryWrapper<AppAccess>()
                .eq(qo.getCustomerId() != null, AppAccess::getCustomerId, qo.getCustomerId())
                .like(qo.getAppName() != null, AppAccess::getAppName, qo.getAppName());
        IPage<AppAccess> page = appAccessService.page(qo.getPage(), qw);

        return page;
    }

    public AppAccess details(Long id) {
        AppAccess entity = appAccessService.getById(id);
        if (entity == null) {
            return null;
        }
        List<AppCall> callList = appCallService.list(new LambdaQueryWrapper<AppCall>().eq(AppCall::getAccessId, entity.getId()));
        entity.setCallList(callList);
        List<AppLimit> limitList = appLimitService.list(new LambdaQueryWrapper<AppLimit>().eq(AppLimit::getAccessId, entity.getId()));
        entity.setLimitList(limitList);
        return entity;
    }

    public List<AppAccess> detailsByCustomer(Long customerId) {
        List<AppAccess> entities = appAccessService.list(new LambdaQueryWrapper<AppAccess>().eq(AppAccess::getCustomerId, customerId));

        if (CollectionUtils.isEmpty(entities)) {
            return null;
        }
        entities.stream().forEach(entity -> {
            List<AppCall> callList = appCallService.list(new LambdaQueryWrapper<AppCall>().eq(AppCall::getAccessId, entity.getId()));
            entity.setCallList(callList);
            List<AppLimit> limitList = appLimitService.list(new LambdaQueryWrapper<AppLimit>().eq(AppLimit::getAccessId, entity.getId()));
            entity.setLimitList(limitList);
        });

        return entities;
    }

    public void saveAppLimit(AppLimitApiDto dto) {
        AppLimit limitEntity = appLimitService.getById(dto.getId());
        if (limitEntity == null) {
            throw new ValidationException(ResultCode.APP_LIMIT_EXISTS_VALID_ERROR);
        }
        appLimitService.modifyLimit(limitEntity, dto);
    }
}
