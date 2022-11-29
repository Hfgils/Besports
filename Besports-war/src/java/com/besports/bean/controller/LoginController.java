/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.besports.bean.controller;

import com.besports.bean.message.MessagesView;
import com.besports.ejb.UsuarioFacadeLocal;
import com.besports.ejb.ValorConfiguracionFacadeLocal;
import com.besports.entity.Usuario;
import com.besports.entity.ValorConfiguracion;
import com.besports.util.Encrypt;
import com.besports.util.GetOS;

import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;

/**
 *
 * @author hgil
 */
@Named(value = "loginController")
@SessionScoped
public class LoginController implements Serializable {

    private String os = new GetOS().getos();
    private LdapContext ctx = null;
    private Attributes attrs;
    private MessagesView messagesView;
    private String redireccion;
    private FacesContext context = FacesContext.getCurrentInstance();
    private Boolean logLdap;

    @EJB
    private UsuarioFacadeLocal UsuariosEJB;
    @EJB
    private ValorConfiguracionFacadeLocal LdapEJB;

    @Inject
    private Usuario usuario;
    @Inject
    private ValorConfiguracion Ldap;

    private List<Usuario> usuarioses;
    private HashMap<String, String> DeHashMap = new HashMap<String, String>();

    @PostConstruct
    public void init() {
//        oS.getos();

        this.DeHashMap = this.LdapEJB.findByldap("LDAP", true);
    }

    @PreDestroy
    public void destroy() {
//        oS.getos();
        System.out.println("muerte");
        this.DeHashMap.clear();
        usuarioses.clear();
        usuario.setIdPerfil(null);
        usuario.setIdPerfil(null);
        usuario.setNombreUsuario(null);
        usuario.setPassword(null);

    }

    public String login() throws Exception {
        System.out.println(os);
        if (this.usuario.getNombreUsuario().isEmpty() && this.usuario.getPassword().isEmpty()) {
            //messagesView.error();
            //this.redireccion = "pretty:AccessDenied";
            this.redireccion = "/resources/error/access-denied?faces-redirect=true";

        } else {
            usuarioses = UsuariosEJB.findByUsername(this.usuario.getNombreUsuario());
            logLdap = usuarioses.get(0).getLdapLogin();
            if (logLdap.equals(true)) {
                try {

                    Hashtable env = new Hashtable();
                    env.put("java.naming.factory.initial", "com.sun.jndi.ldap.LdapCtxFactory");
                    env.put("java.naming.security.authentication", "Simple");
                    env.put("java.naming.security.principal", ((String) this.DeHashMap.get("DOMAIN_NAME")) + this.getUsuario().getNombreUsuario());
                    env.put("java.naming.security.credentials", this.getUsuario().getPassword());
                    env.put("java.naming.provider.url", "ldap://" + ((String) this.DeHashMap.get("HOST")) + ":" + ((String) this.DeHashMap.get("PORT")));
                    this.ctx = new InitialLdapContext(env, null);
                    System.out.println("Connection Successful.");

                    SearchControls constraints = new SearchControls();
                    constraints.setSearchScope(2);

                    String[] attrIDs = {((String) this.DeHashMap.get("REALNAME_FIELD")), ((String) this.DeHashMap.get("POSTAL_CODE")), ((String) this.DeHashMap.get("EMAIL1_FIELD")), ((String) this.DeHashMap.get("TITLE_FIELD")), ((String) this.DeHashMap.get("CATEGORY_FIELD")), ((String) this.DeHashMap.get("FIRSTNAME_FIELD"))};

//            String[] attrIDs = {((SeoAuthldaps) this.authldapss.get(0)).getRealnameField(), ((SeoAuthldaps) this.authldapss.get(0)).getGroupMemberField(), ((SeoAuthldaps) this.authldapss.get(0)).getEmail1Field(), ((SeoAuthldaps) this.authldapss.get(0)).getTitleField(), ((SeoAuthldaps) this.authldapss.get(0)).getCategoryField(), ((SeoAuthldaps) this.authldapss.get(0)).getFirstnameField()};
                    constraints.setReturningAttributes(attrIDs);

                    NamingEnumeration answer = this.ctx.search(((String) this.DeHashMap.get("BASEDN")), ((String) this.DeHashMap.get("FIRSTNAME_FIELD")) + "=" + this.getUsuario().getNombreUsuario(), constraints);
                    if (answer.hasMore()) {
                        this.attrs = ((SearchResult) answer.next()).getAttributes();
                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("Nombre", this.attrs.get("cn").get(0).toString());
                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("Cedula", this.attrs.get("postalCode").get(0).toString());
                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("Email", this.attrs.get("mail").get(0).toString());
                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("Cargo", this.attrs.get("title").get(0).toString());
                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("Compania", this.attrs.get("company").get(0).toString());
                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("Usuario", this.attrs.get("sAMAccountName").get(0).toString());
                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("Idperfil", usuarioses.get(0).getIdPerfil());
                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("NamePerfil", usuarioses.get(0).getIdPerfil().getNombrePerfil());
                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("Os", this.os);
                        this.redireccion = "/Dashboard/Dashboard?faces-redirect=true";
                        // this.redireccion = "pretty:Dashboard";
                    } else {
                        throw new Exception("Invalid User");
                    }

                } catch (NamingException nex) {
                    System.out.println("LDAP Connection: FAILED");
                    nex.printStackTrace();
                    this.redireccion = "/resources/error/access-denied?faces-redirect=true";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Usuario y/o Clave invalidos"));
                }

            } else {

                if (Encrypt.encrypt(this.getUsuario().getPassword()).equals(usuarioses.get(0).getPassword())) {
                    System.out.println(usuarioses.get(0).getIdPerfil());

                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("Nombre", usuarioses.get(0).getIdPersona().getPrimerNombre() + " " + usuarioses.get(0).getIdPersona().getPrimerApellido());
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("Usuario", usuarioses.get(0).getNombreUsuario());
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("Idperfil", usuarioses.get(0).getIdPerfil());
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("NamePerfil", usuarioses.get(0).getIdPerfil().getNombrePerfil());
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("Os", this.os);
                    //FacesContext.getCurrentInstance().getExternalContext().setSessionMaxInactiveInterval(20);
                    this.redireccion = "/Dashboard/Dashboard?faces-redirect=true";
//                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("Nombre", usuarioses.get(0).getIdPersona().getNombre());
//                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("Cedula", usuarioses.get(0).getIdPersona().getIdentificacion());
//                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("Idperfil", usuarioses.get(0).getIdPerfil());
//                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("NamePerfil", usuarioses.get(0).getIdPerfil().getPerfilname());
//                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("Os", this.os);
//                    this.redireccion = "/Dashboard/dashboard?faces-redirect=true";
                } else {
                    this.redireccion = "/resources/error/access-denied?faces-redirect=true";
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Usuario y/o Clave invalidos"));
                }

            }
        }

        return this.redireccion;
    }

    public String logout() {

        this.redireccion = null;
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        this.redireccion = "/index?faces-redirect=true";
        //  this.redireccion = "pretty:home";
        return this.redireccion;

    }

    public String redirect() throws Exception {

        this.redireccion = "#";

        return this.redireccion;
    }

    /**
     * Creates a new instance of LoginController
     */
    public LoginController() {
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the Ldap
     */
    public ValorConfiguracion getLdap() {
        return Ldap;
    }

    /**
     * @param Ldap the Ldap to set
     */
    public void setLdap(ValorConfiguracion Ldap) {
        this.Ldap = Ldap;
    }

}
