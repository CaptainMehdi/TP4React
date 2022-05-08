package com.example.tp3.repository;

import com.example.tp3.model.document.Document;
import com.example.tp3.model.document.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.print.Doc;
import java.util.List;
import java.util.Optional;

public interface DocumentRepository extends JpaRepository<Document, Long> {
    Optional<Document> findById(Long id);

    @Query("select c from Document c where c.titre like %:titre%")
    List<Document> getDocumentByTitre(@Param("titre") String titre);

    @Query("select c from Document c where c.auteur like %:auteur%")
    List<Document> getDocumentByAuteur(@Param("auteur") String auteur);

    @Query("select c from Document c where c.datePublication = :annee")
    List<Document> getDocumentByDatePublication(@Param("annee") int anneePublication);

    @Query("select c from Document c where c.categorie = :categorie")
    List<Document> getDocumentByCategorie(@Param("categorie") String categorie);


}
