package lol.redScarf.yjdf.openapi.service.app;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lol.redScarf.yjdf.openapi.domain.app.model.AppAccess;
import lol.redScarf.yjdf.openapi.domain.app.repository.AppAccessMapper;
import lol.redScarf.yjdf.openapi.infrastructure.exception.NetworkException;
import lol.redScarf.yjdf.openapi.infrastructure.util.encrypt.Base64ConvertUtil;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

/**
 * <p>
 * 一件代发通行证关系表 服务实现类
 * </p>
 *
 * @author zhongshang
 * @since 2020-07-10
 */
@Service
@Slf4j
public class AppAccessService extends ServiceImpl<AppAccessMapper, AppAccess> {

    @Autowired
    private RMap<String, String> appSecretMap;

    public AppAccess rigister(Long customerId, String appName) throws UnsupportedEncodingException {
        AppAccess entity = new AppAccess();
        entity.setCustomerId(customerId);
        entity.setAppName(appName);
        entity.setAppKey(UUID.randomUUID().toString());
        entity.setAppSecret(Base64ConvertUtil.encode(UUID.randomUUID().toString().replaceAll("-", "")));
        entity.setEnabled(true);
        if (!save(entity)) {
            throw new NetworkException();
        }
        appSecretMap.put(entity.getAppKey(), entity.getAppSecret());
        return entity;
    }

    public AppAccess refreshAppSecret(AppAccess entity) throws UnsupportedEncodingException {
        entity.setAppSecret(Base64ConvertUtil.encode(UUID.randomUUID().toString().replaceAll("-", "")));
        if (!updateById(entity)) {
            throw new NetworkException();
        }
        appSecretMap.put(entity.getAppKey(), entity.getAppSecret());
        return entity;
    }

    public AppAccess enable(AppAccess entity) {
        entity.setEnabled(true);
        if (!updateById(entity)) {
            throw new NetworkException();
        }
        return entity;
    }

    public AppAccess disable(AppAccess entity) {
        entity.setEnabled(false);
        if (!updateById(entity)) {
            throw new NetworkException();
        }
        return entity;
    }
}
