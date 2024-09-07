package br.com.tresptecnologia.service.color;

import org.springframework.stereotype.Service;

@Service
public class ColorEventoService implements IColorEventoService {

    @Override
    public String getColorByProcedimento(String titulo) {
        return switch (titulo) {
            case "Depilação a Lazer" -> "#0077b6";
            case "Bioestimulador de colageno" -> "#ffc8dd";
            case "Botox" -> "#bde0fe";
            case "Botox Nefertiti" -> "#a2d2ff";
            case "Laser Lavieen" -> "#ccd5ae";
            case "Preenchimento" -> "#e9edc9";
            case "Rinomodelação" -> "#fefae0";
            case "Botox Fullface" -> "#fb5607";
            case "Botox sorriso gengival" -> "#d4a373";
            case "Design" -> "#8ecae6";
            case "Design com rena" -> "#219ebc";
            case "Buço na linha" -> "#023047";
            case "Limpeza de pele comum" -> "#ffb703";
            case "Limpeza de pele com dermaplaning" -> "#fb8500";
            case "Dermaplaning" -> "#a3b18a";
            case "Dermapen" -> "#588157";
            case "Micropigmentação" -> "#8d99ae";
            case "Retoque micropigmentação" -> "#ef233c";
            case "Pelling quimico" -> "#e76f51";
            case "Aplicação varizes" -> "#f4a261";
            case "Aplicação de enzimas" -> "#e9c46a";
            case "Lipo de papada enzimatica" -> "#2a9d8f";
            case "Massagem modeladora" -> "#264653";
            case "Massagem relaxante" -> "#a8dadc";
            case "Massagem drenagem" -> "#936639";
            case "Massagem para flacidez" -> "#a4ac86";
            case "Massagem para celulite" -> "#c2c5aa";
            case "Lift facial" -> "#b6ad90";
            case "Radiofrequencia" -> "#656d4a";
            case "Lipocavitação" -> "#3a86ff";
            case "Cone yndu" -> "#8338ec";
            case "Sessão detox" -> "#ff006e";
            default -> "#edf2f4";
        };
    }

    public String getColorPreAgendamento() {
        return "#8d99ae";
    }
}