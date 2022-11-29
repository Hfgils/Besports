package com.besports.entity;

import com.besports.entity.Municipios;
import com.besports.entity.Pais;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-11-25T20:44:11", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Departamento.class)
public class Departamento_ { 

    public static volatile SingularAttribute<Departamento, Integer> idDepartamento;
    public static volatile SingularAttribute<Departamento, String> indicativo;
    public static volatile SingularAttribute<Departamento, Boolean> estado;
    public static volatile SingularAttribute<Departamento, String> nombreDepartamento;
    public static volatile SingularAttribute<Departamento, Pais> idPais;
    public static volatile SingularAttribute<Departamento, String> codIso;
    public static volatile SingularAttribute<Departamento, String> codDane;
    public static volatile CollectionAttribute<Departamento, Municipios> municipiosCollection;

}