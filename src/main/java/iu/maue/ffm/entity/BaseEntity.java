package iu.maue.ffm.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * 基类
 */
@MappedSuperclass
@Data
public abstract class BaseEntity {

    @Id
    @GeneratedValue(generator = "ksUid")
    @GenericGenerator(name = "ksUid", strategy = "iu.maue.ffm.utils.KsUidIdentifierGenerator")
    private String id;

    /**
     * 创建时间
     */
    @CreationTimestamp
    private Date createTime;

    /**
     * 更新时间
     */
    @UpdateTimestamp
    private Date updateTime;

}
