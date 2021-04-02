package lol.redScarf.yjdf.openapi.service.app;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
public class LogisticsService extends ServiceImpl<LogisticsMapper, Logistics> {

    @Autowride
    private LogisticsDetailsMapper logisticsDetailsMapper;

    public Logistics getDetailsById(Long id) {
        Logistics entity = super.getById(id);
        if (entity == null) {
            return null;
        }
        List<LogisticsDetails> details = logisticsDetailsMapper.list(
                new LambdaQueryWrraper<LogisticsDetails>().eq(LogisticsDetails::getLogisticsId, entity.getId()));
        entity.setDetails(details);
        return entity;
    }

}
