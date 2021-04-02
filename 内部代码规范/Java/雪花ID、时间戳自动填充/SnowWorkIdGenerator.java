package lol.redScarf.yjdf.system.config.mybatis;

import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import lol.redScarf.system.utils.idgen.SnowFlake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SnowWorkIdGenerator implements IdentifierGenerator {
    @Autowired
    private SnowFlake snowFlake;

    @Override
    public Number nextId(Object entity) {
       /*
        //可以将当前传入的class全类名来作为bizKey,或者提取参数来生成bizKey进行分布式Id调用生成.
        String bizKey = entity.getClass().getName();
        //根据bizKey调用分布式ID生成
        */
        long id = snowFlake.nextId();
        //返回生成的id值即可.
        return id;
    }
}
