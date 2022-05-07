import React from "react";
import {Link} from "react-router-dom";

const Footer = () =>{

    return  (
        <div className="footer">
            <ul onClick={() => window.location.reload()}>
                <Link to="/documents">
                    <button className="navlinks">Ajouter un document</button>
                </Link>
                <Link to="/clients" >
                    <button className="navlinks" >Ajouter un client</button>
                </Link>
                <Link to="/emprunts">
                    <button className="navlinks">Ajouter un emprunt</button>
                </Link>
                <Link to="/retourEmprunt">
                    <button className="navlinks">Retourner un document</button>
                </Link>
                <Link to="/user">
                    <button className="navlinks">Choix Utilisateur</button>
                </Link>
            </ul>
        </div>
    )
}

export default Footer