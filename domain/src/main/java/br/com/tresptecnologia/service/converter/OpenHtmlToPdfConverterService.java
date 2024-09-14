package br.com.tresptecnologia.service.converter;

import br.com.tresptecnologia.core.exception.DomainException;
import br.com.tresptecnologia.core.jpa.util.SpecificationUtils;
import br.com.tresptecnologia.service.termo.TermoService;
import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class OpenHtmlToPdfConverterService implements IOpenHtmlToPdfConverterService {

    private final TermoService termoService;

    public OpenHtmlToPdfConverterService(TermoService termoService) {
        this.termoService = termoService;
    }

    @Override
    @Transactional(readOnly = true)
    public byte[] generatePdfFromHtml(String documentoId) throws DomainException {
        var termo = termoService.findAll(SpecificationUtils.rsqlToSpecification("documento==".concat(documentoId)), Sort.unsorted()).stream().findFirst();
        try (ByteArrayOutputStream os = new ByteArrayOutputStream()) {
            PdfRendererBuilder builder = new PdfRendererBuilder();
            builder.withHtmlContent(adicionarEstruturaHtml(termo.get().getDocumento().getConteudo()), null);
            builder.toStream(os);
            builder.run();
            return os.toByteArray();
        } catch (IOException e) {
            throw new DomainException(e);
        }
    }

    public String adicionarEstruturaHtml(String conteudo) {
        StringBuilder htmlBuilder = new StringBuilder();

        htmlBuilder.append("<!DOCTYPE html>\n");
        htmlBuilder.append("<html lang=\"pt-BR\">\n");
        htmlBuilder.append("<head>\n");
        htmlBuilder.append("    <meta charset=\"UTF-8\"></meta>\n");
        htmlBuilder.append("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"></meta>\n");
        htmlBuilder.append("    <title>Documento</title>\n");
        htmlBuilder.append("</head>\n");
        htmlBuilder.append("<body>\n");
        htmlBuilder.append(conteudo); // Adiciona o conteúdo enviado pelo TinyMCE
        htmlBuilder.append("</body>\n");
        htmlBuilder.append("</html>");
        var aaa = criarHtml();
        return htmlBuilder.toString();
    }

    public String criarHtml() {
        StringBuilder htmlBuilder = new StringBuilder();

        htmlBuilder.append("<!DOCTYPE html>\n");
        htmlBuilder.append("<html lang=\"pt-BR\">\n");
        htmlBuilder.append("<head>\n");
        htmlBuilder.append("    <meta charset=\"UTF-8\"></meta>\n");
        htmlBuilder.append("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"></meta>\n");
        htmlBuilder.append("    <title>Contrato de Serviço</title>\n");
        htmlBuilder.append("</head>\n");
        htmlBuilder.append("<body style=\"font-family: Arial, sans-serif; line-height: 1.6; margin: 20px; color: #333;\">\n");
        htmlBuilder.append("    <h1 style=\"font-size: 24px; color: #0056b3; border-bottom: 2px solid #0056b3; padding-bottom: 10px;\">Contrato de Prestação de Serviços</h1>\n");
        htmlBuilder.append("    <p>Este contrato é firmado entre <strong>Nome do Contratante</strong> e <strong>Nome do Contratado</strong>, com base nas seguintes condições:</p>\n");
        htmlBuilder.append("    <h2 style=\"font-size: 20px; color: #0056b3; margin-top: 20px;\">1. Objeto do Contrato</h2>\n");
        htmlBuilder.append("    <p>O objeto deste contrato é a prestação de serviços de <strong>descrição do serviço</strong> conforme especificado no Anexo I.</p>\n");
        htmlBuilder.append("    <h2 style=\"font-size: 20px; color: #0056b3; margin-top: 20px;\">2. Valor e Forma de Pagamento</h2>\n");
        htmlBuilder.append("    <p>O valor total dos serviços é de <strong>R$ 1.000,00</strong>, que deverá ser pago da seguinte forma: <strong>em duas parcelas de R$ 500,00</strong>.</p>\n");
        htmlBuilder.append("    <h2 style=\"font-size: 20px; color: #0056b3; margin-top: 20px;\">3. Prazo de Execução</h2>\n");
        htmlBuilder.append("    <p>Os serviços serão executados no prazo de <strong>30 dias</strong> contados a partir da assinatura deste contrato.</p>\n");
        htmlBuilder.append("    <h2 style=\"font-size: 20px; color: #0056b3; margin-top: 20px;\">4. Obrigações das Partes</h2>\n");
        htmlBuilder.append("    <p><strong>Obrigações do Contratante:</strong> Fornecer todas as informações necessárias para a execução dos serviços.</p>\n");
        htmlBuilder.append("    <p><strong>Obrigações do Contratado:</strong> Executar os serviços com a devida diligência e qualidade.</p>\n");
        htmlBuilder.append("    <h2 style=\"font-size: 20px; color: #0056b3; margin-top: 20px;\">5. Rescisão</h2>\n");
        htmlBuilder.append("    <p>Este contrato pode ser rescindido por ambas as partes mediante aviso prévio de <strong>15 dias</strong>.</p>\n");
        htmlBuilder.append("    <h2 style=\"font-size: 20px; color: #0056b3; margin-top: 20px;\">6. Disposições Gerais</h2>\n");
        htmlBuilder.append("    <p style=\"background-color: #f0f0f0; padding: 5px; border-left: 5px solid #0056b3;\">Qualquer alteração deste contrato deverá ser formalizada por escrito e assinada por ambas as partes.</p>\n");
        htmlBuilder.append("    <p style=\"color: #d9534f; font-weight: bold;\">Em caso de litígios, o foro competente será o da comarca de <strong>Nome da Cidade</strong>.</p>\n");
        htmlBuilder.append("    <div style=\"margin-top: 40px; border-top: 1px solid #333; padding-top: 10px; text-align: center;\">\n");
        htmlBuilder.append("        <p><strong>Contratante:</strong> ________________________________</p>\n");
        htmlBuilder.append("        <p><strong>Contratado:</strong> ________________________________</p>\n");
        htmlBuilder.append("        <p>Data: ____/____/____</p>\n");
        htmlBuilder.append("    </div>\n");
        htmlBuilder.append("</body>\n");
        htmlBuilder.append("</html>");

        return htmlBuilder.toString();

    }

}
