package com.besports.entity;

import com.besports.entity.Usuario;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-11-25T20:44:11", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Personas.class)
public class Personas_ { 

    public static volatile SingularAttribute<Personas, Integer> segundoNombre;
    public static volatile SingularAttribute<Personas, String> primerNombre;
    public static volatile SingularAttribute<Personas, String> primerApellido;
    public static volatile SingularAttribute<Personas, Date> fechaNacimiento;
    public static volatile SingularAttribute<Personas, String> documento;
    public static volatile SingularAttribute<Personas, String> segundoApellido;
    public static volatile SingularAttribute<Personas, Integer> ciudadExpDoc;
    public static volatile SingularAttribute<Personas, Date> fechaExpDoc;
    public static volatile CollectionAttribute<Personas, Usuario> usuarioCollection;
    public static volatile SingularAttribute<Personas, Integer> ciudadNacimiento;
    public static volatile SingularAttribute<Personas, String> dv;
    public static volatile SingularAttribute<Personas, Integer> genero;
    public static volatile SingularAttribute<Personas, Integer> idTipodocumento;
    public static volatile SingularAttribute<Personas, Integer> idPersona;
    public static volatile SingularAttribute<Personas, Integer> tipoSanguineo;

}