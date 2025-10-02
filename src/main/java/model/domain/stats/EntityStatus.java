package model.domain.stats;

public class EntityStatus {

    private long id;
    private int forca;
    private int agilidade;
    private int inteligencia;
    private int conhecimento;
    private int constituicao;

    public EntityStatus(int forca, int agilidade, int inteligencia, int conhecimento, int constituicao) {
        this.forca = forca;
        this.agilidade = agilidade;
        this.inteligencia = inteligencia;
        this.conhecimento = conhecimento;
        this.constituicao = constituicao;
    }

    public EntityStatus(long id, int forca, int agilidade, int inteligencia, int conhecimento, int constituicao) {
        this.id = id;
        this.forca = forca;
        this.agilidade = agilidade;
        this.inteligencia = inteligencia;
        this.conhecimento = conhecimento;
        this.constituicao = constituicao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getAgilidade() {
        return agilidade;
    }

    public void setAgilidade(int agilidade) {
        this.agilidade = agilidade;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    public int getConhecimento() {
        return conhecimento;
    }

    public void setConhecimento(int conhecimento) {
        this.conhecimento = conhecimento;
    }

    public int getConstituicao() {
        return constituicao;
    }

    public void setConstituicao(int constituicao) {
        this.constituicao = constituicao;
    }

}
