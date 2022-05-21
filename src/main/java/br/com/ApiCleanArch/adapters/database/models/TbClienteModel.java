package br.com.ApiCleanArch.adapters.database.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "tb_dados_cliente")
public class TbClienteModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID identificador;

    @Column(nullable = false)
    private String cpf;

    @Column(nullable = false)
    private String orgaoEmissor;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String dataNascimento;

    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime creationDate;
}
