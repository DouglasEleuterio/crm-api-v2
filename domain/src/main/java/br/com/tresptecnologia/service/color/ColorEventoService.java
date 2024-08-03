package br.com.tresptecnologia.service.color;

import org.springframework.stereotype.Service;

@Service
public class ColorEventoService implements IColorEventoService {

    @Override
    public String getColorByProcedimento(String procedimento) {
        switch (procedimento) {
            case "Depilação a Lazer":
                return "#799496";
            case "Bioestimulador de colageno":
                return "#290436";
        }
        return "#799496";
    }
}
