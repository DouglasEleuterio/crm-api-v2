package br.com.tresptecnologia.entity;

import br.com.tresptecnologia.core.audit.AuditEntityListener;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "revision")
@RevisionEntity(value = AuditEntityListener.class)
public class AuditRevision {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_revisao")
    @SequenceGenerator(name = "sq_revisao", sequenceName = "sq_revisao", initialValue = 1, allocationSize = 1)
    @RevisionNumber
    private long id;

    @Column(name = "user_id", nullable = false, length = 150)
    private String userId;

    @Column(name = "username", nullable = false, length = 150)
    private String userName;

    @Column(name = "user_ip", length = 30)
    private String userIp;

    @RevisionTimestamp
    @Column(name = "revision_date")
    private Date revisionDate;

}
