package com.techgaints.plugins.uam.model;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.sql.Timestamp;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseAuditorEntity {

    @Column(name = "created_by")
    @CreatedBy
    protected String createdBy;

    @Column(name = "created_date")
    @CreatedDate
    protected Timestamp createdDate;

    @Column(name = "modified_date")
    @LastModifiedDate
    protected String modifiedDate;

    @Column(name = "modified_by")
    @LastModifiedBy
    protected String modifiedBy;

}
