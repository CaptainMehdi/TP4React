import React from "react";
import {Link} from "react-router-dom";

const FooterAdmin = () =>{

    return  (
        <div className="footer">
            <ul onClick={() => window.location.reload()}>
                <Link class="btnlien" to="/documents">
                    <button className="navlinks">Ajouter un document</button>
                </Link>
                <Link class="btnlien" to="/clients" >
                    <button className="navlinks" >Ajouter un client</button>
                </Link>
                <Link class="btnlien" to="/emprunts">
                    <button className="navlinks">Ajouter un emprunt</button>
                </Link>
                <Link class="btnlien" to="/retourEmprunt">
                    <button className="navlinks">Retourner un document</button>
                </Link>
                <Link class="btnlien" to="/user">
                    <button className="navlinks">Choix Utilisateur</button>
                </Link>
            </ul>
        </div>
    )
}

export default FooterAdmin