package com.example.demo.Model;
import java.time.LocalDate;
import java.time.Period;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.example.demo.Entity.Inscription;
import com.example.demo.Model.Validation.ValidCin;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
@Table(name = "user")
@Entity
@Component
public class User {   
    @Id
    @Column(name = "userid")
    private Long userid;
    @Column(name = "nom")
    private String nom;
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "date_naissance")
    @Value("${date_naissance}")
    private LocalDate date_naissance;
    @OneToOne(mappedBy = "inscriptionid")
    private Inscription inscription;
    @Column(name = "CIN")
    @NotBlank(message = "Le champ CIN ne peut pas être vide")
    @ValidCin
    private String CIN;
    //Getter & Setters
    //id
    public Long getUserId(){
        return userid;
    }
    public void setUserId(Long UserId){
        this.userid=UserId;
    }
    //nom
    public String getNom(){
        return nom;
    }
    public void setNom(String nom){
        this.nom=nom;
    }
    //prenom
    public String getPrenom(){
        return prenom;
    }
    public void setPrenom(String prenom){
        this.prenom=prenom;
    }
    //date naissance
    public LocalDate getDateNaissance(){
        return date_naissance;
    }
    public void setBirthday(LocalDate dateNaissance){
        this.date_naissance=dateNaissance;
    }
    //Fonction
    public int calculerAge(){
        LocalDate currentDate=LocalDate.now();
        Period period=Period.between(date_naissance, currentDate);
        return period.getYears();
    }
    //CIN
    public String getCIN(){
        return CIN;
    }
    public void setCIN(String CIN){
        this.CIN=CIN;
    }
}