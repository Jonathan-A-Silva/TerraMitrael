package model.persistence.stats;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "entity_status")
public class PersistenceEntityStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "forca")
    private int forca;

    @Column(name = "agilidade")
    private int agilidade;

    @Column(name = "inteligencia")
    private int inteligencia;

    @Column(name = "conhecimento")
    private int conhecimento;

    @Column(name = "constituicao")
    private int constituicao;

    public PersistenceEntityStatus(int forca, int agilidade, int inteligencia, int conhecimento, int constituicao) {
        this.forca = forca;
        this.agilidade = agilidade;
        this.inteligencia = inteligencia;
        this.conhecimento = conhecimento;
        this.constituicao = constituicao;
    }

    public PersistenceEntityStatus(long id, int forca, int agilidade, int inteligencia, int conhecimento, int constituicao) {
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