package com.besports.entity;

import com.besports.entity.Empresa;
import com.besports.entity.PerfilMenu;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-11-25T20:44:11", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Perfiles.class)
public class Perfiles_ { 

    public static volatile CollectionAttribute<Perfiles, PerfilMenu> perfilMenuCollection;
    public static volatile SingularAttribute<Perfiles, Boolean> estado;
    public static volatile SingularAttribute<Perfiles, Integer> idPerfil;
    public static volatile SingularAttribute<Perfiles, String> detallePerfil;
    public static volatile SingularAttribute<Perfiles, Empresa> idEmpresa;
    public static volatile SingularAttribute<Perfiles, String> nombrePerfil;

}