import React from "react";
import {useState} from "react";
import {Link} from "react-router-dom";

const RechercheDocument = () =>{
    return (
        <div className="container">
            <h2>Type de recherche</h2>

            <ul onClick={() => window.location.reload()} style={{listStyleType:"none",textDecoration:"none"}}>
                <li>
                    <Link className="lien" to="/rechercheTitre" >Rechercher a partir du titre<button className="btnUser" style={{backgroundColor:"blanchedalmond"}}>Titre</button></Link>
                </li>
                <li>
                    <Link className="lien" to="/rechercheAuteur">Rechercher a partir de l'auteur<button className="btnUser" style={{backgroundColor:"darkred",color:"white"}}>Auteur</button></Link>
                </li>
                <li>
                    <Link className="lien" to="/rechercheCategorie">Rechercher a partir de la categorie<button className="btnUser" style={{backgroundColor:"orangered",color:"white"}}>Categorie</button></Link>
                </li>
            </ul>
        </div>

    )
}
export default RechercheDocument