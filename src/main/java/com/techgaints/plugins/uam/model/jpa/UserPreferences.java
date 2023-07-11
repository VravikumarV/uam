package com.techgaints.plugins.uam.model.jpa;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.jpa.domain.AbstractAuditable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.JoinType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;

@Slf4j
@Entity
@Table(name = "user_preferences")
public class UserPreferences {



    /*
    javax.persistence.EntityListeners
    javax.persistence.MappedSuperclass
    javax.persistence.Access
    javax.persistence.AssociationOverrides
    javax.persistence.Basic,
    javax.persistence.Cache, Cacheable, CacheStoreMode, CacheRetrieveMode, CascadeType,
    javax.persistence.Convert, Converts, Converter, ConstraintMode
    javax.persistence.Embeddable, Expression, Index,
    javax.persistence.NamedQueries,NamedNativeQueries,NamedStoredProcedureQueries, Enumerated,
    javax.persistence.criteria.CriteriaBuilder, CriteriaDelete,
    javax.persistence.criteria.From, Join, JoinType, Join, Order, Expression, Fetch, CriteriaUpdate, Predicate, CriteriaQuery

    JPA         -
    Hibernate   -

    */
    /*
    org.hibernate.jpa.HibernateQuery
    org.hibernate.jpa.AvailableSettings
    org.hibernate.jpa.QueryHints,
    org.hibernate.cache.CacheException
    */

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long userId;

    @Email(message = "Please enter valid Email")
    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "user_dob")
    private Date userDob;

    @Column(name = "user_phone")
    private String userPhone;

    @Column(name = "user_status")
    private String userStatus;

}
