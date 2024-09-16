package br.com.tresptecnologia.service.color;

import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class ColorEventoService implements IColorEventoService {

    @Override
    public String getColorByProcedimento(String titulo) {
        titulo = titulo.split("-")[0].trim();
        if (titulo.equals("Depilação a Lazer")) {
            return "#0077b6";
        } else if (titulo.equals("Bioestimulador de colageno")) {
            return "#ffc8dd";
        } else if (titulo.equals("Botox")) {
            return "#bde0fe";
        } else if (titulo.equals("Botox Nefertiti")) {
            return "#a2d2ff";
        } else if (titulo.equals("Laser Lavieen")) {
            return "#ccd5ae";
        } else if (titulo.equals("Preenchimento")) {
            return "#e9edc9";
        } else if (titulo.equals("Rinomodelação")) {
            return "#fefae0";
        } else if (titulo.equals("Botox Fullface")) {
            return "#fb5607";
        } else if (titulo.equals("Botox sorriso gengival")) {
            return "#d4a373";
        } else if (titulo.equals("Design")) {
            return "#8ecae6";
        } else if (titulo.equals("Design com rena")) {
            return "#219ebc";
        } else if (titulo.equals("Buço na linha")) {
            return "#023047";
        } else if (titulo.equals("Limpeza de pele comum")) {
            return "#ffb703";
        } else if (titulo.equals("Limpeza de pele com dermaplaning")) {
            return "#fb8500";
        } else if (titulo.equals("Dermaplaning")) {
            return "#a3b18a";
        } else if (titulo.equals("Dermapen")) {
            return "#588157";
        } else if (titulo.equals("Micropigmentação")) {
            return "#8d99ae";
        } else if (titulo.equals("Retoque micropigmentação")) {
            return "#ef233c";
        } else if (titulo.equals("Pelling quimico")) {
            return "#e76f51";
        } else if (titulo.equals("Aplicação varizes")) {
            return "#f4a261";
        } else if (titulo.equals("Aplicação de enzimas")) {
            return "#e9c46a";
        } else if (titulo.equals("Lipo de papada enzimatica")) {
            return "#2a9d8f";
        } else if (titulo.equals("Massagem modeladora")) {
            return "#264653";
        } else if (titulo.equals("Massagem relaxante")) {
            return "#a8dadc";
        } else if (titulo.equals("Massagem drenagem")) {
            return "#936639";
        } else if (titulo.equals("Massagem para flacidez")) {
            return "#a4ac86";
        } else if (titulo.equals("Massagem para celulite")) {
            return "#c2c5aa";
        } else if (titulo.equals("Lift facial")) {
            return "#b6ad90";
        } else if (titulo.equals("Radiofrequencia")) {
            return "#656d4a";
        } else if (titulo.equals("Lipocavitação")) {
            return "#3a86ff";
        } else if (titulo.equals("Cone yndu")) {
            return "#8338ec";
        } else if (titulo.equals("Sessão detox")) {
            return "#ff006e";
        }
        return "#edf2f4";
    }

    public String getColorPreAgendamento() {
        return "#8d99ae";
    }
}