package main.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "TB_ACESSORIOS")
public class Acessorios {

    @Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="acess_seq")
	@SequenceGenerator(name="acess_seq", sequenceName="acess_carro", initialValue = 1, allocationSize = 1)
	private Long id;

    @Column(name = "NOME", length = 30, nullable = false)
	private String nome;


    public enum Status {
        SIM,
        NAO
    }
    
    @Column(name = "STATUS", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;


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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    

}
