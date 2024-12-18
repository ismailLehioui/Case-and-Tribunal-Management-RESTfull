package com.enicar.soc.entities;

import com.enicar.soc.enums.Speciality;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "lawyer")
public class Lawyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lawyer_id")
    private Long lawyerId ;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Enumerated(EnumType.STRING)
    private Speciality speciality;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String telephone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lawyerClient", orphanRemoval = true)
    Set<Client> clients;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lawyerFolder", orphanRemoval = true)
    Set<Folder> folders;
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "lawyers")
    private Set<Court> courts;


    public Long getLawyerId() {
        return lawyerId;
    }

    public void setLawyerId(Long lawyerId) {
        this.lawyerId = lawyerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    public Set<Folder> getFolders() {
        return folders;
    }

    public void setFolders(Set<Folder> folders) {
        this.folders = folders;
    }

    public Set<Court> getCourts() {
        return courts;
    }

    public void setCourts(Set<Court> courts) {
        this.courts = courts;
    }
}
