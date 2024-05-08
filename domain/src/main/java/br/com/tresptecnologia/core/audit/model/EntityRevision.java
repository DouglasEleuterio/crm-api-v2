package br.com.tresptecnologia.core.audit.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.RevisionType;

import java.util.Date;

@Getter
@Setter
public class EntityRevision<T> {
    private long id;
    private String userid;
    private String username;
    private String userIp;
    private Date revisionDate;
    private RevisionType revisionType;
    private T entity;
}
