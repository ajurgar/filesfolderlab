package filesfolderhomework.filesfolderlab.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Folder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @JsonIgnoreProperties({"folder"})
    @OneToMany(mappedBy = "folder", fetch = FetchType.LAZY)
    private List<File> files;

    @JsonIgnoreProperties({"folders"})
    @ManyToOne
    @JoinColumn(name = "person", nullable = false)
    private Person person;


    public Folder(String name, Person person) {
        this.name = name;
        this.files = new ArrayList<>();
        this.person = person;
    }

    public Folder(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void addFile( File file){
        this.files.add(file);
    }
}
