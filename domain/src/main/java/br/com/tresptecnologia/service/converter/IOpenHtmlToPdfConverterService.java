package br.com.tresptecnologia.service.converter;

import br.com.tresptecnologia.core.exception.DomainException;

public interface IOpenHtmlToPdfConverterService {

    byte[] generatePdfFromHtml(String htmlContent) throws DomainException;
}
