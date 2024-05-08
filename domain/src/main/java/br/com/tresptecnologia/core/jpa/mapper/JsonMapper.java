package br.com.tresptecnologia.core.jpa.mapper;

import br.com.tresptecnologia.core.jpa.mapper.exception.JsonMapperException;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.data.domain.Page;

import java.util.List;

public interface JsonMapper {
    /**
     * Mapear os resultados para um classe levando em consideração o nome de suas propriedades
     *
     * @param rows
     * @param clazz
     * @param <T>
     * @return
     * @throws JsonMapperException
     */
    <T> List<T> toListModel(final List<Row> rows, final Class<T> clazz) throws JsonMapperException;

    /**
     * Mapea o resultado para uma classe levando em consideração o nome de suas propriedades
     *
     * @param row
     * @param clazz
     * @param <T>
     * @return
     * @throws JsonMapperException
     */
    <T> T toModel(final Row row, final Class<T> clazz) throws JsonMapperException;

    /**
     * Mapea os resultados para um ArrayNode
     *
     * @param rows
     * @return
     * @throws JsonMapperException
     */
    ArrayNode toJsonArray(final List<Row> rows) throws JsonMapperException;

    /**
     * Mapea os resultados para um Page do spring
     *
     * @param toJsonPage
     * @return
     * @throws JsonMapperException
     */
    ObjectNode toJsonPage(final Page<Row> rowPage) throws JsonMapperException;

    /**
     * Mapea o resultado para um ObjectNode
     *
     * @param row
     * @return
     * @throws JsonMapperException
     */
    ObjectNode toJson(final Row row) throws JsonMapperException;
}
