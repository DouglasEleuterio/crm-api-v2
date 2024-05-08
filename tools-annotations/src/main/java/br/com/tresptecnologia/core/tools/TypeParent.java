package br.com.tresptecnologia.core.tools;

public class TypeParent {
    private String mappedBy;
    private String parentType;

    public TypeParent() {
    }

    public TypeParent(String mappedBy, String parentType) {
        this.mappedBy = mappedBy;
        this.parentType = parentType;
    }

    public void setMappedBy(String mappedBy) {
        this.mappedBy = mappedBy;
    }

    public void setParentType(String parentType) {
        this.parentType = parentType;
    }

    public String getMappedBy() {
        return mappedBy;
    }

    public String getParentType() {
        return parentType;
    }
}
