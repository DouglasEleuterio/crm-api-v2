package br.com.tresptecnologia.core.audit.service;

import br.com.tresptecnologia.core.entity.BaseEntity;
import br.com.tresptecnologia.core.audit.mapper.RevisionMapper;
import br.com.tresptecnologia.core.audit.model.EntityRevision;

import java.time.LocalDate;
import java.util.List;

public interface IBaseAuditService {
    <T extends BaseEntity, R> List<EntityRevision<R>> find(long id, LocalDate start, LocalDate end,
                                                           RevisionMapper<R> revisionMapper, Class<T> clazz);
}
