package br.com.tresptecnologia.core.util;

import lombok.Getter;

@Getter
public final class CharactersUtil {

    private CharactersUtil() {
    }

    public static final String ACCENTS = "âàãáÁÂÀÃéêÉÊíÍóôõÓÔÕüúÜÚÇç";
    public static final String WITHOUT_ACCENTS = "AAAAAAAAEEEEIIOOOOOOUUUUCC";

}
