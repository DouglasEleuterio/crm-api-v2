package br.com.tresptecnologia.service.color;

import org.springframework.stereotype.Service;

@Service
public class ColorEventoService implements IColorEventoService {

    @Override
    public String getColorByProcedimento(String procedimento) {
        switch (procedimento) {
            case "Depilação a Lazer":
                return "#0077b6";
            case "Bioestimulador de colageno":
                return "#ffc8dd";
            case "Botox":
                return "#bde0fe";
            case "Botox Nefertiti":
                return "#a2d2ff";
            case "Laser Lavieen":
                return "#ccd5ae";
            case "Preenchimento":
                return "#e9edc9";
            case "Rinomodelação":
                return "#fefae0";
            case "Botox Fullface":
                return "#fb5607";
            case "Botox sorriso gengival":
                return "#d4a373";
            case "Design":
                return "#8ecae6";
            case "Design com rena":
                return "#219ebc";
            case "Buço na linha":
                return "#023047";
            case "Limpeza de pele comum":
                return "#ffb703";
            case "Limpeza de pele com dermaplaning":
                return "#fb8500";
            case "Dermaplaning":
                return "#a3b18a";
            case "Dermapen":
                return "#588157";
            case "Micropigmentação":
                return "#8d99ae";
            case "Retoque micropigmentação":
                return "#ef233c";
            case "Pelling quimico":
                return "#e76f51";
            case "Aplicação varizes":
                return "#f4a261";
            case "Aplicação de enzimas":
                return "#e9c46a";
            case "Lipo de papada enzimatica":
                return "#2a9d8f";
            case "Massagem modeladora":
                return "#264653";
            case "Massagem relaxante":
                return "#a8dadc";
            case "Massagem drenagem":
                return "#936639";
            case "Massagem para flacidez":
                return "#a4ac86";
            case "Massagem para celulite":
                return "#c2c5aa";
            case "Lift facial":
                return "#b6ad90";
            case "Radiofrequencia":
                return "#656d4a";
            case "Lipocavitação":
                return "#3a86ff";
            case "Cone yndu":
                return "#8338ec";
            case "Sessão detox":
                return "#ff006e";
        }
        return "#edf2f4";
    }
}