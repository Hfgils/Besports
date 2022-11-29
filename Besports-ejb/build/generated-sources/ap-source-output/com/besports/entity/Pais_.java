package com.besports.entity;

import com.besports.entity.Departamento;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-11-25T20:44:11", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Pais.class)
public class Pais_ { 

    public static volatile SingularAttribute<Pais, String> indicativo;
    public static volatile SingularAttribute<Pais, String> longitud;
    public static volatile SingularAttribute<Pais, String> latitud;
    public static volatile CollectionAttribute<Pais, Departamento> departamentoCollection;
    public static volatile SingularAttribute<Pais, Boolean> estadoPais;
    public static volatile SingularAttribute<Pais, Integer> idPais;
    public static volatile SingularAttribute<Pais, String> codPaisDane;
    public static volatile SingularAttribute<Pais, String> codIso;
    public static volatile SingularAttribute<Pais, String> nombrePais;

}