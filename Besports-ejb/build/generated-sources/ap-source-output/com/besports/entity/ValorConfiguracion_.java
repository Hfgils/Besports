package com.besports.entity;

import com.besports.entity.Empresa;
import com.besports.entity.TipoConfiguracion;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-11-25T20:44:11", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(ValorConfiguracion.class)
public class ValorConfiguracion_ { 

    public static volatile SingularAttribute<ValorConfiguracion, String> descripcion;
    public static volatile SingularAttribute<ValorConfiguracion, Boolean> estado;
    public static volatile SingularAttribute<ValorConfiguracion, Integer> idValorConf;
    public static volatile SingularAttribute<ValorConfiguracion, String> valorConfiguracion;
    public static volatile SingularAttribute<ValorConfiguracion, TipoConfiguracion> idTipoConf;
    public static volatile SingularAttribute<ValorConfiguracion, Empresa> idEmpresa;

}