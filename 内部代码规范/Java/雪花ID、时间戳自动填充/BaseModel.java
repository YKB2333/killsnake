package lol.redScarf.yjdf.domain.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

@Data
public class BaseModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.ASSIGN_ID)//自动生成雪花ID
    private Long id;

    @TableField(fill = FieldFill.INSERT)//新增时自动填充时间戳
    private Long createDate;

    @TableField(fill = FieldFill.INSERT_UPDATE)//新增或修改时自动填充时间戳
    private Long updateDate;
}
