package com.techgaints.plugins.uam.model.mongo;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.sql.Date;

@Slf4j
@Builder
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document( "bride_groom_profiles")
public class MUser {
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
            private String id;
            private String name;
            private String fatherName;
            private String motherName;
            private String gothram;
            private String sakha;
            private String tob;
            private String dob;
            private String pob;
            private String birthStar;
            private String height;
            private String education;
            private String jobOccupation;
            private String company;
            private String salaray;
            private String areaBelongsTo;
            private String requirements;
            private String contactNumber;
            private String altContactNumber;
            private String siblings;

}
