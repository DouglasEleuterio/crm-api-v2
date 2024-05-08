package br.com.tresptecnologia.core.jpa.metadata;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PropertyMetadata {
    boolean isId;
    boolean isCollection;
}
