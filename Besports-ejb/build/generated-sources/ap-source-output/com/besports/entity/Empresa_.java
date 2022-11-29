package com.besports.entity;

import com.besports.entity.Perfiles;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-11-25T20:44:11", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Empresa.class)
public class Empresa_ { 

    public static volatile SingularAttribute<Empresa, Integer> dv;
    public static volatile SingularAttribute<Empresa, String> razonSocial;
    public static volatile SingularAttribute<Empresa, String> documentoEmpresa;
    public static volatile SingularAttribute<Empresa, Integer> idTipoDocumento;
    public static volatile SingularAttribute<Empresa, String> siglas;
    public static volatile CollectionAttribute<Empresa, Perfiles> perfilesCollection;
    public static volatile SingularAttribute<Empresa, Integer> idEmpresa;

}