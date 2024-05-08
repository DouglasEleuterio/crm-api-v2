package br.com.tresptecnologia.core.jpa.mapper;

import java.util.Collection;

/**
 * Representa uma registro do resultado da consulta
 */
public interface Row {
    boolean has(String key);
    Object get(String key);

    Collection<String> getKeys();
}
