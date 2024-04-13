package main.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_Carros")
public class Carros {

    @Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="carro_seq")
	@SequenceGenerator(name="carro_seq", sequenceName="sq_carro", initialValue = 1, allocationSize = 1)
	private Long id;

    @Column(name = "MODELO", length = 25, nullable = false)
	private String modelo;

    @Column(name = "ANO", length = 04, nullable = false)
	private int ano;

    @ManyToOne
	@JoinColumn(name = "id_marcas_fk", 
		foreignKey = @ForeignKey(name = "fk_marcas_carros"), 
		referencedColumnName = "id", nullable = false)
        private Marcas marcas; 
    
    //Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    

}
