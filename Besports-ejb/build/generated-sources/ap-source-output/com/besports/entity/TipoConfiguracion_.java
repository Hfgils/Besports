package com.besports.entity;

import com.besports.entity.ValorConfiguracion;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-11-25T20:44:11", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(TipoConfiguracion.class)
public class TipoConfiguracion_ { 

    public static volatile SingularAttribute<TipoConfiguracion, Integer> idConfiguracion;
    public static volatile SingularAttribute<TipoConfiguracion, Boolean> estado;
    public static volatile CollectionAttribute<TipoConfiguracion, ValorConfiguracion> valorConfiguracionCollection;
    public static volatile SingularAttribute<TipoConfiguracion, String> nombreConfiguracion;
    public static volatile SingularAttribute<TipoConfiguracion, String> detalleConfiguracion;

}